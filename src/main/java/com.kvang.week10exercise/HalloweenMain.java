package com.kvang.week10exercise;

public class HalloweenMain {

    public static void main(String[] args) {
        House house = new House();

        Riley riley = new Riley(house);
        KidsGenerator kidsGenerator = new KidsGenerator(house);

        Thread rileyThread = new Thread(riley);
        Thread kidsGeneratorThread = new Thread(kidsGenerator);

        rileyThread.start();
        kidsGeneratorThread.start();
    }
}
