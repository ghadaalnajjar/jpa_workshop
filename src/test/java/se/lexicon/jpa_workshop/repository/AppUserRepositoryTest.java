package se.lexicon.jpa_workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpa_workshop.entity.AppUser;

import java.util.Optional;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepo testObject;


    @Test
    public void test_find_by_name() {
        AppUser appUser = testObject.save(new AppUser("Mehrdad", "Javan", "mehrdad.javan@lexicon.se"));
        System.out.println("appUser = " + appUser);
        AppUser appUser2 = testObject.save(new AppUser("Test", "Test", "test.test@lexicon.se"));
        System.out.println("appUser2 = " + appUser2);
        Optional<AppUser> userOptional = testObject.findByEmail("mehrdad.javan@lexicon.se");
        Assertions.assertTrue(userOptional.isPresent());
        Assertions.assertEquals(appUser, userOptional.get());
    }
}
