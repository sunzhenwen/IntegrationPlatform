package com.tj.jst.base.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class UtilDecode {
	
	/**
	 * ����ת��
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
	        throw new RuntimeException("����ת����������ϵ����Ա");
	    }
		return personName;
	}
	
	public static String transformation(String conName)
	{
		String name = "";
		
		//����
		if(conName.equals("1-1"))
		{
			name = "���蹤��ʩ����ͬ������[2010]88�ţ���Ƥ";
		}
		if(conName.equals("1-2"))
		{
			name = "���蹤��ʩ����ͬ������[2010]88�ţ�ͨ�ú�ͬ����";
		}
		if(conName.equals("1-3"))
		{
			name = "���蹤��ʩ����ͬ������[2010]88�ţ�ר�ú�ͬ����";
		}
		if(conName.equals("1-4"))
		{
			name = "���蹤��ʩ����ͬ������[2010]88�ţ�����һ";
		}
		if(conName.equals("1-5"))
		{
			name = "���蹤��ʩ����ͬ������[2010]88�ţ�������";
		}
		if(conName.equals("1-6"))
		{
			name = "���蹤��ʩ����ͬ������[2010]88�ţ�������";
		}
		if(conName.equals("1-7"))
		{
			name = "���蹤��ʩ����ͬ������[2010]88�ţ�������";
		}
		if(conName.equals("1-8"))
		{
			name = "���蹤��ʩ����ͬ������[2010]88�ţ�������";
		}
		if(conName.equals("1-9"))
		{
			name = "���蹤��ʩ����ͬ������[2010]88�ţ�������";
		}
		if(conName.equals("1-10"))
		{
			name = "���蹤��ʩ����ͬ������[2010]88�ţ�������";
		}
		if(conName.equals("1-11"))
		{
			name = "���蹤��ʩ����ͬ������[2010]88�ţ�������";
		}
		
		//����
		if(conName.equals("2-1"))
		{
			name = "���蹤��ʩ����ͬ�����ķ���[2011]3018�ţ���Ƥ";
		}
		if(conName.equals("2-2"))
		{
			name = "���蹤��ʩ����ͬ�����ķ���[2011]3018�ţ�ͨ������";
		}
		if(conName.equals("2-3"))
		{
			name = "���蹤��ʩ����ͬ�����ķ���[2011]3018�ţ�ר������";
		}
		if(conName.equals("2-4"))
		{
			name = "���蹤��ʩ����ͬ�����ķ���[2011]3018�ţ�����һ";
		}
		if(conName.equals("2-5"))
		{
			name = "���蹤��ʩ����ͬ�����ķ���[2011]3018�ţ�������";
		}
		
		//����ְ�
		if(conName.equals("3-1"))
		{
			name = "������ʡ���蹤��ʩ������ְ���ͬ-��Ƥ";
		}
		if(conName.equals("3-2"))
		{
			name = "������ʡ���蹤��ʩ������ְ���ͬ-����";
		}
		if(conName.equals("3-3"))
		{
			name = "������ʡ���蹤��ʩ������ְ���ͬ-����";
		}
		
		//רҵ�ְ�
		if(conName.equals("4-1"))
		{
			name = "������ʡ���蹤��ʩ��רҵ�ְ���ͬ-��Ƥ";
		}
		if(conName.equals("4-2"))
		{
			name = "������ʡ���蹤��ʩ��רҵ�ְ���ͬ-��һ����";
		}
		if(conName.equals("4-3"))
		{
			name = "������ʡ���蹤��ʩ��רҵ�ְ���ͬ-�ڶ�����ͨ������";
		}
		if(conName.equals("4-4"))
		{
			name = "������ʡ���蹤��ʩ��רҵ�ְ���ͬ-��������ר������";
		}
		return name;
	}
	
}
