/**
 * CSCI1130 Assignment 4 Phone Book Caller
 *
 * I declare that the assignment here submitted is original
 * except for source material explicitly acknowledged,
 * and that the same or closely related material has not been
 * previously submitted for another course.
 * I also acknowledge that I am aware of university policy and
 * regulations on honesty in academic work, and of the disciplinary
 * guidelines and procedures applicable to breaches of such
 * policy and regulations, as contained in the website.
 *
 * University Guideline on Academic Honesty:
 *   http://www.cuhk.edu.hk/policy/academichonesty
 * Faculty of Engineering Guidelines to Academic Honesty:
 *   https://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 *
 * Student Name  : Cheng Ka Pui
 * Student ID    : 1155125534
 * Date          : 03/11/2019
 */
package phonebookcaller;
import java.util.HashMap;
import javax.swing.*;
import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
/**
 *
 * @author Cheng Ka Pui
 */
public class PhoneBookCaller {

    /**
     * @param args the command line arguments
     */
 private static String dialogQuestionMarkIconImageFilename = "question-mark1451232961b8W_from_publicdomainpictures.net_en_images=142577.gif";
 private HashMap<String, String> phoneBook; // a String-String mapping type
 private void clearAndSetupDefaultPhoneBook()
 {
 // drops, if any, existing phone book and creating a new one
 phoneBook = new HashMap<>();
 addContact("Rocky", "39437000");
 addContact("Kitty", "852-87654321");
 addContact("Betty", "(853) 91239123");
 addContact("Donald", "(86)-90018900");
 addContact("Roy", "+886 51903481");
 addContact("Shelly", "85271237890");
 }
 /**
 * Show all contacts in the phone book on System.out in some order AND
 * @return a String representation of the phone book in a HTML table
 */
 public String showAllContacts()
 {
 String table = "<table>";
 table += "<tr>";
 table += "<td>Name<td>Phone";
 table += "</tr>";

// for-each: iterating all records in the phoneBook which is a HashMap
 for (String name : phoneBook.keySet()) {
 // String name will loop through all names (keys)
 String phone = phoneBook.get(name);
 table += "<tr>";
 table += "<td>" + name + "<td>" + phone;
 table += "</tr>";
 }
 table += "</table><hr>";

 System.out.printf("%-20s %s\n", "Name", "Phone");
 System.out.printf("-------------------- --------------\n");
 /*** student's work here to print the phone book on System.out ***/
 for (String name : phoneBook.keySet()) {   //printing the table in the console
 // String name will loop through all names (keys)
    String phone = phoneBook.get(name);
    System.out.printf("%-20s %s\n", name, phone);
 }
 return table; // a String representation of the phone book in HTML
 }
 /**
 * Show a menu of choices and get user's input
 * @return an integer value: 0 means Quit, and options 1, 2, ...
 */
 public int showMenu()
 {
 String menuHTML = "<html>";
 menuHTML += showAllContacts();
 menuHTML += "Please pick an action:<hr>";
 menuHTML += "0. Quit<br>";
 menuHTML += "1. Add contact<br>";
 menuHTML += "2. Make a call<br>";
 menuHTML += "3. Clear ALL contact<br>";
 menuHTML += "4. Save ALL contact<br>";
 menuHTML += "</html>";
 String[] options = {"Quit", "Add", "Call", "Clear", "Save"};

 ImageIcon icon = new ImageIcon(dialogQuestionMarkIconImageFilename);
 int choice = JOptionPane.showOptionDialog(null, menuHTML,
this.getClass().getSimpleName(), 0, 0, icon, options, null);
 if (choice == JOptionPane.CLOSED_OPTION) // CLOSED_OPTION = -1
 choice = 0;
 System.out.println("Choice: " + choice);
 return choice;
 }
 public void addContact(String name, String phone) { //add the contact name and phone number
     name = name.toUpperCase();
     phoneBook.put(name,phone);
 }
 public void call(String name) {
System.out.print("Calling "+name+":"); //name is the input name
name = name.toUpperCase(); //change the input name into uppercase 
 String phone = phoneBook.get(name);    //match the uppercase name with corresponding phone number
 // When calling a number, "dial" each digit by playing the corresponding given MP3 recording file:
//"DTMF_DialTone_MP3/DTMF-n.mp3" where n is a digit in 0 – 9.
	for (int i = 0; i < phone.length() ; i++){
            char n = phone.charAt(i);
            if ((n >= '0') && (n <= '9')){
                playMP3File("DTMF_DialTone_MP3/DTMF-"+n+".mp3"); //echo the calling digit
                System.out.print(" "+n);
            }
        }
        System.out.println();
 }
 
 public void savePhoneBook(String filename) {
try {
    PrintStream book = new PrintStream(filename); 
    for (String name : phoneBook.keySet()) {
 // String name will loop through all names (keys)
    String phone = phoneBook.get(name);
    book.println(name);
    book.println(phone);
 }
}
    catch(FileNotFoundException e){ //for any exception
    System.out.print("File writing error!!");
}   
 }
 public static void playMP3File(String filename) {
 // try-catch...
 try{
 FileInputStream mp3Stream = new FileInputStream(filename);
 AdvancedPlayer mp3Player = new AdvancedPlayer(mp3Stream);
 mp3Player.play();}
    catch(FileNotFoundException | JavaLayerException e){ //for exception
     System.out.print("Cannot find the audio file!");}
 }
public static void main(String[] args) {
        PhoneBookCaller pbc = new PhoneBookCaller(); 
        pbc.clearAndSetupDefaultPhoneBook(); 
        boolean flag = true;    
        playMP3File("DTMF_DialTone_MP3/DialTone.mp3");//welcome
        while (flag){
        int choices = pbc.showMenu();
        switch(choices){
        case 0 ://quit
            playMP3File("DTMF_DialTone_MP3/DTMF-0.mp3");
            flag = false;
            break; 
        case 1 ://add
            playMP3File("DTMF_DialTone_MP3/DTMF-1.mp3");
            String newname = JOptionPane.showInputDialog("Name");
            if ((newname != null) && (!(newname.isBlank()))){
                String newphone = JOptionPane.showInputDialog("Phone");
                if((newphone != null) && (!(newphone.isBlank()))){
                    pbc.addContact(newname, newphone);
                        }
                    }                     
            break; 
        case 2: //call
            playMP3File("DTMF_DialTone_MP3/DTMF-2.mp3");
            String callname = JOptionPane.showInputDialog("Who to call?");
            pbc.call(callname);
            break;
        case 3 ://clear
            playMP3File("DTMF_DialTone_MP3/DTMF-3.mp3");
            int result =JOptionPane.showConfirmDialog(null,"Are you sure?","Clear ALL contact",JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {pbc.clearAndSetupDefaultPhoneBook();}
            break; 
        case 4 ://save
            playMP3File("DTMF_DialTone_MP3/DTMF-4.mp3");
            pbc.savePhoneBook("phonebook.txt");
            break; 
            }
        }       
    }    
}
