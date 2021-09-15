package solo.projeto.cleanwash.services;

import org.springframework.beans.factory.annotation.Autowired;
import solo.projeto.cleanwash.model.Lavagem;
import solo.projeto.cleanwash.repository.RepoWash;

import java.util.Date;
import java.util.List;

public class CleanWashService {
    RepoWash repository;

    @Autowired
    public void setRepository(RepoWash repository) {
        this.repository = repository;
    }

    public List<Lavagem> findAll(){
        return repository.findAll();
    }

    public void save(Lavagem a){
        repository.save(a);
    }

    public void delete(Long id){
        Date data = new Date();
        Lavagem lavagem = repository.getById(id);
        lavagem.setCarDeleted(data);

        repository.save(lavagem);
    }

    public Lavagem findById(Long id){
        return repository.getById(id);
    }
}

