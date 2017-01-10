package com.sok.pomaranczowy;

import com.sok.pomaranczowy.resources.EmployeeResource;
import com.sok.pomaranczowy.db.entities.EmployeeDao;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;

public class RestDemoApplication extends Application<RestDemoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RestDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "RestDemo";
    }

    @Override
    public void initialize(final Bootstrap<RestDemoConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final RestDemoConfiguration configuration,
                    final Environment environment) {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabase(), "mysql");
        EmployeeDao employeeDao = jdbi.onDemand(EmployeeDao.class);
        environment.jersey().register(new EmployeeResource(employeeDao));
    }

}
