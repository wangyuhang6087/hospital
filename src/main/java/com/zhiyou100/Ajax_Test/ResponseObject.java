package com.zhiyou100.Ajax_Test;
/**
* @author Rain
* @des:
* 创建时间：2019年9月18日 下午3:54:43
*/
public class ResponseObject {
	// 状态码
	String code;
	// 信息
	String message;
	// 返回数据
	Object obj;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "ResponseObject [code=" + code + ", message=" + message + ", obj=" + obj + "]";
	}
	public ResponseObject(String code, String message, Object obj) {
		super();
		this.code = code;
		this.message = message;
		this.obj = obj;
	}
	public ResponseObject() {
		super();
	}
	
}
