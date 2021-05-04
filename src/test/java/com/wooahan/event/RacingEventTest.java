package com.wooahan.event;

import com.wooahan.vo.Car;
import com.wooahan.vo.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingEventTest {

    @Test
    @DisplayName("경주 결과 집계")
    public void totalTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        RacingEvent racingEvent = new RacingEvent();
        Method total = racingEvent.getClass().getDeclaredMethod("total", List.class);
        total.setAccessible(true);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test0"));
        cars.add(new Car("test1"));

        // when
        total.invoke(racingEvent, cars);
        Result result = racingEvent.getResult();

        // then
        List<String> winningCars = result.getWinningCars();
        assertAll(
                () -> assertEquals("test0", winningCars.get(0)),
                () -> assertEquals("test1", winningCars.get(1))
        );
    }

    @Test
    @DisplayName("자동차 위치 문자열 받아오기")
    public void getPositionStringTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Car testCar = new Car("테스트");
        RacingEvent racingEvent = new RacingEvent();
        Method getPositionString = racingEvent.getClass().getDeclaredMethod("getPositionString", Car.class);
        getPositionString.setAccessible(true);

        // when
        String positionString = (String) getPositionString.invoke(racingEvent, testCar);

        // then
        assertEquals("", positionString);
    }

}