package com.example.commonservice.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Size;
import java.util.List;

public class Address {
    @Size(max = 3)
    private List<String> codes; // Thứ tự là Tỉnh thành -> Quận huyện -> Xã phường

    @Length(max = 2000)
    private String fullAddress;

    private String address2Show;
}
