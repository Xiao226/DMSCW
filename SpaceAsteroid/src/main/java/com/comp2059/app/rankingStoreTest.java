package com.comp2059.app;

import static com.comp2059.app.informationStore.rankingList;
import static org.junit.Assert.*;

/**
 * test file
 */
public class rankingStoreTest {
    @org.junit.Before
    public void setUp() throws Exception {
        rankingList=new String[20][5];
        rankingList[1] = new String[]{"Fish", "20", "0", "1:30", "60"};
        rankingList[0] = new String[]{"Smile", "233", "4", "3:50", "233"};
    }


    @org.junit.Test
    public void preparePrint() {
        assertEquals("Name, Destroyed Asteroid Number, Beaten Boss Number, Live Time, Score\nSmile 233 4 3:50 233 \nFish 20 0 1:30 60 \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",rankingStore.preparePrint());
    }

    @org.junit.Test
    public void compareTime() {
        assertEquals(false,rankingStore.compareTime("1:00","1:00"));
    }
    @org.junit.Test
    public void compareTime1() {
        assertEquals(true,rankingStore.compareTime("2:00","1:00"));
    }
}