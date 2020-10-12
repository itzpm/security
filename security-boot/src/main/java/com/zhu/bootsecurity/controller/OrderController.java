package com.zhu.bootsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpm
 * @version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ORDER')")
    @GetMapping("/findAll")
    public String findAll() {
        return "订单列表访问成功";
    }
}
