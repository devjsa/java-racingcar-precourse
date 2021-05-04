package com.wooahan.event;

import com.wooahan.vo.CarList;
import com.wooahan.vo.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputEventTest {
    @Test
    @DisplayName("자동차 수 입력하기 - 예외")
    public void getCarInputTest_Exception() {
        // given
        String value = "";

        // when

        // then
        assertThrows(InputMismatchException.class, () -> new CarList(value));
    }

    @Test
    @DisplayName("자동차 수 입력하기")
    public void getCarInputTest() {
        // given
        String value = "홍길동, Mark";

        // when
        CarList carList = new CarList(value);

        // then
        assertEquals(2, carList.getCarList().size());
    }

    @Test
    @DisplayName("횟수 입력하기 - 예외")
    public void getCountInputTest_Exception() {
        // given
        Input input = new Input();
        String value = "150";

        // when

        // then
        assertThrows(InputMismatchException.class, () -> input.setRacingCount(value));
    }

    @Test
    @DisplayName("횟수 입력하기")
    public void getCountInputTest() {
        // given
        Input input = new Input();
        String value = "10";

        // when
        input.setRacingCount(value);

        // then
        assertEquals(10, input.getRacingCount());
    }


}