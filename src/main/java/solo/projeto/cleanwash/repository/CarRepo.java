package solo.projeto.cleanwash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.projeto.cleanwash.model.Carro;


public interface CarRepo extends JpaRepository<Carro, Long> {

}