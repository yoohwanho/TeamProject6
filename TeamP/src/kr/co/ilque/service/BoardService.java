package kr.co.ilque.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.ilque.dao.OracleBoardDAO;

@Service(value="boardService")
public class BoardService implements QuestService{
	@Resource(name="boardDAO")
	OracleBoardDAO dao;
	public Object read(int boardno) {
		
		return dao.selectOne(boardno);
	}

}
