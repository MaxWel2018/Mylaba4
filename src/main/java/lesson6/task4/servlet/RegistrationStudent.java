package lesson6.task4.servlet;

import lesson6.task4.domain.Address;
import lesson6.task4.domain.Department;
import lesson6.task4.domain.Student;
import lesson6.task4.domain.University;
import lesson6.task4.repository.DepartmentRepositoryImpl;
import lesson6.task4.repository.GroupRepositoryImpl;
import lesson6.task4.repository.StudentRepositoryImpl;
import lesson6.task4.service.StudentService;
import lesson6.task4.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

@WebServlet("/register")
public class RegistrationStudent extends HttpServlet {
    private DepartmentRepositoryImpl departmentRepository = DepartmentRepositoryImpl.getInstance();
    private GroupRepositoryImpl groupRepository = GroupRepositoryImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setAttribute("departments",departmentRepository.getIdToDepartment());
      req.setAttribute("groups",groupRepository.getIdToGroup());
        req.getRequestDispatcher("/views/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = Student.builder().withName(req.getParameter("name"))
                .withSurname(req.getParameter("secondName"))
                .withAddress(new Address(req.getParameter("nameStreet"),
                        parseInt(req.getParameter("numberApartment"))))
                .withPhoneNumber(req.getParameter("phone"))
                .withBirthday(LocalDate.parse(req.getParameter("birthday")))
                .withDepartment(new Department(Long.parseLong(req.getParameter("department")),
                        departmentRepository.findById(Long.parseLong(req.getParameter("department"))).getName()))
                .build();
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/menu"));
    }
}
