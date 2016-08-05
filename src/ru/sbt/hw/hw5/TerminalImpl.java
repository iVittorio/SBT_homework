package ru.sbt.hw.hw5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by i.viktor on 04/08/16.
 */
public class TerminalImpl implements Terminal {
    private final PinValidator pinValidator;

    private final TerminalServer terminalServer;

    private boolean correctedPin;
    private int countTrying = 0;
    private boolean accountLocker = false;
    private Date time;

    public TerminalImpl(PinValidator pinValidator, TerminalServer terminalServer) {
        this.pinValidator = pinValidator;
        this.terminalServer = terminalServer;
    }

    @Override
    public boolean enterPin(String card, String pin) {
        try {
            if (isAccountLocker()) {
                throw new AccountIsLockedException("Счет заблокирован до:" + getUnlockTimeFormatted());
            }
            pinValidator.carValidator(card);
            pinValidator.pinValidator(pin);

            terminalServer.checkCard(card);
            terminalServer.checkPin(pin);

            correctedPin = true;
            countTrying = 0;

            System.out.println("Корректный PIN");
            return true;
        } catch (AccountIsLockedException e) {
            countTrying++;
            System.out.println(e.getMessage());
            if (countTrying >= 3) {
                accountLocker = true;
                time = new Date(System.currentTimeMillis() + 5*1000);
                System.out.println("Счет заблокирован до: " + getUnlockTimeFormatted());
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private String getUnlockTimeFormatted() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(time);
    }

    @Override
    public void putMoney(int n) {
        try {
            if(isAccountLocker()) {
                throw new AccountIsLockedException("Счет заблокирован до: " + getUnlockTimeFormatted());
            }
            if (!correctedPin) {
                throw new RuntimeException("Введите верный PIN или номер счета");
            }
            if (n%100 != 0) {
                throw new RuntimeException("Минимальная сумма для пополнения счета равна 100 у.е.");
            }
            terminalServer.putMoney(n);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getBalance() {
        try {
            if(isAccountLocker()) {
                throw new AccountIsLockedException("Счет заблокирован до: " + getUnlockTimeFormatted());
            }
            if (!correctedPin) {
                throw new RuntimeException("Введите верный PIN");
            }
            terminalServer.getBalance();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getMoney(int n) {
        try {
            if(isAccountLocker()) {
                throw new AccountIsLockedException("Счет заблокирован до: " + getUnlockTimeFormatted());
            }
            if (!correctedPin) {
                throw new RuntimeException("Введите верный PIN");
            }
            if (n%100 != 0) {
                throw new RuntimeException("Минимальная сумма для снятия равна 100 у.е.");
            }

            terminalServer.getCash(n);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isAccountLocker() {
        if(accountLocker) {
            if(time.compareTo(new Date(System.currentTimeMillis())) > 0) {
                return accountLocker;
            } else {
                accountLocker = false;
            }
        }
        return accountLocker;
    }
}
