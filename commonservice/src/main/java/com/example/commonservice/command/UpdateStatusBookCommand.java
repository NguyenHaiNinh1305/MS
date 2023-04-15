package com.example.commonservice.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStatusBookCommand {

    @TargetAggregateIdentifier
    private String bookId;
    private Boolean isReady;
    private String employeeId;
    private String borrowId;
}
