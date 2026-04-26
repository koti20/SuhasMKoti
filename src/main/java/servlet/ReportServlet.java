package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.FeePaymentDAO;
import model.FeePayment;
import java.util.*;
import java.sql.Date;

public class ReportServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String type = req.getParameter("type");

        FeePaymentDAO dao = new FeePaymentDAO();

        if (type.equals("overdue")) {
            List<FeePayment> list = dao.getOverduePayments();
            req.setAttribute("list", list);

            RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
            rd.forward(req, res);
        }
        else if (type.equals("total")) {
            Date from = Date.valueOf(req.getParameter("fromDate"));
            Date to = Date.valueOf(req.getParameter("toDate"));

            double total = dao.getTotalCollection(from, to);
            req.setAttribute("total", total);

            RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
            rd.forward(req, res);
        }
    }
}