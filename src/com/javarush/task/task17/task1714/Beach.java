package com.javarush.task.task17.task1714;

/* 
Comparable
*/

import java.util.TreeSet;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach obj) {
        int distanceParam = (int) (distance - obj.getDistance());
        int qualityParam = quality - obj.getQuality();
        return  100 * distanceParam + qualityParam;
    }
    public static void main(String[] args) {
        TreeSet<Beach> beachSet = new TreeSet<Beach>();

        beachSet.add(new Beach("beach1", 12.6f, 7));
        beachSet.add(new Beach("beach2", 124.6f, 8));
        beachSet.add(new Beach("beach3", 124.6f, 7));
        beachSet.add(new Beach("beach4", 124.2f, 7));
        beachSet.add(new Beach("beach5", 1.6f, 90));
        beachSet.add(new Beach("beach6", 124.6f, 6));

        for (Beach x : beachSet)
        {
            System.out.println(x.getName() + " " + x.getDistance() + " " + x.getQuality());
        }
    }
}