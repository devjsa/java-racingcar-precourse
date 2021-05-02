package com.wooahan.vo;

import com.wooahan.constants.ValueConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private Integer winningCount;
    private String[] winningCars;

    public String getWinningCarString() {
        StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < winningCars.length; idx++) {
            sb.append(winningCars[idx]);
            appendDelimiter(sb, idx);
        }
        return sb.toString();
    }

    private void appendDelimiter(StringBuilder sb, Integer idx) {
        if ( idx < winningCars.length) {
            sb.append(ValueConstants.WINNER_DELIMITER_CHAR);
        }
    }
}
