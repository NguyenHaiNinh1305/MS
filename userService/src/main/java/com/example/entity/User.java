package com.example.entity;


import com.example.commonservice.entity.Address;
import com.example.commonservice.entity.BaseEntity;
import com.example.commonservice.enumO.Gender;
import com.example.commonservice.enumO.UserType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Data
@Document(collection = "user")
public class User extends BaseEntity {

    @NotNull
    private String email;

    private String passWord;
    private Gender gender;
    private String userName;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    //    @Length(min = 9, max = 12)
    private String legalId;

    @NotNull
    private Instant dateOfBirth;

    private List<String> roles;

    private List<String> phoneNumbers;

    @Length(max = 255)
    private String avatarUrl;   // ảnh đại diện

    private Address homeTown;   // quê quán

    private Address permanentAddress; // địa chỉ thường chú

    private UserType userType;

    private  String dto;

    public User(String subject, String s, Collection<GrantedAuthority> authorities) {
    }

    public User() {

    }
}
