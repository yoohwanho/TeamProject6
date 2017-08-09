package kr.co.ilque.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ilque.dto.MemberDto;
@Repository("boardDAO")
public class OracleBoardDAO {
	@Autowired
	SqlSession ss;
	
	

	public void setSs(SqlSession ss) {
		this.ss = ss;
	}



	public MemberDto selectOne(int boardno){
		System.out.println(boardno);
		return ss.selectOne("kr.co.ilque.board.showDetails",boardno);
		
	}
	

}
