import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LivroFisicoTeste {
    Autor mariana = new Autor("Mariana");
    LivroFisico book = new LivroFisico("titulo", mariana, 100, 100.0, 10);
    @Test
    public void testePrecoLivroDigital(){
        assertEquals(126.36, book.precoVenda());
    }
}