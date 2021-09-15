package solo.projeto.cleanwash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.projeto.cleanwash.model.Lavagem;

    public interface RepoWash extends JpaRepository<Lavagem, Long> {

    }
