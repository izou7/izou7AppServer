package cn.chinattclub.izou7AppServer.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * 用户实体类
 * 
 * @author ZY
 * 
 */
@Entity
@Table(name = "i_user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 秘钥
	 */
	@Column(name="secret_key")
	private String key;
	/**
	 * 是否上锁 
	 */
	private Boolean locked = Boolean.FALSE;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(
			name = "i_activity_join",
			joinColumns = @JoinColumn(name = "user"),
			inverseJoinColumns = @JoinColumn(name = "activity")
	)
	@NotFound(action = NotFoundAction.IGNORE)
	public List<Activity> activitys ;
	/**
	 * 关联用户信息
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_info_id")
	private UserInfo userInfo;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<UserConcernGroup> userConcernGroup;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<MappingGroupUser> mappingGroupUser;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<BrowsedUser> browseUser;
	
	@OneToMany(mappedBy = "browsedUser",cascade = CascadeType.ALL)
	private List<BrowsedUser> browsedUser;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<UserPublicSubscribe> userPublicSubscribe;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<CollectedArticle> collectedArticle;
	
	@OneToMany(mappedBy = "user1",cascade = CascadeType.ALL)
	private List<MessageRoom> messageRoom1;
	
	@OneToMany(mappedBy = "user2",cascade = CascadeType.ALL)
	private List<MessageRoom> messageRoom2;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PrivacySettings> privacySettings;
	

	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Returns the value of the field called 'activitys'.
	 * @return Returns the activitys.
	 */
	public List<Activity> getActivitys() {
		return this.activitys;
	}

	/**
	 * Sets the field called 'activitys' to the given value.
	 * @param activitys The activitys to set.
	 */
	public void setActivitys(List<Activity> activitys) {
		this.activitys = activitys;
	}

	public List<UserConcernGroup> getUserConcernGroup() {
		return userConcernGroup;
	}

	public void setUserConcernGroup(List<UserConcernGroup> userConcernGroup) {
		this.userConcernGroup = userConcernGroup;
	}

	public List<MappingGroupUser> getMappingGroupUser() {
		return mappingGroupUser;
	}

	public void setMappingGroupUser(List<MappingGroupUser> mappingGroupUser) {
		this.mappingGroupUser = mappingGroupUser;
	}

	public List<BrowsedUser> getBrowseUser() {
		return browseUser;
	}

	public void setBrowseUser(List<BrowsedUser> browseUser) {
		this.browseUser = browseUser;
	}

	public List<BrowsedUser> getBrowsedUser() {
		return browsedUser;
	}

	public void setBrowsedUser(List<BrowsedUser> browsedUser) {
		this.browsedUser = browsedUser;
	}

	public List<UserPublicSubscribe> getUserPublicSubscribe() {
		return userPublicSubscribe;
	}

	public void setUserPublicSubscribe(List<UserPublicSubscribe> userPublicSubscribe) {
		this.userPublicSubscribe = userPublicSubscribe;
	}

	public List<CollectedArticle> getCollectedArticle() {
		return collectedArticle;
	}

	public void setCollectedArticle(List<CollectedArticle> collectedArticle) {
		this.collectedArticle = collectedArticle;
	}

	public List<MessageRoom> getMessageRoom1() {
		return messageRoom1;
	}

	public void setMessageRoom1(List<MessageRoom> messageRoom1) {
		this.messageRoom1 = messageRoom1;
	}



	public List<MessageRoom> getMessageRoom2() {
		return messageRoom2;
	}

	public void setMessageRoom2(List<MessageRoom> messageRoom2) {
		this.messageRoom2 = messageRoom2;
	}

	public List<PrivacySettings> getPrivacySettings() {
		return privacySettings;
	}

	public void setPrivacySettings(List<PrivacySettings> privacySettings) {
		this.privacySettings = privacySettings;
	}

	
}
