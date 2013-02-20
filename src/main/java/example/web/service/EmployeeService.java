package example.web.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import example.configuration.ReadDb;
import example.configuration.ReadWriteDb;
import example.model.dao.EmployeeDao;
import example.model.data.Employee;
import example.web.service.request.EmployeeRequest;
import example.web.service.response.EmployeeListResponse;

@Component
@Path("employee")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class EmployeeService {

    private Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private Validator validator;

    private EmployeeDao employeeDao;

    public EmployeeService() {
    }

    @Inject
    public EmployeeService(EmployeeDao employeeDao, Validator validator) {
        this.employeeDao = employeeDao;
        this.validator = validator;
    }

    @GET
    @Path("/")
    @ReadWriteDb
    public EmployeeListResponse get() {
        logger.debug("enter get");
        List<Employee> list = employeeDao.selectAll();
        return EmployeeListResponse.from(list);
    }

    @GET
    @Path("/read")
    @ReadDb
    public EmployeeListResponse getRead() {
        List<Employee> list = employeeDao.selectAll();
        return EmployeeListResponse.from(list);
    }

    @POST
    @Path("/")
    @ReadWriteDb
    @Consumes(MediaType.APPLICATION_XML)
    public Response post(EmployeeRequest request) {
        return Response.ok().build();
    }
}
