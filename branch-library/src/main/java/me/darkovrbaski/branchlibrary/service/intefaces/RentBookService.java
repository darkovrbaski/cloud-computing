package me.darkovrbaski.branchlibrary.service.intefaces;

import me.darkovrbaski.branchlibrary.dto.MemberDto;
import me.darkovrbaski.branchlibrary.dto.RentBookDto;

public interface RentBookService {

  MemberDto registerMember(MemberDto memberDto);

  RentBookDto rentBook(RentBookDto rentBookDto);

  RentBookDto returnBook(RentBookDto rentBookDto);

}
