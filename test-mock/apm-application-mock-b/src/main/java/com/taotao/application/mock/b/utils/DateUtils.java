package com.taotao.application.mock.b.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public enum DateUtils {

    instance;

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
