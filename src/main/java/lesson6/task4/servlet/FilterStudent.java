package lesson6.task4.servlet;

import lesson6.task4.repository.*;
import lesson6.task4.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/filter")
public class FilterStudent extends HttpServlet {
    private static StudentRepository studentRepository = StudentRepositoryImpl.getInstance();
    private static GroupRepository groupRepository = GroupRepositoryImpl.getInstance();
    private static DepartmentRepository departmentRepository = DepartmentRepositoryImpl.getInstance();
    private static StudentServiceImpl studentService = new StudentServiceImpl(studentRepository, groupRepository, departmentRepository);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List students = studentService.filterByGroup("Group_G2");
        req.setAttribute("filterGroup", students);
        req.getRequestDispatcher("/views/filter.jsp").forward(req, resp);
    }

}
