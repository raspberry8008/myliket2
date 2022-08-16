package com.myliket2.myliket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "")
    public String testView() throws Exception {
        System.out.println("테스트화면 입니다.");
        return "index";
    }
}
