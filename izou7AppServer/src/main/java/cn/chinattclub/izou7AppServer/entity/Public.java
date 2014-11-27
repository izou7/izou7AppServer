package cn.chinattclub.izou7AppServer.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "i_public")
public class Public {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="wechat_id")
	private String wechatId;
	
	@Column(name="public_name")
	private String publicName;
	
	private String tags;
	
	private String description;	
	
	@Column(name="is_mine")
	private boolean isMine;
	
	@Column(name="create_time")
	private boolean createTime;
	
	@Column(name="update_time")
	private boolean updateTime;
	
	@OneToMany(mappedBy="pub",cascade=CascadeType.ALL)
	private List<Article> article;
	
	@OneToMany(mappedBy="pub",cascade=CascadeType.ALL)
	private List<UserPublicSubscribe> userPublicSubscribe;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public String getPublicName() {
		return publicName;
	}

	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isMine() {
		return isMine;
	}

	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	public boolean isCreateTime() {
		return createTime;
	}

	public void setCreateTime(boolean createTime) {
		this.createTime = createTime;
	}

	public boolean isUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(boolean updateTime) {
		this.updateTime = updateTime;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

	public List<UserPublicSubscribe> getUserPublicSubscribe() {
		return userPublicSubscribe;
	}

	public void setUserPublicSubscribe(List<UserPublicSubscribe> userPublicSubscribe) {
		this.userPublicSubscribe = userPublicSubscribe;
	}


}
