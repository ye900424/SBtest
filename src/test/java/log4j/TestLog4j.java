package log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Author     :Administrator
 * Time       :11:33
 * Project    :CMSM
 * Package    :log4j
 */
public   class  TestLog4j  {
    static Logger logger  =  Logger.getLogger(TestLog4j.class);

    public   static   void  main(String[] args)  {
        //默认配置
//        BasicConfigurator.configure();
        //读取配置文件
//        PropertyConfigurator.configure("D:/CMSM/log4j.properties");
        logger.debug(" debug ");
        logger.error(" error2 ");
        logger.error(" error ");
        logger.info(" info2 ");
        logger.info(" info ");
        logger.warn(" warn ");
        System.out.println(logger.isTraceEnabled());
        System.out.println(logger.toString());
        logger.trace("trace");
        logger.info(" info ");
        System.out.println(logger.isTraceEnabled());
        Level level = Level.toLevel(10005);
        logger.setLevel(level);
        System.out.println(logger.getLevel());
        System.out.println(TestLog4j.class.getName());


    }
}
