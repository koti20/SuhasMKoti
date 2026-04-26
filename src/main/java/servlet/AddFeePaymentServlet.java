package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.FeePayment;
import dao.FeePaymentDAO;
import java.sql.Date;

public class AddFeePaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        FeePayment fp = new FeePayment();

        fp.setStudentId(Integer.parseInt(req.getParameter("studentId")));
        fp.setStudentName(req.getParameter("studentName"));
        fp.setPaymentDate(Date.valueOf(req.getParameter("paymentDate")));
        fp.setAmount(Double.parseDouble(req.getParameter("amount")));
        fp.setStatus(req.getParameter("status"));

        new FeePaymentDAO().addPayment(fp);

        res.sendRedirect("feepaymentdisplay.jsp");
    }
}