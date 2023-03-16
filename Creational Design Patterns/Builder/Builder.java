class Beverage
{
		private int    water;
		private int    milk;
		private int    sugar;
		private int    powderQuantity;
		private String beverageName;

		public int getWater()
		{
				return water;
		}

		public void setWater( int water )
		{
				this.water = water;
		}

		public int getMilk()
		{
				return milk;
		}

		public void setMilk( int milk )
		{
				this.milk = milk;
		}

		public int getSugar()
		{
				return sugar;
		}

		public void setSugar( int sugar )
		{
				this.sugar = sugar;
		}

		public int getPowderQuantity()
		{
				return powderQuantity;
		}

		public void setPowderQuantity( int powderQuantity )
		{
				this.powderQuantity = powderQuantity;
		}

		public String getBeverageName()
		{
				return beverageName;
		}

		public void setBeverageName( String beverageName )
		{
				this.beverageName = beverageName;
		}

		public String toString()
		{
				return "Hot " + beverageName + "!!!!  [" + water + " ml of water, " + milk + "ml of milk, " + sugar
				                + " gm of sugar, " + powderQuantity + " gm of " + beverageName + "]\n";
		}

}
abstract class BeverageBuilder
{

		private Beverage beverage;

		public Beverage getBeverage()
		{
				return beverage;
		}

		public void setBeverage( Beverage beverage )
		{
				this.beverage = beverage;
		}

		
		public final Beverage buildBeverage()
		{
				Beverage beverage = createBeverage();
				setBeverage(beverage);
				setBeverageType();
				setWater();
				setMilk();
				setSugar();
				setPowderQuantity();
				return beverage;
		}

		abstract void setBeverageType();

		abstract void setWater();

		abstract void setMilk();

		abstract void setSugar();

		abstract void setPowderQuantity();

		abstract Beverage createBeverage();

}
class CoffeeBuilder extends BeverageBuilder
{
		Beverage createBeverage()
		{
				return new Beverage();
		}

		public void setWater()
		{
				System.out.println("Step 1 : Boiling water");
				getBeverage().setWater(40);
		}

		public void setMilk()
		{
				System.out.println("Step 2 : Adding milk");
				getBeverage().setMilk(50);
		}

		void setSugar()
		{
				System.out.println("Step 3 : Adding sugar");
				getBeverage().setSugar(10);
		}

		void setPowderQuantity()
		{
				System.out.println("Step 4 : Adding 9 Grams of coffee powder");
				getBeverage().setPowderQuantity(9);
		}

		void setBeverageType()
		{
				System.out.println("Coffee");
				getBeverage().setBeverageName("Coffee");
		}

}
class TeaBuilder extends BeverageBuilder
{

		Beverage createBeverage()
		{
				return new Beverage();
		}

		public void setWater()
		{
				System.out.println("Step 1 : Boiling water");
				getBeverage().setWater(40);
		}

		public void setMilk()
		{
				System.out.println("Step 2 : Adding milk");
				getBeverage().setMilk(50);
		}

		void setSugar()
		{
				System.out.println("Step 3 : Adding sugar");
				getBeverage().setSugar(10);
		}

		void setPowderQuantity()
		{
				System.out.println("Step 4 : Adding 9 Grams of tea powder");
				getBeverage().setPowderQuantity(9);
		}


		void setBeverageType()
		{
				System.out.println("Tea");
				getBeverage().setBeverageName("Tea");
		}

}
class HotelWaiter
{

		public static Beverage takeOrder( String beverageType )
		{

				BeverageBuilder beverageBuilder = null;

				if( beverageType.equalsIgnoreCase("tea") )
				{
						beverageBuilder = new TeaBuilder();
				}
				else if( beverageType.equalsIgnoreCase("coffee") )
				{
						beverageBuilder = new CoffeeBuilder();
				}
				else
				{
						System.out.println("Sorry we don't take order for  " + beverageType);
				}
				return beverageBuilder.buildBeverage();
		}

}



public class Main
{
		public static void main( String[] args )
		{

				Beverage tea = HotelWaiter.takeOrder("tea");
				System.out.println(tea);
				
				Beverage coffee = HotelWaiter.takeOrder("coffee");
				System.out.println(coffee);
		}
}