package com.itheima.action;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.action.base.BaseAction;
import com.itheima.annotation.privilege.PrivilegeAnnotation;
import com.itheima.domain.Book;
import com.itheima.domain.User;
import com.itheima.query.BookQuery;
import com.itheima.query.PageResult;
import com.itheima.service.BookService;
import com.itheima.service.UserService;
import com.itheima.util.GenProperties;
import com.itheima.util.POI;
import com.itheima.util.SendGmail;
import com.itheima.util.SendMail163;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class BookAction extends BaseAction<Book> {
	
	@Resource
	private BookService bookService;
	@Resource
	private UserService userService;
	
	private BookQuery bookQuery = new BookQuery();
	private int pageSize = 15;
	
	//批量删除
	private Long[] ids;
	
	//借书
	private String bookname;
	private String number;
	
	@PrivilegeAnnotation(name="查看全部图书")
	public String showBookByCondition(){
		
		bookQuery.setPageSize(pageSize);
		PageResult<Book> pageResult = this.bookService.getBooks(bookQuery);
		pageResult.setUrl("bookAction_showBookByCondition.action?bookQuery.");
		ActionContext.getContext().put("pageResult", pageResult);
		return "listAction";
	}
	
	@PrivilegeAnnotation(name="添加图书")
	public String addUI(){
		
		return "addUI";
	}
	
	@PrivilegeAnnotation(name="添加图书")
	public String add(){
		Book book = new Book();
		BeanUtils.copyProperties(this.getModel(), book);
		book.setStatue("0");
		this.bookService.save(book);
		return "action2action";
	}
	
	@PrivilegeAnnotation(name="修改图书")
	public String updateUI(){
		Book book = this.bookService.getBook(this.getModel().getBid());
		ActionContext.getContext().getValueStack().push(book);
		return "updateUI";
	}
	
	@PrivilegeAnnotation(name="修改图书")
	public String update() throws IntrospectionException{
		Book book = this.bookService.getBook(this.getModel().getBid());
		
		Book model = this.getModel();
		//如果不为空的  修改
		book.setNo(model.getNo());
		book.setName(model.getName());
		book.setPrice(model.getPrice());
		
		this.bookService.update(book);
		return "action2action";
	}
	@PrivilegeAnnotation(name="删除图书")
	public String delete(){
		deleteBook(new Long[]{this.getModel().getBid()});
		return "action2action";
	}
	
	@PrivilegeAnnotation(name="删除图书")
	public String deleteBatch(){
		deleteBook(ids);
		return "action2action";
	}
	
	@PrivilegeAnnotation(name="借书")
	public String borrowUI(){
		Book book = this.bookService.getBook(this.getModel().getBid());
		//图书编号加图书名
		bookname = book.getNo()+"__"+book.getName();
		return "borrowUI";
	}
	@PrivilegeAnnotation(name="借书")
	public String borrowUIInfo(){
		Book book = this.bookService.getBook(this.getModel().getBid());
		//图书编号加图书名
		bookname = book.getNo()+"__"+book.getName();
		
		//根据学号查找借阅人信息
		User user = this.userService.getUserByNumber(number);
		
		ActionContext.getContext().getValueStack().push(user);
		return "borrowUI";
	}
	@PrivilegeAnnotation(name="借书")
	public String borrow(){
		//根据学号和图书编号借书，图书和借阅人之间的关系
		this.bookService.saveBorrowerAndUser(number,this.getModel().getBid());
		return "action2action";
	}
	@PrivilegeAnnotation(name="还书")
	public String back(){
		//根据学号和图书编号借书，图书和借阅人之间的关系
		this.bookService.saveback(this.getModel().getBid());
		return "action2action";
	}
	@PrivilegeAnnotation(name="查看已借图书")
	public String showBookByConditionBorrowed(){
		
		bookQuery.setPageSize(pageSize);
		bookQuery.setStatue("1");
		PageResult<Book> pageResult = this.bookService.getBooks(bookQuery);
		pageResult.setUrl("bookAction_showBookByConditionBorrowed.action?bookQuery.");
		ActionContext.getContext().put("pageResult", pageResult);
		return "showBorrowed";
	}
	@PrivilegeAnnotation(name="还书")
	public String backBook(){
		
		
		//根据学号和图书编号借书，图书和借阅人之间的关系
		this.bookService.saveback(this.getModel().getBid());
		return "action2showBorrowed";
	}
	@PrivilegeAnnotation(name="还书")
	public String backBatch(){
		
		//根据学号和图书编号借书，图书和借阅人之间的关系
		this.bookService.savebackBatch(ids);
		return "action2showBorrowed";
	}
	@PrivilegeAnnotation(name="发送邮件")
	public String sendMail() throws AddressException, MessagingException{
		Book book = this.bookService.getBook(this.getModel().getBid());
		sendMail(book);
		return "action2showBorrowed";
	}
	@PrivilegeAnnotation(name="发送邮件")
	public String sendMailBatch() throws AddressException, MessagingException{
		
		List<Book> books = this.bookService.getAllBorrowedBooks();
		for (Book book : books) {
			sendMail(book);
		}
		
		return "action2showBorrowed";
	}
	@PrivilegeAnnotation(name="导出借阅excel")
	public String excel() throws IOException{
		List<Book> books = this.bookService.getAllBorrowedBooks();
		POI.excel(books);
		return "action2showBorrowed";
	}
	
	
	
	
	
	//---------------------------------------------------------
	//发邮件,私有，调用
	private void sendMail(Book book) throws AddressException, MessagingException{
		String mailType = GenProperties.getValueByKey("mail_type");
		//根据配置文件的类型  选择163邮件发送还是gmail邮件发送
		if("163".equals(mailType)){
			SendMail163.send(book);
		}
		if("gmail".equals(mailType)){
			SendGmail.send(book);
		}
	}
	
	//删除,私有，调用
	private void deleteBook(Long[] ids){
		this.bookService.delete(ids);
	}
	
	
	public BookQuery getBookQuery() {
		return bookQuery;
	}
	public void setBookQuery(BookQuery bookQuery) {
		this.bookQuery = bookQuery;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
