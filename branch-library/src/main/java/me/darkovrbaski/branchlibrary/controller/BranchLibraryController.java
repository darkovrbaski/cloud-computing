package me.darkovrbaski.branchlibrary.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.darkovrbaski.branchlibrary.dto.MemberDto;
import me.darkovrbaski.branchlibrary.dto.RentBookDto;
import me.darkovrbaski.branchlibrary.service.intefaces.RentBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branch-library")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchLibraryController {

  final RentBookService rentBookService;

  @Operation(
      summary = "Register a new member.",
      description = "Returns a registered member."
  )
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Member registered"),
      @ApiResponse(responseCode = "400", description = "Invalid member data")
  })
  @PostMapping("/register")
  public ResponseEntity<MemberDto> registerMember(@RequestBody final MemberDto memberDto) {
    return ResponseEntity.ok(rentBookService.registerMember(memberDto));
  }

  @Operation(
      summary = "Rent a book.",
      description = "Request to rent a book."
  )
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Book rented"),
      @ApiResponse(responseCode = "400", description = "Invalid rent count"),
      @ApiResponse(responseCode = "404", description = "Member not found"),
  })
  @PostMapping("/rent-book")
  public ResponseEntity<RentBookDto> rentBook(@RequestBody final RentBookDto rentBookDto) {
    return ResponseEntity.ok(rentBookService.rentBook(rentBookDto));
  }

  @Operation(
      summary = "Return a book.",
      description = "Return rented book."
  )
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Book returned"),
      @ApiResponse(responseCode = "404", description = "Member not found")
  })
  @PostMapping("/return-book")
  public ResponseEntity<RentBookDto> returnBook(@RequestBody final RentBookDto rentBookDto) {
    return ResponseEntity.ok(rentBookService.returnBook(rentBookDto));
  }

}