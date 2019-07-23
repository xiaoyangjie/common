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
        Integer a = GenericConvertUtil.genericString2Class("1");
        Double b = GenericConvertUtil.genericString2Class("1.0");
        System.out.println(a);
    }

}
