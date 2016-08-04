package ru.sbt.hw.hw5;

/**
 * Created by i.viktor on 04/08/16.
 */
public class TerminalImpl implements Terminal {



    private final TerminalServer server = new TerminalServer();

    private final PinValidator pinValidator = new PinValidator(1234,server.getPin());

    @Override
    public void checkAccount() {

    }

    @Override
    public void getMoney(int n) {

    }

    @Override
    public void putMoney(int n) {

    }
}
