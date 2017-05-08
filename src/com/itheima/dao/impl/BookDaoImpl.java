package com.itheima.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima.dao.BookDao;
import com.itheima.dao.base.impl.BaseDaoImpl;
import com.itheima.domain.Book;
@Repository
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

	@Override
	public List<Book> getAllBorrowedBooks() {
		return this.getHibernateTemplate().find("from Book where statue=?","1");
	}
	
}
