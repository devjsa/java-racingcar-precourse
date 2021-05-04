package com.wooahan.event;

import com.wooahan.constants.MessageConstants;
import com.wooahan.vo.CarList;
import com.wooahan.vo.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputEvent {

    public Input getInput() {
        System.out.println(MessageConstants.GREETING_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        Input input = new Input();
        getCarInput(input, scanner);
        getCountInput(input, scanner);
        scanner.close();
        return input;
    }

    private void getCountInput(Input input, Scanner scanner) {
        System.out.println(MessageConstants.COUNT_REQUIRE_MESSAGE);
        try {
            String countString = scanner.nextLine();
            input.setRacingCount(countString);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println(MessageConstants.ERROR_MESSAGE);
            getCountInput(input, scanner);
        }
    }

    private void getCarInput(Input input, Scanner scanner) {
        System.out.println(MessageConstants.CAR_NAME_REQUIRE_MESSAGE);
        try {
            CarList carList = new CarList(scanner.nextLine());
            input.setCarList(carList.getCarList());
        } catch (InputMismatchException e) {
            System.out.println(MessageConstants.ERROR_MESSAGE);
            getCarInput(input, scanner);
        }
    }

}
