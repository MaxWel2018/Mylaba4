package lesson6.task4.servlet;

import lesson6.task4.domain.Student;
import lesson6.task4.repository.Repository;
import lesson6.task4.repository.StudentRepositoryImpl;
import lesson6.task4.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/filter")
public class FilterStudent extends HttpServlet {
    private StudentRepositoryImpl studentRepository = StudentRepositoryImpl.getInstance();
    private StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List students = studentService.filterByGroup("Group_G2");
//        Map<String, List> nameToResult = studentService.filterByAllDepartmentAndAllCourse();
        req.setAttribute("filterGroup", students);
        req.getRequestDispatcher("/views/filter.jsp").forward(req, resp);
    }

}
