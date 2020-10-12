package com.zhu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZPM
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    /**
     * Secured({"ROLE_PRODUCT", "ROLE_ADMIN"}) SpringSecurity的注解
     * RolesAllowed({"ROLE_PRODUCT", "ROLE_ADMIN"}) jsr250的注解
     * PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ORDER')") spring的注解 方法执行之前验证
     * PostAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ORDER')") spring的注解 方法执行之后验证
     * @return str
     */

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PRODUCT')")
    @RequestMapping("/findAll")
    public String findAll() {
        return "product-list";
    }
}
