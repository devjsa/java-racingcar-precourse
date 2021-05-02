package com.wooahan.vo;

import com.wooahan.constants.ValueConstants;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@ToString
public class Car {
    private final String name;
    private Integer position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Integer goFoward() {
        int forwardValue = new Random().nextInt(10);
        if (forwardValue >= ValueConstants.FORWARD_MIN_VALUE) {
            position++;
        }
        return this.position;
    }
}
