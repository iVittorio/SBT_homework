package ru.sbt.hw.hw7;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by i.viktor on 11/08/16.
 */
public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws InstantiationException, MalformedURLException, ClassNotFoundException, IllegalAccessException {

        String path = "file://" + pluginRootDirectory + "/" + pluginName + "/";
        URL url = new URL(path);

        URLClassLoader loader = new PluginLoader(new URL[]{url});

        Class<?> clazz = loader.loadClass(pluginClassName);
        Object obj = clazz.newInstance();
        Plugin plugin = (Plugin) obj;

        return plugin;
    }
}
