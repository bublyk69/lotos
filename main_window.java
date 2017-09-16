import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.DateFormatter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class main_window extends JFrame{
	static JTextField name,surname,fathername,dateofbirth,dateofvisit,phone,mail;
	static JButton ok,close,viewlist;
	
	

public  main_window() throws FileNotFoundException, IOException, ParseException{
	// making frame
	
	JSONParser parser = new JSONParser();
	Object object = parser.parse(new FileReader("d:\\test.json"));
	JSONArray list = (JSONArray) object;
	JTabbedPane tabs = new JTabbedPane();
	JFrame frame = new JFrame("crm");
	frame.setSize(750, 600);
	JPanel panel = new JPanel(); 
	JPanel customers = new JPanel();
	panel.setPreferredSize(new Dimension(650,500));
	frame.add(tabs);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	panel.setPreferredSize(frame.getSize());
	tabs.add("1", panel);
	tabs.addTab("2", customers);
	
	frame.setLocationRelativeTo(null);
    frame.setVisible(true);
	String data[][] = {{"andr","honchar","bogdanov","19bubl99","093249","0921371","31318"},

	};
	String columns[] = {"name", "surname","fathername", "mail", "phone", "visit date", "birthdate"};
    JTable customerList = new JTable(data, columns);
    //customerList.setBounds(10, 10, 700, 500);
    //customerList.setSize(600, 600);
    
    JScrollPane sp = new JScrollPane(customerList); 
    sp.setPreferredSize(new Dimension(600,500));
    customers.add(sp);
    
    
	
	
	
	name = new JTextField("Input your name");
	name.setToolTipText("Input your name");
	name.setBounds(20, 20, 200, 30);
	panel.add(name);
	name.setFocusTraversalKeysEnabled(false);
	name.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(name.getText().equals("Input your name")){
				name.setText("");
			}
		}
	});
	name.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == e.VK_TAB){
				surname.requestFocus();
			}
		}
	});
	surname = new JTextField("Input your surname");
	surname.setBounds(20,60, 200,30);
	surname.setToolTipText("Input your surname");
	panel.add(surname);
	surname.setFocusTraversalKeysEnabled(false);
	surname.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(surname.getText().equals("Input your surname")){
				surname.setText("");
			}
		}
	});
	surname.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == e.VK_TAB){
				fathername.requestFocus();
			}
		}
	});
	fathername = new JTextField("Input your fathername");
	fathername.setBounds(20,100, 200,30);
	fathername.setToolTipText("Input your fathername");
	panel.add(fathername);
	fathername.setFocusTraversalKeysEnabled(false);
	fathername.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(fathername.getText().equals("Input your fathername")){
				fathername.setText("");
			}
		}
	});
	fathername.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == e.VK_TAB){
				phone.requestFocus();
			}
		}
	});
		
	dateofbirth = new JTextField("Input your date of birth");
	dateofbirth.setBounds(350,20, 130,30);
	dateofbirth.setToolTipText("Input date of your birth");
	panel.add(dateofbirth);
	dateofbirth.setFocusTraversalKeysEnabled(false);
	dateofbirth.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(dateofbirth.getText().equals("Input your date of birth")){
				dateofbirth.setText("");
			}
		}
	});
	dateofbirth.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == e.VK_TAB){
				dateofvisit.requestFocus();
			}
		}
	});
	
	dateofvisit = new JTextField("Input your date of visit");
	dateofvisit.setBounds(350,60, 130,30);
	dateofvisit.setToolTipText("Input date of your visit");
	panel.add(dateofvisit);
	dateofvisit.setFocusTraversalKeysEnabled(false);
	dateofvisit.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(dateofvisit.getText().equals("Input your date of visit")){
				dateofvisit.setText("");
			}
		}
	});
	dateofvisit.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == e.VK_TAB){
				close.requestFocus();
			}
		}
	});
	
	phone = new JTextField("Input your phone number");
	phone.setBounds(20,220, 200,30);
	phone.setToolTipText("Input your phone number");
	panel.add(phone);
	phone.setFocusTraversalKeysEnabled(false);
	phone.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			 if(phone.getText().equals("Input your phone number")){
				 phone.setText("");
			 }
		}
	});
	phone.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == e.VK_TAB){
				mail.requestFocus();
			}
		}
	});
	
	mail = new JTextField("Input your e-mail");
	mail.setBounds(20,260, 200,30);
	mail.setToolTipText("Input your e-mail");
	panel.add(mail);
	mail.setFocusTraversalKeysEnabled(false);
	mail.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(mail.getText().equals("Input your e-mail")){
				mail.setText("");
			}
		}
	});
	mail.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == e.VK_TAB){
				dateofbirth.requestFocus();
			}
		}
	});
	
	ok = new JButton("OK");
	ok.setBounds(0, 450, 650, 50);
	panel.add(ok);
	ok.setFocusTraversalKeysEnabled(false);
	ok.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == e.VK_TAB){
				name.requestFocus();
			}
		}
	});
	ok.addMouseListener(new MouseListener() {
		public void mouseReleased(MouseEvent e){}
		public void mousePressed(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {
		    JSONObject obj = new JSONObject();
		    obj.put("name", name.getText());
		      obj.put("surname", surname.getText());
		      obj.put("date1", dateofbirth.getText());
		      obj.put("fathername", fathername.getText());
		      obj.put("date2", dateofvisit.getText());
		      obj.put("phone", phone.getText());
		      obj.put("mail", mail.getText());
		      name.setText("");
		      surname.setText("");
		      fathername.setText("");
		      dateofvisit.setText("");
		      dateofbirth.setText("");
		      phone.setText("");
		      mail.setText("");
		      list.add(obj);
		      System.out.println(list);
		      try (FileWriter file = new FileWriter("d:\\test.json")) {
		              file.write(list.toString());
		              file.flush();
		          } catch (IOException e1) {
		              e1.printStackTrace();
		          }
		    
			try (FileWriter file = new FileWriter("d:\\test.json")) {
	            file.write(list.toString());
	            file.flush();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
		}
	});
	
	close = new JButton("close");
	close.setSize(100, 50);
	close.setLocation(400, 250);
	close.addActionListener(e -> System.exit(0));
	panel.add(close);
	close.setFocusTraversalKeysEnabled(false);
	close.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == e.VK_TAB){
				ok.requestFocus();
			}
		}
	});
	
	
	frame.setPreferredSize(new Dimension(750, 601));
    frame.pack();
    
    
}

}
