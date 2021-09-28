
import javax.swing.JFrame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class ShowAll {

	private JFrame frame;

	public ShowAll() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 770, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TextArea result_txtArea_showAll = new TextArea();
		result_txtArea_showAll.setBounds(78, 152, 564, 377);
		ArrayList<Person> list = new ArrayList<>();
		try {
			Scanner sc =new Scanner(Add.info);
			while(sc.hasNext()) {
				String words[] = sc.nextLine().split(",");
				list.add(new Person(words[0],Long.parseLong(words[1]),words[2],words[3]));
			}
			sc.close();
			Collections.sort(list,new Comparator<Person>() {
				@Override
				public int compare(Person o1, Person o2) {
					if(o1.phoneNo>o2.phoneNo)
						return 1;
					else if(o1.phoneNo<o2.phoneNo)
						return -1;
					else 
						return 0;
				}
			});
			for(int i=0;i<list.size();i++){
				result_txtArea_showAll.append(list.get(i).toString()+"\n\n");
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		frame.getContentPane().add(result_txtArea_showAll);
		
		JLabel lblNewLabel = new JLabel("                         All Contact");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(140, 98, 405, 48);
		frame.getContentPane().add(lblNewLabel);
		
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
