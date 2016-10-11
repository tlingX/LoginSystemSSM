package com.jpzhutech.dao;

import com.jpzhutech.entity.Admin;

/**
 * 数据持久层
 * @author 朱君鹏
 *
 */
public interface IAdminDao {
	public boolean addAdmin(Admin admin);

	String findByEmail(Admin admin);
	
	public String findPwd(Admin admin);
	
	boolean getUserState(Admin admin);
	
	public Admin findByUUID(String string);
	
	public void updateState(Admin admin);
	
	
}
