package example;

import example.service.EmployeeService;

import javax.xml.ws.Endpoint;

public class MainApplication {
    public static void main(String[] argv) {
        String employeeService = "http://localhost:9000/employee-service";
        Endpoint.publish(employeeService, new EmployeeService());

    }
}
