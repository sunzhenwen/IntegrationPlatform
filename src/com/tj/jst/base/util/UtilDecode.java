package com.tj.jst.base.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class UtilDecode {
	
	/**
	 * 中文转码
	 * @param personName
	 * @return
	 */
	public static String getDecode(String personName)
	{
		try {
			personName = URLDecoder.decode(personName,"utf8");
			if (personName != null){
				personName = URLDecoder.decode(personName,"utf8");
			}
			
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("编码转换错误，请联系管理员");
	    }
		return personName;
	}
	
	public static String transformation(String conName)
	{
		String name = "";
		
		//建市
		if(conName.equals("1-1"))
		{
			name = "建设工程施工合同（建市[2010]88号）封皮";
		}
		if(conName.equals("1-2"))
		{
			name = "建设工程施工合同（建市[2010]88号）通用合同条款";
		}
		if(conName.equals("1-3"))
		{
			name = "建设工程施工合同（建市[2010]88号）专用合同条款";
		}
		if(conName.equals("1-4"))
		{
			name = "建设工程施工合同（建市[2010]88号）附件一";
		}
		if(conName.equals("1-5"))
		{
			name = "建设工程施工合同（建市[2010]88号）附件二";
		}
		if(conName.equals("1-6"))
		{
			name = "建设工程施工合同（建市[2010]88号）附件三";
		}
		if(conName.equals("1-7"))
		{
			name = "建设工程施工合同（建市[2010]88号）附件四";
		}
		if(conName.equals("1-8"))
		{
			name = "建设工程施工合同（建市[2010]88号）附件五";
		}
		if(conName.equals("1-9"))
		{
			name = "建设工程施工合同（建市[2010]88号）附件六";
		}
		if(conName.equals("1-10"))
		{
			name = "建设工程施工合同（建市[2010]88号）附件七";
		}
		if(conName.equals("1-11"))
		{
			name = "建设工程施工合同（建市[2010]88号）附件八";
		}
		
		//发改
		if(conName.equals("2-1"))
		{
			name = "建设工程施工合同（发改法规[2011]3018号）封皮";
		}
		if(conName.equals("2-2"))
		{
			name = "建设工程施工合同（发改法规[2011]3018号）通用条款";
		}
		if(conName.equals("2-3"))
		{
			name = "建设工程施工合同（发改法规[2011]3018号）专用条款";
		}
		if(conName.equals("2-4"))
		{
			name = "建设工程施工合同（发改法规[2011]3018号）附件一";
		}
		if(conName.equals("2-5"))
		{
			name = "建设工程施工合同（发改法规[2011]3018号）附件二";
		}
		
		//劳务分包
		if(conName.equals("3-1"))
		{
			name = "黑龙江省建设工程施工劳务分包合同-封皮";
		}
		if(conName.equals("3-2"))
		{
			name = "黑龙江省建设工程施工劳务分包合同-内容";
		}
		if(conName.equals("3-3"))
		{
			name = "黑龙江省建设工程施工劳务分包合同-附件";
		}
		
		//专业分包
		if(conName.equals("4-1"))
		{
			name = "黑龙江省建设工程施工专业分包合同-封皮";
		}
		if(conName.equals("4-2"))
		{
			name = "黑龙江省建设工程施工专业分包合同-第一部分";
		}
		if(conName.equals("4-3"))
		{
			name = "黑龙江省建设工程施工专业分包合同-第二部分通用条款";
		}
		if(conName.equals("4-4"))
		{
			name = "黑龙江省建设工程施工专业分包合同-第三部分专用条款";
		}
		return name;
	}
	
}
