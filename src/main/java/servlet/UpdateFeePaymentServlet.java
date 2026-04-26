package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.FeePayment;
import dao.FeePaymentDAO;
import java.sql.Date;

public class UpdateFeePaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        FeePayment fp = new FeePayment();

        fp.setPaymentId(Integer.parseInt(req.getParameter("paymentId")));
        fp.setStudentId(Integer.parseInt(req.getParameter("studentId")));
        fp.setStudentName(req.getParameter("studentName"));
        fp.setPaymentDate(Date.valueOf(req.getParameter("paymentDate")));
        fp.setAmount(Double.parseDouble(req.getParameter("amount")));
        fp.setStatus(req.getParameter("status"));

        int rows = new FeePaymentDAO().updatePayment(fp);

        PrintWriter out = res.getWriter();
        out.println("Rows updated = " + rows);
    }
}