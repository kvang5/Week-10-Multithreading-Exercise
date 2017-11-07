package com.kvang.week10exercise;

import lombok.extern.log4j.Log4j;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Log4j
public class KidsGenerator implements Runnable {

    private House house;

    public KidsGenerator(House house) {
        this.house = house;
    }

    public void run() {
        while (true) {
            TrickOrTreater trickOrTreater = new TrickOrTreater(house);
            trickOrTreater.setInTime(new Date());
            Thread kidThread = new Thread(trickOrTreater);
            trickOrTreater.setName("Child " + kidThread.getId());
            kidThread.start();

            try {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            } catch (InterruptedException iex) {
                log.error("Interrupted Exception in Kids Generator class caught " + iex);
            }
        }
    }
}
