package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.FeePaymentDAO;
import model.FeePayment;
import java.util.*;

public class DisplayFeePaymentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<FeePayment> list = new FeePaymentDAO().getAllPayments();
        req.setAttribute("list", list);

        RequestDispatcher rd = req.getRequestDispatcher("feepaymentdisplay.jsp");
        rd.forward(req, res);
    }
}