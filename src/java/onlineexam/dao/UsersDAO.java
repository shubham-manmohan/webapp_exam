/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.dao;

import onlineexam.entity.LoginUser;
import onlineexam.entity.Users;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public interface UsersDAO {
    public abstract Users validateUser(LoginUser user) throws Exception;
    public abstract boolean searchUser(String userId);
    public abstract boolean registerUser(LoginUser newuser) throws Exception;
    public abstract boolean removeUser(String userId);
    public boolean changePassword(LoginUser user);
}
