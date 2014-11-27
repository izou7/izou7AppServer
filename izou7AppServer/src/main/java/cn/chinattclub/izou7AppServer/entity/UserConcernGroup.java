package cn.chinattclub.izou7AppServer.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "i_user_concern_group")
public class UserConcernGroup {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="concern_group")
	private String concernGroup;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
	private Date updateTime;

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@OneToMany(mappedBy = "userConcernGroup",cascade = CascadeType.ALL)
	private List<MappingGroupUser> mappingGroupUser;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConcernGroup() {
		return concernGroup;
	}

	public void setConcernGroup(String concernGroup) {
		this.concernGroup = concernGroup;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<MappingGroupUser> getMappingGroupUser() {
		return mappingGroupUser;
	}

	public void setMappingGroupUser(List<MappingGroupUser> mappingGroupUser) {
		this.mappingGroupUser = mappingGroupUser;
	}

	
	
	
}
