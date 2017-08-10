package kr.co.ilque.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.ilque.dao.ReviewDAO;
import kr.co.ilque.dto.ReviewDto;

@Service("reviewService")
public class ReviewService implements QuestService{
	@Resource(name="reviewDAO")
	ReviewDAO dao;
	
	public void writeReview(ReviewDto rdto) {
		dao.insertOne(rdto);
	}

}
