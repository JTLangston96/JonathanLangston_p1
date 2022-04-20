package dev.langst.data;

import dev.langst.entities.Expense;
import dev.langst.utilities.ConnectionUtil;

import java.sql.*;
import java.util.List;

public class ExpenseDAOPostgres implements ExpenseDAO {


    @Override
    public Expense createExpense(Expense expense) {

        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into expense values (default, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, expense.getEmployeeId());
            ps.setString(2, expense.getStatus());
            ps.setDouble(3, expense.getAmount());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int generatedId = rs.getInt("expense_id");
            expense.setExpenseId(generatedId);

            return expense;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Expense getExpenseById(int id) {
        return null;
    }

    @Override
    public List<Expense> getExpenseByEmployeeId(int id) {
        return null;
    }

    @Override
    public Expense updateExpense(Expense expense) {
        return null;
    }

    @Override
    public boolean deleteExpense(int id) {
        return false;
    }
}
