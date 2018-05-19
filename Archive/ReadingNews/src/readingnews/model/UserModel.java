/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingnews.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import readingnews.entity.User;

/**
 * Dùng để làm việc với bảng users trong database reading_news.
 * 
 * @author xuanhung
 * @since 09/05/2018
 */
public class UserModel {
    
    /**
     * Đăng ký người dùng, trả về true nếu lưu thành công thông tin
     * người dùng vào db. Trả về false trong trường hợp lỗi.
     * @param user
     * @return 
     * @throws java.sql.SQLException
     */
    public boolean register(User user) throws SQLException{
        PreparedStatement ps = DBConnection
                .getInstance()
                .getConnection()
                .prepareStatement("insert into users (username, password, email) values (?, ?, ?)");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.execute();
        return false;
    }
    
    public boolean checkExist(String username){
        return false;
    }
    
    public User login(String username, String password){
        return new User();
    }
    
}
