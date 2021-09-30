package com.zero.thriftservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ThriftServiceApplication {

    private static RPCThriftServer rpcThriftServer;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ThriftServiceApplication.class, args);
        try {
            rpcThriftServer = context.getBean(RPCThriftServer.class);
            rpcThriftServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
