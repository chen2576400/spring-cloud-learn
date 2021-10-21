package com.cn.web;

import com.cn.lb.MyLoadBalancer;
import com.cn.result.Payment;
import com.cn.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @Autowired
    private MyLoadBalancer myLoadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;


    /**
     * http://localhost:2002/consumer/creat?serialNumber=123231
     * HTTP地址调用
     *
     */
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



    /**http://localhost:2002/consumer/get/3
     * 服务名称调用
     * @LoadBalanced负载均衡
     */
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


    /**http://localhost:2002/consumer/lb
     * 服务名称调用
     * @LoadBalanced负载均衡
     */
    @GetMapping("lb")
    public Result create() {
        //拼接URL和参数
        UriComponentsBuilder httpUrl = UriComponentsBuilder.fromHttpUrl("http://ALICLOUD-PROVIDER-PAYMENT2001/payment/lb");
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


    /**http://localhost:2002/consumer/mylb
     * 服务名称调用
     *
     *自定义负载均衡  调用时候记得屏蔽ContextConfiguration里面的restTemplate的@LoadBalanced注解
     */

    @GetMapping("mylb")
    public Result mylb() {

        List<ServiceInstance> discoveryClientInstances = discoveryClient.getInstances("AliCloud-provider-payment2001");
        if (CollectionUtils.isEmpty(discoveryClientInstances)){
            return Result.error("注册中心没找到该服务");
        }
        ServiceInstance instances = myLoadBalancer.instances(discoveryClientInstances);
        URI uri = instances.getUri();
        //拼接URL和参数
        UriComponentsBuilder httpUrl = UriComponentsBuilder.fromHttpUrl(uri+"/payment/lb");
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
