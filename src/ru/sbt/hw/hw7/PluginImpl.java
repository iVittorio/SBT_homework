package ru.sbt.hw.hw7;

/**
 * Created by i.viktor on 12/08/16.
 */
public class PluginImpl implements Plugin {
    static {
        System.out.println("PluginImpl #1");
    }
    @Override
    public void doUsefull() {
        System.out.println("To do #1");
    }
}
