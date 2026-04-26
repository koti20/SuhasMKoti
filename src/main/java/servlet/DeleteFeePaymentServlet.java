package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.FeePaymentDAO;

public class DeleteFeePaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("paymentId"));
        new FeePaymentDAO().deletePayment(id);

        res.sendRedirect("feepaymentdisplay.jsp");
    }
}