package com.advance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description user
 * @Author zcc
 * @Date 18/12/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    /**
     * 用户id
     */
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 创建用户时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 邮件
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 登录IP
     */
    @Column(name = "LOGIN_IP")
    private String loginIp;

    /**
     * 登录次数
     */
    @Column(name = "LOGIN_NUM")
    private Integer loginNum;

    /**
     * 登录时间
     */
    @Column(name = "LOGIN_TIME")
    private Date loginTime;

    /**
     * 上一次登录IP
     */
    @Column(name = "OLD_LOGIN_IP")
    private String oldLoginIp;

    /**
     * 上一次登录时间
     */
    @Column(name = "OLD_LOGIN_TIME")
    private Date oldLoginTime;

    /**
     * 昵称
     */
    @Column(name = "PICK_NAME")
    private String pickName;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private Integer roleId;

    /**
     * 盐值
     */
    @Column(name = "SALT")
    private String salt;

    /**
     * 个性签名
     */
    @Column(name = "SIGNATURE")
    private String signature;

    /**
     * 用户状态
     */
    @Column(name = "STATE")
    private Integer state;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 用户头像
     */
    @Column(name = "USER_ICON")
    private String userIcon;

    /**
     * favicon.ico
     */
    @Column(name = "FAVICON")
    private String favicon;

    /**
     * 用户手机号
     */
    @Column(name = "USER_PHONE")
    private String userPhone;

    /**
     * 用户密码
     */
    @Column(name = "USER_PWD")
    private String userPwd;

    /**
     * 禁封/解封原因
     */
    @Column(name = "CAUSE")
    private String cause;

    private static final long serialVersionUID = 1L;
}