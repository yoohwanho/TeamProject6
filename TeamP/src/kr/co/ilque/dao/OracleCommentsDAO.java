package kr.co.ilque.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ilque.dto.CommentsDto;

@Repository("commentsDao")
public class OracleCommentsDAO {
	@Autowired
	SqlSession ss;

	public void setSs(SqlSession ss) {
		this.ss = ss;
	}

	public List<CommentsDto> selectOne(int boardNo) {

		return ss.selectList("kr.co.ilque.comment.showComments", boardNo);
	}

	public int getTotal(int boardNo) {
		
		return ss.selectOne("kr.co.ilque.comment.getTotal", boardNo);
	}

	public void commentDel(int commentNo) {
		ss.delete("kr.co.ilque.comment.deleteOne",commentNo);
		
	}
}
