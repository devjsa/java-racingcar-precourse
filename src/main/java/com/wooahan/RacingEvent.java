package com.wooahan;

import com.wooahan.vo.Car;
import com.wooahan.vo.Input;
import com.wooahan.vo.Result;

import java.util.List;

public class RacingEvent {

    public Result getResult(Input input) {
        Result result = new Result();
        List<Car> carList = input.getCarList();
        for (int idx = 0; idx < input.getRacingCount(); idx++) {
            racing(carList, result);
        }
        total(carList, result);
        return result;
    }

    private void total(List<Car> carList, Result result) {
        for (Car car: carList) {
            result.addWnningCar(car);
        }
    }

    private void racing(List<Car> carList, Result result) {
        for (Car car: carList) {
            Integer position = car.goFoward();
            result.calculateWinningPosition(position);
        }
    }
}
