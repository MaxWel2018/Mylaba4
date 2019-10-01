package lesson6.task4.service;

import lesson6.task4.exception.dontCorrectArgumentRuntimeException;

import java.util.Map;

public class ValidateService{
        public static boolean userValidate(Map<String, String[]> map) {
            return false;
            //TODO сделать валидацию более корректной
            // TODO перепилить на контроллер
            // TODO Сделать грёбаные тесты на валидатор и на сервисы

        }

    public static void notNull(Object o) {
        if (o == null) {
            throw new dontCorrectArgumentRuntimeException("dont correct argument");

        }
    }

}
