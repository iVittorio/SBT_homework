package ru.sbt.hw.hw7;

/**
 * Created by i.viktor on 12/08/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        PluginManager manager = new PluginManager("/Users/Classes");

        Plugin plugin1 = manager.load("Plugin1","ru.sbt.hw.hw7.PluginImpl");

        Plugin plugin2 = manager.load("Plugin2","ru.sbt.hw.hw7.PluginImpl");

        Plugin plugin3 = manager.load("Plugin2","ru.sbt.hw.hw7.plugins.PluginImpl");

        plugin1.doUsefull();

        plugin2.doUsefull();

        plugin3.doUsefull();

        System.out.println(plugin1.getClass().getName() + " " + plugin2.getClass().getName());
        System.out.println(plugin1 == plugin2);

    }
}
