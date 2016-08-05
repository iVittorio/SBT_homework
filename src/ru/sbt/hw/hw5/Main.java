package ru.sbt.hw.hw5;

/**
 * Created by i.viktor on 05/08/16.
 */
public class Main {
    public static void main(String[] args) {
        TerminalImpl terminal = new TerminalImpl(new PinValidator(), new TerminalServer());

        String s = "12345";
        System.out.println(s.length());

        terminal.enterPin("12345","1234");
        terminal.getBalance();
        terminal.putMoney(10000);
        terminal.getBalance();
    }
}
