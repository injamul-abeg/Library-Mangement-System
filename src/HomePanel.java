import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class HomePanel extends JPanel {


	public HomePanel() {
		setBackground(new Color(238, 232, 170));
		setLayout(null);
		
		JLabel lblLibrary = new JLabel("Library Management System");
		lblLibrary.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLibrary.setBounds(132, 51, 330, 48);
		add(lblLibrary);
		
		JButton btnAdministrator = new JButton("Administrator");
		btnAdministrator.setForeground(new Color(255, 255, 255));
		btnAdministrator.setBackground(new Color(128, 0, 0));
		btnAdministrator.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LibraryMainFrame.showPanel("admin");
			}
		});
		btnAdministrator.setBounds(47, 142, 142, 35);
		add(btnAdministrator);
		
		JButton btnStrudent = new JButton("Student");
		btnStrudent.setForeground(new Color(255, 255, 255));
		btnStrudent.setBackground(new Color(128, 0, 0));
		btnStrudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStrudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryMainFrame.showPanel("student");
			}
		});
		btnStrudent.setBounds(47, 213, 142, 35);
		add(btnStrudent);

	}

}
