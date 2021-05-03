package com.wooahan.event;

import com.wooahan.vo.Result;

import static com.wooahan.constants.MessageConstants.NOTICE_MESSAGE;

public class WraupEvent {
    public void printWinner(Result result) {
        String winningCarString = String.format(NOTICE_MESSAGE, result.getWinningCarString());
        System.out.println(winningCarString);
    }
}
