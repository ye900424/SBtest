package zookeeper;

import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * Author     :Administrator
 * Time       :19:44
 * Project    :CMSM
 * Package    :zookeeper
 */
public class ZooKeeperDel {
    public static ZooKeeper zk ;

    public static void main(String[] args) throws Exception{
        String path = "/dubbo/cn.gov.zcy.fixed.district.service.OpenApiConfigReadService";
        zk = new ZooKeeper("172.16.101.50:1500", 3000, null);
        ls(path);

        zk.close();
    }

    /**
     * 列出指定path下所有孩子
     */
    public static void ls(String path) throws Exception {
        System.out.println(path);
        List<String> list = zk.getChildren(path,false);
        //判断是否有子节点
        if(list.isEmpty() || list == null){
            return;
        }
        for(String s : list){
            //判断是否为根目录
            if(path.equals("/")){
                ls(path + s);
            }else {
                ls(path +"/" + s);
            }
        }
    }




}
