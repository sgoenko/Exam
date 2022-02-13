package hay.micro.hist.controller;

import hay.micro.hist.domain.Question;
import hay.micro.hist.repo.QuestionRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class HistoryController {

	private final QuestionRepo questionRepo;

	@GetMapping("/questions")
	public List<Question> getRandomQuestions(@RequestParam int amount) {
		List<Question> questions = questionRepo.findAll();
		Collections.shuffle(questions);
		return questions.stream().limit(amount).collect(Collectors.toList());
	}
}
