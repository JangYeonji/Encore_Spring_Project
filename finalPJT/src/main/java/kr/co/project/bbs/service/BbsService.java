package kr.co.project.bbs.service;

import java.util.List;

import kr.co.project.bbs.model.vo.BbsVO;
import kr.co.project.bbs.model.vo.FilterVO;
import kr.co.project.bbs.model.vo.ReplyVO;

public interface BbsService {

	public List<Object> listService();
	public void upCntService(Object obj);
	public Object readService(Object obj);
	public int registerService(Object obj);
	public int removeService(Object obj);
	public int updateService(Object obj);
	public List<Object> searchService(Object obj);
	public List<Object> readReplyService(Object obj);
	public int removeReplyService(Object obj);

}
