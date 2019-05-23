package org.stu.spring.boot.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 使用Quartz
 *
 * Created by ShiYing.Ke on 2019/4/11.
 */
public class QuartzJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("+++++>>>>> quartz task " + new Date());
    }
}
