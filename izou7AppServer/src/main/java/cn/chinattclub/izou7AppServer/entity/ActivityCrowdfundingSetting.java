package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.chinattclub.izou7AppServer.enumeration.CrowdfundingStatus;


/**
 * 活动众筹设置实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_crowdfunding_setting")
public class ActivityCrowdfundingSetting {

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	private Activity activity;
	
	/**
	 * 众筹总金额
	 */
	private Integer amount;
	
	/**
	 * 众筹金额上限
	 */
	@Column(name="high_lines")
	private Integer highLines;
	
	/**
	 * 已筹到的金额
	 */
	@Column(name="got_amount")
	private Integer gotAmount;
	
	/**
	 * 众筹天数
	 */
	private Integer days;
	
	/**
	 * 收款人姓名
	 */
	@Column(name="account_name")
	private String accountName;
	
	/**
	 * 收款人账号
	 */
	@Column(name="account_number")
	private String accountNumber;
	
	/**
	 * 银行表id
	 */
	@Column(name="account_bank")
	private Integer accountBank;
	
	/**
	 * 支行
	 */
	@Column(name="sub_bank")
	private String subBank;
	
	/**
	 * 众筹状态
	 */
	@Enumerated(EnumType.ORDINAL)
	private CrowdfundingStatus status;
	
	/** 
	 *  创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;
	
	/** 
	 * 更新时间 
	 */
	@Column(name = "update_time", insertable = false, updatable = false)
	private Date updateTime;

	/**
	 * Returns the value of the field called 'id'.
	 * @return Returns the id.
	 */
	public Integer getId() {
		return this.id;
	}
	
}
