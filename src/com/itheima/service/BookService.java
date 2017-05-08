package com.itheima.service;

import java.io.Serializable;
import java.util.List;

import com.itheima.domain.Book;
import com.itheima.query.BookQuery;
import com.itheima.query.PageResult;

public interface BookService {
	public PageResult<Book> getBooks(BookQuery bookQuery);
	public void save(Book book);
	public void update(Book book);
	public void delete(Long[] ids);
	public Book getBook(Long bid);
	public void saveBorrowerAndUser(String number, Long bid);
	public void saveback(Long bid);
	public void savebackBatch(Long[] ids);
	public List<Book> getAllBorrowedBooks();
}
