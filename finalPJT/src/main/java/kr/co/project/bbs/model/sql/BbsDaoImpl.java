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

	@Override
	public int registerRow(Object obj) {
		System.out.println(">>> dao registerRow");
		return session.insert("encore.project.bbs.registerRow", obj);
	}

	@Override
	public int removeRow(Object obj) {
		System.out.println(">>> dao removeRow");
		return session.delete("encore.project.bbs.removeRow", obj);
	}

	@Override
	public int updateRow(Object obj) {
		System.out.println(">>> dao updateRow");
		return session.update("encore.project.bbs.updateRow", obj);
	}

	@Override
	public List<Object> searchRow(Object obj) {
		System.out.println(">>> dao searchRow");
		return session.selectList("encore.project.bbs.searchRow", obj);
	}

}
