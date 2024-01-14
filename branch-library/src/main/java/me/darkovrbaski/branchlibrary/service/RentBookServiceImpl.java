package me.darkovrbaski.branchlibrary.service;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.darkovrbaski.branchlibrary.dto.MemberDto;
import me.darkovrbaski.branchlibrary.dto.RentBookDto;
import me.darkovrbaski.branchlibrary.dto.RentDto;
import me.darkovrbaski.branchlibrary.httpClient.CentralLibClient;
import me.darkovrbaski.branchlibrary.mapper.CentralLibraryMapper;
import me.darkovrbaski.branchlibrary.model.RentBook;
import me.darkovrbaski.branchlibrary.repository.RentBookRepository;
import me.darkovrbaski.branchlibrary.service.intefaces.RentBookService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentBookServiceImpl implements RentBookService {

  final CentralLibraryMapper mapper;
  final RentBookRepository rentRepository;
  final CentralLibClient centralLibClient;

  @Override
  public MemberDto registerMember(final MemberDto memberDto) {
    return centralLibClient.registerMember(memberDto);
  }

  @Override
  public RentBookDto rentBook(final RentBookDto rentBookDto) {
    centralLibClient.rentBook(new RentDto(0L, rentBookDto.memberId(), 0));
    final RentBook rentBook = mapper.mapToEntity(rentBookDto);
    rentBook.setRentDate(LocalDateTime.now());
    return mapper.mapToDto(rentRepository.save(rentBook));
  }

  @Override
  public RentBookDto returnBook(final RentBookDto rentBookDto) {
    centralLibClient.returnBook(new RentDto(0L, rentBookDto.memberId(), 0));
    final RentBook rentBook = mapper.mapToEntity(rentBookDto);
    rentBook.setReturnDate(LocalDateTime.now());
    return mapper.mapToDto(rentRepository.save(rentBook));
  }

}
