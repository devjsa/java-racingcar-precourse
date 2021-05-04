package com.wooahan.vo;

import com.wooahan.constants.ValueConstants;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Result {
    private Integer winningPosition = 0;
    private final List<String> winningCars = new ArrayList<>();

    public String getWinningCarString() {
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < winningCars.size(); idx++) {
            sb.append(winningCars.get(idx));
            appendDelimiter(sb, idx);
        }
        return sb.toString();
    }

    private void appendDelimiter(StringBuilder sb, Integer idx) {
        if (idx + 1 < winningCars.size()) {
            sb.append(ValueConstants.WINNER_DELIMITER_CHAR);
        }
    }

    public void calculateWinningPosition(Integer position) {
        if (position > winningPosition) {
            winningPosition = position;
        }
    }

    public void addWnningCar(Car car) {
        if (car.getPosition().equals(this.winningPosition)) {
            this.winningCars.add(car.getName());
        }
    }
}
