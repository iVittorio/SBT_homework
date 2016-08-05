package ru.sbt.hw.hw5.exceptions;

/**
 * Created by i.viktor on 04/08/16.
 */
public class AccountIsLockedException extends RuntimeException {
    public AccountIsLockedException(String message) {
        super(message);
    }

    public AccountIsLockedException(String message, Throwable cause) {
        super(message, cause);
    }
}
