package me.darkovrbaski.branchlibrary.mapper;

import me.darkovrbaski.branchlibrary.config.CentralMapperConfig;
import me.darkovrbaski.branchlibrary.dto.RentBookDto;
import me.darkovrbaski.branchlibrary.model.RentBook;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface CentralLibraryMapper {

  RentBook mapToEntity(RentBookDto rentBookDto);

  RentBookDto mapToDto(RentBook rentBook);
  
}
