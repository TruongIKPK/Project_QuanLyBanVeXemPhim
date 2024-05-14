package gui;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.Phim_DAO;
import dao.PhongChieuDAO;
import dao.SuatChieu_DAO;
import entity.Phim;
import entity.PhongChieu;
import entity.SuatChieu;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class QuanLySuatChieu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTextField textField;
	private JComboBox<String> comboBox_3;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_1;
	private JButton btnNewButton_8;
	private SuatChieu_DAO suatChieuDAO;
	private Phim_DAO phimDAO;
	private PhongChieuDAO phongChieuDAO;
	private JComboBox comboBox;
	private DefaultTableModel model_table;
	private ArrayList<SuatChieu> dsSuatChieu = new ArrayList<SuatChieu>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLySuatChieu frame = new QuanLySuatChieu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLySuatChieu() {
		suatChieuDAO = SuatChieu_DAO.getInstance();
		phimDAO = Phim_DAO.getInstance();
		phongChieuDAO = PhongChieuDAO.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1219, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Box verticalBox_1 = Box.createVerticalBox();
		panel_1.add(verticalBox_1, BorderLayout.NORTH);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 40));
		verticalBox_1.add(rigidArea_5);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox);
		
		JPanel panel_4 = new JPanel();
		horizontalBox.add(panel_4);
		
		JPanel panel_12 = new JPanel();
		horizontalBox.add(panel_12);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SUẤT CHIẾU");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_12.add(lblNewLabel);
		
		JPanel panel_13 = new JPanel();
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		btnNewButton_8 = new JButton("Thêm suất chiếu");
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_13.add(btnNewButton_8);
		
		Component rigidArea = Box.createRigidArea(panel_13.getPreferredSize());
		panel_4.add(rigidArea);
		horizontalBox.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.EAST);
		
		JLabel lblNewLabel_1 = new JLabel("Phòng chiếu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Phòng 1", "Phòng 2", "Phòng 3", "Phòng 4", "Phòng 5"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(comboBox);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_3.add(rigidArea_1);
		
		JLabel lblNewLabel_2 = new JLabel("Giờ chiếu:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(textField);
		textField.setColumns(5);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		panel_3.add(rigidArea_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày chiếu:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(lblNewLabel_3);
		
		comboBox_1 = new  JComboBox<String>();
		for(int j = 1; j <= 31 ; j++) {
			if(j > 9) {
				comboBox_1.addItem(String.valueOf(j));
			}else {
				comboBox_1.addItem("0"+String.valueOf(j));
			}
		}
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(comboBox_1);
		
		comboBox_2 = new JComboBox<String>();
		for(int i = 1; i <= 12 ; i++) {
			if(i > 9) {
				comboBox_2.addItem(String.valueOf(i));
			}else {
				comboBox_2.addItem("0"+String.valueOf(i));
			}


		}
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(comboBox_2);
		
		comboBox_3 = new JComboBox<>();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for(int i = currentYear; i <= currentYear+4 ; i++) {
			comboBox_3.addItem(String.valueOf(i));;
		}
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(comboBox_3);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_2.add(tabbedPane);
		
		JPanel panel_14 = new JPanel();
		tabbedPane.addTab("Toàn bộ", null, panel_14, null);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_14.add(scrollPane);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setRowHeight(40);
		JTableHeader header = table.getTableHeader();
		Font headerFont = header.getFont();
		header.setFont(new Font(headerFont.getName(), Font.BOLD, 25));
		Font cellFont = table.getFont();
		table.setFont(new Font(cellFont.getName(), Font.PLAIN, 25));
		
		model_table = new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"T\u00EAn phim", "Ph\u00F2ng chi\u1EBFu", "Th\u1EDDi l\u01B0\u1EE3ng", "Su\u1EA5t chi\u1EBFu"
			}
		);
		table.setModel(model_table);
		table.getColumnModel().getColumn(0).setPreferredWidth(151);
		scrollPane.setViewportView(table);
		
		//phòng 1
		JPanel panel_15 = new JPanel();
		tabbedPane.addTab("Phòng 1", null, panel_15, null);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_15.add(scrollPane_1);
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		// Đặt chiều cao mới cho từng hàng trong bảng
		table_1.setRowHeight(40);
		// Tăng kích thước của tiêu đề cột
		JTableHeader header_1 = table_1.getTableHeader();
		Font headerFont_1 = header_1.getFont();
		header_1.setFont(new Font(headerFont_1.getName(), Font.BOLD, 25));

		// Tăng cỡ chữ trong ô dữ liệu của bảng
		Font cellFont_1 = table_1.getFont();
		table_1.setFont(new Font(cellFont_1.getName(), Font.PLAIN, 25));


		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"T\u00EAn phim", "Th\u1EDDi l\u01B0\u1EE3ng", "Su\u1EA5t chi\u1EBFu"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(151);
		scrollPane_1.setViewportView(table_1);
		
		//phòng 2
		JPanel panel_16 = new JPanel();
		tabbedPane.addTab("Phòng 2", null, panel_16, null);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_16.add(scrollPane_2);
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		// Đặt chiều cao mới cho từng hàng trong bảng
		table_2.setRowHeight(40);
		// Tăng kích thước của tiêu đề cột
		JTableHeader header_2 = table_2.getTableHeader();
		Font headerFont_2 = header_2.getFont();
		header_2.setFont(new Font(headerFont_2.getName(), Font.BOLD, 25));

		// Tăng cỡ chữ trong ô dữ liệu của bảng
		Font cellFont_2 = table_2.getFont();
		table_2.setFont(new Font(cellFont_2.getName(), Font.PLAIN, 25));


		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"T\u00EAn phim", "Th\u1EDDi l\u01B0\u1EE3ng", "Su\u1EA5t chi\u1EBFu"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(151);
		scrollPane_2.setViewportView(table_2);
		capNhatBangLon();
		
		//phòng 3
		JPanel panel_17 = new JPanel();
		tabbedPane.addTab("Phòng 3", null, panel_17, null);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_17.add(scrollPane_3);
		table_3 = new JTable();
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		// Đặt chiều cao mới cho từng hàng trong bảng
		table_3.setRowHeight(40);
		// Tăng kích thước của tiêu đề cột
		JTableHeader header_3 = table_3.getTableHeader();
		Font headerFont_3 = header_3.getFont();
		header_3.setFont(new Font(headerFont_3.getName(), Font.BOLD, 25));

		// Tăng cỡ chữ trong ô dữ liệu của bảng
		Font cellFont_3 = table_3.getFont();
		table_3.setFont(new Font(cellFont_3.getName(), Font.PLAIN, 25));


		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"T\u00EAn phim", "Th\u1EDDi l\u01B0\u1EE3ng", "Su\u1EA5t chi\u1EBFu"
			}
		));
		table_3.getColumnModel().getColumn(0).setPreferredWidth(151);
		scrollPane_3.setViewportView(table_3);
		
		//phòng 4
		JPanel panel_18 = new JPanel();
		tabbedPane.addTab("Phòng 4", null, panel_18, null);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_18.add(scrollPane_4);
		table_4 = new JTable();
		table_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		// Đặt chiều cao mới cho từng hàng trong bảng
		table_4.setRowHeight(40);
		// Tăng kích thước của tiêu đề cột
		JTableHeader header_4 = table_4.getTableHeader();
		Font headerFont_4 = header_4.getFont();
		header_4.setFont(new Font(headerFont_4.getName(), Font.BOLD, 25));

		// Tăng cỡ chữ trong ô dữ liệu của bảng
		Font cellFont_4 = table_4.getFont();
		table_4.setFont(new Font(cellFont_4.getName(), Font.PLAIN, 25));


		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"T\u00EAn phim", "Th\u1EDDi l\u01B0\u1EE3ng", "Su\u1EA5t chi\u1EBFu"
			}
		));
		table_4.getColumnModel().getColumn(0).setPreferredWidth(151);
		scrollPane_4.setViewportView(table_4);
		
		//phòng 5
		JPanel panel_19 = new JPanel();
		tabbedPane.addTab("Phòng 5", null, panel_19, null);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		panel_19.add(scrollPane_5);
		table_5 = new JTable();
		table_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		// Đặt chiều cao mới cho từng hàng trong bảng
		table_5.setRowHeight(40);
		// Tăng kích thước của tiêu đề cột
		JTableHeader header_5 = table_5.getTableHeader();
		Font headerFont_5 = header_5.getFont();
		header_5.setFont(new Font(headerFont_5.getName(), Font.BOLD, 25));

		// Tăng cỡ chữ trong ô dữ liệu của bảng
		Font cellFont_5 = table_5.getFont();
		table_5.setFont(new Font(cellFont_5.getName(), Font.PLAIN, 25));


		table_5.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"T\u00EAn phim", "Th\u1EDDi l\u01B0\u1EE3ng", "Su\u1EA5t chi\u1EBFu"
			}
		));
		table_5.getColumnModel().getColumn(0).setPreferredWidth(151);
		scrollPane_5.setViewportView(table_5);
		btnNewButton_8.addActionListener(this);
	}
	
	private void capNhatBangLon() {
		try {
			dsSuatChieu = suatChieuDAO.getSuatChieus();
	        model_table.setRowCount(0);
	        for (SuatChieu suatChieu : dsSuatChieu) {
	        	Phim phim = phimDAO.timPhim(suatChieu.getPhim().getMaPhim());
	        	String suatChieu1 = "";
	        	suatChieu1 += suatChieu.getNgayChieu() +" "+ suatChieu.getGioChieu();
	        	PhongChieu phongChieu = phongChieuDAO.timPhong(suatChieu.getPhongChieu().getMaPhong());
	            model_table.addRow(new Object[] {
	            		phim.getTenPhim(),
	            		phongChieu.getTenPhong(),
	            		phim.getThoiLuong(),
	            		suatChieu1
	            });
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnNewButton_8)) {
			
			int selectedIndex = comboBox.getSelectedIndex() + 1;
			PhongChieu phongChieu = new PhongChieu(selectedIndex);
			Object selectedItem1 = comboBox_1.getSelectedItem();
			String ngay = selectedItem1.toString();
			Object selectedItem2 = comboBox_2.getSelectedItem();
			String thang = selectedItem2.toString();
			Object selectedItem3 = comboBox_3.getSelectedItem();
			String nam = selectedItem3.toString();
			String ngayChieu = nam + '-' + thang + '-' + ngay;
			String gioChieu = textField.getText();
			SuatChieu suatChieu = new SuatChieu(0, ngayChieu, gioChieu, QuanLyPhim.phimDangChon, phongChieu);
			try {
				suatChieuDAO.addSuatChieu(suatChieu);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			capNhatBangLon();
		}
	}

}
