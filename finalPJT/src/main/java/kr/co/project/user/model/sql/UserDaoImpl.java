package kr.co.project.user.model.sql;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.project.user.model.vo.UserVO;

@Repository("userD")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public Object loginRow(Object obj) {
		System.out.println(">>> dao loginRow");
		return session.selectOne("encore.project.user.loginRow", obj);
	}

	@Override
	public int joinRow(Object obj) {
		System.out.println(">>> dao joinRow");
		return session.insert("encore.project.user.joinRow", obj);
	}

}
