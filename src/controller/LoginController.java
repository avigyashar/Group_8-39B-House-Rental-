package controller;

import dao.UserDAO;
import model.logindata;

public class LoginController {

    UserDAO dao = new UserDAO();

    public boolean loginUser(String usernameOrEmail, String password) {

        logindata user = new logindata(
            usernameOrEmail,  // username
            usernameOrEmail,  // email (you are allowing either login)
            password
        );

        return dao.checkUser(user);
    }
}