package com.springboot.modules.project.domain;

import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author keith
 * @version 2018-10-14
 */
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

	public Integer getBussinessId() {
		return bussinessId;
	}

	public void setBussinessId(Integer bussinessId) {
		this.bussinessId = bussinessId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return HtmlUtils.htmlUnescape(nickName);
	}

	public void setNickName(String nickName) {
		this.nickName = HtmlUtils.htmlUnescape(nickName);
	}

	public String getBussinesAdddress() {
		return bussinesAdddress;
	}

	public void setBussinesAdddress(String bussinesAdddress) {
		this.bussinesAdddress = bussinesAdddress;
	}

	public String getLogoPic() {
		return logoPic;
	}

	public void setLogoPic(String logoPic) {
		this.logoPic = logoPic;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpType() {
		return corpType;
	}

	public void setCorpType(String corpType) {
		this.corpType = corpType;
	}

	public String getCorpLogo() {
		return corpLogo;
	}

	public void setCorpLogo(String corpLogo) {
		this.corpLogo = corpLogo;
	}

	public Integer getCorpUserMax() {
		return corpUserMax;
	}

	public void setCorpUserMax(Integer corpUserMax) {
		this.corpUserMax = corpUserMax;
	}

	public String getCorpFullname() {
		return corpFullname;
	}

	public void setCorpFullname(String corpFullname) {
		this.corpFullname = corpFullname;
	}

	public Integer getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Integer subjectType) {
		this.subjectType = subjectType;
	}

	public Long getVerifiedEndTime() {
		return verifiedEndTime;
	}

	public void setVerifiedEndTime(Long verifiedEndTime) {
		this.verifiedEndTime = verifiedEndTime;
	}

	public String getCorpWxqrcode() {
		return corpWxqrcode;
	}

	public void setCorpWxqrcode(String corpWxqrcode) {
		this.corpWxqrcode = corpWxqrcode;
	}

	public String getCorpScale() {
		return corpScale;
	}

	public void setCorpScale(String corpScale) {
		this.corpScale = corpScale;
	}

	public String getCorpIndustry() {
		return corpIndustry;
	}

	public void setCorpIndustry(String corpIndustry) {
		this.corpIndustry = corpIndustry;
	}

	public String getCorpSubindustry() {
		return corpSubindustry;
	}

	public void setCorpSubindustry(String corpSubindustry) {
		this.corpSubindustry = corpSubindustry;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpiresTime() {
		return expiresTime;
	}

	public void setExpiresTime(Long expiresTime) {
		this.expiresTime = expiresTime;
	}

	public String getLocation() {
		return HtmlUtils.htmlUnescape(location);
	}

	public void setLocation(String location) {
		this.location = HtmlUtils.htmlUnescape(location);
	}

	 
	 
	
}