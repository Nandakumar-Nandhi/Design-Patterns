import java.util.ArrayList;

class Employee
{
		private int    empId;
		private String name;
		private String designation;

		public Employee( int empId, String name, String designation )
		{
				super();
				this.empId = empId;
				this.name = name;
				this.designation = designation;
		}

		public int getEmpId()
		{
				return empId;
		}

		public void setEmpId( int empId )
		{
				this.empId = empId;
		}

		public String getName()
		{
				return name;
		}

		public void setName( String name )
		{
				this.name = name;
		}

		public String getDesignation()
		{
				return designation;
		}

		public void setDesignation( String designation )
		{
				this.designation = designation;
		}

		@Override
		public String toString()
		{
				return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + "]";
		}
}

interface ITarget
{
		public void processCompanySalary(String[][] employeeInfo);
}

class ThirdPartyBillingSystem
{
		public void processSalary( ArrayList<Employee> employeeList )
		{
				for( Employee employee : employeeList )
				{
					System.out.print("\n"+employee.toString()+" : ");
						if( employee.getDesignation().equalsIgnoreCase("Team Leader") )
						{
								System.out.println("70000Rs Salary credited to " + employee.getName() + " Account\n");
						}
						else if( employee.getDesignation().equalsIgnoreCase("Developer") )
						{
								System.out.println("40000Rs Salary credited to " + employee.getName() + " Account\n");
						}
						else if( employee.getDesignation().equalsIgnoreCase("Tester") )
						{
								System.out.println("30000Rs Salary credited to " + employee.getName() + " Account\n");
						}
				}
		}

}

public class EmployeeAdapter extends ThirdPartyBillingSystem implements ITarget
{
		@Override
		public void processCompanySalary( String[][] employeeInfo )
		{
				String empId = null;
				String name = null;
				String designation = null;
				ArrayList<Employee> employeeList = new ArrayList<Employee>();
				for( int i = 0; i < employeeInfo.length; i++ )
				{

						for( int j = 0; j < employeeInfo[i].length; j++ )
						{
								if( j == 0 )
								{
										empId = employeeInfo[i][j];
								}
								else if( j == 1 )
								{
										name = employeeInfo[i][j];
								}
								else
								{
										designation = employeeInfo[i][j];
								}
						}
						employeeList.add(new Employee(Integer.parseInt(empId), name, designation));

				}

				System.out.println("Adapter converted Array of Employee to ArrayList of Employee : \n"+employeeList+"\n"+
						"then call the processSalary method inherited from the ThirdPartyBillingSystem for processing the employee salary");
				processSalary(employeeList);

		}

}



public class HumanResourceSystem
{

		public static String[][] getEmployees()
		{
				String[][] employees = new String[4][];

				employees[0] = new String[] { "100", "Dave", "Team Leader" };
				employees[1] = new String[] { "101", "Ram", "Developer" };
				employees[2] = new String[] { "102", "Raj", "Developer" };
				employees[3] = new String[] { "103", "Rahul", "Tester" };

				return employees;
		}

		public static void main( String args[] )
		{

				ITarget target = new EmployeeAdapter();
				System.out.println("HR system passes employee string array to Adapter\n");
				target.processCompanySalary(getEmployees());

		}
}