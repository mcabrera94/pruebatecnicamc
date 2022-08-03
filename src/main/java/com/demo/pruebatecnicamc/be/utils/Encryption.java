package com.demo.pruebatecnicamc.be.utils;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;

@Service
public class Encryption {

    public String  encryptToDES(String text, String key){

        DESKeySpec keySpec;
        SecretKeyFactory keyFactory;
        SecretKey secretKey;
        Cipher cipher;
        String encryptedRut = "";

        try {
            keyFactory = SecretKeyFactory.getInstance("DES");
            keySpec = new DESKeySpec(key.getBytes("UTF-8"));
            secretKey = keyFactory.generateSecret(keySpec);
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] aux = cipher.doFinal(text.getBytes("UTF-8"));
            byte[] bytes = Base64.getEncoder().encode(aux);
            encryptedRut = new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encryptedRut;
    }

    public String  decryptToDES(String text, String key){

        DESKeySpec keySpec;
        SecretKeyFactory keyFactory;
        SecretKey secretKey;
        Cipher cipher;
        String encryptedRut = "";

        try {
            keyFactory = SecretKeyFactory.getInstance("DES");
            keySpec = new DESKeySpec(key.getBytes("UTF-8"));
            secretKey = keyFactory.generateSecret(keySpec);
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decoded = Base64.getDecoder().decode(text);
            byte[] aux = cipher.doFinal(decoded);
            encryptedRut = new String(aux);
            System.out.println(encryptedRut);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encryptedRut;
    }
}
