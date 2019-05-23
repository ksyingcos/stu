package org.stu.spring.boot.task;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 使用Quartz
 *
 * Created by ShiYing.Ke on 2019/4/11.
 */
@Configuration
public class QuartzConfiguration {

    @Bean
    public JobDetailFactoryBean teatQuartzDetail() {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(QuartzJob.class);
        return bean;
    }

    @Bean
    public CronTriggerFactoryBean testQuartzTrigger() {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(teatQuartzDetail().getObject());
        trigger.setCronExpression("0/5 * * * * ? ");
        return trigger;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactory(Trigger[] triggers){
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setTriggers(triggers);
        return schedulerFactory;
    }
}
