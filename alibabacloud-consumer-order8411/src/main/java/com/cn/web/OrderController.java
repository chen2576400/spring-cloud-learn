package com.cn.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cn.feign.PaymentService;
import com.cn.myhandler.CustomerBlockHandler;
import com.cn.myhandler.CustomerFallbackHandler;
import com.cn.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;

/**
 * @Author nchen
 * @Date 2021/10/28 16:49
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;


    @Autowired
    private PaymentService paymentService;


    /**
     * http://localhost:8411/order/fallback/1
     */
    /*fallback 属于降级  走降级时候依旧会执行方法*/
    /*blockHandler 属于熔断   熔断时候方法都不会执行
     * exceptionsToIgnore = {IllegalArgumentException.class} 忽略fallback异常类型*/

    //region 不配置任何
    //没有配置则会报错，不太友好
    //@SentinelResource(value = "fallback")
    //endregion
    //region  只配置fallback
    //fallback只负责业务异常
    //@SentinelResource(value = "fallback",fallbackClass = CustomerFallbackHandler.class,fallback ="handleFallback1" )//没有配置则会报错，不太友好
    //endregion
    //region 只配置blockHandler
    //blockHandler 只负责配置违规
    //@SentinelResource(value = "fallback",
    //        blockHandlerClass = CustomerBlockHandler.class,blockHandler ="handlerException1" )
    //endregion
    //region fallback和blockHandler都配置
    //如果抛出blockException时只会进入blockHandler处理
    //@SentinelResource(value = "fallback",
    //        blockHandlerClass = CustomerBlockHandler.class,blockHandler ="handlerException1",
    //        fallbackClass = CustomerFallbackHandler.class,fallback ="handleFallback1" )
    //endregion
    @RequestMapping("/fallback/{id}")
    public Result fallback(@PathVariable("id") Integer id) {
        //拼接URL和参数
        UriComponentsBuilder httpUrl = UriComponentsBuilder.fromHttpUrl(serverUrl + "/payment/paymentSQL/" + id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        //直接返回list对象
        ResponseEntity<Result> exchange = restTemplate.exchange
                (httpUrl.toUriString(), HttpMethod.GET, new HttpEntity(headers), new ParameterizedTypeReference<Result>() {
                });
        Result body = exchange.getBody();

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        } else if (body.getContent() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return body;

    }

    /**
     * http://localhost:8411/order/paymentSQL/1
     * 这里如果服务方停止服务就会进入fallback
     */
    @RequestMapping(value = "/paymentSQL/{id}")
    public Result getPayment(@PathVariable("id") Integer id) {

        return paymentService.getPayment(id);
    }

}
