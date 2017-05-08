package com.itheima.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Book;
import com.itheima.domain.User;
import com.itheima.query.BookQuery;
import com.itheima.query.PageResult;
import com.itheima.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Resource
	private BookDao bookDao;
	@Resource
	private UserDao userDao;
	
	@Override
	public PageResult<Book> getBooks(BookQuery bookQuery) {
		return bookDao.findPageResult(Book.class, bookQuery);
	}


	@Override
	public void save(Book book) {
		this.bookDao.addEntity(book);
	}


	@Override
	public void update(Book book) {
		this.bookDao.updateEntity(book);
	}


	@Override
	public void delete(Long[] ids) {
		for (Long bid : ids) {
			this.bookDao.deleteEntity(bid);
		}
	}
	@Override
	public Book getBook(Long bid) {
		return this.bookDao.getEntityById(bid);
	}


	@Override
	public void saveBorrowerAndUser(String number, Long bid) {
		User user = this.userDao.getUserByNumber(number);
		Book book = this.bookDao.getEntityById(bid);
		book.setUser(user);
		book.setStart(new Date());
		book.setStatue("1");
		this.bookDao.updateEntity(book);
	}


	@Override
	public void saveback(Long bid) {
		back(bid);
	}


	@Override
	public void savebackBatch(Long[] ids) {
		for (Long bid : ids) {
			back(bid);
		}
	}
	private void back(Long bid){
		Book book = this.bookDao.getEntityById(bid);
		book.setEnd(new Date());
		book.setUser(null);
		book.setStatue("0");
		book.setStart(null);
		book.setEnd(null);
		this.bookDao.updateEntity(book);
	}


	@Override
	public List<Book> getAllBorrowedBooks() {
		return this.bookDao.getAllBorrowedBooks();
	}
}
