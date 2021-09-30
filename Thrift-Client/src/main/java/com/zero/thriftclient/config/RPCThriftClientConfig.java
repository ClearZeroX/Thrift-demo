package com.zero.thriftclient.config;

import com.zero.thriftclient.client.RPCThriftClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * thrift rpc 客户端配置
 */
@Configuration
public class RPCThriftClientConfig {

    @Value("${thrift.host}")
    private String host;
    @Value("${thrift.port}")
    private int port;

    @Bean(initMethod = "init")
    public RPCThriftClient rpcThriftClient() {
        RPCThriftClient rpcThriftClient = new RPCThriftClient();
        rpcThriftClient.setHost(host);
        rpcThriftClient.setPort(port);
        return rpcThriftClient;
    }
}

