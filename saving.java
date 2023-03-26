package assignment1;

public class saving extends account{
	user u;
	public saving(int acc_no, String acc_type, float balance, Boolean status,user u) {
		super(acc_no, acc_type, balance, status);
		this.u = u;
		// TODO Auto-generated constructor stub
	}
	

	@Override
	void withdraw(float amount) {
		float penalty = amount*0.01f;
		balance-=(amount+penalty);
	}
	
	@Override
	void deposit(float amount) {
		balance+=amount;
	}

}
