/**
 * EmployeeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fpt.myservice;

public interface EmployeeService extends java.rmi.Remote {
    public boolean addEmployees(com.fpt.myservice.Employee arg0) throws java.rmi.RemoteException;
    public com.fpt.myservice.Employee[] getEmployee() throws java.rmi.RemoteException;
}
