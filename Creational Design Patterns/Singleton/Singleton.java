
class Singleton
{
	private static Singleton obj;

	private Singleton() {}

	public static Singleton getInstance()
	{
		if (obj==null)
		{
			obj = new Singleton();
			System.out.println("Object is created "+obj.toString());
		}
		return obj;
	}
	public void printSingleton(){
		System.out.println("Inside print Singleton object: "+obj.toString());
	}
}
public class Main{
    public static void main(String args[]){
        
        Singleton.getInstance().printSingleton();
        Singleton.getInstance().printSingleton();
        Singleton.getInstance().printSingleton();
		
    }
}