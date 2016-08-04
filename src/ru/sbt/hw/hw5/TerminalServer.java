package ru.sbt.hw.hw5;

/**
 * Created by i.viktor on 04/08/16.
 */
public class TerminalServer {
    private int countMoney;

    private int pin;

    public void setCountMoney(int countMoney) {
        this.countMoney = countMoney;
    }

    public void setPin(int pin) throws IncorrectPinException {
        Integer iPin = new Integer(pin);
        if(iPin.toString().length() != 4 && pin<0) throw new IncorrectPinException("Некорректный PIN");
        this.pin = pin;
    }

    public int getCountMoney() throws NotEnoughMoneyException, NetworkException {
        if(countMoney <= 0) throw new NetworkException("Нет денег :(");
        return countMoney;
    }

    public int getPin() throws NetworkException {
        return pin;
    }



}
