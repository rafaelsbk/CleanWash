package solo.projeto.cleanwash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name = "telephoneTB")
public class Telefone implements Serializable {
    @Id
    String clientNumber;

    @OneToOne (mappedBy = "telephoneTB")
    @MapsId
    @JoinColumn (name = "idCliente")
    private Cliente client;
}