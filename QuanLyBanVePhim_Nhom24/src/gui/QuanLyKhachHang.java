package gui;

import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import dao.KhachHang_DAO;
import entity.KhachHang;

import javax.swing.BoxLayout;

public class QuanLyKhachHang extends JFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTimKiem;
	private JTextField hoTen;
	private JTextField ngaySinh;
	private JTextField sDT;
	private JTextField diemTichLuy;
	private JTable table;
	private JButton timKiem;
	private JButton suaThongTin;
	private JButton themKH;
	private JButton lamMoi;
	private JRadioButton rdbtnNewRadioButton;
	private KhachHang_DAO khachHangDAO;
	private DefaultTableModel model_table;
	private ArrayList<KhachHang> dsKhachHang;
	private JRadioButton rdbtnNewRadioButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKhachHang frame = new QuanLyKhachHang();
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
	public QuanLyKhachHang() {
		khachHangDAO = KhachHang_DAO.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 2, 0));
		panel.setBackground(new Color(64, 105, 229));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		Component rigidArea = Box.createRigidArea(new Dimension(1530, 46));
		rigidArea.setBackground(Color.PINK);
		panel.add(rigidArea, BorderLayout.NORTH);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(1530, 45));
		panel.add(rigidArea_1, BorderLayout.SOUTH);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(64, 105, 229));
		panel.add(panel_7, BorderLayout.EAST);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(64, 105, 229));
		panel_7.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(64, 105, 229));
		panel_7.add(panel_5, BorderLayout.EAST);
		
		Box horizontalBox = Box.createHorizontalBox();
		panel_5.add(horizontalBox);
		
		JPanel panel_9 = new JPanel();
		panel_9.setPreferredSize(panel_5.getPreferredSize());
		panel_9.setBackground(new Color(64, 105, 229));
		panel.add(panel_9, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Thông Tin Cần Tìm:");
		lblNewLabel_1.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 10));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblNewLabel_1);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setPreferredSize(new Dimension(30, 35));
		txtTimKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(txtTimKiem);
		txtTimKiem.setColumns(15);
		
		timKiem = new JButton("Tìm Kiếm");
		timKiem.setForeground(Color.WHITE);
		timKiem.setBorderPainted(false);
		timKiem.setBackground(new Color(0, 189, 214));
		timKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(timKiem);
		
		themKH = new JButton("Thêm Khách Hàng Mới");
		themKH.setForeground(Color.WHITE);
		themKH.setBackground(new Color(0, 189, 214));
		themKH.setBorderPainted(false);
		themKH.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(themKH);
		
		suaThongTin = new JButton("Sửa Thông Tin");
		suaThongTin.setForeground(Color.WHITE);
		suaThongTin.setBackground(new Color(0, 189, 214));
		suaThongTin.setBorderPainted(false);
		suaThongTin.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(suaThongTin);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 10));
		panel_3.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		panel_6.add(verticalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_7);
		
		JLabel lblNewLabel_2 = new JLabel("Tên Khách Hàng:   ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		horizontalBox_1.add(lblNewLabel_2);
		
		hoTen = new JTextField();
		hoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hoTen.setPreferredSize(new Dimension(30, 35));
		horizontalBox_1.add(hoTen);
		hoTen.setColumns(15);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_3);
		
		JLabel lblNewLabel_7_1 = new JLabel("Điểm Tích Lũy:   ");
		
		JLabel lblNewLabel_7 = new JLabel("Ngày Sinh:         ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		horizontalBox_1.add(lblNewLabel_7);
		
		ngaySinh = new JTextField();
		ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ngaySinh.setPreferredSize(new Dimension(30, 35));
		ngaySinh.setColumns(15);
		horizontalBox_1.add(ngaySinh);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		panel_6.add(rigidArea_2);
		
		JLabel lblNewLabel_6 = new JLabel("Giới Tính:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_6.add(lblNewLabel_6);
		
		rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_6.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Nữ");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_6.add(rdbtnNewRadioButton_1);
		
		ButtonGroup button_group = new ButtonGroup();
		button_group.add(rdbtnNewRadioButton);
		button_group.add(rdbtnNewRadioButton_1);
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
		
		Box horizontalBox_1_1 = Box.createHorizontalBox();
		panel_11.add(horizontalBox_1_1);
		
		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_1.add(rigidArea_10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số Điện Thoại:");
		lblNewLabel_2_1.setPreferredSize(lblNewLabel_2.getPreferredSize());
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		horizontalBox_1_1.add(lblNewLabel_2_1);
		
		sDT = new JTextField();
		sDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sDT.setPreferredSize(new Dimension(30, 35));
		sDT.setColumns(15);
		horizontalBox_1_1.add(sDT);
		
		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_1.add(rigidArea_3_1);
		
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		horizontalBox_1_1.add(lblNewLabel_7_1);
		
		diemTichLuy = new JTextField();
		diemTichLuy.setEnabled(false);
		diemTichLuy.setEditable(false);
		diemTichLuy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		diemTichLuy.setColumns(15);
		horizontalBox_1_1.add(diemTichLuy);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(237, 20));
		panel_11.add(rigidArea_4);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 10));
		panel_3.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14, BorderLayout.EAST);
		
		lamMoi = new JButton("Làm Mới");
		lamMoi.setForeground(Color.WHITE);
		lamMoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lamMoi.setBorderPainted(false);
		lamMoi.setBackground(new Color(0, 189, 214));
		panel_14.add(lamMoi);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(70, 20));
		panel_14.add(rigidArea_5);
		
		JPanel panel_13 = new JPanel();
		panel_4.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setRowHeight(35);

		
		model_table = new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn Kh\u00E1ch H\u00E0ng", "Gi\u1EDBi T\u00EDnh", "Ng\u00E0y Sinh", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "\u0110i\u1EC3m T\u00EDch L\u0169y"
		});
		table.setModel(model_table);
		
		TableColumnModel columnModel = table.getColumnModel();

		for (int i = 0; i < columnModel.getColumnCount(); i++) {
		  TableColumn headerColumn = columnModel.getColumn(i);
		  headerColumn.setHeaderRenderer(new DefaultTableCellRenderer() {
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		      super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		      setFont(new Font("Tahoma", Font.PLAIN, 20));
		      setBackground(new Color(220, 220, 220)); 
		      setHorizontalAlignment(SwingConstants.CENTER); 
		      return this;
		    }
		  });
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(84);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_13.add(scrollPane);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(222, 225, 230));
		contentPane.add(panel_10, BorderLayout.WEST);
		panel_10.setLayout(new GridLayout(0, 1, 1, 2));
		
		JButton btnNewButton_1_1 = new JButton("Trang Chủ");
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu trangchu;
				try {
					trangchu = new TrangChu();
					trangchu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					trangchu.setExtendedState(MAXIMIZED_BOTH);
					trangchu.setVisible(true);
	                setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1_1.setSize(new Dimension(300, 11));
		btnNewButton_1_1.setPreferredSize(new Dimension(300, 5));
		btnNewButton_1_1.setMinimumSize(new Dimension(65, 5));
		btnNewButton_1_1.setMaximumSize(new Dimension(300, 5));
		btnNewButton_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1_1.setBounds(new Rectangle(1, 2, 0, 10));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(new Color(224, 88, 88));
		panel_10.add(btnNewButton_1_1);
		
		JButton btnNewButton_1 = new JButton("Bán vé");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChonPhim chonPhim;
				try {
					chonPhim = new ChonPhim();
					chonPhim.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                chonPhim.setExtendedState(MAXIMIZED_BOTH);
	                chonPhim.setVisible(true);
	                setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(224, 88, 88));
		btnNewButton_1.setSize(new Dimension(300, 11));
		btnNewButton_1.setPreferredSize(new Dimension(300, 5));
		btnNewButton_1.setMinimumSize(new Dimension(65, 5));
		btnNewButton_1.setMaximumSize(new Dimension(300, 5));
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1.setBounds(new Rectangle(1, 2, 0, 10));
		panel_10.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Quản lý phim");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyPhim qlPhim = new QuanLyPhim();
				qlPhim.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				qlPhim.setExtendedState(MAXIMIZED_BOTH);
				qlPhim.setVisible(true);
                setVisible(false);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(new Color(224, 88, 88));
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_10.add(btnNewButton_2);
		
		JButton btnNewButton_4_1 = new JButton("Quản lý khách hàng");
		btnNewButton_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4_1.setEnabled(false);
		btnNewButton_4_1.setForeground(Color.WHITE);
		btnNewButton_4_1.setBackground(new Color(222, 225, 230));
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_10.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_2 = new JButton("Quản lý nhân viên");
		btnNewButton_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNhanVien qlnv = new QuanLyNhanVien();
				qlnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				qlnv.setExtendedState(MAXIMIZED_BOTH);
				qlnv.setVisible(true);
                setVisible(false);
			}
		});
		btnNewButton_4_2.setForeground(Color.WHITE);
		btnNewButton_4_2.setBorderPainted(false);
		btnNewButton_4_2.setBackground(new Color(224, 88, 88));
		btnNewButton_4_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_10.add(btnNewButton_4_2);
		
		JButton btnNewButton_4_2_1 = new JButton("Lịch Sử");
		btnNewButton_4_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LichSu lichsu = new LichSu();
				lichsu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				lichsu.setExtendedState(MAXIMIZED_BOTH);
				lichsu.setVisible(true);
                setVisible(false);
			}
		});
		btnNewButton_4_2_1.setForeground(Color.WHITE);
		btnNewButton_4_2_1.setBorderPainted(false);
		btnNewButton_4_2_1.setBackground(new Color(224, 88, 88));
		btnNewButton_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_10.add(btnNewButton_4_2_1);
		
		JLabel label = new JLabel("");
		panel_10.add(label);
		
		JLabel label_1 = new JLabel("");
		panel_10.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panel_10.add(label_2);
		
		JButton btnNewButton_4_2_3 = new JButton("Đăng Xuất");
		btnNewButton_4_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất không?", "Xác nhận đăng xuất", JOptionPane.OK_CANCEL_OPTION);
		        if (choice == JOptionPane.OK_OPTION) {
		        	setVisible(false);
                    new DangNhap().setVisible(true);
		        } else {
		            return;
		        }
			}
		});
		btnNewButton_4_2_3.setBorderPainted(false);
		btnNewButton_4_2_3.setForeground(Color.WHITE);
		btnNewButton_4_2_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_4_2_3.setBackground(new Color(0, 189, 214));
		panel_10.add(btnNewButton_4_2_3);
		
		lamMoi.addActionListener(this);
		themKH.addActionListener(this);
		suaThongTin.addActionListener(this);
		timKiem.addActionListener(this);
		table.addMouseListener(this);
	}

	private void lamRong() {
		hoTen.setText("");
		ngaySinh.setText("");
		sDT.setText("");
		diemTichLuy.setText("");
		rdbtnNewRadioButton.setSelected(false);
		rdbtnNewRadioButton_1.setSelected(false);
		hoTen.requestFocus();
		
	}
	private KhachHang khachHang() {
		String ten = hoTen.getText();
		String ngaySinh1 = ngaySinh.getText();
		boolean gioiTinh;
		if(rdbtnNewRadioButton.isSelected()) {
			gioiTinh = true;
		}else {
			gioiTinh = false;
		}
		String sdt = sDT.getText();
		KhachHang khachHang = new KhachHang(ten, gioiTinh, ngaySinh1, sdt);
		return khachHang;
	}
	public void CapNhatBang(ArrayList<KhachHang> kh) {
		model_table.setRowCount(0);
		for (KhachHang khachHang : kh) {
			model_table.addRow(new Object[] {
					khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), 
					khachHang.isPhai()?"Nam":"Nữ", khachHang.getNgaySinh(), 
					khachHang.getSdt(), khachHang.getDiemTichLuy()
			});
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(lamMoi)) {
			 lamRong();
		}
		if(obj.equals(themKH)) {
			 try {
				if(khachHangDAO.addKhachHang(khachHang())) {
					 JOptionPane.showMessageDialog(this, "Thêm Khách Hàng Thành Công");
				 }else {
					 JOptionPane.showMessageDialog(this, "Thêm Khách Hàng Thất Bại");
				 }
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(obj.equals(suaThongTin)){
//			int selectedRow = table.getSelectedRow();
//			if (selectedRow < 0) {
//				JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần thay đổi!");
//			}else {
//				try {
//					khachHangDAO.updateKhachHang(khachHang());
//					JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công!");
//				} catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//			
		}
		if(obj.equals(timKiem)){
			String ndCanTim = txtTimKiem.getText();
			if (ndCanTim.matches("\\d+")) {
				try {
					dsKhachHang = khachHangDAO.timTenKHTheoSDT(ndCanTim);
					CapNhatBang(dsKhachHang);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "không tìm thấy!");
					e1.printStackTrace();
				}
			}else {
				try {
					dsKhachHang = khachHangDAO.timTenKHTheoHoTen(ndCanTim);
					CapNhatBang(dsKhachHang);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "không tìm thấy!");
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0) {
		    KhachHang khachHang = new KhachHang(
		    		(int)table.getValueAt(selectedRow, 0),	
		    		String.valueOf(table.getValueAt(selectedRow, 1)),
		    		table.getValueAt(selectedRow, 2).equals("Nam")?true:false,
		    		String.valueOf(table.getValueAt(selectedRow, 3)),
		    		String.valueOf(table.getValueAt(selectedRow, 4)),
		    		(int)table.getValueAt(selectedRow, 5)
		    );
			hoTen.setText(khachHang.getTenKhachHang());
			ngaySinh.setText(khachHang.getNgaySinh());
			sDT.setText(khachHang.getSdt());
			diemTichLuy.setText(String.valueOf(khachHang.getDiemTichLuy()));
			if(khachHang.isPhai()) {
				rdbtnNewRadioButton.setSelected(true);
			}else {
				rdbtnNewRadioButton_1.setSelected(false);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
