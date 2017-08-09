package kr.co.ilque.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ilque.dto.BoardDto;
import kr.co.ilque.dto.StartEnd;

@Repository("boardDao")
public class OracleBoardDAO {
	
	@Autowired
	private SqlSession ss;

	public void setSs(SqlSession ss) {
		this.ss = ss;
	}
	
	public List<BoardDto> selectAll(int startNo, int endNo) {
		StartEnd se = new StartEnd();
		se.setEndNo(endNo);
		se.setStartNo(startNo);
		return ss.selectList("kr.co.ilque.board.selectAll",se);
	}

	public int getData() {
		return ss.selectOne("kr.co.ilque.board.getTotal");
	}
	public BoardDto selectOne(int boardno){
		System.out.println(boardno);
		return ss.selectOne("kr.co.ilque.board.showDetails",boardno);
		
	}

}
