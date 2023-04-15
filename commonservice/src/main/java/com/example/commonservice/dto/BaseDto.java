package com.example.commonservice.dto;

import com.example.commonservice.enumO.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
public class BaseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Indexed
    private String id;

    @NotNull
    private Status status;


    @NotNull
    private Instant createdDate;

    @NotNull
    private String createdUser;

    private Instant updatedDate;

    private String updatedUser;

}