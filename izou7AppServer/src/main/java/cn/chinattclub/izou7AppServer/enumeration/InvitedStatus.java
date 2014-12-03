package cn.chinattclub.izou7AppServer.enumeration;
/**
 * 
 * 众筹状态枚举
 *
 * @author zhangying.
 *         Created 2014-11-13.
 */
public enum InvitedStatus {

	
	UNSEND(0,"未发送"),
	/**
	 * 已发送申请或邀请
	 */
	SEND(1,"已发送"),
	
	
	/**
	 * 同意
	 */
	AGREED(2,"同意"),
	
	/**
	 * 拒绝邀请或申请
	 */
	REFUSED(3,"拒绝");
	
	private int value;
	
	private String name;
	
	InvitedStatus(int value,String name){
		this.name = name;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

