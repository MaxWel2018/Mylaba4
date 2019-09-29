package lesson6.task4.servlet;

import lesson6.task4.repository.DepartmentRepositoryImpl;
import lesson6.task4.repository.GroupRepositoryImpl;
import lesson6.task4.repository.StudentRepository;
import lesson6.task4.repository.StudentRepositoryImpl;
import lesson6.task4.service.StudentServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/filter")
public class FilterStudent extends HttpServlet {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationСontext.xml"
    );
    private StudentServiceImpl studentService = context.getBean("studentServiceImpl",StudentServiceImpl.class);
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List students = studentService.filterByGroup("Group_G2");
        req.setAttribute("filterGroup", students);
        req.getRequestDispatcher("/views/filter.jsp").forward(req, resp);
    }

}
