package assignment1;

import java.util.ArrayList;
import java.util.List;

public class current extends account {
	Boolean joint;
	List<user> u = new ArrayList<user>();
	
	public current(int acc_no, String acc_type, float balance, Boolean status,Boolean joint,List<user> u) {
		super(acc_no, acc_type, balance, status);
		this.joint=joint;
		this.u =u;
	}
	
	@Override
	void withdraw(float amount) {
		balance-=amount;
		if(balance<=0) {
			status = false; //dormant
			System.out.println("Dormant account, negative balnce!");
		}
	}
	
	@Override
	void deposit(float amount) {
		if(balance<=0 || (balance+amount)>=100) {
			System.out.println("Your account has been reactivated!");
			status = true;
		}
		else if(balance<=0 || (balance+amount)<100) {
			int temp = (int) (100 - (balance+amount));
			System.out.println("Your account is still dormant! Please deposit min "+ Integer.toString(temp)+ " more to ractivate!");
		}
		balance+=amount;
		System.out.println(Integer.toString((int)balance)+" deposited!");
	}
}
