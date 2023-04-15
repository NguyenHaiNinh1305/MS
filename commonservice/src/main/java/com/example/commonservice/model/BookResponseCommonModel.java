package com.example.commonservice.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class BookResponseCommonModel {
    private String bookId;
    private String name;
    private String author;
    private Boolean isReady;
}