package lesson6.task4.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo")
public class DemoLocale extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       String[] planguage = req.getParameter("language").split("_");
//        String language = planguage[0];
//        String country = planguage[1];
//        Locale locale = new Locale(language, country);
//        req.setAttribute("country", locale.getDisplayCountry());
        req.getRequestDispatcher("views/locale1.jsp").forward(req, resp);
    }
}
