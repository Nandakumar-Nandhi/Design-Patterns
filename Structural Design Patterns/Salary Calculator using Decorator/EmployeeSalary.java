package Decorator;

public abstract class EmployeeSalary{
    
    public String description="UnKnown";
    public String getDescription(){
        return description;
    }
    public abstract int getSalary();
    
}