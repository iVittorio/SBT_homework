package ru.sbt.hw.hw4;

import java.util.*;

public class CountMapExample<E> implements CountMap<E>  {

    private final Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E o) {
        if(!map.containsKey(o)) map.put(o, 1);
        else map.put(o, map.get(o) + 1);
    }

    @Override
    public int getCount(E o) {
        if(map.containsKey(o)) return map.get(o);
        else return 0;
    }

    @Override
    public int remove(E o) {
        int i = getCount(o);
        if(i == 0) return 0;
        else {
            map.remove(o);
            return i;
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends E> source) {
        Map<? extends E, Integer> map = source.toMap();
        for (E key : map.keySet()) {
            if(this.map.containsKey(key)) {
                this.map.put(key, this.getCount(key) + map.get(key));
            } else this.map.put(key, map.get(key));
        }
    }

    @Override
    public Map<E, Integer> toMap() {
        Map<E, Integer> map = this.map;
        return map;
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        Map<E, Integer> map = this.toMap();
        for(E key : map.keySet()) {
            if(destination.containsKey(key)) {
                destination.put(key, destination.get(key) + map.get(key));
            } else destination.put(key, map.get(key));
        }
    }
}
