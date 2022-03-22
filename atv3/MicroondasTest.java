import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MicroondasTest {
    Microondas microondas;

    @BeforeEach
    @DisplayName("Inicializando os testes")
    void inicializarTeste(){
        microondas = new Microondas();
        microondas.programarTempo(0, 20);
    }
    @Test
    @DisplayName("Testando os métodos programarTempo e verTempo")
    public void testeProgramarTempo(){
        assertEquals("0:20", microondas.verTempo());
    }
    @Test
    @DisplayName("Testando o metodo abrirMicroondas")
    public void testeabrirMicroondas(){
        microondas.abrirMicroondas();
        assertTrue(microondas.isAberto());
    }
    @Test
    @DisplayName("Testando o metodo fecharMicroondas")
    public void testeFecharMicroondas(){
        //como o microondas inicializa fechado, abriremos para testar se pode ser fechado depois
        microondas.abrirMicroondas();
        microondas.fecharMicroondas();
        assertFalse(microondas.isAberto());
    }
    @Test
    @DisplayName("Testando o metodo ligarMicroondas")
    public void testeLigarMicroondas(){
        microondas.ligarMicroondas();
        assertTrue(microondas.isLigado());
    }
    @Test
    @DisplayName("Testando o metodo desligarMicroondas")
    public void testeDesligarMicroondas(){
        //para testar se o microondas desliga corretamente, é necessário ligá-lo antes
        microondas.ligarMicroondas();
        microondas.desligarMicroondas();
        assertFalse(microondas.isLigado());
    }
    @Test
    @DisplayName("Testando o metodo ligarMicroondas caso ele esteja aberto")
    public void testeLigarMicroondas2(){
        microondas.abrirMicroondas();
        microondas.ligarMicroondas();
        assertFalse(microondas.isLigado());
    }
    @Test
    @DisplayName("Testando o metodo abrirMicroondas caso ele esteja ligado")
    public void testeabrirMicroondas2(){
        microondas.ligarMicroondas();
        microondas.abrirMicroondas();
        assertFalse(microondas.isAberto());
    }
    @Test
    @DisplayName("Testando o método pausarMicroondas")
    public void testePausarMicroondas(){
        /*para testar se o microondas pausa corretamente, é preciso ligá-lo*/
        microondas.ligarMicroondas();
        microondas.pausarMicroondas();
        assertFalse(microondas.isLigado());
    }
    @Test
    @DisplayName("Testando o método reiniciarTempo")
    public void testeReiniciarTempo(){
        /** para testar se o tempo está sendo reiniciado é preciso iniciar a contagem, pausar e reiniciar*/
        microondas.ligarMicroondas();
        microondas.pausarMicroondas();
        microondas.reiniciarTempo();
        assertEquals("0:20", microondas.verTempo());
    }
}