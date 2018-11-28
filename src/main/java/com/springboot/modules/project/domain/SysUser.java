package com.springboot.modules.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * 用户信息
 * @author keith
 * @date 2018-09-03
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SysUser {
    private Integer id;

    private String loginName;

    private String password;

    private String no;

    private String name;

    private String email;

    private String phone;

    private String mobile;

    private String photo;

    private String loginIp;

    private Date loginDate;

    private Integer loginFlag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    private String updateBy;

    private String updateDate;

    private String remarks;

    private Integer delFlag;

    private String qrcode;
}