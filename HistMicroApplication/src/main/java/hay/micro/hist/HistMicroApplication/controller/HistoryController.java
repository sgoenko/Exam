package hay.micro.hist.HistMicroApplication.controller;

import hay.micro.hist.HistMicroApplication.domain.Question;
import hay.micro.hist.HistMicroApplication.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class HistoryController {

	@Autowired
	private QuestionRepo questionRepo;

	@GetMapping("/questions")
	public List<Question> getRandomQuestions(@RequestParam int amount) {
		List <Question> questions = questionRepo.findAll();
		Collections.shuffle(questions);
		return questions.stream().limit(amount).collect(Collectors.toList());
	}
}
