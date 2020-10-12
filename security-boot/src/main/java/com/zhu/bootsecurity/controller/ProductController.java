package com.zhu.bootsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpm
 * @version 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PRODUCT')")
    @GetMapping("/findAll")
    public String findAll() {
        return "产品列表访问成功";
    }
}
