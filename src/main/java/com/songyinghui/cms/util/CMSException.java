package com.songyinghui.cms.util;
/**
 * 自定义异常
 * @ClassName: CMSException 
 * @Description: TODO
 * @author: YH
 * @date: 2020年3月12日 上午9:01:15
 */
public class CMSException extends  RuntimeException{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public CMSException(String message) {
		super();
		this.message = message;
	}
	public CMSException() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
   
}
