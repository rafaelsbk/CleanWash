package solo.projeto.cleanwash.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solo.projeto.cleanwash.model.Carro;
import solo.projeto.cleanwash.services.CarServices;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000/", exposedHeaders = "X-Total-Count")
@RequestMapping("/carro")

public class CarController {

    private CarServices service;

        @Autowired
        public void setService(CarServices service){
            this.service = service;
        }

        @GetMapping
        public List<Carro> getAllCar() {
            return service.getAllCar();
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<Carro> getCarUnique(@PathVariable Long id) {
            Optional<Carro> a = service.getCarById(id);
            if (a.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok().body(a.get());
            }
        }

        @PostMapping
        public Carro newCarro(@RequestBody Carro carro) {
            return service.insert(carro);
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<?> updateCarro(@PathVariable Long id, @RequestBody Carro a) {
            return service.getCarById(id).map(record -> {
                if (record.getId().equals(a.getId())) {
                    service.update(a);
                    return ResponseEntity.ok(a);
                } else {
                    return ResponseEntity.notFound().build();
                }
            }).orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping(path = "/{id}")
        public ResponseEntity<?> deleteCarro(@PathVariable Long id, Carro a){
            return service.getCarById(id)
                    .map( record -> {
                        service.delete(record.getId());
                        return ResponseEntity.ok(a);
                    }).orElse(ResponseEntity.notFound().build());
        }

    }

