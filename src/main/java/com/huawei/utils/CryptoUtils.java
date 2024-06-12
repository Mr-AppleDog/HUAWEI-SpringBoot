package com.huawei.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CryptoUtils {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final byte[] KEY = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8); // 16字节的密钥  

    /**
     * 加密
     * @param valueToEnc
     * @return
     * @throws Exception
     */
    public static String encrypt(String valueToEnc) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKey = new SecretKeySpec(KEY, ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(valueToEnc.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * 解密
      * @param encryptedValue
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptedValue) {
        Cipher cipher = null;
        byte[] original = new byte[0];
        try {
            cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeySpec secretKey = new SecretKeySpec(KEY, ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            original = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(original, StandardCharsets.UTF_8);
    }

    public static Integer decryptByUid(String token){
        Integer uid =null;
        if(token!=null){
            uid=Integer.parseInt(decrypt(token));
        }
        return uid;
    }

    public static void main(String[] args) throws Exception {
        String original = "Hello, World!";
        String encrypted = encrypt(original);
        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}