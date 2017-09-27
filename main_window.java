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
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
	JFrame frame = new JFrame("Облік пацієнтів 'Лотос'");
	frame.setSize(750, 600);
	JPanel panel = new JPanel(); 
	JPanel customers = new JPanel();
	frame.add(tabs);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.add(panel, BorderLayout.CENTER);
	tabs.add("Форма для вводу", panel);
	tabs.addTab("Список пацієнтів", customers);
	frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    panel.setLayout(null);
    customers.setLayout(null);
    
    DefaultTableModel model = new DefaultTableModel(); 
	// Create a couple of columns 
	model.addColumn("Ім'я"); 
	model.addColumn("Прізвище"); 
	model.addColumn("По-батькові");
	model.addColumn("Моб.тел");
	model.addColumn("e-mail");
	model.addColumn("Дата народження");
	model.addColumn("Дата візиту");
	// Append a row 
	JTable customerList = new JTable(model);  
	final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
    customerList.setRowSorter(sorter);
    JScrollPane sp = new JScrollPane(customerList); 
    customers.add(sp);
    sp.setBounds(5, 50, 720, 500);
    JButton delBtn = new JButton("Видалити");
    customers.add(delBtn);
    delBtn.setBounds(628,10,100,30);
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
    
    JButton findBtn = new JButton("Знайти");
    customers.add(findBtn);
    findBtn.setBounds(215, 10, 110, 30);
    
    JTextField filterText = new JTextField("");
    filterText.setBounds(326, 12, 100, 26);
    customers.add(filterText, BorderLayout.CENTER);
    findBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String text = filterText.getText();
	        if (text.length() == 0) {
	          sorter.setRowFilter(null);
	        } else {
	          sorter.setRowFilter(RowFilter.regexFilter(text));
	          
	        }
		}
	});
    
    JButton clear = new JButton("Очистити");
    customers.add(clear);
    clear.setBounds(426, 10, 110, 30);
    clear.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e){
    		sorter.setRowFilter(RowFilter.regexFilter(""));
    		filterText.setText("");
		}
	});
    
    if (!(list.isEmpty())) {
    	
    	for(int i = 0; i < list.size(); i++)
    	{
    		JSONObject obj = (JSONObject) list.get(i);
    		model.addRow(new Object[]{obj.get("name"), obj.get("surname"), obj.get("fathername"), obj.get("phone"), obj.get("mail"), obj.get("date1"), obj.get("date2")});
    	}
    }
	
	name = new JTextField("Введіть ім'я пацієнта");
	name.setToolTipText("Введіть ім'я пацієнта");
	name.setBounds(70, 60, 200, 30);
	panel.add(name);
	name.setFocusTraversalKeysEnabled(false);
	name.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(name.getText().equals("Введіть ім'я пацієнта")){
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
	
	surname = new JTextField("Введіть прізвище пацієнта");
	surname.setBounds(70,100, 200,30);
	surname.setToolTipText("Введіть прізвище пацієнта");
	panel.add(surname);
	surname.setFocusTraversalKeysEnabled(false);
	surname.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(surname.getText().equals("Введіть прізвище пацієнта")){
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

	fathername = new JTextField("Введіть по-батькові пацієнта");
	fathername.setBounds(70,140, 200,30);
	fathername.setToolTipText("Input your fathername");
	panel.add(fathername);
	fathername.setFocusTraversalKeysEnabled(false);
	fathername.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(fathername.getText().equals("Введіть по-батькові пацієнта")){
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
		
	dateofbirth = new JTextField("Введіть дату народження пацієнта");
	dateofbirth.setBounds(400,60, 200,30);
	dateofbirth.setToolTipText("Введіть дату народження пацієнта");
	panel.add(dateofbirth);
	dateofbirth.setFocusTraversalKeysEnabled(false);
	dateofbirth.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(dateofbirth.getText().equals("Введіть дату народження пацієнта")){
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
	
	dateofvisit = new JTextField("Введіть дату останнього візиту");
	dateofvisit.setBounds(400,100, 200,30);
	dateofvisit.setToolTipText("Введіть дату останнього візиту");
	panel.add(dateofvisit);
	dateofvisit.setFocusTraversalKeysEnabled(false);
	dateofvisit.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(dateofvisit.getText().equals("Введіть дату останнього візиту")){
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
	
	phone = new JTextField("Введіть номер телефону пацієнта");
	phone.setBounds(70,260, 200,30);
	phone.setToolTipText("Введіть номер телефону пацієнта");
	panel.add(phone);
	phone.setFocusTraversalKeysEnabled(false);
	phone.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			 if(phone.getText().equals("Введіть номер телефону пацієнта")){
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
	
	mail = new JTextField("Введіть e-mail пацієнта");
	mail.setBounds(70,300, 200,30);
	mail.setToolTipText("Введіть e-mail пацієнта");
	panel.add(mail);
	mail.setFocusTraversalKeysEnabled(false);
	mail.addFocusListener(new FocusListener() {
		public void focusLost(FocusEvent e) {}
		public void focusGained(FocusEvent e) {
			if(mail.getText().equals("Введіть e-mail пацієнта")){
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
	ok.setBounds(0, 450, 730, 50);
	panel.add(ok);
	ok.setLocation(0, 485);

	ok.setFocusTraversalKeysEnabled(false);
	ok.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == e.VK_ENTER){
				JSONObject obj = new JSONObject();
			    obj.put("name", name.getText());
			    obj.put("surname", surname.getText());
			    obj.put("date1", dateofbirth.getText());
			    obj.put("fathername", fathername.getText());
			    obj.put("date2", dateofvisit.getText());
			    obj.put("phone", phone.getText());
			    obj.put("mail", mail.getText());
			    for(int i = 0; i < list.size(); i++)
				{
					JSONObject newobj = (JSONObject) list.get(i);
					if(name.getText().equals(newobj.get("name").toString()) && surname.getText().equals(newobj.get("surname").toString()) && fathername.getText().equals(newobj.get("fathername").toString())) {
						list.remove(i);
						model.removeRow(i);
						break;
					}
				}
			    model.addRow(new Object[]{name.getText(), surname.getText(), fathername.getText(), phone.getText(), mail.getText(), dateofbirth.getText(), dateofvisit.getText()});
			    list.add(obj);
			    try (FileWriter file = new FileWriter("d:\\test.json")) {
			    	file.write(list.toString());
			    	file.flush();
			    } catch (IOException e1) {
			    	e1.printStackTrace();
			    }
			    name.setText("Введіть ім'я пацієнта");
			    surname.setText("Введіть прізвище пацієнта");
			    fathername.setText("Введіть по-батькові пацієнта");
			    dateofvisit.setText("Введіть дату останнього візиту");
			    dateofbirth.setText("Введіть дату народження пацієнта");
			    phone.setText("Введіть номер телефону пацієнта");
			    mail.setText("Введіть e-mail пацієнта");
			}
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
		    for(int i = 0; i < list.size(); i++)
			{
				JSONObject newobj = (JSONObject) list.get(i);
				if(name.getText().equals(newobj.get("name").toString()) && surname.getText().equals(newobj.get("surname").toString()) && fathername.getText().equals(newobj.get("fathername").toString())) {
					list.remove(i);
					model.removeRow(i);
					break;
				}
			}
		    model.addRow(new Object[]{name.getText(), surname.getText(), fathername.getText(), phone.getText(), mail.getText(), dateofbirth.getText(), dateofvisit.getText()});
		    list.add(obj);
		    try (FileWriter file = new FileWriter("d:\\test.json")) {
		    	file.write(list.toString());
		    	file.flush();
		    } catch (IOException e1) {
		    	e1.printStackTrace();
		    }
		    name.setText("Введіть ім'я пацієнта");
		    surname.setText("Введіть прізвище пацієнта");
		    fathername.setText("Введіть по-батькові пацієнта");
		    dateofvisit.setText("Введіть дату останнього візиту");
		    dateofbirth.setText("Введіть дату народження пацієнта");
		    phone.setText("Введіть номер телефону пацієнта");
		    mail.setText("Введіть e-mail пацієнта");
		}
	});
	
	close = new JButton("Закрити");
	close.setBounds(400, 280,200,50);
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
    for(int i = 0; i < list.size(); i++)
	{
		JSONObject obj = (JSONObject) list.get(i);
		if(obj.get("mail").toString()!="") {
		      checker(obj.get("name").toString() , obj.get("fathername").toString() , obj.get("date1").toString() , obj.get("date2").toString() , obj.get("mail").toString());
		    }
	}
}
}
