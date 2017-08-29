package com.TEST;

import javax.annotation.Resource;
import javax.sound.midi.Instrument;

/**
 * Created by caoyang on 2017/7/25.
 */

public class Counter {
    private int flag;
    private String strFlag;
    private Piano piano;

    public  Counter(int flag,String strFlag,Piano piano) {
        this.flag = flag;
        this.strFlag = strFlag;
        this.piano = piano;
    }



    private double multiplier;

    private String song;




}

