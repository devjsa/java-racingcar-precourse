package com.wooahan;

import com.wooahan.constants.MessageConstants;
import com.wooahan.event.InputEvent;
import com.wooahan.event.RacingEvent;
import com.wooahan.event.WraupEvent;
import com.wooahan.vo.Input;

public class Racingcar {

    public static void main(String[] args) {
        System.out.println(MessageConstants.GREETING_MESSAGE);
        InputEvent inputEvent = new InputEvent();
        Input input = inputEvent.getInput();

        RacingEvent racingEvent = new RacingEvent();
        racingEvent.makeResult(input);

        WraupEvent wraupEvent = new WraupEvent();
        wraupEvent.printWinner(racingEvent.getResult());
        System.out.println(MessageConstants.END_MESSAGE);
    }
}
