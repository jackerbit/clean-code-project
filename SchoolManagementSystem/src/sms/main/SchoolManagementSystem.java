package sms.main;

import java.util.Scanner;

import sms.function.*;

public class SchoolManagementSystem {

	public static void showMenu() {
		System.out.println("=================================================");
		System.out.println("|  1. Show information of all school            |");
		System.out.println("|  3. Input School                              |");
		System.out.println("|  3. Find school by name                       |");
		System.out.println("|  4. Find teacher by name                      |");
		System.out.println("|  5. Find teacher by address                   |");
		System.out.println("|  6. Exit                                      |");
		System.out.println("=================================================");
	}
	
	public static int getOption(Scanner sc) {
		String choice="5";
		do {
			System.out.print("Enter your choice: ");
			choice = sc.nextLine();
		}while(!choice.matches("[1-5]"));
		System.out.println();
		return Integer.parseInt(choice);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ManagementSchool ms = new ManagementSchool();
		
		int choice = 6;
		boolean check = true;
		do {
			showMenu();
			choice = getOption(sc);
			switch(choice) {
				case 1: ms.printAll(); break;
				case 2: ms.input(sc); break;
				case 3:{
					String name;
					do {
						System.out.print("School's name: ");
						name = sc.nextLine();
						check = name.length()==0;
					}while(check);
					ms.searchSchoolByName(name);
					break;
				}
				case 4:{
					String name;
					do {
						System.out.print("Teacher's name: ");
						name = sc.nextLine();
						check = name.length()==0;
					}while(check);
					ms.searchTeacherByName(name);
					break;
				}
				case 5:{
					String address;
					do {
						System.out.print("School's name: ");
						address = sc.nextLine();
						check = address.length()==0;
					}while(check);
					ms.searchTeacherByAddress(address);
					break;
				}
				case 6: System.out.println("Exit !");
			}
		}while(choice!=5);
	}

}
