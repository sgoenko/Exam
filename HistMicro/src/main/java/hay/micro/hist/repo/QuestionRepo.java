package hay.micro.hist.repo;

import hay.micro.hist.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
