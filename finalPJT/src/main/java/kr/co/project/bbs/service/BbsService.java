package kr.co.project.bbs.service;

import java.util.List;

public interface BbsService {

	public List<Object> listService();
	public void upCntService(Object obj);
	public Object readService(Object obj);

}
