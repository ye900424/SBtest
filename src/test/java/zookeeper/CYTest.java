package zookeeper;

import Common.LaoCaoConsts;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * Created by C.A.O on 2018/7/4.
 */
public class CYTest implements Watcher{
    // 测试根结点
    private String rootPath = "/locks";
    // zk链接
    private static ZooKeeper zkClient;

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        CYTest cyTest = new CYTest();
        zkClient = new ZooKeeper(LaoCaoConsts.ZK_CONNECT, 30000, cyTest);
        cyTest.fun();
    }

    public void fun() throws IOException, KeeperException, InterruptedException {
        Stat stat = zkClient.exists(rootPath,true);
        byte[] date = zkClient.getData(rootPath,true,null);
        System.out.println(rootPath + "节点数据:" + new String(date));
        List<String> childrenList = zkClient.getChildren(rootPath,true);

        childrenList.forEach(x -> System.out.println(x));

        Thread.sleep(100000L);
    }


    @Override
    public void process(WatchedEvent event) {
        System.out.println("----节点:" + event.getPath() + " 发生了事件：" + event.getType());
        if(Event.EventType.NodeDataChanged.equals(event.getType())){
            byte[] date = new byte[0];
            try {
                date = zkClient.getData(event.getPath(),true,null);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(event.getPath() + "节点数据:" + new String(date));
        }

        if(Event.EventType.NodeChildrenChanged.equals(event.getType())){
            try {
                List<String> childrenList = zkClient.getChildren(event.getPath(),true);
                childrenList.forEach(x -> {
                    String childPath = rootPath + "/" + x;

                    byte[] childDate = new byte[0];
                    try {
                        Stat stat = zkClient.exists(childPath,false);
                        if(null != stat){
                            childDate = zkClient.getData(childPath,true,null);
                        }
                    } catch (KeeperException e) {
                        System.out.println("KeeperException#####"+childPath);
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(childPath + ":" + new String(childDate));
                });



            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
