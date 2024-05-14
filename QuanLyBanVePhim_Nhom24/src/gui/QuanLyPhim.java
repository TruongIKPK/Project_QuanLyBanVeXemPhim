package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.Phim_DAO;
import dao.TaiKhoanDAO;
import entity.Phim;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

public class QuanLyPhim extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField maPhim;
	private JTextField tenPhim;
	private JTextField thoiLuong;
	private JTextField ngayKhoiChieu;
	private JTextField ngayKetThuc;
	private JTextField quocGia;
	private JTextField gioiHanTuoi;
	private JTextField hinhAnh;
	private JTextField namSX;
	private JButton btnthemPhim;
	private JButton btnxoaPhim;
	private JTable table;
	private Phim_DAO phim_DAO;
	private ArrayList<Phim> dsPhim;
	private JCheckBox[] checkBoxes = new JCheckBox[8];
	private DefaultTableModel model_table;
	private QuanLySuatChieu qlnv;
	private JButton btnQunLSut;
	public static Phim phimDangChon;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyPhim frame = new QuanLyPhim();
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
	public QuanLyPhim() {
		phim_DAO = Phim_DAO.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 850);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		panel.add(verticalBox, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		verticalBox.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Trang chủ");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
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
		
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(224, 88, 88));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_5.add(btnNewButton);
		
		btnNewButton.setPreferredSize(new Dimension(20, 50));
		
		Component rigidArea_7_1_1 = Box.createRigidArea(new Dimension(20, 5));
		panel_5.add(rigidArea_7_1_1, BorderLayout.NORTH);
		
		JPanel panel_6_1 = new JPanel();
		verticalBox.add(panel_6_1);
		panel_6_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_1_1 = new JButton("Bán vé");
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.addActionListener(new ActionListener() {
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
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setPreferredSize(new Dimension(20, 50));
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(224, 88, 88));
		panel_6_1.add(btnNewButton_1_1, BorderLayout.CENTER);
		
		Component rigidArea_7_1 = Box.createRigidArea(new Dimension(20, 5));
		panel_6_1.add(rigidArea_7_1, BorderLayout.NORTH);
			
		JPanel panel_6 = new JPanel();
		verticalBox.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("Quản lý phim");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_6.add(btnNewButton_1);
		
		JPanel panel_8 = new JPanel();
		verticalBox.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_3 = new JButton("Quản lý khách hàng");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKhachHang qlkh = new QuanLyKhachHang();
				qlkh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				qlkh.setExtendedState(MAXIMIZED_BOTH);
				qlkh.setVisible(true);
                setVisible(false);
			}
		});
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBackground(new Color(224, 88, 88));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_8.add(btnNewButton_3);
		
		JPanel panel_9 = new JPanel();
		verticalBox.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_4 = new JButton("Quản lý nhân viên");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNhanVien qlnv = new QuanLyNhanVien();
				qlnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				qlnv.setExtendedState(MAXIMIZED_BOTH);
				qlnv.setVisible(true);
                setVisible(false);
			}
		});
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(224, 88, 88));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_9.add(btnNewButton_4);
		
		JPanel panel_10 = new JPanel();
		verticalBox.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_5 = new JButton("Lịch Sử");
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LichSu lichsu = new LichSu();
				lichsu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				lichsu.setExtendedState(MAXIMIZED_BOTH);
				lichsu.setVisible(true);
                setVisible(false);
			}
		});
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(224, 88, 88));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_10.add(btnNewButton_5);
		
		btnNewButton_1.setPreferredSize(new Dimension(20, 50));
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 5));
		panel_6.add(rigidArea_7, BorderLayout.NORTH);
		btnNewButton_3.setPreferredSize(new Dimension(20, 50));
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(250, 5));
		panel_8.add(rigidArea_9, BorderLayout.NORTH);
		btnNewButton_4.setPreferredSize(new Dimension(20, 50));
		
		Component rigidArea_10 = Box.createRigidArea(new Dimension(0, 5));
		panel_9.add(rigidArea_10, BorderLayout.NORTH);
		btnNewButton_5.setPreferredSize(new Dimension(20, 50));
		
		Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 5));
		panel_10.add(rigidArea_11, BorderLayout.NORTH);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11, BorderLayout.SOUTH);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_6 = new JButton("Đăng xuất");
		btnNewButton_6.addActionListener(new ActionListener() {
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
		btnNewButton_6.setPreferredSize(new Dimension(250, 50));
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_6.setBackground(new Color(0, 206, 209));
		panel_11.add(btnNewButton_6, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox_2 = Box.createVerticalBox();
		panel_3.add(verticalBox_2);
		
		JPanel panel_12 = new JPanel();
		verticalBox_2.add(panel_12);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_12.add(textField);
		textField.setColumns(19);
		
		JButton btnNewButton_7 = new JButton(" Tìm phim ");
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(new Color(0, 206, 209));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_12.add(btnNewButton_7);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		panel_12.add(rigidArea_4);
		
		JButton btnNewButton_8 = new JButton("Sửa thông tin");
		btnNewButton_8.setBackground(new Color(0, 206, 209));
		btnNewButton_8.setForeground(new Color(255, 255, 255));
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_12.add(btnNewButton_8);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		panel_12.add(rigidArea_3);
		
		JButton btnNewButton_12 = new JButton(" Làm mới ");
		btnNewButton_12.setForeground(new Color(255, 255, 255));
		btnNewButton_12.setBackground(new Color(0, 206, 209));
		btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_12.add(btnNewButton_12);
		
		Component rigidArea_13 = Box.createRigidArea(new Dimension(20, 20));
		panel_12.add(rigidArea_13);
		
		JPanel panel_13 = new JPanel();
		verticalBox_2.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		Box horizontalBox = Box.createHorizontalBox();
		panel_13.add(horizontalBox, BorderLayout.NORTH);
		
		JPanel panel_14 = new JPanel();
		horizontalBox.add(panel_14);
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox_3 = Box.createVerticalBox();
		panel_14.add(verticalBox_3);
		
		JPanel panel_17 = new JPanel();
		verticalBox_3.add(panel_17);
		panel_17.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Mã phim:          ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_17.add(lblNewLabel_2);
		
		maPhim = new JTextField();
		maPhim.setEditable(false);
		maPhim.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_17.add(maPhim);
		maPhim.setColumns(10);
		
		JPanel panel_21 = new JPanel();
		verticalBox_3.add(panel_21);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày khởi chiếu:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_21.add(lblNewLabel_6);
		
		ngayKhoiChieu = new JTextField();
		ngayKhoiChieu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_21.add(ngayKhoiChieu);
		ngayKhoiChieu.setColumns(10);
		
		JPanel panel_22 = new JPanel();
		verticalBox_3.add(panel_22);
		
		JLabel lblNewLabel_7 = new JLabel("Ngày kết thúc:  ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_22.add(lblNewLabel_7);
		
		ngayKetThuc = new JTextField();
		ngayKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ngayKetThuc.setColumns(10);
		panel_22.add(ngayKetThuc);
		
		JPanel panel_22_1 = new JPanel();
		verticalBox_3.add(panel_22_1);
		panel_22_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_7_1 = new JLabel("Quốc gia:  ");
		lblNewLabel_7_1.setPreferredSize(lblNewLabel_7.getPreferredSize());
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_22_1.add(lblNewLabel_7_1);
		
		quocGia = new JTextField();
		quocGia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		quocGia.setColumns(10);
		panel_22_1.add(quocGia);
		
		JPanel panel_22_1_1 = new JPanel();
		verticalBox_3.add(panel_22_1_1);
		panel_22_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Năm sản xuất:  ");
		lblNewLabel_7_1_1.setPreferredSize(new Dimension(175, 31));
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_22_1_1.add(lblNewLabel_7_1_1);
		
		namSX = new JTextField();
		namSX.setFont(new Font("Tahoma", Font.PLAIN, 25));
		namSX.setColumns(10);
		panel_22_1_1.add(namSX);
		
		JPanel panel_15 = new JPanel();
		horizontalBox.add(panel_15);
		panel_15.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox_4 = Box.createVerticalBox();
		panel_15.add(verticalBox_4);
		
		JPanel panel_19 = new JPanel();
		verticalBox_4.add(panel_19);
		
		JLabel lblNewLabel_4 = new JLabel("Tên phim:        ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_19.add(lblNewLabel_4);
		
		tenPhim = new JTextField();
		tenPhim.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_19.add(tenPhim);
		tenPhim.setColumns(10);
		
		JPanel panel_20 = new JPanel();
		verticalBox_4.add(panel_20);
		
		JLabel lblNewLabel_5 = new JLabel("Thời lượng:      ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_20.add(lblNewLabel_5);
		
		thoiLuong = new JTextField();
		thoiLuong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_20.add(thoiLuong);
		thoiLuong.setColumns(10);
		
		JPanel panel_19_1 = new JPanel();
		verticalBox_4.add(panel_19_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Giới hạn tuổi:");
		lblNewLabel_4_1.setPreferredSize(lblNewLabel_5.getPreferredSize());
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_19_1.add(lblNewLabel_4_1);
		
		gioiHanTuoi = new JTextField();
		gioiHanTuoi.setFont(new Font("Tahoma", Font.PLAIN, 25));
		gioiHanTuoi.setColumns(10);
		panel_19_1.add(gioiHanTuoi);
		
		JPanel panel_19_2 = new JPanel();
		verticalBox_4.add(panel_19_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("Hình ảnh:        ");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_19_2.add(lblNewLabel_4_2);
		
		hinhAnh = new JTextField();
		hinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 25));
		hinhAnh.setColumns(10);
		panel_19_2.add(hinhAnh);
		
		JPanel panel_16 = new JPanel();
		horizontalBox.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		Box verticalBox_5 = Box.createVerticalBox();
		panel_16.add(verticalBox_5);
		
		JPanel panel_27 = new JPanel();
		verticalBox_5.add(panel_27);
		panel_27.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_12 = new JLabel("Thể loại");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_27.add(lblNewLabel_12);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(230, 20));
		panel_27.add(rigidArea_5);
		
		JPanel panel_28 = new JPanel();
		verticalBox_5.add(panel_28);
		panel_28.setLayout(new BorderLayout(0, 0));
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		panel_28.add(horizontalBox_1);
		
		JPanel panel_29 = new JPanel();
		horizontalBox_1.add(panel_29);
		panel_29.setLayout(new BorderLayout(0, 0));
		
		Box verticalBox_6 = Box.createVerticalBox();
		panel_29.add(verticalBox_6);
		
		checkBoxes[0] = new JCheckBox("Hành động");
		checkBoxes[0].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_6.add(checkBoxes[0]);
		
		checkBoxes[1] = new JCheckBox("Viễn tưởng");
		checkBoxes[1].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_6.add(checkBoxes[1]);
		
		checkBoxes[2] = new JCheckBox("Phiêu lưu");
		checkBoxes[2].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_6.add(checkBoxes[2]);
		
		checkBoxes[3] = new JCheckBox("Kinh dị");
		checkBoxes[3].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_6.add(checkBoxes[3]);
		
		JPanel panel_30 = new JPanel();
		horizontalBox_1.add(panel_30);
		panel_30.setLayout(new BorderLayout(0, 0));
		
		Box verticalBox_7 = Box.createVerticalBox();
		panel_30.add(verticalBox_7);
		
		checkBoxes[4] = new JCheckBox("Tâm lý");
		checkBoxes[4].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_7.add(checkBoxes[4]);
		
		checkBoxes[5] = new JCheckBox("Tình cảm");
		checkBoxes[5].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_7.add(checkBoxes[5]);
		
		checkBoxes[6] = new JCheckBox("Gia đình");
		checkBoxes[6].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_7.add(checkBoxes[6]);
		
		checkBoxes[7] = new JCheckBox("Hài hước");
		checkBoxes[7].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_7.add(checkBoxes[7]);
		
		JPanel panel_23 = new JPanel();
		verticalBox_2.add(panel_23);
		
		Component rigidArea_12 = Box.createRigidArea(new Dimension(620, 20));
		panel_23.add(rigidArea_12);
		
		btnthemPhim = new JButton("Thêm phim");
		btnthemPhim.setForeground(new Color(255, 255, 255));
		btnthemPhim.setBackground(new Color(0, 206, 209));
		btnthemPhim.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_23.add(btnthemPhim);
		
		
		
		Component rigidArea_14_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_23.add(rigidArea_14_1);
		
		btnxoaPhim = new JButton(" Xóa phim ");
		btnxoaPhim.setForeground(new Color(255, 255, 255));
		btnxoaPhim.setBackground(new Color(0, 206, 209));
		btnxoaPhim.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_23.add(btnxoaPhim);
		btnxoaPhim.addActionListener(this);
		
		Component rigidArea_14 = Box.createRigidArea(new Dimension(20, 20));
		panel_23.add(rigidArea_14);
	
		btnQunLSut = new JButton("Quản lý suất chiếu");
		btnQunLSut.setForeground(Color.WHITE);
		btnQunLSut.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnQunLSut.setBackground(new Color(0, 206, 209));
		panel_23.add(btnQunLSut);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		// Đặt chiều cao mới cho từng hàng trong bảng
		table.setRowHeight(35);
		// Tăng kích thước của tiêu đề cột
		JTableHeader header = table.getTableHeader();
		Font headerFont = header.getFont();
		header.setFont(new Font(headerFont.getName(), Font.BOLD, 20));

		// Tăng cỡ chữ trong ô dữ liệu của bảng
		Font cellFont = table.getFont();
		table.setFont(new Font(cellFont.getName(), Font.PLAIN, 20));
		model_table = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
						"M\u00E3 phim", "T\u00EAn phim", "Ng\u00E0y kh\u1EDFi chi\u1EBFu", "Ng\u00E0y k\u1EBFt th\u00FAc", "Th\u1EC3 lo\u1EA1i", "Gi\u1EDBi h\u1EA1n tu\u1ED5i", "Qu\u1ED1c gia", "N\u0103m s\u1EA3n xu\u1EA5t", "Th\u1EDDi L\u01B0\u1EE3ng"
				});
		table.setModel(model_table);
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(92);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		LoadDsPhim();	
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 105, 229));
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		Box verticalBox_1 = Box.createVerticalBox();
		panel_2.add(verticalBox_1);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 40));
		verticalBox_1.add(rigidArea);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ PHIM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		verticalBox_1.add(lblNewLabel);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 40));
		verticalBox_1.add(rigidArea_1);
		btnthemPhim.addActionListener(this);
		btnQunLSut.addActionListener(this);
	}
	private void LoadDsPhim() {
	    try {
	        dsPhim = phim_DAO.dsPhim();
	        model_table.setRowCount(0);
	        for (Phim phim : dsPhim) {
	            model_table.addRow(new Object[] {phim.getMaPhim(), phim.getTenPhim(), phim.getNgayKhoiChieu(), phim.getNgayKetThuc(), phim.getTheLoai(),
	                    phim.getGioiHanTuoi(), phim.getQuocGia(), phim.getNamSX(), phim.getThoiLuong()});
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	private Phim createMovie() {
		String tenPhim_tx = tenPhim.getText();
		int thoiLuong_tx =  Integer.parseInt(thoiLuong.getText());
		String ngayKhoiChieu_tx = ngayKhoiChieu.getText();
		String ngayKetThuc_tx = ngayKetThuc.getText();
		String quocGia_tx = quocGia.getText();
		int gioiHanTuoi_tx = Integer.parseInt(gioiHanTuoi.getText());
		String hinhAnh_tx = hinhAnh.getText();
		int namsx_tx = Integer.parseInt(namSX.getText());
		String theLoai = "";
		for(int i = 0; i < checkBoxes.length; i++) {
			if (checkBoxes[i].isSelected()) {
		        theLoai += checkBoxes[i].getText() + " ";
		    }
		}
		Phim phim = new Phim(tenPhim_tx, quocGia_tx, thoiLuong_tx, ngayKhoiChieu_tx, ngayKetThuc_tx, gioiHanTuoi_tx, namsx_tx, theLoai, hinhAnh_tx);
		return phim;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stubs
		Object obj = e.getSource();
		if(obj.equals(btnQunLSut)) {
			int i = table.getSelectedRow();
			if(i < 0) {
				JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Phim");
			}else {
				phimDangChon = dsPhim.get(i);
				qlnv = new QuanLySuatChieu();
				qlnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				qlnv.setLocationRelativeTo(null);
				qlnv.setVisible(true);
			}
			
		}
		if(obj.equals(btnthemPhim)) {
			Phim phim = createMovie();
			try {
				phim_DAO.addPhim(phim);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			LoadDsPhim();
		}
		if(obj.equals(btnxoaPhim)) {
			int i = table.getSelectedRow();
			if(i < 0) {
				JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Phim Khi Xóa");
			}else {
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?", "Xác nhận xóa", JOptionPane.OK_CANCEL_OPTION);
		        if (choice == JOptionPane.OK_OPTION) {
		        	model_table.removeRow(i);
		        } else {
		            return;
		        }
			}
		}
	}
}
