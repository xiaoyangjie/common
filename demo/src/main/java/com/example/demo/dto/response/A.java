package com.example.demo.dto.response;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

@Data
public class A <T> {
    private T b;

    private String a = "1";

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
