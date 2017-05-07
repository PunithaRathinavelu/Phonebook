import java.awt.Desktop;
import java.io.*;
import java.util.*;

public class PhoneBook{
 static Hashtable<String,PhoneBookEntry> phonebook; 
    public static void main(String[] args){
    phonebook=readList(); //read phonebook
    int choice;
    char con='y';
    Scanner sc=new Scanner(System.in); //create scanner object to receive choice input 
    
    while(con=='y'){
     showMenu(); //show menu
     System.out.println("Enter your choice:");
     choice=sc.nextInt();    
     switch(choice){
      case 1:addToPhoneBook();break;
      case 2:deleteFromPhonebook();break;
      case 3:viewAll();break;
      case 4:searchByName();break;
      case 5:editByName();break;
      case 6:System.exit(0);break;
      default: System.out.println("Invalid choice");
      }
    
     try{
      //prompt for continuing the program
      InputStreamReader isr=new InputStreamReader(System.in);
      System.out.println("Press y to continue:");
      con=(char)isr.read();
     }catch(IOException ie){}
    }
  }
   
   //The viewAll method displays all entries in the phonebook
   public static void viewAll(){
     if(phonebook!=null){
      for(Enumeration<String> e=phonebook.keys(); e.hasMoreElements();){
      PhoneBookEntry entry=phonebook.get(e.nextElement());
      entry.printInfo();
     }
    }
  }
   
   //The addToPhoneBook method is able to add each entry to the phonebook
   public static void addToPhoneBook(){
    //If the phonebook null, allocate memory for it so it is ready to get the new item
    if(phonebook==null) phonebook=new Hashtable<String,PhoneBookEntry>();
    try{
    	int limit=200;// limit indicates that maximum of 200 entries can be added in the phonebook
        int size= phonebook.size();
        if(size<limit){
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter first name:");
    String fname=br.readLine();   
    System.out.println("Enter last name:");
    String lname=br.readLine();
    System.out.println("Enter address:");
    String address=br.readLine();
    System.out.println("Enter email id:");
    String emailid=br.readLine(); 
    System.out.println("Enter phone:");
    String phone=br.readLine();   
    PhoneBookEntry st=new PhoneBookEntry(fname,lname,address,emailid,phone);
    phonebook.put(fname,st); //add new entry to the phonebook
    writeIt(phonebook); //save the update phonebook
        }
        else{System.out.println("Reached the limit, no more entries can be added!");}
      }catch(IOException e){}
   }
   
   //The deleteFromPhonebook method is able to delete an entry when the name
   //is correctly input
   public static void deleteFromPhonebook(){
    if(phonebook!=null){
     int si=phonebook.size(); //number of entries in the phonebook before an entry is removed
     try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     System.out.println("First Name:");
     String key=br.readLine();
     phonebook.remove(key); //remove the contact
     if(phonebook.size()<si){ //removing is successful
      writeIt(phonebook);
      System.out.println("The entry has been deleted.");
     }
     else
      System.out.println("Wrong name");
     }catch(IOException ie){}
  }
}
  
   //The searchByName method has code to find a phonebook entry by name in the list
   public static void editByName(){
    if(phonebook!=null){
     try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Edit by name:");
     String key=br.readLine();
     PhoneBookEntry cu=phonebook.get(key);
     String fname=key;
     if(cu!=null){
     System.out.println("Enter the new last name:");
     String lname=br.readLine();
     System.out.println("Enter new address:");
     String address=br.readLine();
     System.out.println("Enter new email id:");
     String emailid=br.readLine(); 
     System.out.println("Enter new phone:");
     String phone=br.readLine();   
     PhoneBookEntry st=new PhoneBookEntry(fname,lname,address,emailid,phone);
     phonebook.put(fname,st); //add new entry to the phonebook
     writeIt(phonebook); 
     System.out.println("Successfully edited!");
     }
     else
      System.out.println("Not found");
     }catch(IOException ie){}
  }
}
   
   public static void searchByName(){
	    if(phonebook!=null){
	     try{
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     System.out.println("Search by name:");
	     String key=br.readLine();
	     PhoneBookEntry cu=phonebook.get(key);
	     if(cu!=null)
	      cu.printInfo();
	     else
	      System.out.println("Not found");
	     }catch(IOException ie){}
	    }
	   }
   
   //Write the Hashtable object representing the phonebook to the file
   public static void writeIt(Hashtable<String,PhoneBookEntry> obj){
    try{
    FileOutputStream fos=new FileOutputStream("phonebook.bin");
    ObjectOutputStream oos=new ObjectOutputStream(fos);
    oos.writeObject(obj);
    oos.flush();
    oos.close();
    }catch(IOException ie){}    
   }
   
   //The readList method has code to read phonebook from the file
   
   public static Hashtable<String,PhoneBookEntry> readList(){

    Hashtable<String,PhoneBookEntry> phbook=null;
    try{
    FileInputStream fis=new FileInputStream("phonebook.bin");
    ObjectInputStream ois=new ObjectInputStream(fis);
    phbook=(Hashtable<String,PhoneBookEntry>)ois.readObject();
    ois.close();
    }catch(Exception ie){}
    return phbook;
   }

    //This method display options menu
   public static void showMenu(){
    System.out.println("1. Add to phonebook");
    System.out.println("2. Remove from phonebook");
    System.out.println("3. View all entries in phonebook");
    System.out.println("4. Search by firstname"); 
    System.out.println("5. Edit By firstname");
    System.out.println("6. Exit");
   }
}