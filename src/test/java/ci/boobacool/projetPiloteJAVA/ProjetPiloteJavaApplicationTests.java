package ci.boobacool.projetPiloteJAVA;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ci.boobacool.projetPiloteJAVA.entities.Task;
import ci.boobacool.projetPiloteJAVA.entities.User;
import ci.boobacool.projetPiloteJAVA.services.TaskService;
import ci.boobacool.projetPiloteJAVA.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetPiloteJavaApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@Before
	public void initDb() {
		{
			User newUser = new User("booba@gmail.com", "booba", "booba");
			userService.createUser(newUser);
		}
		{
			User newUser = new User("boobaAdmin@gmail.com", "boobaAdmin", "booba");
			userService.createAdmin(newUser);
		}
		Task userTask = new Task("22/08/2019", "15:54", "20:00", "Travail sur le cahier de charges");
		User user = userService.findOne("booba@gmail.com");
		taskService.addTask(userTask, user);
		
	}
	
	@Test
	public void testUser() {
		User user = userService.findOne("booba@gmail.com");
		assertNotNull(user);
		User admin = userService.findOne("boobaAdmin@gmail.com");
		assertEquals(admin.getEmail(),"boobaAdmin@gmail.com");
	}
	
	
	@Test
	public void testTask() {
		User user = userService.findOne("booba@gmail.com");
		List<Task> tasks = taskService.findUserTask(user);
		assertNotNull(tasks);
	}

}
