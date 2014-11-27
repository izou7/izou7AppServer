package cn.chinattclub.izou7AppServer.dto;

import java.util.Date;

public class ActivityGuestVoteDto {
	int id;
	String name;
	String company;
	String researchArea;
	int praiseNumber;
	int badNumber;
	Date updateTime;
	boolean hasVoted;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getResearchArea() {
		return researchArea;
	}
	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}
	public int getPraiseNumber() {
		return praiseNumber;
	}
	public void setPraiseNumber(int praiseNumber) {
		this.praiseNumber = praiseNumber;
	}
	public int getBadNumber() {
		return badNumber;
	}
	public void setBadNumber(int badNumber) {
		this.badNumber = badNumber;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public boolean isHasVoted() {
		return hasVoted;
	}
	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}
	
	
}
