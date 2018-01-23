package com.dao;

import java.util.List;

import com.entity.Goods;

public interface GoodsMapper {
	int save(Goods goods);
	boolean delete(Goods goods);
	boolean update(Goods goods);
	List<Goods> select();
}
