package com.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Goods;

public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	@Transactional(
			isolation=Isolation.DEFAULT,
			propagation=Propagation.REQUIRED,
			readOnly=false,
			rollbackFor=Exception.class
			)
	public int save(Goods goods) {
		 Goods goods1 = new Goods(15,"aaaa",300);
		 Goods goods2 = new Goods(16,"bbbb",300);
		 sqlSession.insert("com.dao.GoodsMapper.save",goods1);
		 sqlSession.insert("com.dao.GoodsMapper.save",goods2);
		 return 1;
	}

	@Override
	@Transactional(
			isolation=Isolation.DEFAULT,
			propagation=Propagation.REQUIRED,
			readOnly=false,
			rollbackFor=Exception.class
			)
	public boolean delete(Goods goods) {
		Goods goods1 = new Goods(1,"1",1);
		Goods goods2 = new Goods(2,"2",2);
		sqlSession.delete("com.dao.GoodsMapper.delete1",goods1);
		sqlSession.delete("com.dao.GoodsMapper.delete1",goods2);
		return true;
	}

	@Override
	@Transactional(
			isolation=Isolation.DEFAULT,
			propagation=Propagation.REQUIRED,
			readOnly=false,
			rollbackFor=Exception.class
			)
	public boolean update(Goods goods) {
		Goods goods1 = new Goods(7,"7",7);
		sqlSession.update("com.dao.GoodsMapper.update1",goods1);
		return true;
	}
	@Override
	@Transactional(
			isolation=Isolation.DEFAULT,
			propagation=Propagation.REQUIRED,
			readOnly=true,
			rollbackFor=Exception.class
			)
	public List<Goods> select() {
		List<Goods> ss =(List) sqlSession.selectList("com.dao.GoodsMapper.select1");
		return ss;
	}
}
