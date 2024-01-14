package me.darkovrbaski.branchlibrary.repository;

import me.darkovrbaski.branchlibrary.exception.EntityNotFoundException;
import me.darkovrbaski.branchlibrary.model.EntityDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityRepository<T extends EntityDb> extends JpaRepository<T, Long> {

  default T findByIdOrThrow(final Long id) {
    return findById(id).orElseThrow(
        () -> new EntityNotFoundException("Entity with id " + id + " not found"));
  }

}