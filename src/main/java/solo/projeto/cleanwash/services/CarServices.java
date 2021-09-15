package solo.projeto.cleanwash.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solo.projeto.cleanwash.model.Carro;
import solo.projeto.cleanwash.repository.CarRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarServices {

    private CarRepo repository;

    @Autowired
    public void setRepository(CarRepo repository) {
        this.repository = repository;
    }

    public Optional<Carro> getCarById(Long id){
        return repository.findByDeletedIsNullAndId(id);
    }

    public List<Carro> getAllCar(){
        return repository.findAllByDeletedIsNull();
    }

    public Carro insert(Carro a){
        return repository.save(a);
    }

    public Carro update(Carro a){
        return  repository.saveAndFlush(a);
    }

    public Carro delete(Long id){
        Carro a = repository.getById(id);
        a.setDelete(new Date());
        return repository.saveAndFlush(a);
    }

}


