package com.sjb.chapter1.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by simjunbo on 2018-05-28.
 */
public class JdbcSample {
    public Employee getEmployeeById(long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //conn = dataSource.getConnection();
            stmt = conn.prepareStatement(
                    "select id, firstname, lastname, salary from " +
                            "employee where id=?"
            );
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            Employee employee = null;
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setSalary(rs.getBigDecimal("salary"));
            }
            return employee;
        } catch (SQLException e) {

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {

                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }
            return null;
        }
    }

    // spring template 방식
    private JdbcTemplate jdbcTemplate;

    public Employee getEmployeeById_jdbcTemplate(long id) {
        return jdbcTemplate.queryForObject(
                "select id, firstname, lastname, salary " +  // SQL 쿼리
                        "from employee where id=?",
                new RowMapper<Employee>() {
                    @Override
                    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Employee employee = new Employee();
                        employee.setId(rs.getLong("id"));
                        employee.setFirstName(rs.getString("firstname"));
                        employee.setLastName(rs.getString("lastname"));
                        employee.setSalary(rs.getBigDecimal("salary"));
                        return employee;
                    }
                }, id);
    }
}
