package kr.co.ilque.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ilque.dto.ReviewDto;

@Repository("reviewDAO")
public class ReviewDAO {
	@Autowired
	SqlSession ss;
	
	public void insertOne(ReviewDto rdto) {
		ss.insert("kr.co.ilque.review.insertOne",rdto);				
	}

}
