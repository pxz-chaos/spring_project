package com.peixin.proxy.jdk;



public class Target implements TargetInterface{
    @Override
    public void save() {
        System.out.println("save running....");
    }
}
