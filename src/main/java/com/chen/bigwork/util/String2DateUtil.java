package com.chen.bigwork.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2DateUtil {
    public static Date string2Date(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(date);
    }
}
