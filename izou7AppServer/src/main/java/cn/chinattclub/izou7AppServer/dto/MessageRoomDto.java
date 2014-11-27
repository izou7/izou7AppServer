package cn.chinattclub.izou7AppServer.dto;

import java.util.Date;

public class MessageRoomDto {
	int id;
	String name;
	String headPictureUrl;
	String headPicture;
	String lastMessage;
	Date updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getLastMessage() {
		return lastMessage;
	}
	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
