package com.common.SpringExt;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.exception.JobSystemException;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by C.A.O on 2018/4/24.
 */
public class DynamicAddJob implements SimpleJob {
    private static final String CRON_DATE_FORMAT = "ss mm HH dd MM ? yyyy";

    /***
     * @param date 时间
     * @return cron类型的日期
     */
    public static String getCron(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);
        String formatTimeStr = "";
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring_laocao.xml");
        ZookeeperRegistryCenter zookeeperRegistryCenter = context.getBean(ZookeeperRegistryCenter.class);
        long now = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            String cron = getCron(new Date(now + (i + 1) * 50000));
            JobCoreConfiguration coreConfig = JobCoreConfiguration.newBuilder("dynamicDemoJob-" + i, cron, 2).build();
            SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(coreConfig, DynamicAddJob.class.getCanonicalName());
            JobScheduler jobScheduler = new JobScheduler(zookeeperRegistryCenter, LiteJobConfiguration.newBuilder(simpleJobConfig).build());
            try {
                jobScheduler.init();
            } catch (JobSystemException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void execute(ShardingContext shardingContext) {
        switch (shardingContext.getShardingItem()) {
            case 0:
                System.out.println("doing sharding 0...job name is " + shardingContext.getJobName());
                // do something by sharding item 0
                break;
            case 1:
                System.out.println("doing sharding 1...job name is " + shardingContext.getJobName());
                // do something by sharding item 1
                break;
        }
    }
}

