package com.wooahan.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Input {
    private List<Car> carList;
    private Integer racingCount;

    public void setRacingCount(String countString) {

    }
}
