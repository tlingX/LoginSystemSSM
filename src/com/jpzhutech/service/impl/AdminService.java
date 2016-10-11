package com.jpzhutech.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jpzhutech.dao.impl.AdminDao;
import com.jpzhutech.entity.Admin;
import com.jpzhutech.service.IAdminService;

@Component(value="adminServiceID")
public class AdminService implements IAdminService{
	
	//维护数据持久层的一个对象
	private AdminDao adminDao;

	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	@Resource(name="adminDaoID")
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
	
	public String getUUID(Admin admin){
		return adminDao.getUUID(admin);
	}

	public String findPwd(Admin admin){
		return adminDao.findPwd(admin);
	}
	
	public boolean getUserState(Admin admin){
		return adminDao.getUserState(admin);
	}
	
	public Admin findByUUID(String string){
		return adminDao.findByUUID(string);
	}

	@Override
	public void updateState(Admin admin) {
		adminDao.updateState(admin);
	}
	
}
