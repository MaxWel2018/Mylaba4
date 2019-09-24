package lesson6.task5.service;

import lesson6.task5.domain.Text;

import java.util.Objects;

import static java.util.Objects.isNull;

public class TextServiceImpl implements TextService {
    @Override
    public Text convertStringToText(String text) {
      throw new UnsupportedOperationException("");
    }

    @Override
    public String convertTextToString(Text text) {
        return isNull(text) ? null : text.toString();
    }
}
