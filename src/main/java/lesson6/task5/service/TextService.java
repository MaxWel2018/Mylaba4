package lesson6.task5.service;

import lesson6.task5.domain.Text;

public interface TextService {
    Text convertStringToText(String text);

    String convertTextToString(Text text);
}
