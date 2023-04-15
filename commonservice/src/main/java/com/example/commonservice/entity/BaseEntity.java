package com.example.commonservice.entity;

import com.example.commonservice.enumO.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@ToString
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field(name = "status")
    private Status status;


    @NotNull
    @Field(name = "created_date")
    private Instant createdDate;

    @NotNull
    @Field(name = "created_user")
    private String createdUser;

    @Field(name = "updated_date")
    private Instant updatedDate;

    @Field(name = "updated_user")
    private String updatedUser;

}