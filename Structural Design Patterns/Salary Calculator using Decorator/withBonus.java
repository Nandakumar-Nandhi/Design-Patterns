package Decorator;

public class withBonus extends EmployeeSalaryDecorator{
    EmployeeSalary employeeSalary;
    public withBonus(EmployeeSalary employeeSalary){
        this.employeeSalary=employeeSalary;
    }
    public String getDescription(){
        return employeeSalary.getDescription()+" + with Bonus";
    }
    public int getSalary(){
        return employeeSalary.getSalary()+100000;
    }
}