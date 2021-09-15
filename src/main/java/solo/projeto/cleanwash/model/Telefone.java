package solo.projeto.cleanwash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Accessors(chain = true)
public class Telefone implements Serializable {
    @Id
    String numeroCliente;

}