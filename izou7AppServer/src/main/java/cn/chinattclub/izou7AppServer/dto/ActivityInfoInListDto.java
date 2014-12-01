package cn.chinattclub.izou7AppServer.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.chinattclub.izou7AppServer.entity.Activity;

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
	public List<ActivityInfoInListDto> ConvertToDto(List<Activity> activities) {
		List<ActivityInfoInListDto> activityInfoInListDtos = new ArrayList<ActivityInfoInListDto>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd"); 
		for (Activity activity:activities){
			ActivityInfoInListDto activityInfoInListDto = new ActivityInfoInListDto();
			activityInfoInListDto.setId(activity.getId());
			activityInfoInListDto.setName(activity.getName());
			activityInfoInListDto.setPlace(activity.getPlace());
			activityInfoInListDto.setUser(activity.getUser().getUserInfo().getRealName());
			activityInfoInListDto.setStartTime(time.format(activity.getStartTime()));
			activityInfoInListDto.setEndTime(time.format(activity.getEndTime()));
			activityInfoInListDtos.add(activityInfoInListDto);
		}
		return activityInfoInListDtos;
	}
	
	public List<ActivityInfoInListDto> ConvertObjToDto(List<Object[]> activities) {
		List<ActivityInfoInListDto> activityInfoInListDtos = new ArrayList<ActivityInfoInListDto>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd"); 
		for (Object[] obj:activities){
			Activity activity = (Activity)obj[0];
			ActivityInfoInListDto activityInfoInListDto = new ActivityInfoInListDto();
			activityInfoInListDto.setId(activity.getId());
			activityInfoInListDto.setName(activity.getName());
			activityInfoInListDto.setPlace(activity.getPlace());
			activityInfoInListDto.setUser(activity.getUser().getUserInfo().getRealName());
			activityInfoInListDto.setStartTime(time.format(activity.getStartTime()));
			activityInfoInListDto.setEndTime(time.format(activity.getEndTime()));
			activityInfoInListDtos.add(activityInfoInListDto);
		}
		return activityInfoInListDtos;
	}
	
}
