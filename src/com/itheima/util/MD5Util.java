package com.itheima.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	private final static Log log = LogFactory.getLog(MD5Util.class);
	static MessageDigest md = null;

	static {
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ne) {
			log.error("NoSuchAlgorithmException: md5", ne);
		}
	}

	/**
	 * 对一个文件求他的md5值
	 * 
	 * @param f
	 *            要求md5值的文件
	 * @return md5串
	 */
	public static String md5(File f) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			byte[] buffer = new byte[8192];
			int length;
			while ((length = fis.read(buffer)) != -1) {
				md.update(buffer, 0, length);
			}
			return new String(Hex.encodeHex(md.digest()));
		} catch (FileNotFoundException e) {
			log.error("md5 file " + f.getAbsolutePath() + " failed:"
					+ e.getMessage());
			return null;
		} catch (IOException e) {
			log.error("md5 file " + f.getAbsolutePath() + " failed:"
					+ e.getMessage());
			return null;
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
