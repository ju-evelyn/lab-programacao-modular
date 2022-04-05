import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroFisicoTeste {
    Autor mariana = new Autor("Mariana");
    LivroFisico book = new LivroFisico("titulo", mariana, 1000, 100, 10);
    @Test
    public void testePrecoLivroDigital(){
        assertEquals(194.4, book.precoVenda());
    }
}
