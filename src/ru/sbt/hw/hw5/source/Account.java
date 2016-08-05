package ru.sbt.hw.hw5.source;

/**
 * Created by i.viktor on 05/08/16.
 */
public class Account {
    private final String cardNumber;

    private final String pin;

    private int money;

    public Account(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public void setMoney(int money) {
        this.money += money;
    }

    public String getCardNumber() {

        return cardNumber;
    }

    public int getMoney() {
        return money;
    }

    public int getCash(int cash) throws RuntimeException {
        if(this.money < cash) throw new RuntimeException("На счету не достаточно денег");
        else {
            this.money -= cash;
            return money;
        }
    }

    public String getPin() {
        return pin;
    }
}
