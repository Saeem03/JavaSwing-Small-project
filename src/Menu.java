import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu {
	private JFrame frame;
	public Menu() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 770, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton add_btn_menu = new JButton("Add");
		add_btn_menu.setBackground(Color.DARK_GRAY);
		add_btn_menu.setForeground(Color.RED);
		add_btn_menu.setFont(new Font("Tahoma", Font.BOLD, 14));
		add_btn_menu.setBounds(236, 138, 225, 42);
		add_btn_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Add();
			}
		});
		frame.getContentPane().add(add_btn_menu);
		
		JButton btnShowAllContacts = new JButton("Show All Contacts");
		btnShowAllContacts.setBackground(Color.DARK_GRAY);
		btnShowAllContacts.setForeground(Color.RED);
		btnShowAllContacts.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnShowAllContacts.setBounds(236, 212, 225, 42);
		btnShowAllContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ShowAll();
			}
		});
		frame.getContentPane().add(btnShowAllContacts);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.DARK_GRAY);
		btnSearch.setForeground(Color.RED);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(236, 289, 225, 42);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Search();
			}
		});
		frame.getContentPane().add(btnSearch);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(Color.DARK_GRAY);
		btnEdit.setForeground(Color.RED);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setBounds(236, 370, 225, 42);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Edit();
			}
		});
		frame.getContentPane().add(btnEdit);
		
		JLabel lblNewLabel = new JLabel("                 Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(173, 38, 325, 55);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
}
