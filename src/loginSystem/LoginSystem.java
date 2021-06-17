package loginSystem;

import exeptions.FailedLogin;

import java.util.Set;

public class LoginSystem {
   static private Set<User> users;

     static public String login(String username, String password) throws FailedLogin {
        for (User user : users) {
            if(!user.login(username,password).equals("login failed")) {
                return  user.login(username,password);
            }
        }
        throw new FailedLogin();
    }
}
