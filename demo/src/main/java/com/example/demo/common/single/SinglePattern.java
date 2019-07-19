package com.example.demo.common.single;

import lombok.Data;

@Data
public class SinglePattern {

    private SinglePattern(){

    }
    private Integer count;

    private SinglePattern(Integer count) {
        this.count = count;
    }

    public SinglePattern getSinglePattern() {
        return InnerClass.singlePattern;
    }

    private static class InnerClass {
        private static final SinglePattern singlePattern = new SinglePattern(1);
    }

}
