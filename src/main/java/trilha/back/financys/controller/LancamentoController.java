package trilha.back.financys.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import trilha.back.financys.entity.Lancamento;
import trilha.back.financys.service.LancamentoService;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lancamento salvar(@RequestBody Lancamento lancamento){
       Lancamento lcto = new Lancamento();
        try {
           lcto = lancamentoService.salvar(lancamento);
        }
        catch (NullPointerException error){
            lcto = lancamento;
            System.out.println("Erro: " + error);
        }
        finally {
            return lcto;
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Lancamento> listaLancamento(){ return lancamentoService.listaLancamento();}

    @GetMapping("/pagamentos/{payd}")
    @ResponseStatus(HttpStatus.OK)
    public List<Lancamento> listaPagamentos(@PathVariable("payd") Boolean payd){
        return lancamentoService.listaPagamentos(payd);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Lancamento buscarLancamentoPorId(@PathVariable("id") Long id){
        return lancamentoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lancamento nao encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerLancamento(@PathVariable("id") Long id){
        lancamentoService.buscarPorId(id)
                .map(lancamento ->{
                    lancamentoService.removerPorId(lancamento.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lancamento nao encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarLancamento(@PathVariable("id") Long Id, @RequestBody Lancamento lancamento){
        lancamentoService.buscarPorId(Id)
                .map(lancamentoBase -> {
                    modelMapper.map(lancamento, lancamentoBase);
                    lancamentoService.salvar(lancamentoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lancamento nao encontrado"));
    }

}
