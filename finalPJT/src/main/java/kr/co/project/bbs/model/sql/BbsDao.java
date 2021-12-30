package kr.co.project.bbs.model.sql;

import java.util.List;

import kr.co.project.bbs.model.vo.ReplyVO;

public interface BbsDao {

	public List<Object> listRow();
	public Object readRow(Object obj);
	public void upCntRow(Object obj);
	public int registerRow(Object obj);
	public int removeRow(Object obj);
	public int updateRow(Object obj);
	public List<Object> searchRow(Object obj);
	public List<Object> readReplyRow(Object obj);
	public List<Object> removeReplyRow(Object obj);

}
