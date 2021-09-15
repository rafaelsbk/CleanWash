package solo.projeto.cleanwash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name = "clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idCliente")
    private Long idCliente;
    String nomeCliente;


    @OneToOne (mappedBy = "clientes")
    private Telefone telefone;


    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carro> carro;
}
