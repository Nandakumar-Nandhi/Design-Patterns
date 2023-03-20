abstract class Employee
{
    		protected Employee supervisor;

		public void setNextSupervisor( Employee supervisor )
		{
				this.supervisor = supervisor;
		}

		public abstract void applyLeave( String employeeName, int numberofDaysLeave );
}


class HR extends Employee
{
		private int MAX_LEAVES_CAN_APPROVE = 30;

		public void applyLeave( String employeeName, int numberofDaysLeave )
		{
				if( numberofDaysLeave <= MAX_LEAVES_CAN_APPROVE )
				{
						ApproveLeave(employeeName, numberofDaysLeave);
				}
				else
				{
						System.out.println("Leave application suspended, Please contact HR");
				}
		}

		private void ApproveLeave( String employeeName, int numberofDaysLeave )
		{
				System.out.println("HR approved " + numberofDaysLeave + " days " + "Leave for the employee : "
				                + employeeName);

		}
}

class ProjectLeader extends Employee
{
		private int MAX_LEAVES_CAN_APPROVE = 20;

		public void applyLeave( String employeeName, int numberofDaysLeave )
		{
				if( numberofDaysLeave <= MAX_LEAVES_CAN_APPROVE )
				{
						ApproveLeave(employeeName, numberofDaysLeave);
				}
    			else
				{
						supervisor.applyLeave(employeeName, numberofDaysLeave);
				}
		}

		private void ApproveLeave( String employeeName, int numberofDaysLeave )
		{
				System.out.println("ProjectLeader approved " + numberofDaysLeave + " days " + "Leave for the employee : "
				                + employeeName);

		}
}
class TeamLeader extends Employee
{
		private int MAX_LEAVES_CAN_APPROVE = 10;

		public void applyLeave( String employeeName, int numberofDaysLeave )
		{
				if( numberofDaysLeave <= MAX_LEAVES_CAN_APPROVE )
				{
						ApproveLeave(employeeName, numberofDaysLeave);
				}
				else
				{
						supervisor.applyLeave(employeeName, numberofDaysLeave);
				}
		}

		private void ApproveLeave( String employeeName, int numberofDaysLeave )
		{
				System.out.println("TeamLeader approved " + numberofDaysLeave + " days " + "Leave for the employee : "
				                + employeeName);

		}
}
public class Main
{

		public static void main( String[] args )
		{
				TeamLeader teamLeader= new TeamLeader();
				ProjectLeader projectLeader= new ProjectLeader();
				HR hr=new HR();
				teamLeader.setNextSupervisor(projectLeader);
				projectLeader.setNextSupervisor(hr);
				
				teamLeader.applyLeave("David", 9);
				System.out.println();
				teamLeader.applyLeave("John", 18);
				System.out.println();
				teamLeader.applyLeave("Steve", 30);
				System.out.println();
				teamLeader.applyLeave("Rohan", 50);

		}

}