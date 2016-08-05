package ru.sbt.hw.hw5;

/**
 * Created by i.viktor on 04/08/16.
 */
public interface Terminal {
    boolean enterPin(String card, String pin);

    void getBalance();

    void getMoney();

    void putMoney();
}
