import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentPanel extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public StudentPanel() {
		setBackground(new Color(119, 136, 153));
		setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentId.setBounds(99, 137, 78, 25);
		add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(212, 139, 175, 23);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(101, 203, 64, 23);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 205, 175, 21);
		add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name= textField.getText().toString();
				String pass=String.valueOf(passwordField.getPassword());
					if (name.equals("student")&&pass.equals("student")) {
						JOptionPane.showMessageDialog(null, "Login Success");
						//LibraryMainFrame.showPanel("bookListPanel");
						BookList.setModelAbeg(Dao.getBookListDataInTableModelForm());
						LibraryMainFrame.showPanel("bookListPanel");
					}else {
						JOptionPane.showMessageDialog(null, "Error");
					}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(369, 281, 89, 23);
		add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryMainFrame.showPanel("home");
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(45, 281, 89, 23);
		add(btnBack);

	}

}
