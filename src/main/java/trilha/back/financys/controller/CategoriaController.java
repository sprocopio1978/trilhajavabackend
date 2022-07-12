package trilha.back.financys.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import trilha.back.financys.entity.Categoria;
import trilha.back.financys.service.CategoriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody Categoria categoria) {
        return ResponseEntity.ok().body(categoriaService.salvar(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listaCategoria() {
        return ResponseEntity.ok().body(categoriaService.listaCategoria());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarCategoriaPorId(@PathVariable("id") Long id) {
        Object obj = categoriaService.buscarPorId(id);
        return ResponseEntity.ok().body(obj);

    }

    @GetMapping("/busca/{nome}")
    public ResponseEntity<Long> buscarCategoriaPorNome(@PathVariable("nome") String nome) {
        Long obj = categoriaService.buscarPorNome(nome);
        return ResponseEntity.ok().body(obj);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerCategoria(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(categoriaService.removerPorId(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCatgoria(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
        return ResponseEntity.ok().body(categoriaService.atualizarPorId(id, categoria));
    }
}
