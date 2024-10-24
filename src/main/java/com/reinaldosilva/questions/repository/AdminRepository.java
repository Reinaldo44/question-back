package com.reinaldosilva.questions.repository;

import com.reinaldosilva.questions.entity.Admin.LoginAdminDto;
import com.reinaldosilva.questions.entity.Admin.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdminRepository extends JpaRepository<UserAdmin, String> {

    UserDetails findByLogin(String login);
}
