package net.bigmir;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GeneralServlet", urlPatterns = "/home")
public class GeneralServlet extends HttpServlet {
    private ConnectionFactory cf = new ConnectionFactory();
    private Connection conn = cf.getConnection();
    private DAO dao = new DAOFlatImpl(conn, "Flats");
    private GetFlatOnParam getBy = new GetFlatOnParam(conn,"Flats");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getAllFlats = request.getParameter("getAll");
        String getOne = request.getParameter("region");
        String getTwo = request.getParameter("address");
        String getThree = request.getParameter("square");
        String getFour = request.getParameter("rooms");
        String getFive = request.getParameter("price");
        List<Flat> list = new ArrayList<>();
        if (getAllFlats != null) {
           list = dao.getFlats();
        }
        if(getOne!=null){
            list=getBy.getByParam("region", getOne);
        }
        if(getTwo!=null){
            list=getBy.getByParam("address", getTwo);
        }
        if(getThree!=null){
            list=getBy.getByParam("square", getThree);
        }
        if(getFour!=null){
            list=getBy.getByParam("rooms", getFour);
        }
        if(getFive!=null){
            list=getBy.getByParam("price", getFive);
        }
        request.setAttribute("fullList", list);
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/get.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dao.init();
        String addFlat = request.getParameter("add");
        String removeFlat = request.getParameter("remove");

        if (addFlat != null) {
            try {
                add(request, response, dao);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (removeFlat != null) {
            try {
                remove(request, response, dao);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void add(HttpServletRequest request, HttpServletResponse response, DAO dao) throws Exception {
        String region = request.getParameter("region");
        String address = request.getParameter("address");
        String square = request.getParameter("square");
        String rooms = request.getParameter("rooms");
        String price = request.getParameter("price");
        if (region.isEmpty() || address.isEmpty() || square.isEmpty() || rooms.isEmpty() || price.isEmpty()) {
            response.getWriter().write("Error: You've missed fields");
        } else {
            Flat flat = new Flat(region, address, Double.valueOf(square), Integer.valueOf(rooms), Double.valueOf(price));
            System.out.println(flat);
            dao.addFlat(flat);
            response.sendRedirect("/index.jsp");
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response, DAO dao) throws Exception {
        String id = request.getParameter("id");
        if (id.isEmpty()) {
            response.getWriter().write("Error: You've missed fields");
        } else {
            dao.removeFlat(Integer.valueOf(id));
            response.sendRedirect("/index.jsp");
        }
    }

}
