package com.qihang.subject.infrastructure.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;

/**
 * @Description: 数据库加密util
 * @Author:bread
 * @Date: 2024-07-26 16:17
 */
public class DruidEncrypUtil {

    private static String publickey;

    private static String privatekey;

    static {
        try {
            String[] keyPair = ConfigTools.genKeyPair(512);
            privatekey = keyPair[0];
            System.out.println("privatekey:" + privatekey);
            publickey = keyPair[1];
            System.out.println("publickey:" + publickey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密方法
     *
     * @param plainText
     * @return
     */
    public static String encrypt(String plainText) throws Exception {
        String encrypt = ConfigTools.encrypt(privatekey, plainText);
        System.out.println("encrypt:" + encrypt);
        return encrypt;
    }

    /**
     * 解密方法
     *
     * @param encryptText
     * @return
     */
    public static String decrypt(String encryptText) throws Exception {
        String decrypt = ConfigTools.decrypt(publickey, encryptText);
        System.out.println("encryptText:" + encryptText);
        return encryptText;
    }

    public static void main(String[] args) throws Exception {
        String encrypt = encrypt("he13140303042");
        System.out.println("encrypt:" + encrypt);
    }
}
