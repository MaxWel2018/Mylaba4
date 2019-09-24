package lesson6.task4.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private static University mInstance;
   private   List<Department> departments = new ArrayList<>();
   Map<Department, List<Group>> groupByDepartment = new HashMap<>();

    {
        departments.add(new Department(1L, "Gryffindor"));
        departments.add(new Department(2L, "Slytherin"));
        List<Group> groupFacultyGryffindor = new ArrayList();
        groupFacultyGryffindor.add(new Group("Group_G1"));
        groupFacultyGryffindor.add(new Group("Group_G2"));

        List<Group> groupFacultySlytherin= new ArrayList();
        groupFacultySlytherin.add(new Group("Group_S1"));
        groupFacultySlytherin.add(new Group("Group_S2"));
        groupByDepartment.put(departments.get(0), groupFacultyGryffindor);
        groupByDepartment.put(departments.get(1), groupFacultySlytherin);
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
