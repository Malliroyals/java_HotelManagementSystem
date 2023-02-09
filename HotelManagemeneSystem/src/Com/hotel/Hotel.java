package Com.hotel;

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

class NotAvaiable extends Exception
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
		
		System.out.println("\nEnter customer gender: ");
		gender = input.next();
	}

}
public class Hotel 
{
	public static void main(String[] args) 
	{

	}
}

	


