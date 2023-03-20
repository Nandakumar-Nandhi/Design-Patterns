import java.util.ArrayList;

class School
{

		static ArrayList<Child> childList;
		
		static
		{
				childList = new ArrayList<Child>();

				Child john = new Child("John");
				Child steve = new Child("Steve");
				Child rohit = new Child("Rohit");
				Child sonu = new Child("Sonu");

				childList.add(john);
				childList.add(steve);
				childList.add(rohit);
				childList.add(sonu);
		}
		
		
		public static void doHealthCheckup()
		{
				ChildSpecialistDoctor childSpecialistDoctor = new ChildSpecialistDoctor("Dr.Smith");
				for( Child child : childList )
                {
		                child.accept(childSpecialistDoctor);
                }
		}

}

interface Visitable
{
		public void accept(Visitor visitor);
}

class Child implements Visitable
{

		private String name;

		private String healthStatus;

		public Child( String name )
		{
				super();
				this.name = name;
		}

		public String getName()
		{
				return name;
		}

		public String getHealthStatus()
		{
				return healthStatus;
		}

		public void setHealthStatus( String healthStatus )
		{
				this.healthStatus = healthStatus;
		}

		@Override
		public void accept( Visitor visitor )
		{
				visitor.visit(this);
		}

}

interface Visitor
{
		public void visit(Visitable visitable);
}

class ChildSpecialistDoctor implements Visitor
{

		private String name;

		public ChildSpecialistDoctor( String name )
		{
				super();
				this.name = name;
		}

		public String getName()
		{
				return name;
		}

		@Override
		public void visit( Visitable visitable )
		{
				Child child = (Child) visitable;
				child.setHealthStatus("Bad");
				System.out.println("ChildSpecialistDoctor: '" + this.getName() + "' did the checkup of the child: '"
				                + child.getName()
				                + "' and found health is not good so updated the health status as 'Bad'\n");

		}

}


public class Main
{

		public static void main( String[] args )
		{
				School.doHealthCheckup();
		}

}



