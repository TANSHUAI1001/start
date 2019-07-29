package com.tan.start.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Properties;

public class RSAUtils {

    private static Logger logger = LoggerFactory.getLogger(RSAUtils.class);
    private static final String PUBLIC_KEY = readKeyFromFile("classpath:rsa_public_key.pem");
    private static final String PRIVATE_KEY = readKeyFromFile("classpath:rsa_private_key.pem");

    public static String readKeyFromFile(String filePath){
        try {
            FileReader reader = new FileReader(ResourceUtils.getFile(filePath));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            StringBuilder whole = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.matches("^[-]+.*KEY[-]+$")) {
                    continue;
                }
                whole.append(line);
            }
            reader.close();
            bufferedReader.close();
            return whole.toString();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public static String encrypt(String str){
        try {
            byte[] encodePublicKey = Base64.getDecoder().decode(PUBLIC_KEY);
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(encodePublicKey));
            Cipher cipher1 = Cipher.getInstance("RSA");
            cipher1.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64.getEncoder().encodeToString(cipher1.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    public static String decrypt(String encryptStr){
        try {
            byte[] encryptBytes = Base64.getDecoder().decode(encryptStr);
            byte[] encodePrivateKey = Base64.getDecoder().decode(PRIVATE_KEY);
            PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(encodePrivateKey));
            Cipher cipher2 = Cipher.getInstance("RSA");
            cipher2.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(cipher2.doFinal(encryptBytes));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

}
