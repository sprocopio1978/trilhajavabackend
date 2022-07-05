package trilha.back.financys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import trilha.back.financys.entity.Categoria;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listaCategoria(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id){
        return categoriaRepository.findById(id);}

    public void removerPorId(Long id){
        categoriaRepository.deleteById(id);
    }
}
