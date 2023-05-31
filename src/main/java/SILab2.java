import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {
        if (user==null || user.getPassword()==null || user.getEmail()==null){//10
            throw new RuntimeException("Mandatory information missing!");//20
        }

        if (user.getUsername()==null){//30
            user.setUsername(user.getEmail());//40
        }

        int same = 1;//50
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) {//60
            same = 0;//70
            for (int i=0;i<allUsers.size();i++) {//70.1 70.2h 70h.3
                User existingUser = allUsers.get(i);//80
                if (existingUser.getEmail() == user.getEmail()) {//90
                    same += 1;//100
                }
                if (existingUser.getUsername() == user.getUsername()) {//110
                    same += 1;//120
                }
            }//130
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";//140
        String password = user.getPassword();//140
        String passwordLower = password.toLowerCase();//140

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) {//140
            return false;//150
        }
        else {//160
            if (!passwordLower.contains(" ")) {//170
                for (int i = 0; i < specialCharacters.length(); i++) {//180.1 180.2 180.3
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) {//190
                        return same == 0;//200
                    }
                }//210
            }
        }
        return false;//220
    }
//230
}