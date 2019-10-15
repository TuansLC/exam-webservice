package example.service;

import example.entity.Employee;
import example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService()
public class EmployeeService {
    @WebMethod
    public List<Employee> getEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try(Session session = HibernateUtil.getSession()) {
            employeeList =session.createQuery("from Employee",Employee.class).list();
        }catch (Exception ex){
            System.out.println("Can not findAll student");
        }
        return employeeList;
    }


    @WebMethod
    public boolean addEmployees(Employee e) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(e);
            transaction.commit();
            return true;
        }catch (Exception ex){
            if(transaction !=null){
                transaction.rollback();
            }
            return false;
        }
    }
}
