package me.darkovrbaski.centrallibrary.service;

import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.darkovrbaski.centrallibrary.dto.MemberDto;
import me.darkovrbaski.centrallibrary.dto.RentDto;
import me.darkovrbaski.centrallibrary.exception.EntityAlreadyExistsException;
import me.darkovrbaski.centrallibrary.exception.InvalidRentException;
import me.darkovrbaski.centrallibrary.mapper.CentralLibraryMapper;
import me.darkovrbaski.centrallibrary.model.Member;
import me.darkovrbaski.centrallibrary.model.Rent;
import me.darkovrbaski.centrallibrary.repository.MemberRepository;
import me.darkovrbaski.centrallibrary.repository.RentRepository;
import me.darkovrbaski.centrallibrary.service.intefaces.MemberService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberServiceImpl implements MemberService {

  final CentralLibraryMapper mapper;
  final MemberRepository memberRepository;
  final RentRepository rentRepository;

  @Override
  public MemberDto registerMember(final MemberDto memberDto) {
    final Optional<Member> optionalMember = memberRepository.findByJmbg(memberDto.jmbg());
    if (optionalMember.isPresent())
      throw new EntityAlreadyExistsException(
          "Member with jmbg: " + memberDto.jmbg() + " already exists.");
    return mapper.toDto(memberRepository.save(mapper.toEntity(memberDto)));
  }

  @Override
  public RentDto rentBook(final RentDto rentDto) {
    checkIfMemberExists(rentDto.memberId());
    final Optional<Rent> optionalRent = rentRepository.findByMemberId(rentDto.memberId());
    if (optionalRent.isPresent()) {
      final Rent rent = optionalRent.get();
      if (rent.getCount() >= 3)
        throw new InvalidRentException(
            "Member with id: " + rentDto.memberId() + " has rented 3 books.");
      rent.setCount(rent.getCount() + 1);
      return mapper.toDto(rentRepository.save(rent));
    }
    final Rent rent = Rent.builder().memberId(rentDto.memberId()).count(1).build();
    return mapper.toDto(rentRepository.save(rent));
  }

  @Override
  public RentDto returnBook(final RentDto rentDto) {
    checkIfMemberExists(rentDto.memberId());
    final Optional<Rent> optionalRent = rentRepository.findByMemberId(rentDto.memberId());
    if (optionalRent.isPresent()) {
      final Rent rent = optionalRent.get();
      if (rent.getCount() > 0) {
        rent.setCount(rent.getCount() - 1);
        return mapper.toDto(rentRepository.save(rent));
      }
    }
    final Rent rent = Rent.builder().memberId(rentDto.memberId()).count(0).build();
    return mapper.toDto(rent);
  }

  private void checkIfMemberExists(final Long memberId) {
    memberRepository.findByIdOrThrow(memberId);
  }
}
