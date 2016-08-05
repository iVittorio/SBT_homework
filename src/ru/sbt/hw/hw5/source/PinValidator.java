package ru.sbt.hw.hw5.source;


import ru.sbt.hw.hw5.exceptions.AccountIsLockedException;

/**
 * Created by i.viktor on 04/08/16.
 */
public class PinValidator {

    public void carValidator(String cardNum) throws AccountIsLockedException {
        try {
            Integer.parseInt(cardNum);
            if(cardNum.length() != 5) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new AccountIsLockedException("Некорректный номер счета", e);
        }
    }

    public void pinValidator(String pin) throws AccountIsLockedException {
        try {
            Integer.parseInt(pin);
            if(pin.length() != 4) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new AccountIsLockedException("Некорректный PIN", e);
        }
    }
}
