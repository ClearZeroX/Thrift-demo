package com.zero.thriftclient.controller;

import com.zero.thriftclient.client.RPCThriftClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 客户端调用
 */
@Slf4j
@RestController
@RequestMapping("/zero")
public class RPCThriftContoller {
    @Autowired
    private RPCThriftClient rpcThriftClient;

    @RequestMapping(value = "/thrift", method = RequestMethod.GET)
    public String thriftTest(HttpServletRequest request, HttpServletResponse response) {
        try {
            rpcThriftClient.open();
            return rpcThriftClient.getRPCThriftService().getDate("zero");
        } catch (Exception e) {
            log.error("RPC调用失败", e);
            return "error";
        } finally {
            rpcThriftClient.close();
        }
    }
}
