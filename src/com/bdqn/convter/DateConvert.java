package com.bdqn.convter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author ldwjava
 * @Date 2019/5/9 15:56
 * @Desc 日期转化
 **/

public class DateConvert implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (s != null && !"".equals(s)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = format.parse(s);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
