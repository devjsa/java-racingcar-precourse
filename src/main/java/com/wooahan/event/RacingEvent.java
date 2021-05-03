package com.wooahan.event;

import com.wooahan.vo.Car;
import com.wooahan.vo.Input;
import com.wooahan.vo.Result;
import lombok.Getter;

import java.util.List;

public class RacingEvent {

    @Getter
    private final Result result;

    public RacingEvent() {
        this.result = new Result();
    }

    public void makeResult(Input input) {
        List<Car> carList = input.getCarList();
        for (int idx = 0; idx < input.getRacingCount(); idx++) {
            racing(carList);
        }
    }

    private void racing(List<Car> carList) {
        for (Car car: carList) {
            Integer position = car.goFoward();
            result.calculateWinningPosition(position);
        }
    }
}
