package com.wooahan.event;

import com.wooahan.vo.Car;
import com.wooahan.vo.Input;
import com.wooahan.vo.Result;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

import static com.wooahan.constants.MessageConstants.RACING_RESULT_MESSAGE;
import static com.wooahan.constants.ValueConstants.RACING_POSITION_CHAR;
import static com.wooahan.constants.ValueConstants.RACING_VIEW_CHAR;

public class RacingEvent {

    @Getter
    private final Result result;

    public RacingEvent() {
        this.result = new Result();
    }

    public void makeResult(Input input) {
        List<Car> carList = input.getCarList();
        System.out.println(RACING_RESULT_MESSAGE);
        for (int idx = 0; idx < input.getRacingCount(); idx++) {
            racing(carList);
        }
        total(carList);
    }

    private void total(List<Car> carList) {
        for (Car car: carList) {
            result.addWnningCar(car);
        }
    }

    private void racing(List<Car> carList) {
        for (Car car: carList) {
            Integer position = car.goFoward();
            printRacing(car);
            result.calculateWinningPosition(position);
        }
        System.out.print("\n");
    }

    private void printRacing(Car car){
        String print = String.format("%s %s %s", car.getName(), RACING_VIEW_CHAR, getPositionString(car));
        System.out.println(print);
    }

    private String getPositionString(Car car) {
        return String.join("", Collections.nCopies(car.getPosition(), RACING_POSITION_CHAR));
    }
}
