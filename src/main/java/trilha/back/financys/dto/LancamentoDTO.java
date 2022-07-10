package trilha.back.financys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trilha.back.financys.entity.Categoria;
import trilha.back.financys.entity.Lancamento;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoDTO {

    private Long id;
    private String name;
    private String description;
    private String type;
    private String amount;
    private Date date;
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
