package com.kvang.week10exercise;

import lombok.extern.log4j.Log4j;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Log4j
public class House {

    private int kidsPerHouse;
    private List<TrickOrTreater> listKid;
    private TrickOrTreater trickOrTreater;

    public House() {
        kidsPerHouse = 10;
        listKid = new LinkedList<TrickOrTreater>();
    }

    public void watchTv() {

        synchronized (listKid) {
            while (listKid.size() == 0) {
                log.info("Riley watches TV");
                try {
                    listKid.wait();
                } catch (InterruptedException iex) {
                    log.error("Interrupted Exception in House class for listKid.wait()" + iex);
                }
            }

            trickOrTreater = (TrickOrTreater) ((LinkedList<?>) listKid).poll();
        }
        long duration = 0;
        try {
            log.info(trickOrTreater.getName() + " rings doorbell");
            log.info("Riley answers the door");
            log.info("Riley gives candy");
            duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException iex) {
            log.error("Interrupted Exception in House class - giving out candy " + iex);
        }
        log.info("Riley goes back and enjoy watching tv.");
    }

    public void add(TrickOrTreater trickOrTreater) {
        log.info(trickOrTreater.getName() + " is created");
        synchronized (listKid) {
            if (listKid.size() == kidsPerHouse) {
                log.info("Too many kids at the door ");
                log.info(trickOrTreater.getName() + " Exists...");
                return;
            }

            ((LinkedList<TrickOrTreater>)listKid).offer(trickOrTreater);

            if (listKid.size() == 1) {
                listKid.notify();
            }
        }
    }
}
