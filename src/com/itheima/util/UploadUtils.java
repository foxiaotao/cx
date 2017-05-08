package com.itheima.util;
import java.io.File;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.itheima.dao.FilesDao;
import com.itheima.domain.Files;
import com.itheima.domain.User;

public class UploadUtils extends Thread{
	private String path = null;
	private File upload = null;
	private FilesDao filesDao = null;
	private Files newfile = null;
	public UploadUtils(File upload,String path,FilesDao filesDao,Files newfile) {
		this.path = path;
		this.upload = upload;
		this.filesDao = filesDao;
		this.newfile = newfile;
	}
	
/*	
	public static String saveUploadFile(File upload,String filename,String md5){
		//把日期格式化成字符串的一个帮助类 
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		//用类加载器获得配置文件配置信息
		InputStream inputStream = UploadUtils.class.getClassLoader().getResourceAsStream("filelocation.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//配置文件中的路径
		String basePath = properties.getProperty("location");
		
		//把日期类型格式化为"/yyyy/MM/dd/"这种形式的字符串
		String subPath = sdf.format(new Date());
		//如果文件夹不存在，就创建文件夹
		File dir = new File(basePath+subPath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		String path = basePath + subPath + md5 + "_" + filename;//文件名是配置文件设置路径+日期路径+文件的MD5+上传文件的名字
		File dest = new File(path);
		//把文件移动到dest处
		upload.renameTo(dest);
		//文件的全url下载地址（下载时的流数据）
		return path;
	}
*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		File dest = new File(path);
		//把文件移动到dest处
		upload.renameTo(dest);
		//文件的全url下载地址（下载时的流数据）
		//path和url其实值是一样的
		newfile.setUrl(path);
		newfile.setLength(new File(path).length());
		this.filesDao.addEntity(newfile);
//		System.out.println("成功");
	}
	
/*	
 * 下载时 文件名处理
 * String path = formTemplate.getUrl();
	inputStream = new FileInputStream(new File(path));
	resourceFileName = path.substring(path.lastIndexOf("_")+1);
	if(resourceFileName.matches("\\.[a-zA-Z]+?")){
		resourceFileName = "未命名"+resourceFileName;
	}*/
}
