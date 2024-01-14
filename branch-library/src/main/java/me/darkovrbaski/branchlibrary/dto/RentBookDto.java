package me.darkovrbaski.branchlibrary.dto;

import java.time.LocalDateTime;

public record RentBookDto(

    Long id,

    Long memberId,

    String title,

    String author,

    String isbn,

    LocalDateTime rentDate,

    LocalDateTime returnDate

) {

}
