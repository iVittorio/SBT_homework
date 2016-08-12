package ru.sbt.hw.hw7;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by i.viktor on 11/08/16.
 */
public class PluginLoader extends URLClassLoader {


    public PluginLoader(URL[] urls) {

        super(urls);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.startsWith("java") || name.equals("ru.sbt.hw.hw7.Plugin")) {
            return super.loadClass(name);
        }

        return findClass(name);
    }
}
