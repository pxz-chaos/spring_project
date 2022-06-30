package com.peixin.aop;

/**
 * 目标类，含接口
 */
public class Target implements TargetInterface {
    @Override
    public void save() {
        int i = 1 / 0;
        System.out.println("save running....");
    }
}
