package assignment1;

import java.util.ArrayList;
import java.util.List;

public class user {
	public int u_id;
	String name;
	String address;
	long phone;
	int acc_count;
	List<account> acc = new ArrayList<account>();
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setAcc(account newAcc) {
		if(acc_count>=3) {
			System.out.println("You have reached the maximum limit of 3 accounts!");
		}
		else {
			this.acc.add(newAcc);
			acc_count++;
		}
	}
	public List<account> getAcc() {
		return acc;
	}
	public user(int u_id, String name, String address, long phone) {
		
		this.u_id = u_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		//this.acc_count++;
	}
	
	@Override
	public String toString() {
		System.out.println(Integer.toString(u_id)+" "+ name + " " +address+" " + Integer.toString((int) phone) + " No.of account: " + Integer.toString(acc_count));
		for(account a: acc) {
			a.toString();
		}
		return "--------------\nPRINTED!\n--------------\n\n";
	}
	
}
