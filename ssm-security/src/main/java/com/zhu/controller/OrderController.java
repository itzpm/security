package com.zhu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZPM
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ORDER')")
    @RequestMapping("/findAll")
    public String findAll() {
        return "order-list";
    }
}
