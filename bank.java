package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class bank {
	static List<user> u= new ArrayList<user>();
	static List<account> acc = new ArrayList<>();
	static List<ledger> trans=new ArrayList<ledger>();
	static int acc_id = 0;
	static int u_id = 0;
	
	static Scanner input = new Scanner(System.in);
	
	static void addUser(int u_id, String name,String address, long phone) throws IOException {
		user tempU = new user(u_id,name,address,phone);
		u.add(tempU);
		tempU.toString();
		System.out.println("Account type?(1.Saving or 2.Current)");
		int option = input.nextInt();
		
		switch(option) {
		case 1:
			account newAcc = new saving(acc_id++,"Saving",0f,true,tempU);
			acc.add(newAcc);
			tempU.setAcc(newAcc);
			break;
		case 2:
			System.out.println("Joint?1.Yes or 2.No");
			int joint = input.nextInt();
			List<user> jointUser = new ArrayList<user>();
			switch(joint) {
			case 1:
				//jointUser = null;
				jointUser.add(tempU);
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter name: ");
				String uname = reader.readLine();
				System.out.println("Enter address: ");
				String addr = reader.readLine();
				user temp = new user(++u_id,name,addr,01110000000);
				jointUser.add(temp);
				account newAcc1 = new current(acc_id++,"Current",0f,true,true,jointUser);
				acc.add(newAcc1);
				tempU.setAcc(newAcc1);
				temp.setAcc(newAcc1);
				break;
			case 2:
				//jointUser = null;
				jointUser.add(tempU);
				account newAcc2 = new current(acc_id++,"Current",0f,true,true,jointUser);
				acc.add(newAcc2);
				tempU.setAcc(newAcc2);
				break;
			}
			break;
		default:
				System.out.println("Not an Option!");
		}
	}

	static void transaction(int id) {
		float amount;
		for (user User : u) {
	        if (User.getU_id() == id) {
	            System.out.println("Enter account id: ");
	            int a = input.nextInt();
	            for(int i =0; i<3;i++) {
	            	if(User.acc.get(i).acc_no == a) {
	            		System.out.println("1.Withdraw or 2.deposit");
	    	            int opt = input.nextInt();
	    	            if(opt==1) {
	    	            	System.out.println("Enter amount to Withdraw: ");
	    	            	amount = input.nextFloat();
	    	            	User.acc.get(i).withdraw(amount);
	    	            	LocalDateTime date = LocalDateTime.now();
	    	            	ledger temp = new ledger(a,"withdraw",amount,date,id);
	    	            	trans.add(temp);
	    	            }
	    	            else if(opt==2) {
	    	            	System.out.println("Enter amount to Deposit: ");
	    	            	amount = input.nextFloat();
		            		User.acc.get(i).deposit(amount);
		            		LocalDateTime date1 = LocalDateTime.now();
	    	            	ledger temp1 = new ledger(a,"deposit",amount,date1,id);
	    	            	trans.add(temp1);
	    	            }
	            	}
	            }
	        }
	    }
	}

	public static Boolean findUser(int id) {
		for(user User: u) {
			if (User.getU_id() == id) {
				System.out.println("You,ve successfully logged in!");
				User.toString();
				return true;
			}
		}
		System.out.println("No User Found!");
		return false; 
	}
	
	public static Boolean findTransaction(int id,int acc_n) {
		for(ledger User: trans) {
			System.out.println("TRANSACTIONS: ");
			if (User.getU_id() == id) {
				User.toString();
				return true;
			}
		}
		System.out.println("No User Found!");
		return false; 
	}
	
	public static void addAcc(int id) {
		for(user User: u) {
			if (User.getU_id() == id) {
				if(User.acc_count>=3) {
					System.out.println("You've reached the max account limit!");
				}
				else {
					System.out.println("Account type?(1.Saving or 2.Current)");
					int option = input.nextInt();
					
					switch(option) {
					case 1:
						account newAcc = new saving(acc_id++,"Saving",0f,true,User);
						acc.add(newAcc);
						User.setAcc(newAcc);
						break;
					case 2:
						System.out.println("Joint?1.Yes or 2.No");
						int joint = input.nextInt();
						List<user> jointUser = new ArrayList<user>();
						switch(joint) {
						case 1:
							//jointUser = null;
							jointUser.add(User);
							user temp = new user(u_id++,Integer.toString(u_id++)+"user","zyx",01110000000);
							jointUser.add(temp);
							account newAcc1 = new current(acc_id++,"Current",0f,true,true,jointUser);
							acc.add(newAcc1);
							User.setAcc(newAcc1);
							temp.setAcc(newAcc1);
							break;
						case 2:
							//jointUser = null;
							jointUser.add(User);
							account newAcc2 = new current(acc_id++,"Current",0f,true,true,jointUser);
							acc.add(newAcc2);
							User.setAcc(newAcc2);
							break;
						}
						break;
					default:
							System.out.println("Not an Option!");
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		/*
		 * addUser(u_id,"Mahad","lkjhgfd",1000000);
		 * addUser(u_id,"Sheikh","qwert",1111111);
		 * addUser(u_id,"Muhammad","zxcvbnm",2222222);
		 * addUser(u_id,"Mahad","poiuy",3333333);
		 */
		addUser(u_id,"Mahad","lkjhgfd",1000000);
		int x = 0, y = 0, z = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(x!=3) {
			System.out.println("1.Login\n2.Signup\n3.Exit");
			int a = input.nextInt();
			switch(a) {
			case 1:
				System.out.println("Enter user id: ");
				int id = input.nextInt();
				if(findUser(id)) {
					System.out.println("1.Add Account\n2.Transaction\n3.Search Transaction\n");
					int b = input.nextInt();
					switch(b) {
					case 1:
						addAcc(id);
						break;
					case 2:
						transaction(id);
						break;
					default:
						System.out.println("Not an option!");
					}
				}
				break;
			case 2:
				
				System.out.println("Enter name: ");
				String uname = reader.readLine();
				System.out.println("Enter address: ");
				String addr = reader.readLine();
				addUser(++u_id,uname,addr,2000000000);
				break;
			case 3:
				System.out.println("Enter name: ");
				int l_id = input.nextInt();
				System.out.println("Enter name: ");
				int l_acc = input.nextInt();
				findTransaction(l_id,l_acc);
				break;
			default:
				System.out.println("Not an Option!");	
			}
			
		}
		
		
	}
}
