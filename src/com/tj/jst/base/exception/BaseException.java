package com.tj.jst.base.exception;

/**
 * 全局异常
 * @author Administrator
 *
 */
public class BaseException extends Exception {
	
	// 提示的出错信息
	private String message;

	// 构造方法
	public BaseException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
