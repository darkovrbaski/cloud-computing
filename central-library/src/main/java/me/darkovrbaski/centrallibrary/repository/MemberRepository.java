package me.darkovrbaski.centrallibrary.repository;

import java.util.Optional;
import me.darkovrbaski.centrallibrary.model.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends EntityRepository<Member> {

  Optional<Member> findByJmbg(String jmbg);

}
