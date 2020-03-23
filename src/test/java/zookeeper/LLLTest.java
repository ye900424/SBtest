package zookeeper;

import org.apache.log4j.Logger;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * @author C.A.O
 * @date 2019/10/8
 */
public class LLLTest {


    private static final String connectString = "172.16.101.50:1500";

    private static final int sessionTimeout = 100000;

    private static ZooKeeper zookeeper = null;

    public static Logger logger = Logger.getLogger(LLLTest.class);

    /**
     * main函数
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.setProperty("jute.maxbuffer", 4096 * 1024 * 10 + "");

        //调用rmr,删除所有目录
        rmr("/dubbo");
    }

    /**
     * 递归删除 因为zookeeper只允许删除叶子节点，如果要删除非叶子节点，只能使用递归
     * @param path
     * @throws IOException
     */
    public static void rmr(String path) throws Exception {
//        System.out.println("#####节点为：" + path);

//        logger.info("#####节点为：" + path);
        ZooKeeper zk = getZookeeper();
        //获取路径下的节点
        List<String> children = zk.getChildren(path, false);
        for (String pathCd : children) {
            //获取父节点下面的子节点路径
            String newPath = "";
            //递归调用,判断是否是根节点
            if (path.equals("/")) {
                newPath = "/" + pathCd;
            } else {
                newPath = path + "/" + pathCd;
            }

            if(newPath.indexOf("BiddingRpcContext") > 0){
                System.out.println("#####节点为：" + path);
            }

            rmr(newPath);
        }
        //删除节点,并过滤zookeeper节点和 /节点
        if (path != null && !path.trim().startsWith("/zookeeper") && !path.trim().equals("/")) {
//            zk.delete(path, -1);
            //打印删除的节点路径
//            System.out.println("被删除的节点为：" + path);
        }
    }

    /**
     * 获取Zookeeper实例
     * @return
     * @throws IOException
     */
    public static ZooKeeper getZookeeper() throws IOException {
        zookeeper = new ZooKeeper(connectString, sessionTimeout, new MyWatch());
        return zookeeper;
    }
}

/**
 * 自定义watch类，不做任何事
 * @author LiJie
 *  */
class MyWatch implements Watcher {

    @Override
    public void process(WatchedEvent event) {
        // DO Nothing
    }

}

