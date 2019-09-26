package lesson6.task4.service;

import java.util.List;

public interface FilterService {
    List filterByDepartment(String nameDepartment);

    List filterByAfterGivenYear(int year);

    List filterByGroup(String nameGroup);


}
