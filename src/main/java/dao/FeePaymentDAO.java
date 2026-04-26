package dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import model.FeePayment;

public class FeePaymentDAO {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college", "root", "password");
    }

    // ADD
    public void addPayment(FeePayment fp) {
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO FeePayments(StudentID, StudentName, PaymentDate, Amount, Status) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, fp.getStudentId());
            ps.setString(2, fp.getStudentName());
            ps.setDate(3, fp.getPaymentDate());
            ps.setDouble(4, fp.getAmount());
            ps.setString(5, fp.getStatus());

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public int updatePayment(FeePayment fp) {
        int rows = 0;
        try {
            Connection con = getConnection();
            String sql = "UPDATE FeePayments SET StudentID=?, StudentName=?, PaymentDate=?, Amount=?, Status=? WHERE PaymentID=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, fp.getStudentId());
            ps.setString(2, fp.getStudentName());
            ps.setDate(3, fp.getPaymentDate());
            ps.setDouble(4, fp.getAmount());
            ps.setString(5, fp.getStatus());
            ps.setInt(6, fp.getPaymentId());

            rows = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    // DELETE
    public void deletePayment(int id) {
        try {
            Connection con = getConnection();
            String sql = "DELETE FROM FeePayments WHERE PaymentID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DISPLAY
    public List<FeePayment> getAllPayments() {
        List<FeePayment> list = new ArrayList<>();

        try {
            Connection con = getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM FeePayments");

            while (rs.next()) {
                FeePayment fp = new FeePayment();
                fp.setPaymentId(rs.getInt("PaymentID"));
                fp.setStudentId(rs.getInt("StudentID"));
                fp.setStudentName(rs.getString("StudentName"));
                fp.setPaymentDate(rs.getDate("PaymentDate"));
                fp.setAmount(rs.getDouble("Amount"));
                fp.setStatus(rs.getString("Status"));
                list.add(fp);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // OVERDUE REPORT
    public List<FeePayment> getOverduePayments() {
        List<FeePayment> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM FeePayments WHERE Status='Overdue'");

            while (rs.next()) {
                FeePayment fp = new FeePayment();
                fp.setPaymentId(rs.getInt("PaymentID"));
                fp.setStudentName(rs.getString("StudentName"));
                fp.setAmount(rs.getDouble("Amount"));
                list.add(fp);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // TOTAL COLLECTION
    public double getTotalCollection(Date from, Date to) {
        double total = 0;
        try {
            Connection con = getConnection();
            String sql = "SELECT SUM(Amount) FROM FeePayments WHERE PaymentDate BETWEEN ? AND ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, from);
            ps.setDate(2, to);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}