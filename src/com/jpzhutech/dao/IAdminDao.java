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
}
