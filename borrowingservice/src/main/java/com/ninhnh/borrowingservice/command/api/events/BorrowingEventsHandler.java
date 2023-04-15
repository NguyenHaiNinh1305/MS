package com.ninhnh.borrowingservice.command.api.events;

import com.ninhnh.borrowingservice.command.api.data.BorrowRepository;
import com.ninhnh.borrowingservice.command.api.data.Borrowing;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BorrowingEventsHandler {
    @Autowired
    private BorrowRepository borrowRepository;

//    @Autowired
//    private BorrowService borrowService;

    @EventHandler
    public void on(BorrowCreatedEvent event) {
        Borrowing model = new Borrowing();

        BeanUtils.copyProperties(event, model);

        borrowRepository.save(model);
    }
// xử lý event
    @EventHandler
    public void on(BorrowDeletedEvent event) {
        if(borrowRepository.findById(event.getId()).isPresent()) {
            borrowRepository.deleteById(event.getId());
        }
        else return;

    }
}
