package ru.sbt.hw.hw4;

import java.util.Map;

public interface CountMap<E> {

    void add(E o);

    int getCount(E o);

    //current count
    int remove(E o );

    int size();

    void addAll (CountMap<? extends E> source);

    Map<E, Integer> toMap();

    void toMap (Map<? super E, Integer> destination);

}
