package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReportCriteriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String from = req.getParameter("fromDate");
        String to = req.getParameter("toDate");

        req.setAttribute("fromDate", from);
        req.setAttribute("toDate", to);

        RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
        rd.forward(req, res);
    }
}