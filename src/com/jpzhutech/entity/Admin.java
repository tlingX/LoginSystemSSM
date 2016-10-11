package com.jpzhutech.entity;
/**
 * 基本的实体对象Admin，JavaBean对象
 * 在PostgreSQL中对应一张表，表名public.admin
 * @author 朱君鹏
 *
 */
public class Admin {
	private String id;      //编号，采用UUID生成，系统自动的生成，在后续用于邮箱激活时使用UUID去数据库中查找相应的admin对象
	private String email;   //在注册时使用email
	private String userName;  //用户名，用户名不能相同
	private String pwd;    //密码
	private boolean state;  //在注册之后，必须要经过邮箱验证，否则不能正常的登录
	public Admin() {
		
	}
	public Admin(String id, String email, String userName, String pwd,
			boolean state) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.pwd = pwd;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", userName="
				+ userName + ", pwd=" + pwd + ", state=" + state + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Admin(String id) {
		super();
		this.id = id;
	}
	
	
	
	
	
}
