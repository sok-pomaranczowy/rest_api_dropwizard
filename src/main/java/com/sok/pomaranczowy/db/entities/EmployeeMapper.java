package com.sok.pomaranczowy.db.entities;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by l.rokita on 2017-01-10.
 */
public class EmployeeMapper implements ResultSetMapper<Employee>
{
    public Employee map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new Employee(r.getLong("emp_no"),r.getDate("birth_date"), r.getString("first_name"),
                r.getString("last_name"),r.getString("gender"),r.getDate("hire_date"));
    }
}