package cn.chinattclub.izou7AppServer.dto;

import java.util.Date;

public class CrowdfundingDetailDto {
	Integer id;
	float amount;
	String reward;
	Date rewardStartTime;
	Date rewardEndTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public Date getRewardStartTime() {
		return rewardStartTime;
	}
	public void setRewardStartTime(Date rewardStartTime) {
		this.rewardStartTime = rewardStartTime;
	}
	public Date getRewardEndTime() {
		return rewardEndTime;
	}
	public void setRewardEndTime(Date rewardEndTime) {
		this.rewardEndTime = rewardEndTime;
	}
	
	
}
