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

}
