package com.cn.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Author nchen
 * @Date 2021/10/22 10:39
 * @Version 1.0
 * @Description  gateway全局日志过滤器
 */
@Component
@Slf4j
public class MylogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("*************************com in MylogGatewayFilter"+new Date());
        String uname=exchange.getRequest().getQueryParams().getFirst("uname");//地址必须挂参 参数为uname
        if (uname ==null){
            log.info("***********用户名为null ，为非法用户o(╥﹏╥)o");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;  //order越小 优先级越高
    }
}
