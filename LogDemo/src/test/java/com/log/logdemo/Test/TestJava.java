package com.log.logdemo.Test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJava {
    private static final Logger logger = LoggerFactory.getLogger(TestJava.class);

    @Test
    public void test0(){
        logger.info("info=======================");
        logger.error("error=====================");
        logger.debug("debug=====================");
        logger.warn("warn=======================");
        logger.trace("trace=====================");
    }

}
