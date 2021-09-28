import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class Edit {

	private JFrame frame;
	private JTextField input_txt;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	int lineNumber;
	Person p;
	public Edit() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 770, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton goTo_Menu = new JButton("Back");
		goTo_Menu.setFont(new Font("Tahoma", Font.BOLD, 14));
		goTo_Menu.setBounds(10, 11, 142, 41);
		goTo_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Menu();
			}
		});
		frame.getContentPane().add(goTo_Menu);
		
		input_txt = new JTextField();
		input_txt.setColumns(10);
		input_txt.setBounds(314, 58, 239, 28);
		frame.getContentPane().add(input_txt);
		
		JLabel lblSearchName = new JLabel(" Search  Name");
		lblSearchName.setForeground(Color.BLACK);
		lblSearchName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearchName.setBackground(Color.DARK_GRAY);
		lblSearchName.setBounds(168, 58, 136, 28);
		frame.getContentPane().add(lblSearchName);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(46, 164, 670, 358);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("         Name");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(103, 32, 136, 28);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(273, 34, 239, 28);
		panel.add(textField);
		
		JLabel lblPhoneNo = new JLabel("         Phone No");
		lblPhoneNo.setForeground(Color.BLACK);
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhoneNo.setBackground(Color.DARK_GRAY);
		lblPhoneNo.setBounds(103, 83, 136, 28);
		panel.add(lblPhoneNo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(273, 83, 239, 28);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("         Email");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1_1.setBounds(103, 137, 136, 28);
		panel.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(273, 137, 239, 28);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("         Address");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1_1_1.setBounds(103, 200, 136, 28);
		panel.add(lblNewLabel_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(273, 200, 239, 28);
		panel.add(textField_3);
		
		JButton edit_btn_edit = new JButton("Edit");
		edit_btn_edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		edit_btn_edit.setBounds(332, 262, 180, 45);
		edit_btn_edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Person();
				Scanner sc ;
				String out="";
				out+=textField.getText()+",";
				out+=textField_1.getText()+",";
				out+=textField_2.getText()+",";
				out+=textField_3.getText();
				System.out.println(out);
				try {
					sc = new Scanner(Add.info);
					int c=1;
					while(sc.hasNext()) {
						String words[]=sc.nextLine().split(",");
						if(c!=lineNumber && words[0].equals(textField.getText())) {
							JOptionPane.showMessageDialog( null, "Name already in use!" );
							sc.close();
							return;
						}
						c++;
					}
					sc.close();
					sc = new Scanner(Add.info);
					FileWriter fw = new FileWriter(new File("temp.txt"));
					int count=1;
					while(sc.hasNext()) {
						String line = sc.nextLine();
						if(count==lineNumber) {
							line = out;
						}
						fw.write(line+"\n");
						count++;
					}
					fw.close();
					sc.close();
					sc = new Scanner(new File("temp.txt"));
					fw = new FileWriter(Add.info);
					while(sc.hasNext()) {
						fw.write(sc.nextLine()+"\n");
					}
					sc.close();
					fw.close();
					JOptionPane.showMessageDialog( null, "Edit was successful!" );
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		panel.add(edit_btn_edit);
		
		JButton search_btn_Edit = new JButton("Search ");
		search_btn_Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		search_btn_Edit.setBounds(373, 108, 180, 45);
		search_btn_Edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean found=false;
				try {
					Scanner sc = new Scanner(Add.info);
					lineNumber=1;
					while(sc.hasNext()) {
						String[] words = sc.nextLine().split(",");
						if(words[0].equals(input_txt.getText())) {
							p = new Person(words[0],Long.parseLong(words[1]),words[2],words[3]);
							textField.setText(p.name);
							textField_1.setText("0"+p.phoneNo);
							textField_2.setText(p.emailAddress);
							textField_3.setText(p.address);
							found=true;
							break;
						}
						lineNumber++;
					}
					sc.close();
					if(found) {
						panel.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog( null, "Name was not found!" );
						panel.setVisible(false);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		frame.getContentPane().add(search_btn_Edit);
		
		frame.setVisible(true);
	}
}
