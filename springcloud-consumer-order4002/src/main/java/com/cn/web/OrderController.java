package com.cn.web;

import com.cn.result.Payment;
import com.cn.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @Author nchen
 * @Date 2021/10/18 17:04
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("zk")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


    /**http://localhost:4002/zk/getMsg*/
    @GetMapping("getMsg")
    public Result getZookeeperMsg() {
        //拼接URL和参数
        UriComponentsBuilder httpUrl = UriComponentsBuilder.fromHttpUrl("http://springcloud-provider-payment4001/zk/payment");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        //直接返回list对象
        ParameterizedTypeReference<Result> responseType = new ParameterizedTypeReference<Result>() {
        };
        ResponseEntity<Result> exchange = restTemplate.exchange(httpUrl.toUriString(), HttpMethod.GET, new HttpEntity(headers), responseType);
        Result body = exchange.getBody();
        System.out.println(body);
        return body;
    }



}
