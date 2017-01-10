package com.sok.pomaranczowy.resources;

import com.codahale.metrics.annotation.Timed;
import com.sok.pomaranczowy.db.entities.Employee;
import com.sok.pomaranczowy.db.entities.EmployeeDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by l.rokita on 2017-01-05.
 */
@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    private EmployeeDao employeeDao;

    public EmployeeResource(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GET
    @Timed
    public Employee getEmployee(){
        return employeeDao.findNameById(17474);
    }

}
