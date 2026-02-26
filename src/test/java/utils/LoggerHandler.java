package utils;

import org.apache.log4j.Logger;

public class LoggerHandler {

    public static Logger getLogger(Class<?> clazz) {
        return Logger.getLogger(clazz);
    }
}
