package ru.sbt.hw.hw5.exceptions;

/**
 * Created by i.viktor on 04/08/16.
 */
public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message, Throwable cause) {
        super(message, cause);
    }
}
