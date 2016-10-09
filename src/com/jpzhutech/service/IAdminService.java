package com.jpzhutech.service;

import com.jpzhutech.entity.Admin;

public interface IAdminService {
	public String  findByName(Admin admin);
	public boolean addAdmin(Admin admin);
}
