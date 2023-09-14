package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class CommonUtils {

	public static String tranToUtf8(String a)
	{
		try {
			return new String(a.getBytes("iso8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		return a;
	}
	
	/**
	 * 传入req对象，读取出请求体重的json字符串
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public static String getRequstBody(HttpServletRequest req) throws IOException
	{
		BufferedReader r = new BufferedReader(new InputStreamReader(req.getInputStream(),"utf-8"));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line=r.readLine())!=null)
		{
			sb.append(line);
		}
		String jsonData = sb.toString();
		return jsonData;
	}
}
