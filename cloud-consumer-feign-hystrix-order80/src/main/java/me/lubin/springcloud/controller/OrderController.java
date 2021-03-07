package me.lubin.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import me.lubin.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id) {
        return paymentService.paymentOk(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    @HystrixCommand
    public String paymentTimeout(@PathVariable("id") Integer id) {
//        int age = 10 / 0;
        return paymentService.paymentTimeout(id);
    }

    public String paymentTimeoutHandler(@PathVariable("id") Integer id) {
        return "系统繁忙";
    }

    public String globalFallback(){
        return "global 系统繁忙";
    }

}