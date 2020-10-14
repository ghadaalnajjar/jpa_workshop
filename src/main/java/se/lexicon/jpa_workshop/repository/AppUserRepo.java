package se.lexicon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_workshop.entity.AppUser;

import java.util.Optional;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public interface AppUserRepo extends CrudRepository<AppUser, Integer> {
    Optional<AppUser> findByEmail(String email);
}
