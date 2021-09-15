package solo.projeto.cleanwash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Carro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idCarro;
    String fabricante;
    String modeloCarro;
    String tamanho;
    String placaCarro;
    Date dateCarroDeleted;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lavagem> lavagem;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    Carro car;

}
