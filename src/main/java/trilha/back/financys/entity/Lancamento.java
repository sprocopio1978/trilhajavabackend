package trilha.back.financys.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import trilha.back.financys.Tipo;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "Campo obrigatório")
    @NotNull
    @Length(min = 3, max = 45, message = "Nome deverá ter no mínimo {min} e no máximo {max} caracteres")
    @Column(name = "Nome", nullable = false)
    private String name;

    @NotBlank(message = "Campo obrigatório")
    @NotNull
    @Length(min = 15, max = 150, message = "Descrição deverá ter no mínimo {min} e no máximo {max} caracteres")
    @Column(name = "Descricao")
    private String description;

    @NotBlank(message = "Campo obrigatório")
    @NotNull
    @Length(min = 3, max = 10, message = "Tipo deverá ter no mínimo {min} e no máximo {max} caracteres")
    @Column(name = "Tipo")
    private String type;

    @NotBlank(message = "Campo obrigatório")
    @NotNull
    @Min(value = 0, message = "Quantia deverá ser maior que {value}")
    @Column(name = "Quantia")
    private String amount;

    @NotBlank(message = "Campo obrigatório")
    @NotNull
    @Column(name = "Data")
    private Date date;

    @NotBlank(message = "Campo obrigatório")
    @NotNull
    @Column(name = "Pago")
    private Boolean payd;

    @Column(name = "IDCategoria")
    private Long categoryid;

}
