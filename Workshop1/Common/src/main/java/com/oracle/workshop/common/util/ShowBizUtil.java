package com.oracle.workshop.common.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public class ShowBizUtil {
    //get log4j handler
    private static final Logger logger = Logger.getLogger(ShowBizUtil.class);

    public static Date getDate(String dateString, String format) {
        Date releaseDate;
        try {
            releaseDate = new SimpleDateFormat(format, Locale.US).parse(dateString);
        } catch (ParseException e) {
            releaseDate = handleParseException(logger);
        }
        return releaseDate;
    }

    public static Date getDateFullFormat(String dateString)  {
        return getDate(dateString, "MMMM d, yyyy");
    }

    public static Date getDateOnlyYear(String dateString)  {
        return getDate(dateString, "yyyy");
    }

    public static  Date handleParseException(Logger logger) {
        Date releaseDate;
        logger.error("error in parsing date");
        releaseDate = new Date();
        return releaseDate;
    }
}
