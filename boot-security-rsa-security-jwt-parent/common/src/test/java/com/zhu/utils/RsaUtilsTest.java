package com.zhu.utils;

import org.junit.jupiter.api.Test;

/**
 * @author zpm
 * @version 1.0
 */
class RsaUtilsTest {

    private final static String PRIVATE_KEY_PATH = "F:\\img\\id_key_rsa";
    private final static String PUBLIC_KEY_PATH = "F:\\img\\id_key_rsa.pub";

    @Test
    void getPublicKey() throws Exception {
        System.out.println(RsaUtils.getPublicKey(PUBLIC_KEY_PATH));
    }

    @Test
    void getPrivateKey() throws Exception {
        System.out.println(RsaUtils.getPrivateKey(PRIVATE_KEY_PATH));

    }

    @Test
    void generateKey() throws Exception {
        RsaUtils.generateKey(PUBLIC_KEY_PATH, PRIVATE_KEY_PATH, "comzhu", 2048);
    }
}