import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class LivroDigitalTeste {
    Autor mariana = new Autor("Mariana");
    LivroDigital ebook = new LivroDigital("titulo", mariana, 100, 100.0);
    @Test
    public void testePrecoLivroDigital(){
        assertEquals(108.0, ebook.precoVenda());
    }
}