package com.ninhnh.borrowingservice.command.api.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBorrowCommand {


    @TargetAggregateIdentifier
    private String id;

    private String bookId;
    private String employeeId;
    private Date borrowingDate;
}
