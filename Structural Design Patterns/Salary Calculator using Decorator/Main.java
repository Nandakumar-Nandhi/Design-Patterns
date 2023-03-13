package Decorator;

public class Main
{
    public static void printSalary(EmployeeSalary employee){
        System.out.println(employee.getDescription()+"  is Rs "+employee.getSalary());
        
    }
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        
    EmployeeSalary employee=new Junior_SE();
    
        printSalary(employee);
        
        employee=new withStock(employee);
        printSalary(employee);
        employee=new withBonus(employee);
        printSalary(employee);
	}
}