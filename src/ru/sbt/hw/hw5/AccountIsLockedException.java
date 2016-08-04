package ru.sbt.hw.hw5;

/**
 * Created by i.viktor on 04/08/16.
 */
public class AccountIsLockedException extends RuntimeException {
    public AccountIsLockedException(String message) {
        super(message);
    }
}
