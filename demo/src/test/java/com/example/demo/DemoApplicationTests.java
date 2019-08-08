package com.example.demo;

import com.example.demo.common.util.GenericConvertUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        String s3 = new String("1") + new String("1");
        System.out.println(s3 == s3.intern());
        System.out.println(1111);
    }

}
