package com.ninhnh.borrowingservice.command.api.controller;

import com.ninhnh.borrowingservice.command.api.command.CreateBorrowCommand;
import com.ninhnh.borrowingservice.command.api.model.BorrowRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/borrowing")
public class BorrowCommandController {
    @Autowired
    private CommandGateway commandGateway;

//    @Autowired
//    private BorrowService borrowService;

    @PostMapping
    public String addBookBorrowing(@RequestBody BorrowRequestModel model) {
        try {
            CreateBorrowCommand command =
                    new CreateBorrowCommand(model.getBookId(), model.getEmployeeId(), UUID.randomUUID().toString(),new Date());
            commandGateway.sendAndWait(command);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return "Book borrowing added";
    }

}
