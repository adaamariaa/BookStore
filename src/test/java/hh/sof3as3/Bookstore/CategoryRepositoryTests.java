package hh.sof3as3.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTests {
		
		@Autowired
		private CategoryRepository crepository;
		
		@Test
		public void findByBookTitleReturnYear() {
			List<Category> categories = crepository.findByName("Fantasy");
	        assertThat(categories.get(0).getCategoryid()).isEqualTo(1);
		}
		
		@Test
		public void createNewCategory() {
			Category category = new Category("Nonfiction");
			crepository.save(category);
			assertThat(category.getCategoryid()).isNotNull();
		}
		
		@Test
		public void deleteCategory() {
			crepository.delete(crepository.findByName("Nonfiction").get(0));
			List<Category> categories = crepository.findByName("Nonfiction");
			assertThat(categories).hasSize(0);
		}

	}


