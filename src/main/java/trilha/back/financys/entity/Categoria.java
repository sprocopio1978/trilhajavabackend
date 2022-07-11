package trilha.back.financys.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo Obrigatório")
    @NotNull
    @Length(min = 3, max = 15, message = "Nome deverá ter no mínimo {min}  e no máximo {max}  caracteres")
    @Column(name = "Nome", nullable = false)
    private String nome;

    @NotBlank(message = "Campo Obrigatório")
    @NotNull
    @Length(min = 15, max = 50, message = "Descrição deverá ter no minimo {min} e no máximo {max} caracteres")
    @Column(name = "Descricao")
    private String description;

    public Categoria(String nome, String description) {
    }


}
