package com.example.demo.proxy;

import com.example.demo.common.proxy.Man;
import com.example.demo.common.proxy.NormalHandler;
import com.example.demo.common.proxy.Person;
import com.example.demo.dto.response.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyTest {

    public ProxyTest() {
    }

    @Test
    public void test() {
        Man man = new Man();
        NormalHandler normalHandler = new NormalHandler(man);
        Person iPerson = (Person) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                Person.class.getInterfaces(), normalHandler);
        iPerson.say();
    }

    @Test
    public void test1() {
        List<A> listA = Arrays.asList(new A(1), new A(8), new A(3));
        Comparator<A> co = Comparator.comparing(e -> e.getCount());
        co = co.reversed();
        Map<String, List<Integer>> t = listA.stream().collect(Collectors.groupingBy(A::getA, Collectors.mapping(A::getCount, Collectors.toList())));
        System.out.println(t);
    }

}
