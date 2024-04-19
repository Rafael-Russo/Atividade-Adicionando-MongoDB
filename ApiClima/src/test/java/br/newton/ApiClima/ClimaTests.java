package br.newton.ApiClima;

import br.newton.ApiClima.controller.ClimaController;
import br.newton.ApiClima.model.ClimaEntity;
import br.newton.ApiClima.service.ClimaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {br.newton.ApiClima.application.ApiClimaApplication.class})
public class ClimaTests {
    @Mock
    private ClimaService climaService;
    @InjectMocks
    private ClimaController climaController;

    @Test
    void testObterTodos(){
        List<ClimaEntity> climaList = Arrays.asList(
                new ClimaEntity("1", "BR", "2024-03-31", "Teste texto descrevendo clima"),
                new ClimaEntity("2", "USA", "2024-04-31", "Teste texto descrevendo clima")
        );

        when(climaService.obterTodos()).thenReturn(climaList);

        List<ClimaEntity> result = climaController.obterTodosClimas();

        assertEquals(climaList, result);
    }
    @Test
    void testInserir(){
        ClimaEntity newClima = new ClimaEntity("1", "BR", "2024-03-31", "Teste texto descrevendo clima");

        when(climaService.inserir(newClima)).thenReturn(newClima);

        ClimaEntity result = climaController.salvaClima(newClima);

        assertEquals(newClima, result);
    }
    @Test
    void testUpdate(){
        ClimaEntity updatedClima = new ClimaEntity("1", "BR", "2024-03-31", "Teste texto descrevendo clima");

        when(climaService.atualizar("1", updatedClima)).thenReturn(updatedClima);

        ClimaEntity result = climaController.atualizaClima("1", updatedClima);

        assertEquals(updatedClima, result);
    }
    @Test
    void testExcluir(){
        doNothing().when(climaService).excluir("1");

        climaController.deletaClima("1");

        verify(climaService, times(1)).excluir("1");
    }
}
