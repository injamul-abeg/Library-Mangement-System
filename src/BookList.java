import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookList extends JPanel {
	public JLabel label[];
	private static JTable table;

	public BookList() {
		setLayout(null);

		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(25, 11, 71, 14);
		add(lblBookName);

		JPanel panel = new JPanel();
		panel.setBounds(10, 36, 430, 253);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		
//		JButton btnBack = new JButton("Back");
//		btnBack.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				LibraryMainFrame.showPanel("student");
//			}
//		});
//		btnBack.setBounds(20, 308, 89, 23);
//		add(btnBack);

	}

	public static void setModelAbeg(DefaultTableModel defaultTableModel) {
		table.setModel(defaultTableModel);
	}
}
