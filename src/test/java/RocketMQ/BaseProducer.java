package RocketMQ;

/**
 * Created by C.A.O on 2018/6/3.
 */
public class BaseProducer {
//    public static DefaultMQProducer producer;
//
//    public BaseProducer(){
//        init();
//        Runtime.getRuntime().addShutdownHook(new Thread(){
//            @Override
//            public void run() {
//                System.out.println("#######销毁");
//                producer.shutdown();
//            }
//        });
//    }
//
//    @PostConstruct
//    public void init(){
//        System.out.println("#######初始化");
//        producer = new DefaultMQProducer("Producer_laocao");
//        producer.setNamesrvAddr("127.0.0.1:9876");
//
//        try {
//            producer.start();
//        } catch (MQClientException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @PreDestroy
//    public void destroy(){
//        System.out.println("#######销毁");
//        producer.shutdown();
//    }

}
