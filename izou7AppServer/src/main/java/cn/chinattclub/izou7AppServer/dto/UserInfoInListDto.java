package cn.chinattclub.izou7AppServer.dto;

public class UserInfoInListDto {
	int userId;
	String userName;
	String headPictureUrl;
	String headPicture;
	String introduction;
	boolean suggest;
	boolean concerned;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public boolean isSuggest() {
		return suggest;
	}
	public void setSuggest(boolean suggest) {
		this.suggest = suggest;
	}
	public boolean isConcerned() {
		return concerned;
	}
	public void setConcerned(boolean concerned) {
		this.concerned = concerned;
	}
	
	
}
