package ru.sbt.hw.hw7.encryptedclassloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by i.viktor on 12/08/16.
 */
public class EncryptedClassLoader extends ClassLoader {
    private final String key;

    private final File dir;

    public EncryptedClassLoader(ClassLoader parent, File dir, String key) {
        super(parent);
        this.dir = dir;
        this.key = key;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        final Class<?> result;

        String classPath = name.replace(".","/").concat(".class");

        Path path = Paths.get(dir.getPath(), classPath);


        byte encryptor = (byte) key.length();

        try {
            byte[] arr = Files.readAllBytes(path);

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (byte)(arr[i] + encryptor);
            }

            result = defineClass(name, arr, 0, arr.length);

        } catch (IOException e) {
            throw new ClassNotFoundException("File not found", e);
        }

        return result;
    }

}
