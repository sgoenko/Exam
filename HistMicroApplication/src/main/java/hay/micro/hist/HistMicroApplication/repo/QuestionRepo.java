package hay.micro.hist.HistMicroApplication.repo;

import hay.micro.hist.HistMicroApplication.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
