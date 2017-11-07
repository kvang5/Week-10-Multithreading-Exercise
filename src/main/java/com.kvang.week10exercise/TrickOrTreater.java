package com.kvang.week10exercise;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.util.Date;

@Log4j
@Getter
@Setter
public class TrickOrTreater implements Runnable{

    private String name;
    private Date inTime;
    private House house;

    public TrickOrTreater(House house) {
        this.house = house;
    }

    public void run() {
        goAskForCandy();
    }

    private synchronized void goAskForCandy() {
        house.add(this);
    }
}
