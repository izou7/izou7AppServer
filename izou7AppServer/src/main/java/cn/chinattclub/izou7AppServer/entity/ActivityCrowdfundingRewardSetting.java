package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cn.chinattclub.izou7AppServer.enumeration.CrowdfundingStatus;


/**
 * 活动众筹设置实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_crowdfunding_reward_setting")
public class ActivityCrowdfundingRewardSetting {

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	@JoinColumn(name="activity")
	private Activity activity;
	
	private int amount;
	
	@Column(name="limit_num")
	private int limitNum;
	
	private String reward;
	
	@Column(name="reward_start_time")
	private Date rewardStartTime;
	
	@Column(name="reward_end_time")
	private Date rewardEndTime;
	
	
	@OneToMany(mappedBy ="crowdfunding", cascade = CascadeType.ALL)
	private List<ActivityCrowdfundingResult> activityCrowdfundingResult;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Activity getActivity() {
		return activity;
	}


	public void setActivity(Activity activity) {
		this.activity = activity;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getLimitNum() {
		return limitNum;
	}


	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
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


	public List<ActivityCrowdfundingResult> getActivityCrowdfundingResult() {
		return activityCrowdfundingResult;
	}


	public void setActivityCrowdfundingResult(
			List<ActivityCrowdfundingResult> activityCrowdfundingResult) {
		this.activityCrowdfundingResult = activityCrowdfundingResult;
	}


	
	
}
