package me.darkovrbaski.centrallibrary.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.darkovrbaski.centrallibrary.dto.MemberDto;
import me.darkovrbaski.centrallibrary.dto.RentDto;
import me.darkovrbaski.centrallibrary.service.intefaces.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/central-library")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CentralLibraryController {

  final MemberService memberService;

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
    return ResponseEntity.ok(memberService.registerMember(memberDto));
  }

  @Operation(
      summary = "Rent a book.",
      description = "Increases the number of rented books for the member."
  )
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Book rented"),
      @ApiResponse(responseCode = "400", description = "Invalid rent count"),
      @ApiResponse(responseCode = "404", description = "Member not found"),
  })
  @PostMapping("/rent-book")
  public ResponseEntity<RentDto> rentBook(@RequestBody final RentDto memberDto) {
    return ResponseEntity.ok(memberService.rentBook(memberDto));
  }

  @Operation(
      summary = "Return a book.",
      description = "Decreases the number of rented books for the member."
  )
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Book returned"),
      @ApiResponse(responseCode = "404", description = "Member not found")
  })
  @PostMapping("/return-book")
  public ResponseEntity<RentDto> returnBook(@RequestBody final RentDto memberDto) {
    return ResponseEntity.ok(memberService.returnBook(memberDto));
  }

}