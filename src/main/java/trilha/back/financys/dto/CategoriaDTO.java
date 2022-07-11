package trilha.back.financys.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;
import trilha.back.financys.entity.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    
    private ModelMapper modelMapper;

    private Long id;
    @NotBlank(message = "Campo Obrigatório")
    @NotNull
    @Length(min = 3, max = 15, message = "Nome deverá ter no mínimo {min}  e no máximo {max}  caracteres")
    private String nome;
    @NotBlank(message = "Campo Obrigatório")
    @NotNull
    @Length(min = 15, max = 50, message = "Descrição deverá ter no minimo {min} e no máximo {max} caracteres")
    private String description;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.description = categoria.getDescription();
    }

    public static List<CategoriaDTO> convert(List<Categoria> categoria){
        return categoria.stream().map(CategoriaDTO::new).collect(Collectors.toList());
    }
}
