package ru.sbt.hw.hw6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by i.viktor on 08/08/16.
 */
public class BeanUtils {


    public static void main(String[] args) {
        TestClass testClass1 = new TestClass(20, "Alex", true);
        TestClass testClass2 = new TestClass();

        String s = "das";


        assign(testClass2, testClass1);

        System.out.println("Name: " + testClass2.getName() +
                            ", age: " + testClass2.getAge() +
                            ", sex: " + testClass2.getSex());

    }

    public static void assign(Object to, Object from) {
        List<Method> getters = getAllGetters(from);
        List<Method> setters = getAllSetters(to);

        try {
            for (Method s : setters) {
                for (Method g : getters) {
                    if(s.getParameterTypes()[0].equals(g.getReturnType()))
                        s.invoke(to,g.invoke(from));
                }
            }
        } catch ( IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("We have trouble with invocation method", e);
        }



    }


    public static List<Method> getAllSetters (Object o) {
        List<Method> list = new ArrayList<>();

        Class<?> clazz = o.getClass();

        Method[] methods = clazz.getMethods();

        for(Method m : methods) {
            if(m.getName().startsWith("set")) list.add(m);
        }

        return list;
    }

    public static List<Method> getAllGetters (Object o) {
        List<Method> list = new ArrayList<>();

        Class<?> clazz = o.getClass();

        Method[] methods = clazz.getMethods();

        for(Method m : methods) {
            if(m.getName().startsWith("get")) list.add(m);
        }

        return list;
    }
}
