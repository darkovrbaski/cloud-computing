package me.darkovrbaski.branchlibrary.httpClient;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.darkovrbaski.branchlibrary.dto.MemberDto;
import me.darkovrbaski.branchlibrary.dto.RentDto;
import me.darkovrbaski.branchlibrary.exception.EntityAlreadyExistsException;
import me.darkovrbaski.branchlibrary.exception.EntityNotFoundException;
import me.darkovrbaski.branchlibrary.exception.InvalidRentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CentralLibClient {

  final RestClient centralHttpClient;

  public MemberDto registerMember(final MemberDto memberDto) {
    return centralHttpClient.post()
        .uri("/register")
        .body(memberDto)
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError,
            (req, res) -> {
              if (res.getStatusCode() == HttpStatus.CONFLICT)
                throw new EntityAlreadyExistsException("Member already exists");

            }
        )
        .body(MemberDto.class);
  }

  public RentDto rentBook(final RentDto rentDto) {
    return centralHttpClient.post()
        .uri("/rent-book")
        .body(rentDto)
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError,
            (req, res) -> {
              if (res.getStatusCode() == HttpStatus.BAD_REQUEST)
                throw new InvalidRentException("Member already has 3 books rented");
              else if (res.getStatusCode() == HttpStatus.NOT_FOUND)
                throw new EntityNotFoundException("Member does not exist");
            }
        )
        .body(RentDto.class);
  }

  public RentDto returnBook(final RentDto rentDto) {
    return centralHttpClient.post()
        .uri("/return-book")
        .body(rentDto)
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError,
            (req, res) -> {
              if (res.getStatusCode() == HttpStatus.NOT_FOUND)
                throw new EntityNotFoundException("Member does not exist");
            }
        )
        .body(RentDto.class);
  }
}
