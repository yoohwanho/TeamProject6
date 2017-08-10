package kr.co.ilque.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.ilque.dao.OracleCommentsDAO;
import kr.co.ilque.dto.CommentsDto;

@Service(value = "commentsService")
public class CommentsService implements QuestService {
	@Resource(name = "commentsDao")
	OracleCommentsDAO dao;

	public List<CommentsDto> read(int boardno) {

		return dao.selectOne(boardno);
	}

	public int total(int boardNo) {

		return dao.getTotal(boardNo);
	}

	public void commentDel(int commentNo) {
		dao.commentDel(commentNo);

	}
}
