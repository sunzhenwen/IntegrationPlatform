package com.tj.jst.login.dao;

import com.tj.jst.login.model.Login;


public interface ILoginDao {
	
	public Login query(String results,String check);
}
