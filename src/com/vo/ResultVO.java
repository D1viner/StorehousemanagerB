package com.vo;

public class ResultVO {
	
	int code = 0;
	String message = "";
	Object data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResultVO(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public ResultVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static ResultVO success(Object data)
	{
		return new ResultVO(1,"Ö´ÐÐ³É¹¦",data);
	}
	
	public static ResultVO fail(int code,String message)
	{
		return new ResultVO(code,message,null);
	}
	
	@Override
	public String toString() {
		return "ResultVO [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
}
	