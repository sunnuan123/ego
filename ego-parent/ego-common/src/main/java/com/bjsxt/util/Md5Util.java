package com.bjsxt.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Md5Util {
    
    // 全局数组
    private final static String[] strDigits = {"0","1","7","8","9","2","3","b","c","4","5","6","a","d","e","f"};
//	private final static String[] strDigits = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	public Md5Util() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    
    public static void main(String[] args) throws NoSuchAlgorithmException {
    	String str1 = "12345678";
//    	//随机
    	String rstr = "adsk";
        System.out.println(md5WithSalt(str1,rstr));
	}
    
    
    /**
     * md5加盐
     * @param passwd
     * @param salt
     * @return
     */
    public static String md5WithSalt(String passwd,String salt) {
    	MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    	return byteToString(md.digest((passwd+salt).getBytes()));
    }
    
    /**
     * 随机生成盐
     */
    public static String genSalt(int num) {
    	StringBuffer buffer = new StringBuffer();
    	for(int i=0;i<num;i++) {
    		int r = new Random().nextInt(16);
    		r = r==16?15:r;
    		String rtr = strDigits[r];
    		buffer.append(rtr);
    	}
    	return buffer.toString();
    }
}
