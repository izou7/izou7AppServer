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

import cn.chinattclub.izou7AppServer.enumeration.InvitedStatus;


/**
 * 活动合作邀请实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_activity_cooperation")
public class ActivityCooperation {


	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	private Activity activity;
	
	/**
	 * 微信ID
	 */
	@Column(name="wechat_id")
	private String wechatId;
	
	/**
	 * 公众号名
	 */
	@Column(name="public_name")
	private String publicName;
	
	/**
	 * 公众号标签
	 */
	private String tags;
	
	/**
	 * 公众号描述信息
	 */
	private String description;
	
	/**
	 * 邀请或申请状态
	 */
	@Enumerated(EnumType.ORDINAL)
	private InvitedStatus status;
	
	/**
	 * 合作类型（0：申请 1：邀请）
	 */
	private Integer type;
	
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

	/**
	 * Sets the field called 'id' to the given value.
	 * @param id The id to set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Returns the value of the field called 'activity'.
	 * @return Returns the activity.
	 */
	public Activity getActivity() {
		return this.activity;
	}

	/**
	 * Sets the field called 'activity' to the given value.
	 * @param activity The activity to set.
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	/**
	 * Returns the value of the field called 'wechatId'.
	 * @return Returns the wechatId.
	 */
	public String getWechatId() {
		return this.wechatId;
	}

	/**
	 * Sets the field called 'wechatId' to the given value.
	 * @param wechatId The wechatId to set.
	 */
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	/**
	 * Returns the value of the field called 'publicName'.
	 * @return Returns the publicName.
	 */
	public String getPublicName() {
		return this.publicName;
	}

	/**
	 * Sets the field called 'publicName' to the given value.
	 * @param publicName The publicName to set.
	 */
	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}

	/**
	 * Returns the value of the field called 'tags'.
	 * @return Returns the tags.
	 */
	public String getTags() {
		return this.tags;
	}

	/**
	 * Sets the field called 'tags' to the given value.
	 * @param tags The tags to set.
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * Returns the value of the field called 'description'.
	 * @return Returns the description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the field called 'description' to the given value.
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the value of the field called 'status'.
	 * @return Returns the status.
	 */
	public InvitedStatus getStatus() {
		return this.status;
	}

	/**
	 * Sets the field called 'status' to the given value.
	 * @param status The status to set.
	 */
	public void setStatus(InvitedStatus status) {
		this.status = status;
	}

	/**
	 * Returns the value of the field called 'type'.
	 * @return Returns the type.
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * Sets the field called 'type' to the given value.
	 * @param type The type to set.
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * Returns the value of the field called 'createTime'.
	 * @return Returns the createTime.
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * Sets the field called 'createTime' to the given value.
	 * @param createTime The createTime to set.
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Returns the value of the field called 'updateTime'.
	 * @return Returns the updateTime.
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * Sets the field called 'updateTime' to the given value.
	 * @param updateTime The updateTime to set.
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
