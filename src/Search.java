import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
public class Search {

	private JFrame frame;
	private JTextField search_txt_Search;
	Person p;
	JTextPane result_search ;

	public Search() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 770, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("         Name");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(126, 198, 136, 28);
		frame.getContentPane().add(lblNewLabel);
		
		search_txt_Search = new JTextField();
		search_txt_Search.setColumns(10);
		search_txt_Search.setBounds(286, 196, 239, 37);
		frame.getContentPane().add(search_txt_Search);
		
		JButton search_btn_search = new JButton("Search");
		search_btn_search.setFont(new Font("Tahoma", Font.BOLD, 14));
		search_btn_search.setBounds(286, 271, 239, 43);
		search_btn_search.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Scanner sc;
					p = new Person();
					try {
						sc = new Scanner(Add.info);
						while(sc.hasNext()) {
							String words[] = sc.nextLine().split(",");
							if(words[0].equals(search_txt_Search.getText())) {
								p = new Person(words[0],Long.parseLong(words[1]),words[2],words[3]);
								break;
							}
						}
						sc.close();
						if(p.name.equals("")) {
							JOptionPane.showMessageDialog( null, "Contact not found!" );
							result_search.setText("");
							return;
						}
						result_search.setText(p.toString()+"\n");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
		});
		frame.getContentPane().add(search_btn_search);
		
		result_search = new JTextPane();
		result_search.setBounds(126, 359, 593, 160);
		frame.getContentPane().add(result_search);
		
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
