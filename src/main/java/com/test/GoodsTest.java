package com.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.entity.Goods;
import com.service.GoodsService;
import com.service.GoodsServiceImpl;

public class GoodsTest {
	private GoodsService goodsServiceImpl;
	@Before
	public void init() {
		FileSystemXmlApplicationContext app = 
				new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
		goodsServiceImpl = app.getBean("goodsServiceImpl",GoodsServiceImpl.class);
	}
	@Test
	public void save() {
		int row = goodsServiceImpl.save(null);
		System.out.println(row);
	}
	@Test
	public void delete(){
		boolean b = goodsServiceImpl.delete(null);
		System.out.println(b);
	}
	@Test
	public void update(){
		boolean b = goodsServiceImpl.update(null);
		System.out.println(b);
	}
	@Test
	public void select(){
		List<Goods> ss = goodsServiceImpl.select();
		for (Goods goods : ss) {
			System.out.println(goods);
		}
	}
}
