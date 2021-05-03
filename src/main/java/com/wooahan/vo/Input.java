package com.wooahan.vo;

import com.wooahan.constants.ValueConstants;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.InputMismatchException;
import java.util.List;

@Getter
@Setter
@ToString
public class Input {
    private List<Car> carList;
    private Integer racingCount;

    public void setRacingCount(String countString) throws NumberFormatException {
        int count = Integer.parseInt(countString);
        if (count > ValueConstants.RACING_COUNT_LIMIT) {
            throw new InputMismatchException();
        }
        this.racingCount = count;
    }
}
