package com.springboot.modules.project.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author keith
 * @version 2018-10-14
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Bussinessinfo {
	
	private Integer bussinessId;
	private Integer userId;
	private String nickName;
	private String bussinesAdddress;
	private String logoPic;
	private String corpId;
	private String corpName;
	private String corpType;
	private String corpLogo;
	private Integer corpUserMax;
	private String corpFullname;
	private Integer subjectType;
	private Long verifiedEndTime;
	private String corpWxqrcode;
	private String corpScale;
	private String corpIndustry;
	private String corpSubindustry;
	private String accessToken;
	private Long expiresTime;
	private String location;
	@Override
	public String toString() {
		return "Bussinessinfo{" +
				"bussinessId=" + bussinessId +
				", userId=" + userId +
				", nickName='" + nickName + '\'' +
				", bussinesAdddress='" + bussinesAdddress + '\'' +
				", logoPic='" + logoPic + '\'' +
				", corpId='" + corpId + '\'' +
				", corpName='" + corpName + '\'' +
				", corpType='" + corpType + '\'' +
				", corpLogo='" + corpLogo + '\'' +
				", corpUserMax=" + corpUserMax +
				", corpFullname='" + corpFullname + '\'' +
				", subjectType=" + subjectType +
				", verifiedEndTime=" + verifiedEndTime +
				", corpWxqrcode='" + corpWxqrcode + '\'' +
				", corpScale='" + corpScale + '\'' +
				", corpIndustry='" + corpIndustry + '\'' +
				", corpSubindustry='" + corpSubindustry + '\'' +
				", accessToken='" + accessToken + '\'' +
				", expiresTime=" + expiresTime +
				", location='" + location + '\'' +
				'}';
	}
}