package Decorator;

public class withStock extends EmployeeSalaryDecorator{
    EmployeeSalary empsal;
    public withStock(EmployeeSalary empsal){
        this.empsal=empsal;
    }
    public String getDescription(){
        return empsal.getDescription()+" + with stocks";
    }
    public int getSalary(){
        return empsal.getSalary()+25000;
    }
}