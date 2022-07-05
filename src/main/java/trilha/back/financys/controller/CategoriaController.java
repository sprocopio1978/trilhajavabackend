package trilha.back.financys.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import trilha.back.financys.entity.Categoria;
import trilha.back.financys.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria salvar(@RequestBody Categoria categoria){
        return categoriaService.salvar(categoria);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listaCategoria(){
        return categoriaService.listaCategoria();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Categoria buscarCategoriaPorId(@PathVariable("id") Long id){
        return categoriaService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria nao encontrada"));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerCategoria(@PathVariable("id") Long id){
        categoriaService.buscarPorId(id)
                .map(categoria ->{
                    categoriaService.removerPorId(categoria.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria nao encontrada"));
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public void atualizarCatgoria(@PathVariable("id") Long Id, @RequestBody Categoria categoria){
        categoriaService.buscarPorId(Id)
                .map(categoriaBase -> {
                    modelMapper.map(categoria, categoriaBase);
                    categoriaService.salvar(categoriaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria nao encontrada"));
    }
}
