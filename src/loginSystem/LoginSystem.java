package loginSystem;

import exeptions.FailedLogin;

import java.util.HashSet;
import java.util.Set;

public class LoginSystem {
   static private Set<User> users = new HashSet<>();

     static public String login(String username, String password) throws FailedLogin {
        for (User user : users) {
            if(!user.login(username,password).equals("login failed")) {
                return  user.login(username,password);
            }
        }
        throw new FailedLogin();
    }
    static public String Register(String username, String password) {
         User user = new User(username,password);
         System.out.println(username + "line 20");
         users.add(user);
         System.out.println("line 22");
         System.out.println(user.login(username,password));
         return user.login(username,password);
    }

    public static User authorise(String sessionID) {
         for (User user : users) {
             if (user.getSessionID().equals(sessionID)) {
                 return user;
             }
         }
         throw new IllegalStateException("user does not exist");
    }
}
