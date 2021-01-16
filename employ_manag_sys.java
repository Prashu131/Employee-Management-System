import java.util.*;
import java.io.*;
import java.lang.*;
abstract class Manager
{
static String em_name[];
static int em_uid[];
static Scanner sc=new Scanner(System.in);
Manager()//constructor created
{
System.out.println("\tWELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM\t");
em_name=new String[100000];
em_uid=new int[100000];
}
abstract boolean check();//abstarct function 
}

class Employee extends Manager//Employee inherits base class Manager
{

void employ_add() throws IOException//fuction to add new employees
{
int n,count;
System.out.println("Enter the number of Employess whose information you want to enter:");
n=sc.nextInt();
for(count=0;count<n;count++)
{
String p="";
System.out.println("ENTER YOUR NAME");
String nm=sc.next();
p="NAME :"+nm+"\n";
System.out.println("ENTER YOUR PHONE NUMBER");
sc.nextLine();
String phno=sc.next();
p=p+"PHONE NUMBER :"+phno+"\n";
System.out.println("ENTER YOUR DATE OF BIRTH (in dd-mm-yyyy)");
sc.nextLine();
String dob=sc.next();
p=p+"DATE OF BIRTH :"+dob+"\n";
/*System.out.println("ENTER YOUR ADDRESS");
sc.next();
String add=sc.nextLine();
p=p+"ADDRESS :"+add+"\n";*/
em_name[count]=nm;
double j=Math.random()*10000;
System.out.println("EMPLOYEE ID :"+(int)j);
em_uid[count]=(int)j;
p=p+"UID :"+(int)j+"\n";
FileWriter fw=new FileWriter("emp_data.txt",true);
for (int i=0;i<p.length();i++)
{
fw.write(p.charAt(i));
}
fw.close();
System.out.println("RECORD SAVED SUCCESSFULLY");
}
}
public void employ_records(int a) throws IOException//function overloading to create the record of the employees
{
if(a==1)
{
String lr="";
System.out.println("\t WELCOME TO THE LEAVE MANAGER \t");
System.out.println("ENTER YOUR NAME");
String nm=sc.next();
System.out.println("ENTER YOUR EMPLOYEE ID");
sc.nextLine();
String uid=sc.next();
lr=lr+"EMPLOYEE ID :"+uid+"\n EMPLOYEE NAME:"+nm+"\n";
sc.nextLine();
System.out.println("ENTER THE TIME PERIOD OF THE LEAVE");
sc.next();
String date=sc.nextLine();
lr=lr+"LEAVE DATE "+date+"\n";
System.out.println("ENTER THE REASON FOR YOUR LEAVE");
//sc.next();
String re=sc.nextLine();
lr=lr+"LEAVE REASON :"+re+"\n";
FileWriter fw=new FileWriter("leave_record.txt",true);
for (int i=0;i<lr.length();i++)
{
fw.write(lr.charAt(i));
}
fw.close();
}
if(a==2)
{
String asm="";
System.out.println("\t WELCOME TO THE ADVANCE SALARY MANAGER \t");
System.out.println("ENTER YOUR NAME");
String nm=sc.next();
System.out.println("ENTER YOUR EMPLOYEE ID");
sc.nextLine();
String uid=sc.next();
asm=asm+"EMPLOYEE ID :"+uid+"\nEMPLOYEE NAME:"+nm+"\n";
System.out.println("ENTER THE ADVANCE SALARY AMOUNT");
sc.nextLine();
String advance=sc.next();
asm=asm+"ADVANCE SALARY RECEIVED "+advance+"\n";
FileWriter fr=new FileWriter("advance_record.txt");
for(int i=0;i<asm.length();i++)
{
fr.write(asm.charAt(i));
}
fr.close();
}
}
void employ_records() throws IOException//function overloading to display the records of the employees
{
System.out.println("ENTER 1 TO SEE THE EMPLOYEE RECORDS \n2 TO SEE LEAVE RECORDS \n3 TO SEE ADVANCE SALARY RECORD");
int n=sc.nextInt();
if(n==1)
{
int ch;
FileReader fr=null;
try
{
fr=new FileReader("emp_data.txt");
}
catch (FileNotFoundException fe)
{
System.out.println("FILE NOT FOUND.\nPLEASE TRY AGAIN");
}
while ((ch=fr.read())!=-1)
{
System.out.print((char)ch);
}
fr.close();
}
if(n==2) 
{
	int h;
    FileReader fv=null; 
    try
    { 
        fv = new FileReader("leave_record.txt"); 
    } 
    catch (FileNotFoundException e) 
    { 
        System.out.println("File not found.\n Please try again."); 
    }
 while ((h=fv.read())!=-1) 
        System.out.print((char)h); 
    fv.close();
}
if(n==3) 
{
	int c;
    FileReader fp=null; 
    try
    { 
        fp = new FileReader("advance_record.txt"); 
    } 
    catch (FileNotFoundException o) 
    { 
        System.out.println("File not found.\nPlease try again."); 
    }
    while ((c=fp.read())!=-1) 
        System.out.print((char)c); 
    fp.close();
}
}
boolean check()//abstract method defination checks username and password
{
	boolean tt=false,dd=false;
	Scanner sc=new Scanner(System.in);
	System.out.println("\t \t  LOGIN  \t \n");
	
	System.out.println("ENTER USERNAME");
	String pp=sc.nextLine();
	
	System.out.println("ENTER PASSCODE");
	String nn=sc.nextLine();
	if(pp.equalsIgnoreCase("vaishnavi")==true&&nn.equalsIgnoreCase("java")==true)
	{
	System.out.println("login 1 for yes or 2 for no");
	int opt=sc.nextInt();

	if(opt==1) 
	{
		tt=true;
	}
}
	else 
	System.out.println("PLEASE TRY AGAIN");
	return tt;
}
static void salary()// static function to calculate the salary of the employees
{
int salary=0;
System.out.println("ENTER YOUR NAME");
String s=sc.next();
System.out.println("ENTER YOUR EMPLOYEE ID");
String uid=sc.next();
System.out.println("ENTER YOUR DESIGNATION");
System.out.println("1.SALES DEPARTMENT \n2.TECHNICAL DEPARTMENT \n3.HR AND FINANCES \n4.WORKERS");
int n=sc.nextInt();
System.out.println("ENTER THE NUMBER OF LEAVES");
int l=sc.nextInt();
if(n==1)
{
salary=(30-l)*500;
}
else if(n==2)
{
salary=(30-l)*750;
}
else if(n==3)
{
salary=(30-l)*1000;
}
else if(n==4)
{
salary=(30-l)*150;
}
System.out.println("YOUR SALARY ="+salary);
}
}
class Management extends Employee//inherits the properties of base class Employee
{
public static void main(String args[])
{
Employee obj=new Management();//object creation
boolean b=obj.check();//returns tru if correct login else false
if(b==true) 
{
System.out.println("\t \t Enter 1 to see records menu ");
System.out.println("\t \t Enter 2 to register as an Employee");
System.out.println("\t \t Enter 3 to register a Leave or an Advance ");
System.out.println("\t \t Enter 4 to know your salary of the month irrespective of the advance");
int n=sc.nextInt();
if(n==1) 
{
try 
{
	obj.employ_records();
}
catch(IOException g) 
{
	System.out.println("error occured");
}
}
if(n==2) 
{
try
{
obj.employ_add();
}
catch(IOException e) 
{
	System.out.println("error occured");
}
}
if(n==3) 
{
	System.out.println("Enter 1 to register leave record and enter 2 to register advance record");
	int o=sc.nextInt();
try {
obj.employ_records(o);
}
catch(IOException f)
{
	System.out.println("error occured");
}
}
if(n==4)
{
salary();
}
}
else 
{
	System.out.println("YOU ARE NOT AN EMPLOYEE");
}
}
}


