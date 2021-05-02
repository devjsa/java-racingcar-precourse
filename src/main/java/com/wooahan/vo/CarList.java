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
        String[] cars = validateCars(carNames);
        setCarList(cars);
    }

    private void setCarList(String[] cars) {
        carList = new ArrayList<>();
        for (String name : cars) {
            carList.add(new Car(name));
        }
    }

    private String[] validateCars(String carNames) throws InputMismatchException {
        String[] rawCars = carNames.split(ValueConstants.WINNER_DELIMITER_CHAR);
        validateListSize(rawCars);
        String[] cars = new String[rawCars.length];
        for (int idx = 0; idx < rawCars.length; idx++) {
            String name = rawCars[idx].trim();
            validateEmptyString(name);
            validateLength(name);
            cars[idx] = name;
        }
        return cars;
    }

    private void validateEmptyString(String name) throws InputMismatchException {
        if (name == null || "".equals(name)) {
            throw new InputMismatchException();
        }
    }

    private void validateLength(String name) throws InputMismatchException {
        if (name.length() > ValueConstants.CAR_NAME_LIMIT) {
            throw new InputMismatchException();
        }
    }

    private void validateListSize(String[] rawCars) throws InputMismatchException {
        if (rawCars.length > ValueConstants.CAR_LIST_LIMIT) {
            throw new InputMismatchException();
        }
    }
}
