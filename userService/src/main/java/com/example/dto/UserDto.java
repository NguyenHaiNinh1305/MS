package com.example.dto;

import com.example.commonservice.dto.BaseDto;
import com.example.commonservice.entity.Address;
import com.example.commonservice.enumO.Gender;
import com.example.commonservice.enumO.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {

    @NotNull
    private String email;

    private Gender gender;
    private String userName;

    private String passWord;

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
}
