package com.kvang.week10exercise;

import lombok.extern.log4j.Log4j;

@Log4j
public class Riley implements Runnable{

    private House house;

    public Riley(House house) {
        this.house = house;
    }

    public void run() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException iex) {
            log.error("Interrupted Exception error in Riley run(): ", iex);
        }

        log.info("Trick-Or-Treating begins");
        while (true) {
            house.watchTv();
        }
    }
}
