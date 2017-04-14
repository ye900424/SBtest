package com.tmp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by clover on 2016/03/06.
 */
public abstract class Properties {
    protected final Class clazz = this.getClass();
    protected final Logger logger = LoggerFactory.getLogger(clazz.getClass());
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void print(Logger logger) {
        logger.info("[properties] {} ---> {}", clazz.getName(), this);
    }
    public void print() {
        print(getLogger());
    }
}
