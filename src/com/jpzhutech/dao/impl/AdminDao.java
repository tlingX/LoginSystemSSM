package com.jpzhutech.dao.impl;

import java.sql.SQLException;
import java.util.UUID;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;
import org.springframework.stereotype.Component;

import com.jpzhutech.dao.IAdminDao;
import com.jpzhutech.entity.Admin;
import com.jpzhutech.utils.JdbcUtils;



@Component(value="adminDaoID")  //属性注入值
public class AdminDao implements IAdminDao{
	
	    //根据用户查找数据中是否存在该用户名，如果存在返回用户名，如果不存在，则返回空
		public String  findByEmail(Admin admin) {
			try {
				//?在DButils中表示一个占位符
				String sql = "select * from public.admin where email=?";
				//执行该SQL语句并返回一个admin对象
				admin =  JdbcUtils.getQueryRuner().query(sql,
						new BeanHandler<Admin>(Admin.class), admin.getEmail() //根据email查找数据库中是否存在该用户
					); 
				if (admin != null) {
					return admin.getEmail();
				}else{
					return null;
				}
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	//增加管理员，也就是注册功能的持久层数据
	@Override
	public boolean addAdmin(Admin admin) {
		//在数据库中根据用户名查找，如果发现用户名已经存在则不将新的数据插入到数据库中，而是提示用户已经注册过
        String oldEmail = findByEmail(admin);
System.out.println("=====================================");
System.out.println("在数据库中的旧用户名为："+oldEmail);
System.out.println("=====================================");

        if(oldEmail != null){
System.out.println("已经注册过");
        	return false;
        }else {
        	try {
    			JdbcUtils.getQueryRuner().update(
    					"insert into public.admin(id,username,pwd,email,state) values(?,?,?,?,?)",UUID.randomUUID().toString(),
    					admin.getUserName(), admin.getPwd(),admin.getEmail(),false);
    			System.out.println("插入到数据库中成功");
    			return true;
    		} catch (SQLException e) {
    			System.out.println("插入到数据库中操作失败"); //应该将此信息发送到一个新的页面	
    			throw new RuntimeException(e);
    			
    			 
    		}
		}//else语句结束
		}  //方法结束
	
	//从数据库中获取用户的UUID
	public String getUUID(Admin admin){
		String sql = "select * from public.admin where email=?";   //根据用户的email查找到数据库中存放的整个对象
		try {
			//执行该SQL语句并返回一个admin对象
			admin =  JdbcUtils.getQueryRuner().query(sql,
					new BeanHandler<Admin>(Admin.class), admin.getEmail() //根据email查找数据库中是否存在该用户
				); 
			if (admin != null) {
				return admin.getId();
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String findPwd(Admin admin){
		try {
			//?在DButils中表示一个占位符
			String sql = "select * from public.admin where email=?";
System.out.println("进入到数据库之后收到的邮箱参数为:"+admin.getEmail());
			admin =  JdbcUtils.getQueryRuner().query(sql,
					new BeanHandler<Admin>(Admin.class), admin.getEmail()
				);  
			if (admin != null) {
				return admin.getPwd();
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
		
	}
	
	//得到email当前用户的状态
	public boolean getUserState(Admin admin){
		try {
			//?在DButils中表示一个占位符
			String sql = "select * from public.admin where email=? and pwd=?";
			admin = JdbcUtils.getQueryRuner().query(sql,
					new BeanHandler<Admin>(Admin.class), admin.getUserName(),  //admin.getUserName()获取其用户名
					admin.getPwd());  //admin.getPwd()获取其密码
			if(admin != null){
				return admin.isState();
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void test(){
		AdminDao adminDao = new AdminDao();
		Admin admin = new Admin("1000","jpzhu","560128","13101900@qq.com",false);
		System.out.println(admin);
		adminDao.addAdmin(admin);
		System.out.println("UUID:"+adminDao.getUUID(admin));
		
	}
}
