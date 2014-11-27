package cn.chinattclub.izou7AppServer.dto;

import java.util.Date;

public class PersonDto {
	int userId;
	String name;
	String introduction;
	Date createTime;
	String headPictureUrl;
	String headPicture;
	String concerGroup;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	public String getConcerGroup() {
		return concerGroup;
	}
	public void setConcerGroup(String concerGroup) {
		this.concerGroup = concerGroup;
	}
	
	
}
