package cn.chinattclub.izou7AppServer.dto;

import java.util.List;

public class ActivityInfoInListDto {
	private Integer id;
	private String user;
	private String name;
	private String place;
	private String startTime;
	private String endTime;
	private float distance;
	private List<String> persons;
	private List<String> weMedia;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public List<String> getPersons() {
		return persons;
	}
	public void setPersons(List<String> persons) {
		this.persons = persons;
	}
	public List<String> getWeMedia() {
		return weMedia;
	}
	public void setWeMedia(List<String> weMedia) {
		this.weMedia = weMedia;
	}
	
	
	
}
