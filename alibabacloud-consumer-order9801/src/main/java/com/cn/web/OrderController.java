package com.cn.web;

import com.cn.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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


    /**http://localhost:9801/order/nacos/1*/
    @RequestMapping("/nacos/{id}")
    public  Result getPayment(@PathVariable("id") Integer id){
        //拼接URL和参数
        UriComponentsBuilder httpUrl = UriComponentsBuilder.fromHttpUrl(serverUrl+"/payment/nacos/"+id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        //直接返回list对象
        ResponseEntity<Result> exchange = restTemplate.exchange
                 (httpUrl.toUriString(), HttpMethod.GET, new HttpEntity(headers),  new ParameterizedTypeReference<Result>(){});
        Result body = exchange.getBody();
        System.out.println(body);
        return body;

    }

}
