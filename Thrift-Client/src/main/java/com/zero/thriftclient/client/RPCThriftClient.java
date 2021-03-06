package com.zero.thriftclient.client;

import com.zero.thrift.api.RPCDateService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Thrift RPC 客户端调用
 */
public class RPCThriftClient {
    private RPCDateService.Client client;
    private TBinaryProtocol protocol;
    private TSocket transport;
    private String host;
    private int port;

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    public void init() throws TTransportException {
        transport = new TSocket(host, port);
        protocol = new TBinaryProtocol(transport);
        client = new RPCDateService.Client(protocol);
    }

    public RPCDateService.Client getRPCThriftService() {
        return client;
    }

    public void open() throws TTransportException {
        transport.open();
    }

    public void close() {
        transport.close();
    }
}

