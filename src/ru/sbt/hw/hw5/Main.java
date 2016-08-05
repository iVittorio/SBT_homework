package ru.sbt.hw.hw5;

import ru.sbt.hw.hw5.source.PinValidator;
import ru.sbt.hw.hw5.source.TerminalImpl;
import ru.sbt.hw.hw5.source.TerminalServer;

/**
 * Created by i.viktor on 05/08/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        TerminalImpl terminal = new TerminalImpl(new PinValidator(), new TerminalServer());

        String s = "12345";
        System.out.println(s.length());

        terminal.enterPin("12345","1234");
        terminal.getBalance();
        terminal.enterPin("12345","1234");
        terminal.putMoney(10000);
        terminal.enterPin("12345","1234");
        terminal.getBalance();
        terminal.enterPin("12345","1231");
        terminal.enterPin("12345","1232");
        terminal.enterPin("12345","1232");
        Thread.sleep(5000);
        terminal.enterPin("12345","1234");
        terminal.getMoney(100);
        terminal.enterPin("12345","1234");
        terminal.getBalance();
        terminal.enterPin("12345","1234");
        terminal.getMoney(120);

    }
}
