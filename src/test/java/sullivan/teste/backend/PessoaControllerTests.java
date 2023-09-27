package sullivan.teste.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sullivan.teste.backend.controller.PessoaController;
import sullivan.teste.backend.entities.Pessoa;
import sullivan.teste.backend.service.PessoaService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PessoaControllerTests {

    @InjectMocks
    private PessoaController pessoaController;

    @Mock
    private PessoaService pessoaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Pessoa pessoa = new Pessoa();
        Mockito.when(pessoaService.create(Mockito.any(Pessoa.class))).thenReturn(pessoa);

        Pessoa pessoaCriada = pessoaController.create(pessoa).getBody();

        assertEquals(pessoa, pessoaCriada);
    }

    @Test
    public void testDelete() {
        ResponseEntity<Void> responseEntity = pessoaController.delete(1L);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    public void testGetId() {
        Pessoa pessoa = new Pessoa();
        Mockito.when(pessoaService.getId(1L)).thenReturn(pessoa);

        ResponseEntity<Pessoa> responseEntity = pessoaController.getId(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(pessoa, responseEntity.getBody());
    }

    @Test
    public void testGetAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        Mockito.when(pessoaService.getAll()).thenReturn(pessoas);

        ResponseEntity<List<Pessoa>> responseEntity = pessoaController.getAll();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(pessoas, responseEntity.getBody());
    }

    @Test
    public void testUpdate() {
        Pessoa pessoa = new Pessoa();
        Mockito.when(pessoaService.update(Mockito.any(Pessoa.class))).thenReturn(pessoa);

        ResponseEntity<Pessoa> responseEntity = pessoaController.update(1L, pessoa);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(pessoa, responseEntity.getBody());
    }

}
