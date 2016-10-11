package com.jpzhutech.service;

import com.jpzhutech.entity.Admin;

public interface IAdminService {
	
	public boolean addAdmin(Admin admin);
	String findByEmail(Admin admin);
}
