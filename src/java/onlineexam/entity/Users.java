/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.entity;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class Users {
    private String userId;
    private String password;
    private String userType;
   

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Users{" + "userId=" + userId + ", password=" + password + ", userType=" + userType + '}';
    }

   

    
}
