package ru.sbt.hw.hw4.pecs;

import java.util.*;

public class CollectionUtils {

    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {

        destination.addAll(source);

    }



    public static<T> List<T> newArrayList() {
        return new ArrayList<>();
    }



    public static<T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }



    public static<T> List limit(List<? extends T> source, int size) {
        return source.subList(0, size - 1);
    }



    public static<T> void add(List<? super T> source, T o) {
        source.add(o);
    }



    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }



    public static<T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }



    public static<T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for(T t : c2) {
            if(c1.contains(c2)) {
                return true;
            } else return false;
        } return false;
    }



    public static<T> List range(List<? extends T> list, T min, T max) {
        return list.subList(list.indexOf(min), list.indexOf(max));
    }



    public static<T> List range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<? extends T> range = list.subList(list.indexOf(min), list.indexOf(max));
        range.sort(comparator);
        return range;
    }
}
