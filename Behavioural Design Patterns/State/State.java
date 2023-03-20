interface AtmMachineState
{

		public void insertDebitCard();
		
		public void ejectDebitCard();
		
		public void enterPinAndWithdrawMoney();
}
class AtmMachine implements AtmMachineState
{

		private AtmMachineState atmMachineState;

		public AtmMachine()
		{
				atmMachineState = new NoDebitCardState();
		}

		public AtmMachineState getAtmMachineState()
		{
				return atmMachineState;
		}

		public void setAtmMachineState( AtmMachineState atmMachineState )
		{
				this.atmMachineState = atmMachineState;
		}

		@Override
		public void insertDebitCard()
		{
				atmMachineState.insertDebitCard();
				if( atmMachineState instanceof NoDebitCardState )
				{

						AtmMachineState hasDebitCardState = new HasDebitCardState();
						setAtmMachineState(hasDebitCardState);
						System.out.println("ATM Machine internal state has been moved to : "
						                + atmMachineState.getClass().getName());
				}

		}

		@Override
		public void ejectDebitCard()
		{
				atmMachineState.ejectDebitCard();
				if( atmMachineState instanceof HasDebitCardState )
				{

						AtmMachineState noDebitCardState = new NoDebitCardState();
						setAtmMachineState(noDebitCardState);
						System.out.println("ATM Machine internal state has been moved to : "
						                + atmMachineState.getClass().getName());
				}

		}

		@Override
		public void enterPinAndWithdrawMoney()
		{
				atmMachineState.enterPinAndWithdrawMoney();

		}

}
class HasDebitCardState implements AtmMachineState
{

		@Override
		public void insertDebitCard()
		{
				System.out.println("Debit Card is already there,So you cannot insert the Debit Card ...");

		}

		@Override
		public void ejectDebitCard()
		{

				System.out.println("Debit Card is ejected...");
		}

		@Override
		public void enterPinAndWithdrawMoney()
		{
				System.out.println("Pin number has been entered correctly and money has been withdrawn...");

		}
}
class NoDebitCardState implements AtmMachineState
{

		@Override
		public void insertDebitCard()
		{
				System.out.println("DebitCard inserted ....");

		}

		@Override
		public void ejectDebitCard()
		{

				System.out.println("No Debit Card in ATM Machine slot, so you cannot eject the Debit Card...");
		}

		@Override
		public void enterPinAndWithdrawMoney()
		{
				System.out.println("No Debit Card in ATM Machine slot, so you cannot enter the pin and withdraw the money...");

		}

}

public class Main
{

		public static void main( String[] args )
		{
				AtmMachine atmMachine = new AtmMachine();

				System.out.println("ATM Machine Current state : "
				                + atmMachine.getAtmMachineState().getClass().getName());

				System.out.println();
				atmMachine.enterPinAndWithdrawMoney();
				atmMachine.ejectDebitCard();
				atmMachine.insertDebitCard();
				
				System.out.println("\n*******************************************************");

				System.out.println("\nATM Machine Current state : "
				                + atmMachine.getAtmMachineState().getClass().getName());
				System.out.println();

				atmMachine.enterPinAndWithdrawMoney();
				atmMachine.insertDebitCard();
				atmMachine.ejectDebitCard();
				System.out.println("\n*******************************************************");
				System.out.println("\nATM Machine Current state : "
				                + atmMachine.getAtmMachineState().getClass().getName());

		}

}