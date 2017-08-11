package kr.co.ilque.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.ilque.dao.OracleBoardDAO;
import kr.co.ilque.dto.BoardDto;
import kr.co.ilque.dto.DetailViewDto;

@Service("boardService")
public class BoardService implements QuestService {

	@Resource(name = "boardDao")
	OracleBoardDAO dao;

	public void setDao(OracleBoardDAO dao) {
		this.dao = dao;
	}

	public List<BoardDto> leadAll(int startNo, int endNo,String keyword,String category,String gender) {
		System.out.println("서비스에서 keyword값"+keyword);
		return dao.selectAll(startNo, endNo,keyword,category,gender);
	}

	public int getTotal() {
		return dao.getData();
	}

	public DetailViewDto read(int boardNo) {

		return dao.selectOne(boardNo);
	}

	public void insertOne(BoardDto bdto) {
		// TODO Auto-generated method stub
		dao.insertOne(bdto);
	}

	public void deleteOne(int boardNo) {
		dao.deleteOne(boardNo);
		
	}

	public void modifyOne(BoardDto bdto) {
		dao.modifyOk(bdto);
		
	}
}
