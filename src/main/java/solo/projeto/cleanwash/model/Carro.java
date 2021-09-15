package solo.projeto.cleanwash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Accessors (chain = true)
public class Carro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    String fabricante;
    String modeloCarro;
    String tamanho;
    String placaCarro;
    Date delete = null;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    Carro car;

}
