package cn.chinattclub.izou7AppServer.dto;

import java.util.Date;
import java.util.List;

public class ActivityDetailInfoDto {
	List<String> poster;
	String user;
	
	
	
	String name;
	String city;
	String place;
	float coordinateX;
	float coordinateY;
	Date startTime;
	Date endTime;
	int headCount;
	String tags;
	String introduction;
	boolean opened;
	String homePage;
	Date createTime;
	public List<String> getPoster() {
		return poster;
	}
	public void setPoster(List<String> poster) {
		this.poster = poster;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public float getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(float coordinateX) {
		this.coordinateX = coordinateX;
	}
	public float getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(float coordinateY) {
		this.coordinateY = coordinateY;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getHeadCount() {
		return headCount;
	}
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public boolean isOpened() {
		return opened;
	}
	public void setOpened(boolean opened) {
		this.opened = opened;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
	
	
}
