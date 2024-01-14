package me.darkovrbaski.centrallibrary.service.intefaces;

import me.darkovrbaski.centrallibrary.dto.MemberDto;
import me.darkovrbaski.centrallibrary.dto.RentDto;

public interface MemberService {

  MemberDto registerMember(MemberDto memberDto);

  RentDto rentBook(RentDto memberDto);

  RentDto returnBook(RentDto memberDto);

}
