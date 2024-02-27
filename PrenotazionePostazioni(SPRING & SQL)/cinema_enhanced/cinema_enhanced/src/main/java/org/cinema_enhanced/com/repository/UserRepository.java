package org.cinema_enhanced.com.repository;

import org.cinema_enhanced.com.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.lang.*;

public interface UserRepository extends JpaRepository<User, Long> {


    @Nullable
    User findByEmailIgnoreCase(String email);
    @Nullable
    User findByEmailIgnoreCaseAndPassword(String email, String password);
    @Nullable
    User findByUsernameIgnoreCase(String email);
    @Nullable
    User findByUsernameIgnoreCaseAndPassword(String email, String password);
}
