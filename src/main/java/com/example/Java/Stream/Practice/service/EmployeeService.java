package com.example.Java.Stream.Practice.service;

import com.example.Java.Stream.Practice.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "HR", 55000, true),
            new Employee(2, "Bob", "Finance", 80000, true),
            new Employee(3, "Charlie", "HR", 60000, false),
            new Employee(4, "David", "Engineering", 95000, true),
            new Employee(5, "Eva", "Engineering", 99000, true),
            new Employee(6, "Frank", "Developer", 75000, false),
            new Employee(7, "Alice", "HR", 59000, true)
    );


   //1. find a list whose name is Alice

    public List<Employee> getEmployeesNamedAlice() {
        return employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase("alice"))
                .collect(Collectors.toList());
    }


    // 2. Filter and collect employees from "HR"
    public List<Employee> getEmployeesHR() {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("HR"))
                .collect(Collectors.toList());
    }

    // 3. Average salary of active employees

    public Double getAvgSalary(){
//        return employees.stream().filter(i-> i.isActive()==true).map(Employee::getSalary).reduce(0.0,(acc, itr)->acc+itr)/employees.stream().filter(i-> i.isActive()==true).count();

        return employees.stream().filter(Employee::isActive).map(Employee::getSalary).collect(Collectors.summarizingDouble(i->i)).getAverage();
    }

    // 4. Group employees by department

    public Map<String,List<Employee>>groupEmpByDept(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }


    // 4. Group employees name by department

    public Map<String,List<String>>groupEmpNameByDept(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName,Collectors.toList())));
    }


    // 5. Get names of employees earning > 70,000

    public List<String>getEmployeeWhoEarnMoreThanSeventyThousand(){
        return employees.stream().filter(i->i.getSalary()>70_000).map(Employee::getName).collect(Collectors.toList());
    }


    // 6. Sort names of employees earning > 70,000

    public List<String>getEmployeeSortedWhoEarnMoreThanSeventyThousand(){
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary)).filter(i->i.getSalary()>70_000).map(Employee::getName).collect(Collectors.toList());
    }


    // 7. Count employees per department

    public Map<String,Long>countEmployeePerDepartment(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
    }


    // 8. Find the employee with the highest salary

    public Employee getHighestSalary(){
        return employees.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }


    // 9. Get a comma-separated list of all employee names

    public String commaSeparatedEmployee(){
        return employees.stream().map(Employee::getName).collect(Collectors.joining(","));
    }


     // 10. Partition employees into active and inactive

    public Map<Boolean,List<Employee>> partitionOfEmployee(){
        return employees.stream().collect(Collectors.partitioningBy(Employee::isActive));
    }


    // 11. Map of employee IDs to their names

    public Map<Long,String> mapEmployeeIdAndName(){
        return employees.stream().collect(Collectors.toMap(i->(long) i.getId(), Employee::getName));
    }


    // 12. Sort employees by salary descending

    public List<Employee> employeeSalaryInDescOrder(){
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
    }

    // 13. Total salary of all employees

    public Double totalSalary(){
//        return employees.stream().map(Employee::getSalary).collect(Collectors.summarizingDouble(i->i)).getSum();
        return employees.stream().map(Employee::getSalary).reduce(0.0,(acc,itr)->acc+itr);

    }


     // 14. Department-wise salary sum

    public Map<String, Double> deptWiseSalarySum(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingDouble(Employee::getSalary)));
    }


    // 15. List employee names grouped by department

    public Map<String,List<String>> listOfEmployeeGroupByDept(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName,Collectors.toList())));
    }


    // 16. Find duplicate department entries (count > 1)  and print the department name as list

    public List<String> findDuplicateDepartmentName(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
                .entrySet().stream().filter(i->i.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    // 17. Collect names of active employees

    public List<String> findAllActiveEmployeeName(){
        return employees.stream().filter(Employee::isActive).map(Employee::getName).collect(Collectors.toList());
    }

    // 18. Remove duplicate employee names

    public List<String> uniqueNames(){
        return employees.stream().map(Employee::getName).distinct().collect(Collectors.toList());
    }

    // 19. Find employees not in "Engineering"

    public List<Employee> findEmployeeNotInEngineering(){
        return employees.stream().filter(i->!i.getDepartment().equals("Engineering"))
                .collect(Collectors.toList());
    }

    // 20. Is there any inactive employee in Finance?

    public Boolean checkInActiveEmployeeInFinance(){
        return employees.stream().filter(i->i.getDepartment().equalsIgnoreCase("Finance"))
                .anyMatch(i->!i.isActive());
    }


    // 21. Find first employee in HR

    public Employee getFirstEmployeeWhichIsHR(){
//        return employees.stream().filter(i->i.getDepartment().equalsIgnoreCase("HR")).findFirst().orElse(null);
        return employees.stream().filter(i->i.getDepartment().equalsIgnoreCase("HR")).toList().get(0);

    }


    // 22. Calculate average salary per department

    public Map<String,Double> calculateAverageSalaryPerDept(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingDouble(Employee::getSalary)));
    }

    // 23. Get department with the most employees

    public String getDeptWithMostNoOfEmployee(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("null");
    }


    // 24. Filter employees by name pattern (e.g., names starting with 'A')  find employees whose names start with 'A'?

    public List<String>findListOfNameStartingWithA(){
        return employees.stream().map(Employee::getName).filter(name -> name.startsWith("A")).collect(Collectors.toList());
    }


    // 25. Find duplicate names (same name used by multiple employees)

    public List<String> findDuplicateNames(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getName,
                Collectors.counting())).entrySet().stream().distinct().filter(i->i.getValue()>1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }


    // 26. List of salaries above average

    public List<Double> findBySalariesAboveAverage(){

        return employees.stream().map(Employee::getSalary).
                filter(salary -> salary > employees.stream().map(Employee::getSalary)
                .collect(Collectors.summarizingDouble(Double::valueOf)).getAverage())
                .collect(Collectors.toList());
    }


    // 27. Find employee with the lowest salary in Engineering

    public Double getLowestSalaryFromEngineering(){
//        return employees.stream().filter(dept->dept.getDepartment().equalsIgnoreCase("engineering"))
//                .map(Employee::getSalary).sorted().limit(1).findFirst().orElse(0.0);

        return employees.stream().filter(dept->dept.getDepartment().equalsIgnoreCase("engineering"))
                .min(Comparator.comparing(Employee::getSalary)).map(Employee::getSalary).orElse(0.0);
    }



    // 31. Count of employees with salary in specific range (e.g., 60K–90K)

    public Long countNoOfEmployeeWithInSpecificRange(){
        return employees.stream().filter(i->i.getSalary()>=60_000 && i.getSalary()<=90_000).count();
    }


    // 32. Get the second-highest salary

    public Double getSecondHighestSalary(){
        return employees.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder())
                .limit(2).skip(1).findFirst().orElse(0.0);
    }

    // 33. Get a sorted list of employee names by salary ascending

    public List<String> findListOfNameAccordingToTheirSalaryAsc(){
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary))
                .map(Employee::getName).collect(Collectors.toList());
    }

    // 34. Partition employees into "senior" and "junior" based on salary > 75K

    public Map<Boolean,List<Employee>> divideEmployeeBasedOnTheirEarningMoreThan70k(){
        return employees.stream().collect(Collectors.partitioningBy(i->i.getSalary()>70_000));
    }


    // 35. Find employees whose department has average salary > 80,000

    public List<String> employeeWhoseDeptHasAvgSalaryIsMoreThan80k(){
        Map<String,Double>avgSalaryPerDept=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        return employees.stream().filter(i-> avgSalaryPerDept.get(i.getDepartment())>80_000).map(Employee::getName).collect(Collectors.toList());
    }

    // 36 . Get a list of employee initials

    public List<String> getListOfEmployeeInitialsName(){
        return employees.stream().map(i->i.getName().substring(0,1)).collect(Collectors.toList());
    }

    // 37. Get a comma-separated list of departments in uppercase (no duplicates)

    public String getDepartmentStringInUpperCase(){
        return employees.stream().map(Employee::getDepartment).distinct()
                .map(String::toUpperCase).collect(Collectors.joining(","));
    }


    // 38. Get employee with longest name per department

    public List<Employee> getListOfEmployeeWithLongestNamePerDept(){
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(i -> i.getName().length())),
                                Optional::get
                        )
                ))
                .values().stream()
                .collect(Collectors.toList());
    }

    // 39. Count employees in a specific department

    public Map<String,Long> getAllEmployees(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
    }


    // 40. Find the highest salary among employees

    public Double findHighestSalary(){
        return employees.stream().map(Employee::getSalary).collect(Collectors.summarizingDouble(i->i)).getMax();
    }


    // 41. Find the highest salary from every department

//    public Map<String,Employee> findHighestSalaryFromEveryDept(){
//        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
//                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(i->i.getSalary())),
//                        Optional::get)));
//    }


    public Map<String,Double> findHighestSalaryFromEveryDept(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                        e -> e.get().getSalary())));
    }

    // 42. Sum salary of inactive employees

    public Double sumOfSalaryOfAllInActiveEmployee(){
        return employees.stream().filter(i-> !i.isActive()).map(Employee::getSalary)
                .collect(Collectors.summarizingDouble(i->i)).getSum();
    }

    // 43. Group employees named by department

    public Map<String,List<String>>getListOfEmployeeNameByDept(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName,Collectors.toList())));
    }

    // 44. Sort employees by salary descending

    public List<Employee> sortEmpBySalaryDesc(){
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
    }


    // 45. Map employee IDs to their names

    public Map<Integer,String> mapEmpIdWithName(){
        return employees.stream().collect(Collectors.toMap(Employee::getId,Employee::getName));
    }

    // 46. Check if there's any employee in the "IT" department

    public Boolean checkAnyEmployeeFromITDept(){
        return employees.stream().anyMatch(i->i.getDepartment().equalsIgnoreCase("IT"));
    }





























}
