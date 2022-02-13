package hay.micro.math.service;

import hay.micro.math.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MathService {
	private final Random random = new Random();
	private int max = 10;

	public Question getRandomQuestion() {
		int a = random.nextInt(max);
		int b = random.nextInt(max);

		return Question.builder().question(a + " + " + b + " = ?").answer(String.valueOf(a+b)).build();
	}
}
