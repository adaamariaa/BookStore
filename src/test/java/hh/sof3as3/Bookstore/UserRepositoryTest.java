package hh.sof3as3.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Bookstore.domain.User;
import hh.sof3as3.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepository;
	
	@Test
	public void findByUsername() {
		User user = urepository.findByUsername("kille233");
        assertThat(user).isNotNull();
        assertThat(user.getRole()).isEqualTo("ADMIN");
	}
	
	@Test
	public void createNewUser() {
		User user = new User("kalle", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "kalle.kallenen@email.com", "USER");
		urepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		urepository.delete(urepository.findByUsername("kille233"));
		User user = urepository.findByUsername("kille233");
		assertThat(user).isNull();
	}
}
