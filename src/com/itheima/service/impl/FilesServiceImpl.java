package com.itheima.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.itheima.dao.FilesDao;
import com.itheima.domain.Files;
import com.itheima.domain.User;
import com.itheima.query.BaseQuery;
import com.itheima.query.FilesQuery;
import com.itheima.query.PageResult;
import com.itheima.service.FilesService;
import com.itheima.util.GenProperties;
import com.itheima.util.MD5Util;
import com.itheima.util.UploadUtils;
@Service("filesService")
public class FilesServiceImpl implements FilesService {

	@Resource
	private FilesDao filesDao;
	@Override
	public void saveFiles(File file, Files newfile) {//File:java io    Files: com.itheima.domain
		// 保存文件
		/*判断file的MD5是否与数据库中有匹配：
		 * 		有：文件重复
		 * 		没有：文件上传
		 */
		//计算上传文件的MD5
//		String md5 = MD5Util.md5(file);
		String md5 = null;
		
		//先把MD5设置给文件件
		newfile.setMd5(md5);
		User u = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		newfile.setUser(u);
		newfile.setApprove("0");
		newfile.setUploadtime(new Date());
		//去数据库查找对应为MD5的文件是否存在，存在返回Files对象，不存在就直接上传
		List<Files> fileIsExistList = this.filesDao.md5IsExist(md5);
		
		String url= "";
		
		//计算文件的存储路径
		
				//把日期格式化成字符串的一个帮助类 
				SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
				//用类加载器获得配置文件配置信息
				String basePath = GenProperties.getValueByKey("location");
				
				//把日期类型格式化为"/yyyy/MM/dd/"这种形式的字符串
				String subPath = sdf.format(new Date());
				//如果文件夹不存在，就创建文件夹
				File dir = new File(basePath+subPath);
				if(!dir.exists()){
					dir.mkdirs();
				}
				String path = basePath + subPath + md5 + "_" + newfile.getName();//文件名是配置文件设置路径+日期路径+文件的MD5+上传文件的名字
		
		
		//上传文件
		if(fileIsExistList.size()==0){
			//数据库不存在
			//开启一个线程上传文件
			UploadUtils thread = new UploadUtils(file,path,this.filesDao,newfile);
			thread.start();
		}
		//文件已存在，获取url
		else{
			//存在,把存在的Files对象的url路径设置给新上传的文件
			url = fileIsExistList.get(0).getUrl();
			newfile.setUrl(url);
			newfile.setLength(new File(url).length());
			this.filesDao.addEntity(newfile);
		}
	}

	@Override
	public void deleteFiles(Serializable id) {
		//一个磁盘文件被几个Files对象的url指向
		List<Files> files = this.filesDao.md5IsExist(this.filesDao.getEntityById(id).getMd5());
		//如果files的size>2，说明真实磁盘的url还在被Files对象引用.不删除。
		if(files.size()<2){
			//如果size=1，同时删除磁盘文件
			String url = this.filesDao.getEntityById(id).getUrl();
			File file = new File(url);
			file.delete();
		}
		this.filesDao.deleteEntity(id);
	}
	
	@Override
	public void updateFiles(Files file) {
		this.filesDao.updateEntity(file);
	}

	@Override
	public Files getFilesByFid(Serializable id) {
		// TODO Auto-generated method stub
		return this.filesDao.getEntityById(id);
	}

	@Override
	public PageResult<Files> getFilesByCondition(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return this.filesDao.findPageResult(Files.class, baseQuery);
	}

	@Override
	public void deleteFileByIds(Long[] ids) {
		List<Files> files = this.filesDao.getEntityByIds(ids);
		if(files!=null){
			for (Files files2 : files) {
				//删除磁盘文件
				String url = files2.getUrl();
				File f = new File(url);
				f.delete();
				//删除数据库文件
				this.filesDao.deleteEntity(files2.getFid());
			}
		}
	}

	@Override
	public PageResult<Files> getFilesByConditionNotApprove(BaseQuery baseQuery) {
		return this.filesDao.findPageResultNotApprove(Files.class, baseQuery);
	}

	@Override
	public void saveApproveFiles(Long []fids) {
		//产过来的全部fids通过审核
		List<Files> files = this.filesDao.getEntityByIds(fids);
		for (Files files2 : files) {
			files2.setApprove("1");//通过审核的标记
			this.filesDao.updateEntity(files2);
		}
	}


}
