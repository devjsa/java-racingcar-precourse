package com.wooahan;

import com.wooahan.vo.CarList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingEventTest {

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

}