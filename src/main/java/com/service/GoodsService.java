package com.service;

import java.util.List;

import com.entity.Goods;

public interface GoodsService {
	int save(Goods goods);
	boolean delete(Goods goods);
	boolean update(Goods goods);
	List<Goods> select();
}
