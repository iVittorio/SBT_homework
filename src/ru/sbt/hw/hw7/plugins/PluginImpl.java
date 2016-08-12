package ru.sbt.hw.hw7.plugins;

import ru.sbt.hw.hw7.Plugin;

/**
 * Created by i.viktor on 12/08/16.
 */
public class PluginImpl implements Plugin {
    static {
        System.out.println("PluginImpl #2");
    }
    @Override
    public void doUsefull() {
        System.out.println("To do #2");
    }
}
