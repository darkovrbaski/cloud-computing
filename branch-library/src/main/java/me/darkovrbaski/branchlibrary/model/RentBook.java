package me.darkovrbaski.branchlibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "rent_book")
public class RentBook extends EntityDb {

  @Column
  Long memberId;

  @Column
  String title;

  @Column
  String author;

  @Column
  String isbn;

  @Column
  LocalDateTime rentDate;

  @Column
  LocalDateTime returnDate;

}
