package com.itheima.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

public class FileUploadUtils {
	public static String saveUploadFile(File upload,String filename){
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
		String path = basePath + subPath + UUID.randomUUID().toString() + "_" + filename;//文件名是配置文件设置路径+日期路径+文件的MD5+上传文件的名字
		File dest = new File(path);
		//把文件移动到dest处
		upload.renameTo(dest);
		//文件的全url下载地址（下载时的流数据）
		return path;
	}
    public static void copyFile(String srcFile, String destFile)
            throws java.io.FileNotFoundException, java.io.IOException {
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);
        FileChannel fcin = fis.getChannel();
        FileChannel fcout = fos.getChannel();
        fcin.transferTo(0, fcin.size(), fcout);
        fcin.close();
        fcout.close();
        fis.close();
        fos.close();
    }
}
