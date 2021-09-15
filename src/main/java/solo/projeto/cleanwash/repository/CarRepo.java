package solo.projeto.cleanwash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solo.projeto.cleanwash.model.Carro;

import java.util.List;
import java.util.Optional;

public interface CarRepo extends JpaRepository<Carro, Long> {
    List<Carro> findAllByDeletedIsNull();
    Optional<Carro> findByDeletedIsNullAndId(Long id);
}