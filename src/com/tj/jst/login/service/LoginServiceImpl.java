package com.tj.jst.login.service;

import com.tj.jst.login.dao.ILoginDao;
import com.tj.jst.login.dao.LoginDaoImpl;
import com.tj.jst.login.model.Login;

public class LoginServiceImpl implements ILoginService {
	
	@Override
	public Login query(String results,String check) {
		ILoginDao loginDao = new LoginDaoImpl();
		return loginDao.query(results,check);
	}

}
