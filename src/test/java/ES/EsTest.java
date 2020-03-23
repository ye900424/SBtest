package ES;

import com.google.gson.JsonObject;
import com.model.Person;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author C.A.O
 * @date 2019/11/25
 */
@Slf4j
public class EsTest {

    private final static String host = "172.16.101.166";
    private final static String port = "9210";

    private static JestClient jest = getJest();


    public static void main(String[] args) {
        createIndex();
    }


    public static void createIndex(){
        Person person = new Person(1L,"laocao2");
        Index index = new Index.Builder(person).index("laocao").type("laocao").build();

        try {
            jest.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateIndex(){

    }

    public static void deleteIndex(){

    }

    public static void search(){
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        List<QueryBuilder> filters = queryBuilder.filter();
        filters.add(QueryBuilders.matchQuery("name","laocao"));

        Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex("laocao").addType("laocao").build();
        try {
            JestResult jestResult = jest.execute(search);
            JsonObject jsonObject = jestResult.getJsonObject().getAsJsonObject("hits");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }







    public static JestClient getJest() {
        log.info("------->  elasticsearch hosts:{}",host);
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://"+host+":"+port)
                .multiThreaded(true)
                //Per default this implementation will create no more than 2 concurrent connections per given route
                .defaultMaxTotalConnectionPerRoute(2)
                // and no more 20 connections in total
                .maxTotalConnection(10)
                .build());
        JestClient jestClient = factory.getObject();
        return jestClient;
    }




}
