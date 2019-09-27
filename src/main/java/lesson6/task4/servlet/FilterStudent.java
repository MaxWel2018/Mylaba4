package lesson6.task4.servlet;

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
    private static StudentRepositoryImpl studentRepository = StudentRepositoryImpl.STUDENT_REPOSITORY;
    private static StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List students = studentService.filterByGroup("Group_G2");
        req.setAttribute("filterGroup", students);
        req.getRequestDispatcher("/views/filter.jsp").forward(req, resp);
    }

}
