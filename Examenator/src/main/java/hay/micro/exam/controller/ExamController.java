package hay.micro.exam.controller;

import hay.micro.exam.domain.Exam;
import hay.micro.exam.domain.Question;
import hay.micro.exam.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ExamController {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/exam")
	public Exam getExam(@RequestBody Map<String, Integer> spec) {
		List<Section> sections = spec.entrySet().stream()
				.map(this::getUrl)
				.map(url -> restTemplate.getForObject(url, Question[].class))
				.map(Arrays::asList)
				.map(Section::new)
				.collect(Collectors.toList());
		return Exam.builder().title("EXAM").sections(sections).build();
	}

	private String getUrl(Map.Entry<String, Integer> entry) {
		return null;
	}
}
