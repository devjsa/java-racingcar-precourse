package com.wooahan;

import com.wooahan.constants.MessageConstants;
import com.wooahan.vo.CarList;
import com.wooahan.vo.Input;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputEvent {

    public Input getInput(){
        Scanner scanner = new Scanner(System.in);
        Input input = new Input();
        getCarInput(input, scanner);
        scanner.close();
        return input;
    }

    private void getCarInput(Input input, Scanner scanner) {
        System.out.println(MessageConstants.CAR_NAME_REQUIRE_MESSAGE);
        try {
            CarList carList = new CarList(scanner.nextLine());
            input.setCarList(carList.getCarList());
        } catch (InputMismatchException e) {
            System.out.println(MessageConstants.ERROR_MESSAGE);
            getInput();
        }
    }

}
