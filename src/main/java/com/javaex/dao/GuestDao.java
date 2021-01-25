package com.javaex.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	@Autowired
	private SqlSession sqlSession;

	public List<GuestVo> getList() {
		List<GuestVo> guestlist = sqlSession.selectList("guestbook.selectlist");
		System.out.println("list들어옴");
		return guestlist;
	}
	 public int guestinsert(GuestVo guVo) {
		int count = sqlSession.insert("guestbook.guestinsert", guVo);
		return count;
	 }

	 public int guestdelete(GuestVo guVo) {
		 int count =sqlSession.delete("guestbook.delete", guVo);
		 return count;
	 
	 }
}