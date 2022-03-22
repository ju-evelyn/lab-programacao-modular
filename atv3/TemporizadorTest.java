import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemporizadorTest {
    Temporizador tempo;

    @BeforeEach
    @DisplayName("Inicializando os testes do temporizador")
    void init(){
        tempo = new Temporizador();
        //primeiro iniciamos a contagem para que o outros métodos possam ser testados
        tempo.inicioContagem(1, 30);
    }
    @Test
    @DisplayName("Teste para saber se o temporizador está programando o tempo corretamente")
    void testeInicioContagem(){
        assertEquals("1:30", tempo.verContagem());
    }
    @Test
    @DisplayName("Teste para saber se o temporizador está pausando a contagem corretamente")
    void testePararContagem(){
        tempo.pararContagem();
        assertFalse(tempo.isContando());
    }
    @Test
    @DisplayName("Teste para saber se o temporizador está reiniciando a contagem corretamente")
    void testeReiniciarContagem(){
        //devemos iniciar a contagem para que ela possa ser reiniciada
        tempo.passarTempo();
        tempo.reiniciarContagem();
        assertEquals("1:30", tempo.verContagem());
    }
    @Test
    @DisplayName("Teste para saber se o temporizador está zerando a contagem corretamente")
    void testeZerarContagem(){
        tempo.zerarContagem();
        assertEquals("0:0",tempo.verContagem());
    }
    @Test
    @DisplayName("Teste para saber se o temporizador está passando o tempo corretamente")
    void testePassarTempo(){
        tempo.passarTempo();
        assertEquals("1:29",tempo.verContagem());
    }
}
