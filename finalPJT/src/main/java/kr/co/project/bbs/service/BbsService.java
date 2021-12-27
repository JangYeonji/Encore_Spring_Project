package kr.co.project.bbs.service;

import java.util.List;

import kr.co.project.bbs.model.vo.BbsVO;

public interface BbsService {

	public List<Object> listService();
	public void upCntService(Object obj);
	public Object readService(Object obj);
	public int registerService(Object obj);
	public int removeService(Object obj);
	public int updateService(Object obj);

}
