package com.itheima.dao;

import java.util.List;

import com.itheima.dao.base.BaseDao;
import com.itheima.domain.Book;


public interface BookDao extends BaseDao<Book> {

	List<Book> getAllBorrowedBooks();
	
}
