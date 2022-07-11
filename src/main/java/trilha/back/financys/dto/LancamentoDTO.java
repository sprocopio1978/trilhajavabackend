package trilha.back.financys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import trilha.back.financys.Tipo;
import trilha.back.financys.entity.Categoria;
import trilha.back.financys.entity.Lancamento;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoDTO {

    private Long id;
    @NotBlank(message = "Campo obrigatório")
    @NotNull
    @Length(min = 3, max = 45, message = "Nome deverá ter no mínimo {min} e no máximo {max} caracteres")
    private String name;
    @NotBlank(message = "Campo obrigatório")
    @NotNull
    @Length(min = 15, max = 150, message = "Descrição deverá ter no mínimo {min} e no máximo {max} caracteres")
    private String description;
    @NotBlank(message = "Campo obrigatório")
    @NotNull
    @Length(min = 3, max = 10, message = "Tipo deverá ter no mínimo {min} e no máximo {max} caracteres")
    private String type;
    @NotBlank(message = "Campo obrigatório")
    @NotNull
    @Min(value = 0, message = "Quantia deverá ser maior que {value}")
    private String amount;
    @NotBlank(message = "Campo obrigatório")
    @NotNull
    private Date date;
    @NotBlank(message = "Campo obrigatório")
    @NotNull
    private Boolean payd;
    private Long categoryid;



    public LancamentoDTO(Lancamento lancamento) {
        this.id = lancamento.getId();
        this.name = lancamento.getName();
        this.description = lancamento.getDescription();
        this.type = lancamento.getType();
        this.amount = lancamento.getAmount();
        this.date = lancamento.getDate();
        this.payd = lancamento.getPayd();
        this.categoryid = lancamento.getCategoryid();
    }

    public static List<LancamentoDTO> convert(List<Lancamento> lancamento){
        return lancamento.stream().map(LancamentoDTO::new).collect(Collectors.toList());
    }


}
