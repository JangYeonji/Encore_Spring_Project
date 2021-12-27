package kr.co.project.bbs.model.sql;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bbsD")
public class BbsDaoImpl implements BbsDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Object> listRow() {
		System.out.println(">>> dao listRow");
		return session.selectList("encore.project.bbs.listRow");
	}

	@Override
	public Object readRow(Object obj) {
		System.out.println(">>> dao readRow");
		return session.selectOne("encore.project.bbs.readRow", obj);
	}

	@Override
	public void upCntRow(Object obj) {
		System.out.println(">>> dao upCntRow");
		session.update("encore.project.bbs.upCntRow", obj);
	}

}
