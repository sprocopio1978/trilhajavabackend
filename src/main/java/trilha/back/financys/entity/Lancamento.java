package trilha.back.financys.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Lancamento implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Lcto_Id")
    private Long id;

    @Column(name = "Nome", nullable = false)
    private String name;

    @Column(name = "Descricao")
    private String description;

    @Column(name = "Tipo")
    private String type;

    @Column(name = "Quantia")
    private String amount;

    @Column(name = "Data")
    private Date date;

    @Column(name = "Pago")
    private Boolean payd;

    @Column(name = "IDCategoria")
    private Long categoryid;

}
