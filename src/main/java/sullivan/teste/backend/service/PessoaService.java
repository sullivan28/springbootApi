package sullivan.teste.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sullivan.teste.backend.entities.Pessoa;
import sullivan.teste.backend.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public Pessoa create(Pessoa obj) {
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Pessoa getId(Long id) {
        Optional<Pessoa> obj = repository.findById(id);
        return obj.get();
    }

    public List<Pessoa> getAll() {
        return repository.findAll();
    }

    public Pessoa update(Pessoa obj) {
        Optional<Pessoa> newObj = repository.findById(obj.getId());
        updatePessoa(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updatePessoa(Optional<Pessoa> newObj, Pessoa obj) {
        newObj.get().setNome(obj.getNome());
    }
}
