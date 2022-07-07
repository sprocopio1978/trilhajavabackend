package trilha.back.financys.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import trilha.back.financys.entity.Lancamento;
import trilha.back.financys.service.LancamentoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
     public ResponseEntity<Object> salvar(@RequestBody Lancamento lancamento){
       Object lcto = lancamentoService.salvar(lancamento);
        HttpHeaders headers = new HttpHeaders();
        headers.add("URL", "/lancamentos");

       if (lcto!=null) {

           headers.add("Responded", "Lancamento criado em LancamentoController");
           return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(lcto);
       }
       else {
           headers.add("Responded", "Id da Categoria nao encontrada em CategoriaController");
           return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("CategoriaId nao Cadastrada!");
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
    public Object buscarLancamentoPorId(@PathVariable("id") Long id){
        Optional<Lancamento> lcto = lancamentoService.buscarPorId(id);
        if (lcto.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(lcto);
        }
        else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CategoriaId nao Cadastrada!");
        }
    }

    @DeleteMapping("/{id}")
      public void removerLancamento(@PathVariable("id") Long id){
        lancamentoService.buscarPorId(id)
                .map(lancamento ->{
                    lancamentoService.removerPorId(lancamento.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lancamento nao encontrado"));
    }

    @PutMapping("/{id}")
       public void atualizarLancamento(@PathVariable("id") Long Id, @RequestBody Lancamento lancamento){
        lancamentoService.buscarPorId(Id)
                .map(lancamentoBase -> {
                    modelMapper.map(lancamento, lancamentoBase);
                    lancamentoService.salvar(lancamentoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lancamento nao encontrado"));
    }

}
