package cn.chinattclub.izou7AppServer.dto;

public class PersonHomePageDto {
	String name;
	String headPicture;
	String headPictureUrl;
	String email;
	String phone;
	String careerInfo;
	boolean hasConcerned;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadPicture() {
		return headPicture;
	}
	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}
	public String getHeadPictureUrl() {
		return headPictureUrl;
	}
	public void setHeadPictureUrl(String headPictureUrl) {
		this.headPictureUrl = headPictureUrl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCareerInfo() {
		return careerInfo;
	}
	public void setCareerInfo(String careerInfo) {
		this.careerInfo = careerInfo;
	}
	public boolean isHasConcerned() {
		return hasConcerned;
	}
	public void setHasConcerned(boolean hasConcerned) {
		this.hasConcerned = hasConcerned;
	}
	
	
}
