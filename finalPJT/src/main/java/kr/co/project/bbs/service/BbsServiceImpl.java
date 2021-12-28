package kr.co.project.bbs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.project.bbs.model.sql.BbsDao;

@Service("bbsS")
public class BbsServiceImpl implements BbsService{
	@Resource(name="bbsD")
	private BbsDao dao;
	
	@Override
	public List<Object> listService() {
		System.out.println(">>> bbs service list");
		return dao.listRow();
	}

	@Override
	public void upCntService(Object obj) {
		System.out.println(">>> bbs service upCnt");
		dao.upCntRow(obj);
	}

	@Override
	public Object readService(Object obj) {
		System.out.println(">>> bbs service read");
		return dao.readRow(obj);
	}

	@Override
	public int registerService(Object obj) {
		System.out.println(">>> bbs service register");
		return dao.registerRow(obj);
	}

	@Override
	public int removeService(Object obj) {
		System.out.println(">>> bbs service remove");
		return dao.removeRow(obj);
	}

	@Override
	public int updateService(Object obj) {
		System.out.println(">>> bbs service update");
		return dao.updateRow(obj);
	}

	@Override
	public List<Object> searchService(Object obj) {
		System.out.println(">>> bbs service search");
		return dao.searchRow(obj);
	}

}
