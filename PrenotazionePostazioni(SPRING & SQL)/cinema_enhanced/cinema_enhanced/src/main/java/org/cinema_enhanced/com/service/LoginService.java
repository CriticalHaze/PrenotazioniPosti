package org.cinema_enhanced.com.service;

import org.cinema_enhanced.com.entity.*;
import org.cinema_enhanced.com.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    private boolean checkEmail(String emailOrUser){
        boolean returned = false;
        if(emailOrUser.contains("@")){
            returned = true;
        }
        return returned;
    }

    public User doLogin(String userOrEmail, String password){
        User returnedUser = null;
        if(checkEmail(userOrEmail)){
            if(userRepository.findByEmailIgnoreCase(userOrEmail) != null){
                returnedUser = userRepository.findByEmailIgnoreCaseAndPassword(userOrEmail, password);
            }
        }else{
            if(userRepository.findByUsernameIgnoreCase(userOrEmail) != null){
                returnedUser = userRepository.findByUsernameIgnoreCaseAndPassword(userOrEmail, password);
            }
        }
        return returnedUser;
    }
}
