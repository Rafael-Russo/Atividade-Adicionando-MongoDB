package br.newton.ApiRestFipe;

import br.newton.ApiRestFipe.controller.FipeController;
import br.newton.ApiRestFipe.model.MarcaEntity;
import br.newton.ApiRestFipe.service.FipeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes={br.newton.ApiRestFipe.application.ApiRestFipeApplication.class})
public class MarcaTests {
    @Mock
    private FipeService fipeService;
    @InjectMocks
    private FipeController fipeController;

    @Test
    void testObterPorId(){
        MarcaEntity marca = new MarcaEntity("1", "1", "Teste1");

        when(fipeService.marcaPorId("1")).thenReturn(marca);

        MarcaEntity result = fipeController.marcaPorId("1");

        assertEquals(marca, result);
    }
    @Test
    void testInserir(){
        MarcaEntity newMarca = new MarcaEntity("1", "1", "Teste1");

        when(fipeService.inserirMarca(newMarca)).thenReturn(newMarca);

        MarcaEntity result = fipeController.inserirMarca(newMarca);

        assertEquals(newMarca, result);
    }
    @Test
    void testAtualizar(){
        MarcaEntity updatedMarca = new MarcaEntity("1", "1", "Teste1");

        when(fipeService.atualizaMarca("1", updatedMarca)).thenReturn(updatedMarca);

        MarcaEntity result = fipeController.atualizaMarca("1", updatedMarca);

        assertEquals(updatedMarca, result);
    }
    @Test
    void testExcluir(){
        doNothing().when(fipeService).deletaMarca("1");

        fipeController.deletaMarca("1");

        verify(fipeService, timeout(1)).deletaMarca("1");
    }
}
