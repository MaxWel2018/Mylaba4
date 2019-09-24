package lesson6.task5.domain;

import java.util.List;

public class Sentence {
    private final List<Word> words;

    public Sentence(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }
}
