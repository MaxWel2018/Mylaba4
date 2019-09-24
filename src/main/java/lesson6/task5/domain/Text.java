package lesson6.task5.domain;

import java.util.List;

public class Text {
    private final Sentence header;
    private final List<Sentence> sentences;

    public Text(Sentence header, List<Sentence> sentences) {
        this.header = header;
        this.sentences = sentences;
    }

    public Sentence getHeader() {
        return header;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        return  header +"\n"+ sentences;

    }
}
