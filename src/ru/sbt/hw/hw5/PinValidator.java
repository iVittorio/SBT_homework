package ru.sbt.hw.hw5;


/**
 * Created by i.viktor on 04/08/16.
 */
public class PinValidator {
    private int pin;

    private int serverPin;


    public PinValidator(int pin, int serverPin) {
        this.pin = pin;
        this.serverPin = serverPin;
    }


    public boolean checkPin() throws AccountIsLockedException {
        boolean key = false;
        if(this.pin == this.serverPin) return true;
        return false;
    }
}
