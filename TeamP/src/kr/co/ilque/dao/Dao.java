package kr.co.ilque.dao;

import java.util.List;

import kr.co.ilque.dto.Dto;

public interface Dao {
	public List<Dto> selectAll();	//전체조회
	public Dto selectOne();			//한 건 조회
	public void insertOne(Dto dto); //한 건 추가
	public void modifyOne(Dto dto);	//수정
	public void deleteOne(Dto dto); //삭제
	public void close();			//자원반납
}
