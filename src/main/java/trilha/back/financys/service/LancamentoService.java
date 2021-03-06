package trilha.back.financys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.dto.LancamentoDTO;
import trilha.back.financys.entity.Categoria;
import trilha.back.financys.entity.Lancamento;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private Optional<Categoria> categoria;


    public Object salvar(Lancamento lancamento){

        if (validateCategoryById(lancamento.getCategoryid()))
        {
            return lancamentoRepository.save(lancamento);
        }
        return null;
    }

    public List<LancamentoDTO> listaLancamento(){
        List<Lancamento> lancamento = lancamentoRepository.findAll();
        return LancamentoDTO.convert(lancamento);
    }

    public Optional<Lancamento> buscarPorId(Long id){

        return lancamentoRepository.findById(id);
    }

    public void removerPorId(Long id){

        lancamentoRepository.deleteById(id);
    }

    public List<LancamentoDTO> listaPagamentos(Boolean payd){
        List<Lancamento> listlancamento = new ArrayList<>();
        listlancamento = lancamentoRepository.findAll();
        List<Lancamento> listPagamentos = listPagamentos = listlancamento.stream().filter(x-> x.getPayd() == payd).collect(Collectors.toList());
        for (Lancamento x : listlancamento){
            if (x.getPayd() == payd){
                listPagamentos.add(x);
            }
        }

        return LancamentoDTO.convert(listPagamentos);
    }

    public List<LancamentoDTO> listaCategoria(Long categoryId){
        List<Lancamento> listlancamento = new ArrayList<>();
        listlancamento = lancamentoRepository.findAll();
        List<Lancamento> listCategoria = new ArrayList<>();
        for (Lancamento x : listlancamento){
            if (x.getCategoryid() == categoryId){
                listCategoria.add(x);
            }
        }
        return LancamentoDTO.convert(listCategoria);
    }

    public boolean validateCategoryById(Long idCategory) {
        if (categoriaService.buscarPorId(idCategory).isPresent())
            return true;
        else
            return false;

    }
}
