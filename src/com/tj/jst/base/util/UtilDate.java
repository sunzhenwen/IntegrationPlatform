package com.tj.jst.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class UtilDate {
	
	/**
	 * ��ȡ��ǰʱ��
	 * @return
	 */
	public static Date getDate()
	{
		return new Date(new java.util.Date().getTime());
	}

	/**
	 * ��ȡ�����Ժ��ʱ��
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
     * ������ 2011-06-23 ��õ�ǰʱ��
     * 
     * @return String
     */
    public static String getTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return simpleDateFormat.format(c.getTime());
    }
}
