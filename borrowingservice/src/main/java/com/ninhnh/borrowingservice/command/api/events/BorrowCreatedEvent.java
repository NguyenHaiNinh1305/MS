package com.ninhnh.borrowingservice.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowCreatedEvent {
    private String id;
    private String bookId;
    private String employeeId;
    private Date borrowingDate;
}
