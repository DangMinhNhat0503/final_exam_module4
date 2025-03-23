package com.example.final_exam_module4.dto;

import com.example.final_exam_module4.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserInfoUserDetails implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(User appUser) {
        this.username = appUser.getUsername();
        this.password = appUser.getPassword();
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority(appUser.getRole()));
        // Bắt buộc dữ liệu là ROLE_USER hoặc ROLE_ADMIN (đúng cú pháp)
        // Chỉ có 1 Role duy nhất cho mỗi user
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
