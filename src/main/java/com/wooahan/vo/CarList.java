package com.wooahan.vo;


import com.wooahan.constants.ValueConstants;
import lombok.Getter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@Getter
public class CarList {
    private List<Car> carList;

    public CarList(String carNames) throws InputMismatchException {
        String[] cars = carNames.split(ValueConstants.WINNER_DELIMITER_CHAR);
        setCarList(cars);
    }

    private void setCarList(String[] cars) {
        carList = new ArrayList<>();
        for (String name : cars) {
            carList.add(new Car(name));
        }
    }
}
