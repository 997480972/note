package test;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Application;
import com.dao.NoteDao;
import com.entity.Note;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
@Slf4j
public class ApplicationTest {
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private NoteDao noteDao;
	@Test
	public void contextLoads( ) {
		log.info("note : {}", noteDao.findAll());
	}
	
	@Test
	public void save( ) {
		noteDao.save(new Note(6, 1, "java", "javaNote", "content", "description", 1, "author", null, null, 0));
		log.info("note : {}", noteDao.findAll());
	}
	
	@Test
	public void delete(){
		noteDao.delete(1);
	}
}