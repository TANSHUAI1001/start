package com.tan.start;


import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.tan.start.utils.RSAUtils.decrypt;
import static com.tan.start.utils.RSAUtils.encrypt;

public class RsaTest {
    private Logger logger = LoggerFactory.getLogger(RsaTest.class);
    @Test
    public void testDecryptAndEncrypt(){
        String[] emails = {"tanshuai@gmail.com","tanshuai.cn@gmail.com",null};
        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            String encryptString = encrypt(email);
            logger.info("{}",encryptString);
            String decryptString = decrypt(encryptString);
            logger.info("{}",decryptString);
            if(email != null) {
                Assert.assertEquals(email,decryptString);
            }
        }
    }
}
