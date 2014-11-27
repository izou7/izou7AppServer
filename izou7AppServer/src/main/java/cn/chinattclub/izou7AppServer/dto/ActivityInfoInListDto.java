package cn.chinattclub.izou7AppServer.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.chinattclub.izou7AppServer.entity.Activity;

public class ActivityInfoInListDto {
	private Integer id;
	private String user;
	private String name;
	private String place;
	private Date startTime;
	private Date endTime;
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
	public List<ActivityInfoInListDto> ConvertToDto(List<Activity> activities) {
		List<ActivityInfoInListDto> activityInfoInListDtos = new ArrayList<ActivityInfoInListDto>();
		for (Activity activity:activities){
			ActivityInfoInListDto activityInfoInListDto = new ActivityInfoInListDto();
			activityInfoInListDto.setId(activity.getId());
			activityInfoInListDto.setName(activity.getName());
			activityInfoInListDto.setPlace(activity.getPlace());
			activityInfoInListDto.setUser(activity.getUser().getUserInfo().getRealName());
			activityInfoInListDto.setStartTime(activity.getStartTime());
			activityInfoInListDto.setEndTime(activity.getEndTime());
			activityInfoInListDtos.add(activityInfoInListDto);
		}
		return activityInfoInListDtos;
	}
	
	
	
}
