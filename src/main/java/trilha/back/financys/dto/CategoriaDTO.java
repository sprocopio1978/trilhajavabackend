package trilha.back.financys.dto;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import trilha.back.financys.entity.Categoria;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    
    private ModelMapper modelMapper;

    private Long id;
    private String nome;
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
