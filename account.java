package assignment1;

public abstract class account {
	int acc_no;
	String acc_type;
	float balance;
	Boolean status;//active or inactive
	
	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public account(int acc_no, String acc_type, float balance, Boolean status) {
		this.acc_no = acc_no;
		this.acc_type = acc_type;
		this.balance = balance;
		this.status = status;
	}
	
	abstract void withdraw(float amount);
	abstract void deposit(float amount);
	
	@Override
	public String toString() {
		return(Integer.toString(acc_no)+" "+ acc_type + " " + String.valueOf(balance) + " Active: " + status);
	}
}
