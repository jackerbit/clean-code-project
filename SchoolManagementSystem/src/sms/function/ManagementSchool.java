package sms.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ManagementSchool {
	protected List<SchoolDTO> list = null;
	
	public ManagementSchool() {
		list = new ArrayList<SchoolDTO>();
	}
	
	
	// input data
	public void input(Scanner sc) {
		String name, address, email, phone;
		String nameTeacher, phoneTeacher, addressTeacher;
		Teacher[] teacher;
		int n;
		boolean check=true;
		do {
			System.out.print("School's name: ");
			name = sc.nextLine();
			check = name.length()==0;
		}while(check);
		do {
			System.out.print("School's address: ");
			address = sc.nextLine();
			check = address.length()==0;
		}while(check);
		do {
			System.out.print("School's email: ");
			email = sc.nextLine();
			check = email.length()==0||!email.matches("[a-zA-Z0-9-_.]{5,30}@[a-z]{1,20}?.(com|vn)");
		}while(check);
		do {
			System.out.print("School's phone: ");
			phone = sc.nextLine();
			check = phone.length()==0||!phone.matches("[0-9]{6,11}");
		}while(check);
		
		do {
			System.out.print("Number of teacher: ");
			n = Integer.parseInt(sc.nextLine());
			check = n<=0;
		}while(check);
		teacher = new Teacher[n];
		for(int i=0;i<n;i++) {
			do {
				System.out.print("Teacher's name: ");
				nameTeacher = sc.nextLine();
				check = nameTeacher.length()==0;
			}while(check);
			do {
				System.out.print("Teacher's address: ");
				addressTeacher = sc.nextLine();
				check = addressTeacher.length()==0;
			}while(check);
			do {
				System.out.print("Teacher's phone: ");
				phoneTeacher = sc.nextLine();
				check = phoneTeacher.length()==0||!phone.matches("[0-9]{6,11}");
			}while(check);
			teacher[i] = new Teacher(nameTeacher, addressTeacher, phoneTeacher);
		}
		list.add(new SchoolDTO(name, address, email, phone, teacher));
		
		// unit test
		if(!list.isEmpty()) System.out.println("Adding Successfull !");
	}
	
	// search school by name 
	public void searchSchoolByName(String name) {
		if(list.isEmpty())	System.out.println("List is empty !");
		else {
			boolean check = true;
			for(int i=0;i<list.size();i++) {
				if(isBruteSearch(list.get(i).getName().toUpperCase(),
						name.toUpperCase())) { 
					System.out.println(list.get(i).toString());
					check=false;
				}
			}
			if(check) System.out.println("There has no any school in list !");
		}
	}
	
	// search teacher by name 
	public void searchTeacherByName(String name) {
		if(list.isEmpty())	System.out.println("List is empty !");
		else {
			boolean check = true;
			for(int i=0;i<list.size();i++) {
				Teacher[] tmp = list.get(i).getTeacher();
				for(int k=0;k<tmp.length;k++) {
					if(isBruteSearch(tmp[k].getName().toUpperCase(), name.toUpperCase())) {
						System.out.println(tmp[k].toString());
						check=false;
					}
				}
			}
			if(check) System.out.println("There has no any school in list !");
		}
	}
	
	// search teacher by address
	public void searchTeacherByAddress(String address) {
		if(list.isEmpty())	System.out.println("List is empty !");
		else {
			boolean check = true;
			for(int i=0;i<list.size();i++) {
				Teacher[] tmp = list.get(i).getTeacher();
				for(int k=0;k<tmp.length;k++) {
					if(isBruteSearch(tmp[k].getAddress().toUpperCase(), address.toUpperCase())) {
						System.out.println(tmp[k].toString());
						check=false;
					}
				}
			}
			if(check) System.out.println("There has no any school in list !");
		}
	}
	
	// Brute Search
	public boolean isBruteSearch(String a, String p) {
		int i=0,j=0;
		do {
			if(a.substring(i, i+1).equals(p.substring(j, j+1))) {
				i++;
				j++;
			}else {
				i = i-j+1;
				j=0;
			}
		}while(j<p.length()&&i<a.length());
		return j>=p.length();
	}
	
	// print all
	public void printAll() {
		if(list.isEmpty())	System.out.println("List is empty !");
		else 
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i).toString());
	}
}

