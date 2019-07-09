package com.tan.start;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadPropertiesTest {
    @Test
    public void testRead() throws IOException {
//        FileReader reader = new FileReader(ResourceUtils.getURL("classpath:rsa_public_key.pem").getFile());
        FileReader reader = new FileReader(ResourceUtils.getURL("classpath:rsa_private_key.pem").getFile());
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        StringBuilder whole = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null){
            if(line.matches("^[-]+.*KEY[-]+$")){
                continue;
            }
            System.out.println(line);
            whole.append(line);
        }
        System.out.println(whole.toString());
    }
}
