import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JPanel {
	private JTextField userName;
	private JPasswordField password;

	
	public AdminPanel() {
		setBackground(new Color(119, 136, 153));
		setLayout(null);

		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdmin.setBounds(91, 118, 73, 28);
		add(lblAdmin);

		userName = new JTextField();
		userName.setBounds(174, 119, 154, 28);
		add(userName);
		userName.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(91, 182, 73, 22);
		add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (userName.getText().equals("admin") && new String(password.getPassword()).equals("admin")) {
					LibraryMainFrame.showPanel("adminOptionPanel");
				} else {
					JOptionPane.showMessageDialog(null, "password does not match!");
				}

			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(317, 281, 89, 28);
		add(btnLogin);

		password = new JPasswordField();
		password.setBounds(174, 180, 154, 28);
		add(password);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryMainFrame.showPanel("home");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(54, 282, 89, 27);
		add(btnNewButton);

	}
}
