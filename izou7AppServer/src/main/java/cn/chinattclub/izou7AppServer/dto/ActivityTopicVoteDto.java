package cn.chinattclub.izou7AppServer.dto;

import java.util.Date;

public class ActivityTopicVoteDto {
	int id;
	String topic;
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
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
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
