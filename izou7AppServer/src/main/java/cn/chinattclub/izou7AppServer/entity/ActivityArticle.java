package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 活动文章实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "_activity_article")
public class ActivityArticle {

	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 活动
	 */
	@ManyToOne
	private Activity activity;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 标签
	 */
	private String tags;
	
	/**
	 * 摘要
	 */
	private String summary;
	
	/**
	 * 文章地址
	 */
	private String article;
	
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
	 * Returns the value of the field called 'title'.
	 * @return Returns the title.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Sets the field called 'title' to the given value.
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * Returns the value of the field called 'summary'.
	 * @return Returns the summary.
	 */
	public String getSummary() {
		return this.summary;
	}

	/**
	 * Sets the field called 'summary' to the given value.
	 * @param summary The summary to set.
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * Returns the value of the field called 'article'.
	 * @return Returns the article.
	 */
	public String getArticle() {
		return this.article;
	}

	/**
	 * Sets the field called 'article' to the given value.
	 * @param article The article to set.
	 */
	public void setArticle(String article) {
		this.article = article;
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
