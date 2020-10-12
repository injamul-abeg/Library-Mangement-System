
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LibraryMainFrame extends JFrame {

	private static JPanel contentPane;
	private static CardLayout cardLayout;

	public static void main(String[] args) {
		
		Dao dao = new Dao();
		dao.getConnection();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryMainFrame frame = new LibraryMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LibraryMainFrame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);

		HomePanel homePanel = new HomePanel();
		contentPane.add(homePanel, "home");
		AdminPanel adminPanel = new AdminPanel();
		contentPane.add(adminPanel, "admin");
		StudentPanel studentPanel = new StudentPanel();
		contentPane.add(studentPanel, "student");
		
		Login_BookList login_BookList = new Login_BookList();
		contentPane.add(login_BookList, "book");
		
		BookList list=new BookList();
		contentPane.add(list,"bookListPanel");

		JPanel adminOptionPanel = new AdminOptionPanel();
		contentPane.add(adminOptionPanel, "adminOptionPanel");
		adminOptionPanel.setLayout(null);

		JPanel studentOptionPanel = new StudentOptionPanel();
		contentPane.add(studentOptionPanel, "studentOptionPanel");
		studentOptionPanel.setLayout(new BorderLayout(0, 0));
		

		showPanel("home");

	}

	public static void showPanel(String name) {
		cardLayout.show(contentPane, name);
	}
}
