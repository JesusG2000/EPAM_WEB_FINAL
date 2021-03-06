package servlet.view;

import bean.User;
import dao.Dao;
import dao.impl.JdbcUserDao;
import service.ServiceFactory;
import service.UserService;
import servlet.PageAccess;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends MainServlet implements PageAccess {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(isLogin(req)==null) {
            resp.sendRedirect("/userRegistration");
        }else{
            resp.sendRedirect("/profile");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dao<User> dao = new JdbcUserDao();
        UserService userService = ServiceFactory.getCalcService();


        String nameGET = req.getParameter("name");
        String passwordGET = req.getParameter("password");
        User user = new User(nameGET,passwordGET);

        if (!userService.isRegistered(user)) {
            dao.create(user);
            resp.sendRedirect("/userLogin");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/userRegistration");
            req.setAttribute("message", "This user has already registered");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    public User isLogin(HttpServletRequest request) {
        return checkLogin(request);
    }
}




