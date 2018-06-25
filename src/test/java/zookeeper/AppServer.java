package zookeeper;

import org.apache.zookeeper.*;

/**
 * Author     :Administrator
 * Time       :15:32
 * Project    :CMSM
 * Package    :zookeeper
 */
public class AppServer {
    private String groupNode = "sgroup";
    private String subNode = "sub2";

    /**
     * 连接zookeeper
     * @param address server的地址
     */
    public void connectZookeeper(String address) throws Exception {
        ZooKeeper zk = new ZooKeeper("39.105.17.168:2181", 5000, new Watcher() {

            @Override
            public void process(WatchedEvent watchedEvent) {
                // 如果发生了"/sgroup"节点下的子节点变化事件, 更新server列表, 并重新注册监听
                System.out.println(watchedEvent.getType());
            }
        });
        // 在"/sgroup"下创建子节点
        // 子节点的类型设置为EPHEMERAL_SEQUENTIAL, 表明这是一个临时节点, 且在子节点的名称后面加上一串数字后缀
        // 将server的地址数据关联到新创建的子节点上
        String createdPath = zk.create("/" + groupNode + "/" + subNode, address.getBytes("utf-8"),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("create: " + createdPath);
    }

    /**
     * server的工作逻辑写在这个方法中
     * 此处不做任何处理, 只让server sleep
     */
    public void handle() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args) throws Exception {
        // 在参数中指定server的地址
        /*if (args.length == 0) {
            System.err.println("The first argument must be server address");
            System.exit(1);
        }*/

        AppServer as = new AppServer();
        as.connectZookeeper("192.168.251.58:8081222");
//        as.connectZookeeper(args[0]);

        as.handle();
    }
}
