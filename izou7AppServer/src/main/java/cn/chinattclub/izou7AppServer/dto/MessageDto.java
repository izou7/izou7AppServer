package cn.chinattclub.izou7AppServer.dto;

import java.util.Date;

public class MessageDto {
	String message;
	boolean recieved;
	Date createTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isRecieved() {
		return recieved;
	}
	public void setRecieved(boolean recieved) {
		this.recieved = recieved;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
