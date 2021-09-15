package solo.projeto.cleanwash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Accessors(chain = true)
public class Cliente implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idCliente")
    private Long idCliente;
    String nomeCliente;


    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "numeroCliente")
    private Telefone telefone;

}
