/**
 * Project Name:NdkTest
 * File Name:UtilsTool.java
 * Package Name:com.example.util
 * Date:2015年7月2日
 * Copyright (c) 2015, zhaofeng@ushayden.com All Rights Reserved.
 *
*/

package com.example.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ClassName:UtilsTool ().<br/>
 * Date:     2015年7月2日  <br/>
 * @author   zhaofeng
 * @version  
 * @see 	 
 */
public class UtilsTool {

	public static String getLocalDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
		return df.format(new Date());
	}
}

