package kr.co.project.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.project.user.model.sql.UserDao;

@Service("userS")
public class UserServiceImpl implements UserService{
	@Resource(name="userD")
	private UserDao dao;

	@Override
	public Object loginService(Object obj) {
		System.out.println(">>> user service login");
		return dao.loginRow(obj);
	}

	@Override
	public int joinService(Object obj) {
		System.out.println(">>> user service join");
		return dao.joinRow(obj);
	}
	
}
