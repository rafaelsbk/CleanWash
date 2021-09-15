package solo.projeto.cleanwash.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solo.projeto.cleanwash.model.Carro;
import solo.projeto.cleanwash.repository.CarRepo;

import java.util.Date;
import java.util.List;

@Service
public class CarServices {
        CarRepo repository;
        @Autowired
        public void setRepository(CarRepo repository) {
            this.repository = repository;
        }

        public List<Carro> findAll(){
            return repository.findAll();
        }

        public void save(Carro a){
            repository.save(a);
        }

        public void delete(Long id){
            Date date = new Date();
            Carro carro = repository.getById(id);
            carro.setDateCarDeleted(date);

            repository.save(carro);
        }
        public Carro findById(Long id){
            return repository.getById(id);
        }
    }

