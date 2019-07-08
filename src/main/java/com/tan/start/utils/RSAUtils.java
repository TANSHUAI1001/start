package com.tan.start.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtils {
    // TODO 使用pem格式并读取
    private static Logger logger = LoggerFactory.getLogger(RSAUtils.class);
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGPp7Dbzv/xeDeAj8Vs4/YmsW/9ohVoSecj" +
            "PJ45S0Pf1dpV3TfadjRx1aEcQYXaHzhcfhtRaVDiaHKgdFLynoAyaMsoLPdTkWHucZo/G4RADpFQe+qYxAC1ipNZa6kLGNnMvZMC2o/fY8k" +
            "zJlpzXRQ/M1LZKKG4FCIAz11tU452QIDAQAB";

    private static final String PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAMY+nsNvO//F4N4CPxWzj9iax" +
            "b/2iFWhJ5yM8njlLQ9/V2lXdN9p2NHHVoRxBhdofOFx+G1FpUOJocqB0UvKegDJoyygs91ORYe5xmj8bhEAOkVB76pjEALWKk1lrqQsY2cy" +
            "9kwLaj99jyTMmWnNdFD8zUtkoobgUIgDPXW1TjnZAgMBAAECgYBJ3NcGdhFi0PVhgnDCwy5bQ/9d8JsHXI4HtDQ7exf46DdHVoCDJUrVjnH" +
            "b0si0PAgbb31iKUrUCRmw/AFhPcWKkHKwAiKjKn3m9oIto5XJmjn0ql0DpZ+E1n5ow7lkvskLG8siy3l7dcWpqyZ7VXLzRc3FJ3lR3B4qsx" +
            "oXlt8h6QJBAP6xTzC5ULXUDedb5h3mOTgBw5YIspZL+nlyTddj6KIqiFrGq9Qii7ebwfBp/9elVKq1S3xCcp5abiaSxlTd4a8CQQDHQyH5Q" +
            "BY9TfYooAU1riOlCnN+Yj1S0uTtB4Rolu0F2j4NURW3CTp1nCoh/I+kAkQg7vnVustWHIbsyG59vqb3AkAPu0P47nldwctaDwMXtbCzFOjP" +
            "y5m8TtUZy0WjmDg2TApAESVr5PZcUPKZtvJmj3+7S5duBWyu+0byev5lH49hAkBwtOMphXtOz6MVVXW86DOXLXMoIE8JYupDu8XEFuIYNlp" +
            "009FRh3G+hkc6lA13OiTo7+L2ZkKPAXG7yp7clxL/AkB4g6VxRhOy4Gd1SjBUyhjLClDH+Idxk7egUly/3bU9WjzmTH/1koSWKdNAmfGYj8" +
            "luFjugg8YLtESwzOzr4cME";

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

    public static void main(String[] args) {
        String[] emails = {"tanshuai@gmail.com","tanshuai.cn@gmail.com",null};

        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            String encryptString = encrypt(email);
//            logger.info("{}: {}",encryptString.length(),encryptString);
            logger.info("{}",encryptString);
            String decryptString = decrypt(encryptString);
//            logger.info("{}: {}",decryptString.length(),decryptString);
            logger.info("{}",decryptString);
//            logger.info("{}",email.equals(decryptString));
        }

    }

}
