package com.example.ndk;

public class NdkNativeJava {
	
	static{
		System.loadLibrary("hello");
	}

	/**
	 * getCallResultByC:(jni测试方法). <br/>
	 * date: 2015年7月2日 <br/>
	 *
	 * @author zhaofeng
	 * @return
	 */
	public static native  String getCallResultByC();
	
	/**
	 * updateFile:(创建了文件，并且往文件中写入了信息). <br/>
	 * date: 2015年7月2日 <br/>
	 *
	 * @author zhaofeng
	 * @param path
	 */
	public static native void updateFile(String path);
	
	/**
	 * writeFile:(往指定文件中写入信息). <br/>
	 * date: 2015年7月2日 <br/>
	 *
	 * @author zhaofeng
	 * @param file
	 * @param message
	 */
	public static native void writeFile(String file,String message);
	
	/**
	 * updateIntArray:(测试jni数组). <br/>
	 * date: 2015年7月2日 <br/>
	 *
	 * @author zhaofeng
	 * @param data
	 * @return
	 */
	public static native int[] updateIntArray(int[] data);
	/**
	 * updateIntArrayByPointer:(测试jni数组，通过生成数据指针). <br/>
	 * date: 2015年7月2日 <br/>
	 *
	 * @author zhaofeng
	 * @param data
	 * @return
	 */
	public static native int[] updateIntArrayByPointer(int[] data);
	/**
	 * testJavahEclipseConfigTool:(配置完eclipse的javah选项，测试). <br/>
	 * date: 2015年7月2日 <br/>
	 *
	 * @author zhaofeng
	 */
	public static native void testJavahEclipseConfigTool();
}
