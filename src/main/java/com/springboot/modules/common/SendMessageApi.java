package com.springboot.modules.common;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 发送短信服务类
 * @author keith
 * @date 2018-09-04
 */
public class SendMessageApi {
	public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    public static final String APPKEY =  ConfigurationFileHelper.getAppkey();

	/**
	 * 发送短信接口
	 *  @param phone 手机号
	 *  @param template 模板
	 *  @param codeNew 验证码
	 *  @return  是否成功
	 */
	public static int getSendMessage(String phone,String template,String codeNew){
        System.out.println(APPKEY);
		String code = codeNew;
		System.err.println("code:"+code);
		String result;
        //请求接口地址
        String url ="http://v.juhe.cn/sms/send";
        Map<String, Object> params = new HashMap<String, Object>(16);
        //接收短信的手机号码
        params.put("mobile",phone);
        //短信模板ID
        params.put("tpl_id",template);
        //变量名和变量值对
        params.put("tpl_value","#code#="+code);
        //应用APPKEY(应用详细页查询)
        params.put("key",APPKEY);
        params.put("dtype","json");
        try {
            result =net(url, params, "GET");
            System.out.println(result);
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
                return Const.MessageSendStatusEnum.SUCCESS.getCode();
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
                return Const.MessageSendStatusEnum.ERROR.getCode();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Const.MessageSendStatusEnum.EXCEPTION.getCode();
        }
    }
    /**
    *
    * @param strUrl 请求地址
    * @param params 请求参数
    * @param method 请求方法
    * @return  网络请求字符串
    * @throws Exception
    */
   public static String net(String strUrl, Map<String, Object> params,String method) throws Exception {
       HttpURLConnection conn = null;
       BufferedReader reader = null;
       String rs = null;
       try {
           StringBuffer sb = new StringBuffer();
           if(method==null || method.equals("GET")){
               strUrl = strUrl+"?"+urlencode(params);
           }
           URL url = new URL(strUrl);
           conn = (HttpURLConnection) url.openConnection();
           if(method==null || method.equals("GET")){
               conn.setRequestMethod("GET");
           }else{
               conn.setRequestMethod("POST");
               conn.setDoOutput(true);
           }
           conn.setRequestProperty("User-agent", userAgent);
           conn.setUseCaches(false);
           conn.setConnectTimeout(DEF_CONN_TIMEOUT);
           conn.setReadTimeout(DEF_READ_TIMEOUT);
           conn.setInstanceFollowRedirects(false);
           conn.connect();
           if (params!= null && method.equals("POST")) {
               try {
                   DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                       out.writeBytes(urlencode(params));
               } catch (Exception e) {
                   // TODO: handle exception
               }
           }
           InputStream is = conn.getInputStream();
           reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
           String strRead = null;
           while ((strRead = reader.readLine()) != null) {
               sb.append(strRead);
           }
           rs = sb.toString();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (reader != null) {
               reader.close();
           }
           if (conn != null) {
               conn.disconnect();
           }
       }
       return rs;
   }
   //将map型转为请求参数型
   @SuppressWarnings("rawtypes")
   public static String urlencode(Map<String,Object>data) {
       StringBuilder sb = new StringBuilder();
       for (Map.Entry i : data.entrySet()) {
           try {
               sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
           } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
           }
       }
       return sb.toString();
   }


}
