package com.xiaoniucr.common.dto;

/**
 * 登录请求参数
 */
public class LoginDto {

    /**
     * 账号
     */
    private String username;



    /**
     * 密码
     */
    private String password;

    /**
     * 角色：0 管理员，1 学生
     */
    private Integer role;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
