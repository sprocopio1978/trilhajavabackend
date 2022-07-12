package trilha.back.financys.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import trilha.back.financys.entity.Categoria;
import trilha.back.financys.entity.Lancamento;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listaCategoria() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Long buscarPorNome(String nome) {
        Long id = Long.valueOf(0);
        List<Categoria> listcategoria = categoriaRepository.findAll();
        for (Categoria cat : listcategoria) {
            if (cat.getNome().equals(nome)) {
                id = cat.getId();
            }
        }
        return id;
    }


    public String removerPorId(Long id) {
        String ret = "";
        Optional<Categoria> cat = buscarPorId(id);
        if (cat.isPresent()) {
            categoriaRepository.deleteById(id);
            ret = "Categoria deletada com sucesso!";
        } else
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

