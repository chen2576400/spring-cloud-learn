package com.cn.web;

import com.cn.result.Payment;
import com.cn.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
/**
 * @Author nchen
 * @Date 2021/10/18 17:04
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("consumer")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


    /**http://localhost:2002/consumer/creat?serialNumber=123231*/
    @GetMapping("creat")
    public Result create(Payment payment) {
        //拼接URL和参数
        UriComponentsBuilder httpUrl = UriComponentsBuilder.fromHttpUrl("http://localhost:2001/payment/creat")
                .queryParam("serialNumber",payment.getSerialNumber());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        //直接返回list对象
        ParameterizedTypeReference<Result> responseType = new ParameterizedTypeReference<Result>() {
        };
        //HttpEntity<String> httpEntity = new HttpEntity(JSON.toJSONString(payment), headers);
        ResponseEntity<Result> exchange = restTemplate.exchange(httpUrl.toUriString(), HttpMethod.POST, new HttpEntity(headers), responseType);
        Result body = exchange.getBody();
        System.out.println(body);
        return body;
    }



    /**http://localhost:2002/consumer/get/3*/
    @GetMapping("get/{id}")
    public Result create(@PathVariable("id") Long id) {
        //拼接URL和参数
        UriComponentsBuilder httpUrl = UriComponentsBuilder.fromHttpUrl("http://ALICLOUD-PROVIDER-PAYMENT2001/payment/get/"+id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        //直接返回list对象
        ParameterizedTypeReference<Result> responseType = new ParameterizedTypeReference<Result>() {
        };
        //HttpEntity<String> httpEntity = new HttpEntity(JSON.toJSONString(payment), headers);
        ResponseEntity<Result> exchange = restTemplate.exchange(httpUrl.toUriString(), HttpMethod.GET, new HttpEntity(headers), responseType);
        Result body = exchange.getBody();
        System.out.println(body);
        return body;
    }



}
