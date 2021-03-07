package me.lubin.springcloud.service.controller;

import lombok.extern.slf4j.Slf4j;
import me.lubin.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping(value = "/send/message")
    public String sendMessage() {
        return iMessageProvider.send();
    }

}
