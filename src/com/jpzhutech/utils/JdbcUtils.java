package com.jpzhutech.utils;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	private static  DataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	public static QueryRunner getQueryRuner(){
		return new QueryRunner(dataSource);
	}
	
	//测试是否成功的连接数据源
	@Test
	public void test() throws SQLException{
		System.out.println(dataSource.getClass());    //不报错并返回class com.mchange.v2.c3p0.ComboPooledDataSource，说明已经成功的连接数据源
		System.out.println(dataSource.getConnection().toString());
	}
}








