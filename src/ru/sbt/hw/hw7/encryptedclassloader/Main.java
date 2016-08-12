package ru.sbt.hw.hw7.encryptedclassloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 * Created by i.viktor on 12/08/16.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String dir = "/Users/i.viktor/IdeaProjects/SBT_homework/src/";

        String name = "ru.sbt.hw.hw7.encryptedclassloader.TestClass";

        File file = new File(dir);

        crypto(file, name, "java");

        ClassLoader classLoader = new EncryptedClassLoader(Main.class.getClassLoader(), file, "java");

        TestClass testClass = (TestClass) classLoader.loadClass(name).newInstance();

        testClass.sayHello();

    }

    public static void crypto(File file, String name, String key) {
        String classPath = name.replace(".","/").concat(".class");

        Path path = Paths.get(file.getPath(), classPath);

        byte encoder = (byte) key.length();

        try {
            byte[] arr = Files.readAllBytes(path);

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (byte)(arr[i] - encoder);
            }

            Files.write(path, arr, StandardOpenOption.WRITE);

        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
    }
}
