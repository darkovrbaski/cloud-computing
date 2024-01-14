package me.darkovrbaski.centrallibrary.mapper;

import me.darkovrbaski.centrallibrary.config.CentralMapperConfig;
import me.darkovrbaski.centrallibrary.dto.MemberDto;
import me.darkovrbaski.centrallibrary.dto.RentDto;
import me.darkovrbaski.centrallibrary.model.Member;
import me.darkovrbaski.centrallibrary.model.Rent;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface CentralLibraryMapper {

  Member toEntity(MemberDto memberDto);

  MemberDto toDto(Member member);

  Rent toEntity(RentDto rentDto);

  RentDto toDto(Rent rent);
}
