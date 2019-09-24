package lesson6.task5.domain;

import java.util.List;

public class Word {
    private final List<Symbol> symbols;

    public Word(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }
}
