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

}
