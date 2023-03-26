package assignment1;

import java.time.LocalDateTime;

public class ledger {
	int u_id;
	int acc_no;
	String type; //deposit or withdraw
	float amount;
	LocalDateTime date;
	
	
	
	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public ledger(int acc_no, String type, float amount, LocalDateTime date, int u_id) {
		this.u_id = u_id;
		this.acc_no = acc_no;
		this.type = type;
		this.amount = amount;
		this.date = date;	
	}
	
	@Override
	public String toString() {
		return(Integer.toString(u_id)+" "+Integer.toString(acc_no)+" "+ type + " " + String.valueOf(amount) + " Date: " + date);
	}
	
}
