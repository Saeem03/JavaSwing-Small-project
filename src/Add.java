import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Add {

	private JFrame frame;
	private JTextField name_txt_add;
	private JTextField phone_txt_add;
	private JTextField email_txt_add;
	private JTextField address_txt_add;
	public static File info = new File("Info.txt");
	FileWriter fw;
	JLabel message_add;
	public Add() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 770, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("         Name");
		lblNewLabel.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(94, 158, 136, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPhoneNo = new JLabel("         Phone No");
		lblPhoneNo.setForeground(SystemColor.inactiveCaptionText);
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhoneNo.setBackground(Color.DARK_GRAY);
		lblPhoneNo.setBounds(94, 209, 136, 28);
		frame.getContentPane().add(lblPhoneNo);
		
		JLabel lblNewLabel_1_1 = new JLabel("         Email");
		lblNewLabel_1_1.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1_1.setBounds(94, 263, 136, 28);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("         Address");
		lblNewLabel_1_1_1.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1_1_1.setBounds(94, 326, 136, 28);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		name_txt_add = new JTextField();
		name_txt_add.setBounds(264, 160, 239, 28);
		frame.getContentPane().add(name_txt_add);
		name_txt_add.setColumns(10);
		
		phone_txt_add = new JTextField();
		phone_txt_add.setColumns(10);
		phone_txt_add.setBounds(264, 209, 239, 28);
		frame.getContentPane().add(phone_txt_add);
		
		email_txt_add = new JTextField();
		email_txt_add.setColumns(10);
		email_txt_add.setBounds(264, 263, 239, 28);
		frame.getContentPane().add(email_txt_add);
		
		address_txt_add = new JTextField();
		address_txt_add.setColumns(10);
		address_txt_add.setBounds(264, 326, 239, 28);
		frame.getContentPane().add(address_txt_add);
		
		message_add = new JLabel("");
		message_add.setBounds(555, 158, 100, 28);
		frame.getContentPane().add(message_add);
		JButton add_btn_add = new JButton("Add");
		add_btn_add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add_btn_add.setBounds(389, 378, 114, 33);
		add_btn_add.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			message_add.setText("");
			try {
				Scanner sc  = new Scanner(info);
				while(sc.hasNext()) {
					String line = sc.nextLine();
					String words[] = line.split(",");
					if(words[0].equals(name_txt_add.getText())) {
						message_add.setText("Name is already in use.");
						sc.close();
						return;
					}
				}
				sc.close();
				Person p = new Person();
				p.name = name_txt_add.getText();
				p.phoneNo = Long.parseLong(phone_txt_add.getText());
				p.emailAddress =  email_txt_add.getText();
				p.address =address_txt_add.getText();
				fw = new FileWriter(info,true);
				fw.write(p.commaInfo()+"\n");
				fw.close();
				JOptionPane.showMessageDialog( null, "Contact added!" );
				frame.dispose();
				new Add();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}});
		frame.getContentPane().add(add_btn_add);
		
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
		
		
		frame.setVisible(true);
	}
}
