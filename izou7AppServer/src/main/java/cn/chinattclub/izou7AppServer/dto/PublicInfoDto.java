package cn.chinattclub.izou7AppServer.dto;

import java.util.Date;

public class PublicInfoDto {
	int id;
	int publicId;
	String publicName;
	String tags;
	Date createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPublicId() {
		return publicId;
	}
	public void setPublicId(int publicId) {
		this.publicId = publicId;
	}
	public String getPublicName() {
		return publicName;
	}
	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
