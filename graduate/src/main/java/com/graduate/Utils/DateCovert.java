package com.graduate.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCovert {
	//日期转换格式
	public static String timeC(Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 要转换的时间格式
		try {
			return sdf.format(time);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//获取日期具体为多少星期几
	public static String getWeek(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String week = sdf.format(date);
		return week;
		}

}
