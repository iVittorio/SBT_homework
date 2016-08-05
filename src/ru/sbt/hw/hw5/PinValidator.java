package ru.sbt.hw.hw5;


/**
 * Created by i.viktor on 04/08/16.
 */
public class PinValidator {

    public void carValidator(String cardNum) throws AccountIsLockedException {
        try {
            Integer.parseInt(cardNum);
            if(cardNum.length() != 16) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new AccountIsLockedException("Некорректный номер карты", e);
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
