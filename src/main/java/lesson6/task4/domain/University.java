package lesson6.task4.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private static University mInstance;
   private   List<Department> departments = new ArrayList<>();
   Map<Department, List<Group>> groupByDepartment = new HashMap<>();


    public List<Department> getDepartments() {
        return departments;
    }

    public Map<Department, List<Group>> getGroupByDepartment() {
        return groupByDepartment;
    }

    private University() {
    }

    public static University getInstance() {
        if (mInstance == null) {
            mInstance = new University();
        }
        return mInstance;
    }
}
