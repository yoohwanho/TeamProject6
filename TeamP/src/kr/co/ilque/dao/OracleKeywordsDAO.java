package kr.co.ilque.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ilque.dto.KeywordsDto;

@Repository("keywordsDao")
public class OracleKeywordsDAO {
	@Autowired
	SqlSession ss;

	public void setSs(SqlSession ss) {
		this.ss = ss;
	}
	public List<KeywordsDto> showTop10(){
		return ss.selectList("kr.co.ilque.keyword.showTop10");
	}
}
