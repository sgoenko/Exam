package hay.micro.hist.HistMicroApplication;

import hay.micro.hist.HistMicroApplication.domain.Question;
import hay.micro.hist.HistMicroApplication.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HistMicroApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(HistMicroApplication.class, args);

		QuestionRepo questionRepo = (QuestionRepo) context.getBean("questionRepo");
		questionRepo.save(Question.builder().question("How many years in a century ?").answer("100").build());
		questionRepo.save(Question.builder().question("How long did the Hundred Years War last ?").answer("116").build());
	}

}
