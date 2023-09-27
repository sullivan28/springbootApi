package sullivan.teste.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sullivan.teste.backend.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
