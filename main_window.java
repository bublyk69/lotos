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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class main_window extends date_manager{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	frame.add(tabs);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	tabs.add("1", panel);
	tabs.addTab("2", customers);
	frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    DefaultTableModel model = new DefaultTableModel(); 
	// Create a couple of columns 
	model.addColumn("name"); 
	model.addColumn("surname"); 
	model.addColumn("fathername");
	model.addColumn("phone");
	model.addColumn("e-mail");
	model.addColumn("date of birth");
	model.addColumn("date of visit");
	// Append a row 
	JTable customerList = new JTable(model);  
    JScrollPane sp = new JScrollPane(customerList); 
    sp.setPreferredSize(new Dimension(600,500));
    customers.add(sp);
    JButton delBtn = new JButton("delete");
    customers.add(delBtn);
    delBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int selRow = customerList.getSelectedRow();
            if(selRow != -1) {
                model.removeRow(selRow);
               list.remove(selRow);
               try (FileWriter file = new FileWriter("d:\\test.json")) {
   	            file.write(list.toString());
   	            file.flush();
   	        	} catch (IOException e1) {
   	        		e1.printStackTrace();
   	        	}
            }
        }
    });
    if (!(list.isEmpty())) {
    	
    	for(int i = 0; i < list.size(); i++)
    	{
    		JSONObject obj = (JSONObject) list.get(i);
    		model.addRow(new Object[]{obj.get("name"), obj.get("surname"), obj.get("fathername"), obj.get("phone"), obj.get("e-mail"), obj.get("date1"), obj.get("date2")});
    		checker(obj.get("name").toString() , obj.get("fathername").toString() , obj.get("date1").toString() , obj.get("mail").toString());
    	}
    	
    }
	
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
		public void keyPressed(KeyEvent e){
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
		    model.addRow(new Object[]{name.getText(), surname.getText(), fathername.getText(), phone.getText(), mail.getText(), dateofbirth.getText(), dateofvisit.getText()});
		    name.setText("");
		    surname.setText("");
		    fathername.setText("");
		    dateofvisit.setText("");
		    dateofbirth.setText("");
		    phone.setText("");
		    mail.setText("");
		    list.add(obj);
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
