package com.hubert.common.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

/**
 * 常用工具类
 * 
 * @author JackDou
 * @since 2012-8-1
 */
public class CommUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommUtil.class);

	private CommUtil() {
	}

	/**
	 * 获取i18n讯息
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param key
	 *            取得讯息的key
	 * @return i18n讯息
	 */
	public static String getI18nMsg(HttpServletRequest request, String key) {
		ServletContext servletContext = request.getSession().getServletContext();
		String contextAttribute = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
		WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(contextAttribute);
		return context.getMessage(key, null, request.getLocale());
	}

	/**
	 * 对指定字符串取MD5摘要
	 * 
	 * @param credentials
	 *            待加密的字符串
	 * @return 通过对凭证进行MD5加密后的凭证
	 */
	public static String getMD5Digest(String credentials) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("不支持指定摘要算法", e);
			return null;
		}
		byte[] bytes = null;
		try {
			bytes = credentials.getBytes(Constant.CHARSET);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("不支持指定字节转换编码", e);
			return null;
		}
		md.update(bytes);
		return (convert(md.digest()).toUpperCase());
	}

	private static String convert(byte bytes[]) {
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			sb.append(convertDigit(bytes[i] >> 4));
			sb.append(convertDigit(bytes[i] & 0x0f));
		}
		return (sb.toString());
	}

	private static char convertDigit(int value) {
		value &= 0x0f;
		if (value >= 10) {
			return ((char) (value - 10 + 'a'));
		} else {
			return ((char) (value + '0'));
		}
	}

	public static final synchronized String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static Date str2date(String dstr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(dstr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String date2Str(Date date, String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static <T> List<T> convertSetToList(Set<T> set) {
		List<T> list = new ArrayList<T>();
		if (set != null && set.size() > 0) {
			for (T t : set) {
				list.add(t);
			}
		}
		return list;
	}
	
	
	
	/**
	 *判断属性为空
	 * 
	 * @author bossking <renjie.jing@hand-china.com>
	 * 
	 * @return boolean
	 * 
	 * @param Object 
	 *  
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static boolean checkAttributeNull (Object obj) {
		Field[] field = obj.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组  
		try {
		   for(int j=0 ; j<field.length ; j++){     //遍历所有属性
                String name = field[j].getName();    //获取属性的名字    
                name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
                String type = field[j].getGenericType().toString();    //获取属性的类型
                if(!name.equals("pageSize") || !name.equals("pageNum")){
                	if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
                        Method m = obj.getClass().getMethod("get"+name);
                        String value = (String) m.invoke(obj);    //调用getter方法获取属性值
                        if(StringUtils.isNotEmpty(value)){
                            return false;
                        }
                    }    
                }else{
                 continue;	
                }            
            }
		} catch (NoSuchMethodException e) {
			
			System.out.println("没有找到方法！");
		} catch (SecurityException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		return true;
	}

	public static String formartDate(Date date, String formatStr) {
		if (date == null)
			return "";
		if (StringUtils.isEmpty(formatStr)) {
			formatStr = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}
	
	public static Date formDate(String dateStr,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null ;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}