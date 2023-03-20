
interface EmployeeSalary
{
    public String getDescription();
    public int getSalary();
    
 
}
class Junior_SE implements EmployeeSalary
{
    public String getDescription()
    { 
        return this.getClass().getName();  
    }
    public int getSalary()
    {
    return 40000;
    }
}
 
abstract class EmployeeSalaryDecorator implements EmployeeSalary
{       
        EmployeeSalary employeeSalary;
        EmployeeSalaryDecorator(EmployeeSalary employeeSalary)
        {
            this.employeeSalary=employeeSalary;
        }
        
} 
class withBonus extends EmployeeSalaryDecorator
{
          
    public withBonus(EmployeeSalary employeeSalary)
    {
        super(employeeSalary);          
    } 
    public String getDescription()
    {
            
        return employeeSalary.getClass().getName()+" "+this.getClass().getName();
          
    }
    public int getSalary()
    {       
        return employeeSalary.getSalary() + 10000;
    }

}

public class Main 
{
  
    public static void printSalary(EmployeeSalary employee)
      {
        
        System.out.println (employee.getDescription() + "  is Rs " +employee.getSalary());
     
    } 
    public static void main (String[]args)
    {
                EmployeeSalary employee = new Junior_SE();                 
                printSalary (employee); 
                
                employee = new withBonus(employee);
                printSalary(employee);
        
    } 
}
