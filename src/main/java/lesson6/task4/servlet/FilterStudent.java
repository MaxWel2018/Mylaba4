package lesson6.task4.servlet;

import lesson6.task4.repository.DepartmentRepositoryImpl;
import lesson6.task4.repository.GroupRepositoryImpl;
import lesson6.task4.repository.StudentRepository;
import lesson6.task4.repository.StudentRepositoryImpl;
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
    private StudentRepository studentRepository = new StudentRepositoryImpl();
    private GroupRepositoryImpl groupRepository = new GroupRepositoryImpl();
    private DepartmentRepositoryImpl departmentRepository = new DepartmentRepositoryImpl();
    private StudentServiceImpl studentService = new StudentServiceImpl(studentRepository, groupRepository, departmentRepository);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List students = studentService.filterByGroup("Group_G2");
        req.setAttribute("filterGroup", students);
        req.getRequestDispatcher("filter.jsp").forward(req, resp);
    }

}
