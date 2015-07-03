#include<stdio.h>
#include<stdlib.h>
#include"com_example_ndk_NdkNativeJava.h"
#include<android/log.h>
#define TAG "nate"
#define LOGV(...)  __android_log_print(ANDROID_LOG_ERROR,TAG,__VA_ARGS__)

/*
 * Class:     com_example_ndk_NdkNativeJava
 * Method:    getCallResultByC
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_example_ndk_NdkNativeJava_getCallResultByC
  (JNIEnv * env, jclass jclass){

	LOGV("log from _android_log_print of ndk!!");

	return (*env)->NewStringUTF(env,"Hello from JNI!!!");
}

/*
 * Class:     com_example_ndk_NdkNativeJava
 * Method:    updateFile
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_example_ndk_NdkNativeJava_updateFile
  (JNIEnv* env, jclass jclas, jstring path){
	const char* file_path = (*env)->GetStringUTFChars(env,path,NULL);
	if(file_path!=NULL){
		LOGV("from c file file_path %s", file_path);
	}
	FILE* file = fopen(file_path,"a+");
	if(file!=NULL){
		LOGV("from c open file success");
	}
	char data[] = "I am boy";
	int count  = fwrite(data,strlen(data),1,file);
	if(count>0){
		LOGV("from c write file success");
	}
	if(file!=NULL){
		fclose(file);
	}
}

/*
 * Class:     com_example_ndk_NdkNativeJava
 * Method:    writeFile
 * Signature: (Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_example_ndk_NdkNativeJava_writeFile
  (JNIEnv * env, jclass jc, jstring path, jstring message){
	const char* file_path = (*env)->GetStringUTFChars(env,path,NULL);
	const char* in_message = (*env)->GetStringUTFChars(env,message,NULL);
	if(file_path!=NULL){
		LOGV("from c file file_path %s", file_path);
	}
	FILE* file = fopen(file_path,"a+");
	if(file!=NULL){
		LOGV("from c open file success");
	}
	if(in_message!=NULL){
		LOGV("from c file message %s", in_message);
		int count  = fwrite(in_message,strlen(in_message),1,file);
		if(count>0){
			LOGV("from c write file success");
		}
		if(file!=NULL){
			fclose(file);
		}
	}
}

/*
 * Class:     com_example_ndk_NdkNativeJava
 * Method:    updateIntArray
 * Signature: ([I)[I
 */
JNIEXPORT jintArray JNICALL Java_com_example_ndk_NdkNativeJava_updateIntArray
  (JNIEnv * env, jclass jc, jintArray array){
	jint nativeArray[5] ;
	(*env)->GetIntArrayRegion(env,array,0,5,nativeArray);
	int j;
	for(j = 0;j<5;j++){
		nativeArray[j]+=5;
		LOGV("from c int %d",nativeArray[j]);
	}
	(*env)->SetIntArrayRegion(env,array,0,5,nativeArray);
	return array;
}
/*
 * Class:     com_example_ndk_NdkNativeJava
 * Method:    updateIntArrayByPointer
 * Signature: ([I)[I
 */
JNIEXPORT jintArray JNICALL Java_com_example_ndk_NdkNativeJava_updateIntArrayByPointer
  (JNIEnv * env, jclass jc, jintArray array){
	//生成数据的指针
	jint* data = (*env)->GetIntArrayElements(env,array,NULL);
	jsize len = (*env)->GetArrayLength(env,array);

	int j ;
	for(j=0;j<len;j++){
		data[j] += 3;
		LOGV("from c int %d",data[j]);
	}
	//释放相关的资源
	(*env)->ReleaseIntArrayElements(env,array,data,0);
	return array;
}










