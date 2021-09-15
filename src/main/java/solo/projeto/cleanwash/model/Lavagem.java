package solo.projeto.cleanwash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Lavagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idLavagem")
    Long idLavagem;
    String tipoLavagem;
    Date dataLavagem;
    String observacao;

    @ManyToOne
    @JoinColumn (name = "idCarro")
    Carro carro;
}
