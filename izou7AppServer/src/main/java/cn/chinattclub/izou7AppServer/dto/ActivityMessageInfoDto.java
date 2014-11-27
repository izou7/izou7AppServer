package cn.chinattclub.izou7AppServer.dto;

import java.util.Date;

public class ActivityMessageInfoDto {
	int userId;
	String headPictureUrl;
	String headPicture;
	String message;
	Date messageTime;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getHeadPictureUrl() {
		return headPictureUrl;
	}
	public void setHeadPictureUrl(String headPictureUrl) {
		this.headPictureUrl = headPictureUrl;
	}
	public String getHeadPicture() {
		return headPicture;
	}
	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	
	
}
