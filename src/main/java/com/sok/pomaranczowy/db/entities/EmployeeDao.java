package com.sok.pomaranczowy.db.entities;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by l.rokita on 2017-01-05.
 */
@RegisterMapper(EmployeeMapper.class)
public interface EmployeeDao {
    @SqlQuery("select * from employees where emp_no = :id")
    Employee  findNameById(@Bind("id") int id);

    @SqlQuery("select * from employees")
    Employee findAll();
}
