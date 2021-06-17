package loginSystem;

public class User {
    private String username;
    private String password;
    private String sessionID = IdGenerator.generate();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String login(String username, String password) {
        if (this.username.equals(username) || this.password.equals(password)) {
            return sessionID;
        } else {
            return "login failed";
        }
    }

    public String getSessionID() {
        return sessionID;
    }
}
