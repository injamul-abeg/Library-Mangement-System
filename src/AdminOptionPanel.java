import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminOptionPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public AdminOptionPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("Book Name");
		label.setBounds(83, 37, 68, 14);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(192, 34, 86, 20);
		add(textField);
		
		JLabel label_1 = new JLabel("Book No");
		label_1.setBounds(83, 82, 68, 14);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(192, 79, 86, 20);
		add(textField_1);
		
		JLabel label_2 = new JLabel("Author");
		label_2.setBounds(105, 113, 46, 14);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(192, 110, 86, 20);
		add(textField_2);
		
		JButton button = new JButton("add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bookName=textField.getText().toString();
				int bookId =Integer.parseInt(textField_1.getText().toString());
				String author =textField_2.getText().toString();
				
				System.out.println(bookName+"  "+bookId+"  "+author);
				int status=Dao.save(bookName, bookId, author);
				if (status>0) {
					JOptionPane.showMessageDialog(null, "Added");
				}
			}
		});
		button.setBounds(192, 153, 89, 23);
		add(button);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookList.setModelAbeg(Dao.getBookListDataInTableModelForm());
				LibraryMainFrame.showPanel("bookListPanel");
			}
		});
		btnShow.setBounds(318, 153, 89, 23);
		add(btnShow);
	}
}
