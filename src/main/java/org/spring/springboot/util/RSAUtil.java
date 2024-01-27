package org.spring.springboot.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 20:16
 */
public class RSAUtil {

    //在网站生成：http://web.chacuo.net/netrsakeypair
    private static final String privateKey="MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAq8J53UxQ9nbU86/XmrNJvsaQwkM5YDDRfv+X/4qw9sRSW13ORqTSct87v62bolDtd4J9flMguoNhUwAK8okY0QIDAQABAkB7uxYk6DQuyD3x6kuMAvnt94cSmnC7rY9NSHzLtrJyoJ5/awq2Jst2ez45K/z2zOlYBSQTNriH6LdCNcFs6do9AiEA01PyMLU57twQmtlxZjGd7Mtbyr9qHkX6PDTaQy+r/rMCIQDQEUlNKwiBgu92kF0nqFANfdXTuopxdIB5Oz/3phXMawIhAMuj/CFFsbLj6zhcyvLQYz9Y43Znp+nOQwmbYKwXlyUTAiBCIZxouIrFjzZJOu1A05BOGXbDCwFBukOzRI+6SMGY7QIhALMEoF/x+8hPhm4OU4MKETTZe4y9dzL0t+c0TQ2q5LmG";
    private static final String publicKey="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKvCed1MUPZ21POv15qzSb7GkMJDOWAw0X7/l/+KsPbEUltdzkak0nLfO7+tm6JQ7XeCfX5TILqDYVMACvKJGNECAwEAAQ==";
    /**
     * RSA公钥加密
     * @param str 加密字符串
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt( String str) throws Exception{
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        return Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
    }

    /**
     * RSA私钥解密
     * @param str 加密字符串
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        return new String(cipher.doFinal(inputByte));
    }

    public static void main(String[] args) throws Exception{

        String encrypt = RSAUtil.encrypt("mWcMffb*wsqh");
        String decrypt = RSAUtil.decrypt("nKyZfi9uVWKpqhrs6yBhvPnyEFpMwgLJh+GcTodE3tVzBeC18oiiO+QEnmO64FPdk8mtNHNDVG6ridB6IV7W4g==");
        System.out.println(encrypt);
        System.out.println(decrypt);
    }
}
