package eschool;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.eschool.model.Pupil;
import com.example.eschool.service.PupilService;

@Test
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class PupilTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private PupilService pupilService;
	
	@Test
	public void shouldInsertNewPupilIntoDB() {
		
		Pupil p = new Pupil();
		p.setFirstName("bob");
		p.setLastName("alex");
		
		pupilService.create(p);
		
		List<Pupil> pupils = pupilService.findAll();
		
		Assert.assertEquals(1, pupils.size());
		Assert.assertEquals(Long.valueOf(1L), pupils.get(0).getId());
		Assert.assertEquals("bob", pupils.get(0).getFirstName());
		Assert.assertEquals("alex", pupils.get(0).getLastName());
	}
}
