package sullivan.teste.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sullivan.teste.backend.entities.Pessoa;
import sullivan.teste.backend.repository.PessoaRepository;
import sullivan.teste.backend.service.PessoaService;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaServiceTests {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Pessoa pessoa = new Pessoa();
        Mockito.when(pessoaRepository.save(Mockito.any(Pessoa.class))).thenReturn(pessoa);

        Pessoa pessoaCriada = pessoaService.create(new Pessoa());

        assertEquals(pessoa, pessoaCriada);
    }

    @Test
    public void testDelete() {
        pessoaService.delete(1L);

        Mockito.verify(pessoaRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void testGetId() {
        Pessoa pessoa = new Pessoa();
        Mockito.when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));

        Pessoa pessoaEncontrada = pessoaService.getId(1L);

        assertEquals(pessoa, pessoaEncontrada);
    }

}
