package ES;

import com.google.gson.Gson;
import io.searchbox.action.BulkableAction;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.client.JestResultHandler;
import io.searchbox.core.BulkResult;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.IndicesExists;
import io.searchbox.indices.mapping.PutMapping;
import io.searchbox.indices.type.TypeExist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JestUntil {

    private static final Gson gson = new Gson();

    public static BulkableAction mapUpsertAction(EsMapping mapping, String index, String type){
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("doc", mapping);
        objectMap.put("doc_as_upsert", true);
        String script = gson.toJson(objectMap);
        io.searchbox.core.Update.Builder builder = new io.searchbox.core.Update.Builder(script);
        return builder.index(type).type(type).id(String.valueOf(mapping.getId())).build();
    }


    public static void indexExistsOrCreate(JestClient jestClient, String index) {
        log.info("determine index {} is exist ", index);
        IndicesExists indicesExists = new IndicesExists.Builder(index).build();
        try {
            JestResult result = jestClient.execute(indicesExists);
            boolean succeeded = result.isSucceeded();
            if (!succeeded) {
                log.info(" index {} is not exist , then create", index);
                CreateIndex createIndex = new CreateIndex.Builder(index).build();
                JestResult execute = jestClient.execute(createIndex);
                execute.isSucceeded();
            }
            log.info(" index {} is exist ", index);
        } catch (IOException e) {
            log.error("indexExistsOrCreate error ", e);
        }
    }


    public static void indexTypeExistsOrCreate(JestClient jestClient,String index, String type,String mapping) {
        indexExistsOrCreate(jestClient,index);
        log.info("determine index {} type {} is exist ", index,type);
        TypeExist typeExist = new TypeExist.Builder(index).addType(type).build();
        JestResult result = null;
        try {
            result = jestClient.execute(typeExist);
            boolean succeeded = result.isSucceeded();
            if (!succeeded) {
                log.info(" index {} type {} is not exist , then create", index, type);
                PutMapping putMapping = new PutMapping.Builder(index, type, mapping).build();
                Map<String, Object> headers = putMapping.getHeaders();
                headers.put("content-type", "application/json");
                JestResult jestResult = jestClient.execute(putMapping);
                if (!jestResult.isSucceeded()) {
                    log.warn(" index {} type {} create error, please check config, reason: {}", index, type, jestResult.getErrorMessage());
                    return;
                }
            }
            log.info(" index {} type {} is exist ", index, type);
        } catch (IOException e) {
            log.error("indexTypeExistsOrCreate error ", e);
        }
    }



    /**
     * @return
     */
    public static JestResultHandler resultHandler(List<BulkableAction> actions) {
        return new JestResultHandler() {
            @Override
            public void completed(Object result) {
                BulkResult bulkResult = (BulkResult) result;
                List<BulkResult.BulkResultItem> failedItems = bulkResult.getFailedItems();
                if(CollectionUtils.isEmpty(failedItems)){
                    log.info("[ES_R]quote bulk request success");
                }else {
                    failedItems.forEach(x -> {
                        for(Object object : actions){
                            BulkableAction action = (BulkableAction) object;
                            if(x.id.equals(action.getId())){
                                log.info("[ES_R]quote bulk request error, id: {},operation :{},date: {},error: {}, reason :{} ", x.id, x.operation, action.getData(gson),x.error, x.errorReason);
                            }
                        }
                    });
                }
            }

            @Override
            public void failed(Exception ex) {
                log.error("[ES_R]quote bulk request fail", ex);
            }
        };
    }

}
