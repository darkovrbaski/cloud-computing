package me.darkovrbaski.centrallibrary.repository;

import java.util.Optional;
import me.darkovrbaski.centrallibrary.model.Rent;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends EntityRepository<Rent> {

  Optional<Rent> findByMemberId(Long memberId);

}
