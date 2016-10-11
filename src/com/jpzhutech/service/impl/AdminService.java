package com.jpzhutech.service.impl;


import com.jpzhutech.dao.impl.AdminDao;
import com.jpzhutech.entity.Admin;
import com.jpzhutech.service.IAdminService;

public class AdminService implements IAdminService{
	
	//维护数据持久层的一个对象
	private AdminDao adminDao;

	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public String findByEmail(Admin admin) {
		return adminDao.findByEmail(admin);
	}

	@Override
	public boolean addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

}
