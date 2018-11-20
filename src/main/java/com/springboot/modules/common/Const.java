package com.springboot.modules.common;
/**
* @author Keith
* @version 2018年6月26日 上午8:26:59
*
*/
public class Const {
	/**
	 * 用户Redis Key键
	 */
	  public static final String USER = "USER";

	/**
	 * 短信发送状态
	 */
	public enum MessageSendStatusEnum{
		/**
		 * 执行成功
		 */
		SUCCESS(1,"成功"),
		/**
		 * 执行失败
		 */
		ERROR(2,"失败"),
		/**
		 * 出现异常
		 */
		EXCEPTION(3,"出现异常");
		private String value;
		private int code;
		MessageSendStatusEnum(int code,String value){
			this.code = code;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public int getCode() {
			return code;
		}
	}

}
