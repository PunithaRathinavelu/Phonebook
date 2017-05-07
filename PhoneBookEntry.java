import java.awt.Desktop;
import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
class PhoneBookEntry implements Serializable{
 private String FirstName;
 private String LastName;
 private String Address;
 private String EmailId;
 private String Phone;
 
 //constructor
 PhoneBookEntry(String fname, String lname, String address, String emailid, String phone){
  this.FirstName=fname;
  this.LastName=lname;
  this.Address=address;
  this.EmailId=emailid;
  this.Phone=phone;
 }
 //get first name
 public String getFirstName(){
  return FirstName;
 }
 
 //get last name
 public String getLastName(){
 return LastName;
 }
 //get address
 public String getAddress(){
 return Address;
 }
 //get email id
 public String getEmailId(){
 return EmailId;
 }
 
 //get phone number
 public String getPhone(){
  return Phone;
 }
 
 //print entry information
 public void printInfo(){
  System.out.println("First Name:"+FirstName+",Last Name:"+LastName+",Address:"+Address+",Email Id:"+EmailId+ ",Phone:"+Phone);
 }
}
