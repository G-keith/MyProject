package com.springboot.modules.common;
/**
 * 枚举类
* @author Keith
* @version 2018年6月25日 下午7:09:40
*
*/
public enum ResponseCode {

	/**
	 * 执行成功
	 */
	 SUCCESS(0,"SUCCESS"),
	/**
	 * 执行失败
	 */
	 ERROR(1,"ERROR");

	    private final int code;
	    private final String desc;


	    ResponseCode(int code,String desc){
	        this.code = code;
	        this.desc = desc;
	    }

	    public int getCode(){
	        return code;
	    }
	    public String getDesc(){
	        return desc;
	    }
}
