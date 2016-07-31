package ru.sbt.hw.hw4;

import java.util.*;

public class TestCountMap {
    public static void main(String[] args) {
        CountMap<String> map1 = new CountMapExample<>();
        CountMap<String> map2 = new CountMapExample<>();
        Map<String, Integer> map3 = new HashMap<>();

        map1.add("q");
        map1.add("q");
        map1.add("q");
        map1.add("q");
        map1.add("w");
        map1.add("w");
        map1.add("w");

        System.out.println("map1 count w: " + map1.getCount("w") + ", map1 count q: " + map1.getCount("q"));

        map2.add("q");
        map2.add("q");
        map2.add("w");
        map2.add("w");
        map2.add("w");

        map2.addAll(map1);

        System.out.println("map2 count w: " + map2.getCount("w") + ", map2 count q: " + map2.getCount("q"));

        map1.toMap(map3);

        System.out.println("map3 count w: " + map3.get("w") + ", map2 count q: " + map3.get("q"));

        map2.toMap(map3);

        System.out.println("map3 count w: " + map3.get("w") + ", map2 count q: " + map3.get("q"));

        System.out.println("remove w from map1: " + map1.remove("w"));
        System.out.println("remove q from map1: " + map1.remove("q"));
        System.out.println("count w: " + map1.getCount("w") + ", count q: " + map1.getCount("q"));

    }
}
