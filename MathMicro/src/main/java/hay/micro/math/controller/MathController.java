package hay.micro.math.controller;

import hay.micro.math.domain.Question;
import hay.micro.math.service.MathService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class MathController {

	private final MathService mathService;

	@GetMapping("/questions")
	public List<Question> getRandomQuestions(@RequestParam int amount) {
		List <Question> questions = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			questions.add(mathService.getRandomQuestion());
		}
		return questions;
	}
}
