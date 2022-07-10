package trilha.back.financys.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import trilha.back.financys.dto.CategoriaDTO;
import trilha.back.financys.entity.Categoria;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;




    public Categoria salvar(Categoria categoria){
            return categoriaRepository.save(categoria);
    }

    public List<CategoriaDTO> listaCategoria(){
        List<Categoria> listaCategoria = categoriaRepository.findAll();
        return CategoriaDTO.convert(listaCategoria);
    }

    public Optional<Categoria> buscarPorId(Long id){
        return categoriaRepository.findById(id);}

    public String removerPorId(Long id){
        String ret = "";
        Optional<Categoria> cat = buscarPorId(id);
        if (cat.isPresent()) {
            categoriaRepository.deleteById(id);
            ret = "Categoria deletada com sucesso!";
        }
        else
            ret = "Categoria nao encontrada!";

        return ret;
    }

    public String atualizarPorId(Long id, Categoria categoria) {
        Optional<Categoria> cat = buscarPorId(id);
        String ret = "";
        if (cat.isPresent()) {
           salvar(categoria);
            ret = "Categoria Atualizada com sucesso!";
        } else {
            ret = "Categoria nao encontrada!";
        }

        return ret;
    }
}

