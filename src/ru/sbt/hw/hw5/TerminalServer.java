package ru.sbt.hw.hw5;


/**
 * Created by i.viktor on 04/08/16.
 */
public class TerminalServer {

    private final Account person = new Account("12345","1234");

    public void checkPin(String pin) {
        if(person.getPin().equals(pin)) return;
        else throw new RuntimeException("Не правильный PIN");
    }
    public void checkCard(String card) {
        if(person.getCardNumber().equals(card)) return;
        else throw new RuntimeException("Такого счета не существует");
    }

    public void getBalance() {
        System.out.println("Баланс равен: " + person.getMoney());
    }

    public void getCash(int sum) {
        try {
            person.getCash(sum);
        } catch (RuntimeException e) {
        }
    }

    public void putMoney(int sum) {
        person.setMoney(sum);
    }
}
