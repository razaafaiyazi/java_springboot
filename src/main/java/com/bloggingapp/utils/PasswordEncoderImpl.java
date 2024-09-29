package com.bloggingapp.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String razaa = passwordEncoder.encode("razaa");
        System.out.println(razaa);
        String admin = passwordEncoder.encode("admin");
        System.out.println(admin);
    }
}
