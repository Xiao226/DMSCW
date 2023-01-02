package com.comp2059.app;

import org.junit.Test;

import java.util.Date;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

/**
 * test file
 */
public class informationStoreTest {

    @Test
    public void timeCalculate() throws InterruptedException {
        Date time1 = new Date();
        sleep(1000);
        Date time2 = new Date();
        assertEquals("0:01",informationStore.timeCalculate(time1,time2));
    }
}