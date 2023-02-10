package com.hotel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Food implements Serializable
{
	int itemno;
	int quantity;
	float price;
	public Food(int itemno, int quantity) 
	{
		this.itemno = itemno;
		this.quantity = quantity;
		switch(itemno)
		{
		case 1: price = quantity * 50;
		break;

		case 2: price = quantity * 60;
		break;

		case 3: price = quantity * 70;
		break;

		case 4: price = quantity * 30;
		break;
		}
	}
}

class Singleroom implements Serializable
{
	String name;
	String contact;
	String gender;

	ArrayList<Food> food = new ArrayList<Food>();

	Singleroom()
	{
		this.name = "";
	}

	public Singleroom(String name, String contact, String gender) 
	{	
		this.name = name;
		this.contact = contact;
		this.gender = gender;
	}
}

class Doubleroom extends Singleroom implements Serializable
{
	String name2;
	String contact2;
	String gender2;


	Doubleroom()
	{
		this.name = "";
		this.name2 = "";

	}

	public Doubleroom(String name, String contact, String gender, 
			String name2, String contact2, String gender2)
	{
		this.name = name;
		this.contact = contact;
		this.gender = gender;
		this.name2 = name2;
		this.contact2 = contact2;
		this.gender2 = gender2;
	}
}

class NotAvailable extends Exception
{
	public String toString()
	{
		return "NotAvailable";
	}
}

class Holder implements Serializable
{
	Doubleroom luxury_doubleroom[] = new Doubleroom[10];
	Doubleroom deluxe_doubleroom[] = new Doubleroom[20];
	Singleroom luxury_singleroom[] = new Singleroom[10];
	Singleroom deluxe_singleroom[] = new Singleroom[20];
}

class Reception
{
	static Holder hotel_ob = new Holder();
	static Scanner input = new Scanner(System.in);

	static void CustDetails(int i, int rn)
	{
		String name, contact, gender;
		String name2 = null, contact2 = null;
		String gender2 = "";
		System.out.println("\nEnter customer name: ");
		name = input.next();

		System.out.println("\nEnter customer contact: ");
		contact = input.next();

		System.out.println("\nEnter gender: ");
		gender = input.next();

		if(i < 3)
		{
			System.out.println("Enter second customer name: ");
			name2 = input.next();
			System.out.println("Enter customer number: ");
			contact2 = input.next();
			System.out.println("Enter gender: ");
			gender2 = input.next();
		}

		switch(i)
		{
		case 1:
			hotel_ob.luxury_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
			break;

		case 2:
			hotel_ob.deluxe_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
			break;

		case 3:
			hotel_ob.luxury_singleroom[rn] = new Singleroom(name, contact, gender);
			break;

		case 4:
			hotel_ob.deluxe_singleroom[rn] = new Singleroom(name, contact, gender);
			break;

		default : 
			System.out.println("Wrong option");
			break;
		}
	}

	static void bookroom(int i)
	{
		int j;
		int rn;
		System.out.println("\n Please choose room number from: ");

		switch(i)
		{
		case 1:
			for(j = 0; j < hotel_ob.luxury_doubleroom.length; j++);
			{
				if(hotel_ob.deluxe_doubleroom[j] == null)
				{
					System.out.println(j + 1 + ",");
				}
			}
			System.out.println("\nEnter room number: ");
			try
			{
				rn = input.nextInt();
				rn--;
				if(hotel_ob.luxury_doubleroom[rn] != null)throw new NotAvailable();
				CustDetails(i, rn);
			}
			catch(Exception ex)
			{
				System.out.println("Invalid Option");
				return;
			}
			break;

		case 2:
			for(j = 0; j < hotel_ob.deluxe_doubleroom.length; j++)
			{
				if(hotel_ob.deluxe_doubleroom[j] == null)
				{
					System.out.println(j + 11 + ",");
				}
			}
			System.out.println("\nEnter room number: ");
			try
			{
				rn = input.nextInt();
				rn = rn - 11;

				if(hotel_ob.deluxe_doubleroom[rn] != null)throw new NotAvailable();
				CustDetails(i, rn);
			}
			catch(Exception ex)
			{
				System.out.println("Invalid Option");
				return;
			}
			break;

		case 3: 
			for(j = 0; j < hotel_ob.luxury_singleroom.length; j++)
			{
				if(hotel_ob.luxury_singleroom[j] == null)
				{
					System.out.println(j + 31 + ",");
				}
			}
			System.out.println("\nEnter room number: ");

			try
			{
				rn = input.nextInt();
				rn = rn - 31;
				if(hotel_ob.luxury_singleroom[rn] != null)throw new NotAvailable();
				CustDetails(i, rn);
			}
			catch(Exception ex)
			{
				System.out.println("Invalid Option");
				return;
			}
			break;

		case 4:
			for(j = 0; j < hotel_ob.deluxe_singleroom.length; j++)
			{
				if(hotel_ob.deluxe_singleroom[j] == null)
				{
					System.out.println(j + 41 + ",");
				}
			}
			System.out.println("\nEnter room number: ");

			try
			{
				rn = input.nextInt();
				rn = rn - 41;
				if(hotel_ob.deluxe_singleroom[rn] != null)throw new NotAvailable();
				CustDetails(i, rn);
			}
			catch(Exception ex)
			{
				System.out.println("Invalid Option");
				return;
			}
			break;
			default :
				System.out.println("Enter valid option");
				break;
		}
		System.out.println("Room Booked");
	}
   static void features(int i)
   {
	   switch(i)
	   {
	   case 1:
		   System.out.println("Number of double beds : 1\nAc:"
				   + "Yes\nFree breakfast : Yes\nCharge per day:"
				   + "4000");
		   break;
	   case 2:
		   System.out.println("Number of double beds : 1\nAc:"
				   + "No\nFree breakfast : Yes\nCharge per day:"
				   + "3000"); 
		   break;
	   case 3:
		   System.out.println("Number of single beds : 1\nAc:"
				   + "Yes\nFree breakfast : Yes\nCharge per day:"
				   + "2200");
		   break;
	   case 4:
		   System.out.println("Number of single beds : 1\nAc:"
				   + "No\nFree breakfast : Yes\nCharge per day:"
				   + "1200");
		   break;
		   default:
			   System.out.println("Enter valid option");
			   break;
		   
	   }
   }
	static void availability (int i)
	{
		int j,count=0;
		switch (i)
		{
		case 1:
			for (j=0;j<10;j++)
			{
				if(hotel_ob.luxury_doubleroom[j]==null)
					count++;
			}
			break;
		case 2:
			for (j=0;j<hotel_ob.deluxe_doubleroom.length;j++)
			{
				if(hotel_ob.luxury_doubleroom[j]==null)
					count++;
			}
			break;
		
		}
	}
	
}
public class Hotel
{
	public static void main(String[]args)
			{
		
			}
}
 
	
	



	

