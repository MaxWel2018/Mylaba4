package lesson6.task5.service;

import lesson6.task5.domain.Letter;
import lesson6.task5.domain.Sentence;
import lesson6.task5.domain.Symbol;
import lesson6.task5.domain.Text;
import lesson6.task5.domain.Word;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TextServiceImplTest {
    private final TextServiceImpl textService = new TextServiceImpl();

    @Test
    public void shouldReturnNullStringForNullText() {
        String expectedResult = null;
        String actualResult = textService.convertTextToString(null);
//        assertEquals(expectedResult,actualResult);
        assertNull("", actualResult);
    }

    @Test
    // testConvertTextToString_shouldReturnString_
    public void shouldReturnStringForTextWithOutBody() {
        String expectedResult = "Hello";
        List<Symbol> symbols = asList(new Letter('H'),new Letter('e'),new Letter('l'),
                new Letter('l'),new Letter('o'));
        Sentence header = new Sentence(asList(new Word(symbols)));
        Text text = new Text(header, null);
        String actualResult = textService.convertTextToString(text);
        assertEquals(expectedResult, actualResult);
    }
}
