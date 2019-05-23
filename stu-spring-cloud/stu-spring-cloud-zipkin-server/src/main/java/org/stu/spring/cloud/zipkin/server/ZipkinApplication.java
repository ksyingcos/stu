package org.stu.spring.cloud.zipkin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * Created by ShiYing.Ke on 2019/5/17.
 */
@EnableZipkinServer
@SpringBootApplication
public class ZipkinApplication {
    public static void main(String[] args){

        SpringApplication.run(ZipkinApplication.class, args);
    }
}
