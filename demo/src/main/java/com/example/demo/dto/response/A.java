package com.example.demo.dto.response;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

@Data
public class A implements Comparable {

    private Integer count;

    private Integer count1;

    private String a = "1";

    public A(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }


    public void setCount(Integer count) {
        this.count = count;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public int compareTo(Object o) {
        A test = (A)o;
        return test.getCount() - this.count ;
    }
}
