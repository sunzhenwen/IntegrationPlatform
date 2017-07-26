package com.tj.jst.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class UtilDate {
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static Date getDate()
	{
		return new Date(new java.util.Date().getTime());
	}

	/**
	 * 获取五年以后的时间
	 * @return
	 */
	public static java.sql.Date getStringChangeDate() {
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)+5);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String fDate = simpleDateFormat.format(curr.getTime());
        Date date = null;
        java.sql.Date sqldate = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = (Date) format.parse(fDate);
            sqldate=new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sqldate;
    }
	
    /**
     * 韩虎成 2011-06-23 获得当前时间
     * 
     * @return String
     */
    public static String getTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return simpleDateFormat.format(c.getTime());
    }
}
