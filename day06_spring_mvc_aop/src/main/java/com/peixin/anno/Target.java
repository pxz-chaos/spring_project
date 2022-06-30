package com.peixin.anno;

import org.springframework.stereotype.Component;

/**
 * 目标类，含接口
 */

@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
//        int i = 1 / 0;
        System.out.println("save running....");
    }
}
