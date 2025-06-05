package com.example.Java.Stream.Practice.controller;


import com.example.Java.Stream.Practice.entity.Employee;
import com.example.Java.Stream.Practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/getName")
    public List<Employee> getEmployeesNamedAlice() {
        return employeeService.getEmployeesNamedAlice();
    }


    @GetMapping("/getHR")
    public List<Employee> getEmployeesHR() {
        return employeeService.getEmployeesHR();
    }

    @GetMapping("/getAverage")
    public Double getAvgSalary(){
        return employeeService.getAvgSalary();
    }


    @GetMapping("/getGroupingByDept")
    public Map<String,List<Employee>> groupEmpByDept(){
        return employeeService.groupEmpByDept();
    }

    @GetMapping("/getGroupingEmpNameByDept")
    public Map<String,List<String>> groupEmpNameByDept(){
        return employeeService.groupEmpNameByDept();
    }

    @GetMapping("/getGroupingEmpNameBySalaryMoreThan70000")
    public List<String>getEmployeeWhoEarnMoreThanSeventyThousand(){
        return employeeService.getEmployeeWhoEarnMoreThanSeventyThousand();
    }



    @GetMapping("/getGroupingSortedEmpNameBySalaryMoreThan70000")
    public List<String>getEmployeeSortedWhoEarnMoreThanSeventyThousand(){
        return employeeService.getEmployeeSortedWhoEarnMoreThanSeventyThousand();
    }


    @GetMapping("/countEmployeePerDepartment")
    public Map<String,Long>countEmployeePerDepartment(){
        return employeeService.countEmployeePerDepartment();
    }


    @GetMapping("/getHighestSalary")
    public Employee getHighestSalary(){
        return employeeService.getHighestSalary();
    }


    @GetMapping("/commaSeparatedEmployee")
    public String commaSeparatedEmployee(){
        return employeeService.commaSeparatedEmployee();
    }



    @GetMapping("/partitionOfEmployee")
    public Map<Boolean,List<Employee>> partitionOfEmployee(){
        return employeeService.partitionOfEmployee();
    }



    @GetMapping("/mapEmployeeIdAndName")
    public Map<Long,String> mapEmployeeIdAndName(){
        return employeeService.mapEmployeeIdAndName();
    }


    @GetMapping("/employeeSalaryInDescOrder")
    public List<Employee> employeeSalaryInDescOrder(){
        return employeeService.employeeSalaryInDescOrder();
    }

    @GetMapping("/totalSalary")
    public Double totalSalary(){
        return employeeService.totalSalary();
    }


    @GetMapping("/deptWiseSalarySum")
    public Map<String, Double> deptWiseSalarySum(){
        return employeeService.deptWiseSalarySum();
    }



    @GetMapping("/listOfEmployeeGroupByDept")
    public Map<String,List<String>> listOfEmployeeGroupByDept(){
        return employeeService.listOfEmployeeGroupByDept();
    }


    @GetMapping("/findDuplicateDepartmentName")
    public List<String> findDuplicateDepartmentName(){
        return employeeService.findDuplicateDepartmentName();
    }


    @GetMapping("/findAllActiveEmployeeName")
    public List<String> findAllActiveEmployeeName(){
        return employeeService.findAllActiveEmployeeName();
    }


    @GetMapping("/findAllUniqueNames")
    public List<String> uniqueNames(){
        return employeeService.uniqueNames();
    }


    @GetMapping("/findEmployeeNotInEngineering")
    public List<Employee> findEmployeeNotInEngineering(){
        return employeeService.findEmployeeNotInEngineering();
    }



    @GetMapping("/checkInActiveEmployeeInFinance")
    public Boolean checkInActiveEmployeeInFinance(){
        return employeeService.checkInActiveEmployeeInFinance();
    }


    @GetMapping("/getFirstEmployeeWhichIsHR")
    public Employee getFirstEmployeeWhichIsHR(){
        return employeeService.getFirstEmployeeWhichIsHR();
    }



    @GetMapping("/calculateAverageSalaryPerDept")
    public Map<String,Double> calculateAverageSalaryPerDept(){
        return employeeService.calculateAverageSalaryPerDept();
    }



    @GetMapping("/getDeptWithMostNoOfEmployee")
    public String getDeptWithMostNoOfEmployee(){
        return employeeService.getDeptWithMostNoOfEmployee();
    }


    @GetMapping("/findListOfNameStartingWithA")
    public List<String> findListOfNameStartingWithA(){
        return employeeService.findListOfNameStartingWithA();
    }



    @GetMapping("/findDuplicateNames")
    public List<String> findDuplicateNames(){
        return employeeService.findDuplicateNames();
    }


    @GetMapping("/findBySalariesAboveAverage")
    public List<Double> findBySalariesAboveAverage(){
        return employeeService.findBySalariesAboveAverage();
    }


    @GetMapping("/getLowestSalaryFromEngineering")
    public Double getLowestSalaryFromEngineering(){
        return employeeService.getLowestSalaryFromEngineering();
    }


    @GetMapping("/countNoOfEmployeeWithInSpecificRange")
    public Long countNoOfEmployeeWithInSpecificRange(){
        return employeeService.countNoOfEmployeeWithInSpecificRange();
    }



    @GetMapping("/getSecondHighestSalary")
    public Double getSecondHighestSalary(){
        return employeeService.getSecondHighestSalary();
    }



    @GetMapping("/findListOfNameAccordingToTheirSalaryAsc")
    public List<String> findListOfNameAccordingToTheirSalaryAsc(){
        return employeeService.findListOfNameAccordingToTheirSalaryAsc();
    }


    @GetMapping("/divideEmployeeBasedOnTheirEarningMoreThan70k")
    public Map<Boolean,List<Employee>> divideEmployeeBasedOnTheirEarningMoreThan70k(){
        return employeeService.divideEmployeeBasedOnTheirEarningMoreThan70k();
    }

    @GetMapping("/employeeWhoseDeptHasAvgSalaryIsMoreThan80k")
    public List<String> employeeWhoseDeptHasAvgSalaryIsMoreThan80k(){
        return employeeService.employeeWhoseDeptHasAvgSalaryIsMoreThan80k();
    }


    @GetMapping("/getListOfEmployeeInitialsName")
    public List<String> getListOfEmployeeInitialsName(){
        return employeeService.getListOfEmployeeInitialsName();
    }


    @GetMapping("/getDepartmentStringInUpperCase")
    public String getDepartmentStringInUpperCase(){
        return employeeService.getDepartmentStringInUpperCase();
    }


    @GetMapping("/getListOfEmployeeWithLongestNamePerDept")
    public List<Employee> getListOfEmployeeWithLongestNamePerDept(){
        return employeeService.getListOfEmployeeWithLongestNamePerDept();
    }


    @GetMapping("/getAllEmployeesBasedOnDept")
    public Map<String,Long> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    @GetMapping("/findHighestSalary")
    public Double findHighestSalary(){
        return employeeService.findHighestSalary();
    }

    @GetMapping("/findHighestSalaryFromEveryDept")
    public Map<String,Double> findHighestSalaryFromEveryDept(){
        return employeeService.findHighestSalaryFromEveryDept();
    }



    @GetMapping("/sumOfSalaryOfAllInActiveEmployee")
    public Double sumOfSalaryOfAllInActiveEmployee(){
        return employeeService.sumOfSalaryOfAllInActiveEmployee();
    }


    @GetMapping("/getListOfEmployeeNameByDept")
    public Map<String,List<String>>getListOfEmployeeNameByDept(){
        return employeeService.getListOfEmployeeNameByDept();
    }


    @GetMapping("/sortEmpBySalaryDesc")
    public List<Employee> sortEmpBySalaryDesc(){
        return employeeService.sortEmpBySalaryDesc();
    }


    @GetMapping("/mapEmpIdWithName")
    public Map<Integer,String> mapEmpIdWithName(){
        return employeeService.mapEmpIdWithName();
    }


    @GetMapping("/checkAnyEmployeeFromITDept")
    public Boolean checkAnyEmployeeFromITDept(){
        return employeeService.checkAnyEmployeeFromITDept();
    }








}
