package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.HoaDonXemPhimDAO;
import dao.KhachHang_DAO;
import dao.PhongChieuDAO;
import dao.SuatChieu_DAO;
import dao.VeXemPhim_DAO;
import entity.Ghe;
import entity.HoaDonXemPhim;
import entity.KhachHang;
import entity.Phim;
import entity.PhongChieu;
import entity.SuatChieu;
import entity.VeXemPhim;

import javax.swing.ScrollPaneConstants;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DropMode;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.DefaultComboBoxModel;

public class ThanhToan extends JFrame implements ActionListener ,MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtVoucher;
	private JTextField txtSDT;
	private JTextField txtDiem;
	private JTextField txtTienNhan;
	private JButton btnApMa, btnThanhToan;
	private JButton[] nhanTien;
	private int soLuongnhanTien[];
	private JComboBox<String> cbVoucher;
	private JLabel lblTienDuocGiam, lblTongTien, lblTienThanhToan;
	private SuatChieu_DAO suatChieuDAO;
	private KhachHang_DAO khachHangDao;
	private JLabel lblNewLabel_23;
	private JLabel lblTienTra;
	private double tongtienNhan = 0;
	private double tongTienChuaGiam;
	private double tongTienGiam =0;
	private double tongTienCanThanhToan;
	private double tongtienCanTraLai;
	private JButton btnNewButton;
	private JButton btnDoiDiem;
	private ArrayList<KhachHang> kh;
	private int diemCanDoi;
	private boolean daDoiDiem = false;
	private HoaDonXemPhimDAO hoadonPhim_DAO;
	private VeXemPhim_DAO veXemPhim_DAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanhToan frame = new ThanhToan();
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
	public ThanhToan() {
		suatChieuDAO = SuatChieu_DAO.getInstance();
		khachHangDao = KhachHang_DAO.getInstance();
		hoadonPhim_DAO = HoaDonXemPhimDAO.getInstance();
		veXemPhim_DAO = VeXemPhim_DAO.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1709, 850);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));

		Box verticalBox = Box.createVerticalBox();
		panel.add(verticalBox);

		JPanel panel_1 = new JPanel();
		verticalBox.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		Box verticalBox_1 = Box.createVerticalBox();
		panel_1.add(verticalBox_1);

		JPanel panel_3 = new JPanel();
		verticalBox_1.add(panel_3);

		Box horizontalBox = Box.createHorizontalBox();
		panel_3.add(horizontalBox);

		JLabel lblNewLabel = new JLabel("");
		ImageIcon icon = new ImageIcon("C:\\Users\\DELL\\Pictures\\Screenshots\\Screenshot 2024-04-19 164659.png");
		Image img = icon.getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT);
		ImageIcon newIcon = new ImageIcon(img);
		lblNewLabel.setIcon(newIcon);
		horizontalBox.add(lblNewLabel);

		Box verticalBox_2 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_2);

		Phim phim = ChonPhim.phimDaChon;
		JLabel lblNewLabel_1 = new JLabel(phim.getTenPhim());
		lblNewLabel_1.setForeground(new Color(3, 89, 157));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		verticalBox_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("2D phụ đề");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_2.add(lblNewLabel_2);

		JPanel panel_4 = new JPanel();
		verticalBox_1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		Box verticalBox_3 = Box.createVerticalBox();
		panel_5.add(verticalBox_3);

		JLabel lblNewLabel_3 = new JLabel("Thể loại");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_3.add(lblNewLabel_3);

		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_3.add(rigidArea_10);

		JLabel lblNewLabel_4 = new JLabel("Thời lượng");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_3.add(lblNewLabel_4);

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);

		Box verticalBox_4 = Box.createVerticalBox();
		panel_6.add(verticalBox_4);

		
		JLabel lblNewLabel_5 = new JLabel(phim.getTheLoai());
		lblNewLabel_5.setPreferredSize(new Dimension(200, 30));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_4.add(lblNewLabel_5);

		Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_4.add(rigidArea_11);

		JLabel lblNewLabel_6 = new JLabel(phim.getThoiLuong()+" phút");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_4.add(lblNewLabel_6);

		JSeparator separator = new JSeparator();
		verticalBox.add(separator);

		JPanel panel_2 = new JPanel();
		verticalBox.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11, BorderLayout.WEST);
		panel_11.setLayout(new BorderLayout(0, 0));

		Box verticalBox_5 = Box.createVerticalBox();
		panel_11.add(verticalBox_5);

		JLabel lblNewLabel_11 = new JLabel("Ngày chiếu");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_5.add(lblNewLabel_11);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_5.add(rigidArea_1);

		JLabel lblNewLabel_12 = new JLabel("Giờ chiếu");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_5.add(lblNewLabel_12);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_5.add(rigidArea_2);

		JLabel lblNewLabel_13 = new JLabel("Phòng chiếu");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_5.add(lblNewLabel_13);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_5.add(rigidArea_3);

		JLabel lblNewLabel_14 = new JLabel("Ghế ngồi");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_5.add(lblNewLabel_14);

		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12);
		panel_12.setLayout(null);

		Box verticalBox_6 = Box.createVerticalBox();
		verticalBox_6.setBounds(0, 0, 256, 244);
		panel_12.add(verticalBox_6);

		SuatChieu suatchieu = ChonPhim.suatChieu1;
		JLabel lblNewLabel_16 = new JLabel(suatchieu.getNgayChieu());
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_6.add(lblNewLabel_16);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_6.add(rigidArea_6);

		JLabel lblNewLabel_17 = new JLabel(suatchieu.getGioChieu());
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_6.add(lblNewLabel_17);

		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_6.add(rigidArea_7);
		
		PhongChieuDAO phongChieuDAO = new PhongChieuDAO().getInstance();
		PhongChieu phongChieu = null;
		try {
			phongChieu = phongChieuDAO.timPhong(suatchieu.getPhongChieu().getMaPhong());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel lblNewLabel_18 = new JLabel(phongChieu.getTenPhong());
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_6.add(lblNewLabel_18);

		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_6.add(rigidArea_8);
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_6.add(lblNewLabel_19);
		
		JPanel panel_42 = new JPanel();
		panel_2.add(panel_42, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_19_1 = new JLabel(ChonGhe.chuoiGhe);
		lblNewLabel_19_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_42.add(lblNewLabel_19_1);

		JPanel panel_38 = new JPanel();
		verticalBox.add(panel_38);
		panel_38.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("Dịch vụ");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_38.add(lblNewLabel_10, BorderLayout.NORTH);

		JPanel panel_41 = new JPanel();
		verticalBox.add(panel_41);
		panel_41.setLayout(new BorderLayout(0, 0));

		btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setForeground(new Color(255, 255, 255));
		btnThanhToan.setBackground(new Color(3, 89, 157));
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnThanhToan.addActionListener(this);
		panel_41.add(btnThanhToan);

		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_1 = Box.createHorizontalBox();
		panel_7.add(horizontalBox_1);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		horizontalBox_1.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Box verticalBox_7 = Box.createVerticalBox();
		panel_8.add(verticalBox_7);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		verticalBox_7.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_7 = new JLabel("Voucher");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_10.add(lblNewLabel_7);

		JSeparator separator_1 = new JSeparator();
		verticalBox_7.add(separator_1);

		Component rigidArea_19 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_7.add(rigidArea_19);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		verticalBox_7.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_2 = Box.createHorizontalBox();
		panel_13.add(horizontalBox_2, BorderLayout.NORTH);

		JLabel lblNewLabel_8 = new JLabel("Nhập mã voucher");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_2.add(lblNewLabel_8);

		Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_12);

		txtVoucher = new JTextField();
		txtVoucher.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_2.add(txtVoucher);
		txtVoucher.setColumns(12);

		Insets insets = txtVoucher.getInsets();
		insets.top = 5;
		insets.bottom = 5;
		txtVoucher.setMargin(insets);

		Component rigidArea_20 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_7.add(rigidArea_20);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 255));
		verticalBox_7.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_3 = Box.createHorizontalBox();
		panel_14.add(horizontalBox_3);

		JLabel lblNewLabel_9 = new JLabel("Voucher");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_3.add(lblNewLabel_9);

		Component rigidArea_13 = Box.createRigidArea(new Dimension(122, 20));
		horizontalBox_3.add(rigidArea_13);

		String[] vouchers = new String[] { "", "Giảm 7000 vnđ", "Giảm 10000 vnđ", "Giảm 12000 vnđ" };
		cbVoucher = new JComboBox<>(vouchers);
		cbVoucher.setModel(new DefaultComboBoxModel(new String[] {"", "HSSV", "Thứ 4 Vui Vẻ", "Black Friday"}));
		cbVoucher.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbVoucher.setBackground(Color.WHITE);
		horizontalBox_3.add(cbVoucher);

		Component rigidArea_21 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_7.add(rigidArea_21);

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		verticalBox_7.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));

		btnApMa = new JButton("ÁP MÃ");
		btnApMa.setBackground(new Color(255, 69, 0));
		btnApMa.setForeground(new Color(255, 255, 255));
		btnApMa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_16.add(btnApMa);
		btnApMa.addActionListener(this);

		Component rigidArea_28 = Box.createRigidArea(new Dimension(210, 20));
		panel_16.add(rigidArea_28, BorderLayout.WEST);

		Component rigidArea_22 = Box.createRigidArea(new Dimension(20, 40));
		verticalBox_7.add(rigidArea_22);

		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(255, 255, 255));
		verticalBox_7.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_20 = new JLabel("Điểm beta");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_17.add(lblNewLabel_20, BorderLayout.NORTH);

		JSeparator separator_2 = new JSeparator();
		panel_17.add(separator_2, BorderLayout.SOUTH);

		Component rigidArea_23 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_7.add(rigidArea_23);

		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(255, 255, 255));
		verticalBox_7.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_4 = Box.createHorizontalBox();
		panel_18.add(horizontalBox_4, BorderLayout.NORTH);

		JLabel lblNewLabel_21 = new JLabel("Số điện thoại");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_4.add(lblNewLabel_21);

		Component rigidArea_14 = Box.createRigidArea(new Dimension(65, 20));
		horizontalBox_4.add(rigidArea_14);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_4.add(txtSDT);
		txtSDT.setColumns(10);

		Insets insets1 = txtSDT.getInsets();
		insets1.top = 5;
		insets1.bottom = 5;
		txtSDT.setMargin(insets1);

		Component rigidArea_24 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_7.add(rigidArea_24);

		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(255, 255, 255));
		verticalBox_7.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_5 = Box.createHorizontalBox();
		horizontalBox_5.setBackground(new Color(255, 255, 255));
		panel_19.add(horizontalBox_5, BorderLayout.NORTH);

		JLabel lblNewLabel_22 = new JLabel("Điểm hiện có");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_5.add(lblNewLabel_22);

		Component rigidArea_15 = Box.createRigidArea(new Dimension(65, 20));
		horizontalBox_5.add(rigidArea_15);

		lblNewLabel_23 = new JLabel("0");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_5.add(lblNewLabel_23);

		Component rigidArea_18 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_7.add(rigidArea_18);

		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(255, 255, 255));
		verticalBox_7.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_6 = Box.createHorizontalBox();
		panel_20.add(horizontalBox_6, BorderLayout.NORTH);

		JLabel lblNewLabel_24 = new JLabel("Nhập điểm");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_6.add(lblNewLabel_24);

		Component rigidArea_16 = Box.createRigidArea(new Dimension(90, 20));
		horizontalBox_6.add(rigidArea_16);

		txtDiem = new JTextField();
		txtDiem.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_6.add(txtDiem);
		txtDiem.setColumns(10);

		Insets insets2 = txtDiem.getInsets();
		insets2.top = 5;
		insets2.bottom = 5;
		txtDiem.setMargin(insets2);

		Component rigidArea_25 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_7.add(rigidArea_25);

		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(255, 255, 255));
		verticalBox_7.add(panel_21);
		panel_21.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_7 = Box.createHorizontalBox();
		panel_21.add(horizontalBox_7, BorderLayout.NORTH);

		JLabel lblNewLabel_25 = new JLabel("Số tiền được giảm");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_7.add(lblNewLabel_25);

		Component rigidArea_17 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_17);

		JLabel lblNewLabel_26 = new JLabel("1 điểm = 1 VNĐ");
		lblNewLabel_26.setBackground(new Color(255, 255, 255));
		lblNewLabel_26.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_7.add(lblNewLabel_26);

		Component rigidArea_26 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_7.add(rigidArea_26);

		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(255, 255, 255));
		verticalBox_7.add(panel_22);
		panel_22.setLayout(new BorderLayout(0, 0));

		btnDoiDiem = new JButton("ĐỔI ĐIỂM");
		btnDoiDiem.setBackground(new Color(255, 69, 0));
		btnDoiDiem.setForeground(new Color(255, 255, 255));
		btnDoiDiem.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_22.add(btnDoiDiem);

		Component rigidArea_27 = Box.createRigidArea(new Dimension(210, 20));
		panel_22.add(rigidArea_27, BorderLayout.WEST);

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 255));
		horizontalBox_1.add(panel_15);

		Component rigidArea_30 = Box.createRigidArea(new Dimension(10, 20));
		panel_15.add(rigidArea_30);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		horizontalBox_1.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		Box verticalBox_8 = Box.createVerticalBox();
		panel_9.add(verticalBox_8, BorderLayout.NORTH);

		Component rigidArea_31 = Box.createRigidArea(new Dimension(20, 5));
		verticalBox_8.add(rigidArea_31);

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(255, 255, 255));
		verticalBox_8.add(panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_27 = new JLabel("Chọn phương thức thanh toán");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_23.add(lblNewLabel_27, BorderLayout.NORTH);

		JSeparator separator_3 = new JSeparator();
		panel_23.add(separator_3, BorderLayout.SOUTH);

		Component rigidArea_29 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_8.add(rigidArea_29);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_8.add(tabbedPane);

		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Trực tiếp", null, panel_24, null);
		panel_24.setLayout(new BorderLayout(0, 0));

		Box verticalBox_9 = Box.createVerticalBox();
		panel_24.add(verticalBox_9);

		Component rigidArea_33 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_9.add(rigidArea_33);

		JPanel panel_26 = new JPanel();
		panel_26.setBackground(new Color(255, 255, 255));
		verticalBox_9.add(panel_26);
		panel_26.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_28 = new JLabel("Thanh toán trực tiếp");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_26.add(lblNewLabel_28);

		Component rigidArea_42 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_9.add(rigidArea_42);

		JPanel panel_27 = new JPanel();
		panel_27.setBackground(new Color(255, 255, 255));
		verticalBox_9.add(panel_27);
		panel_27.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_8 = Box.createHorizontalBox();
		panel_27.add(horizontalBox_8, BorderLayout.NORTH);

		JLabel lblNewLabel_29 = new JLabel("Tổng tiền");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_8.add(lblNewLabel_29);

		Component rigidArea_37 = Box.createRigidArea(new Dimension(305, 20));
		horizontalBox_8.add(rigidArea_37);

		double tongtienGhe = ChonGhe.tongTienGhe;
		double tongtienDichVu = DichVu.tongTien;

		double tongTien = tongtienDichVu + tongtienGhe;
		tongTienChuaGiam = tongTien + tongTien*0.08;
		lblTongTien = new JLabel(tongTienChuaGiam+"");
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_8.add(lblTongTien);
		
		JLabel lblVn = new JLabel(" VNĐ");
		lblVn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_8.add(lblVn);

		Component rigidArea_41 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_9.add(rigidArea_41);

		JPanel panel_28 = new JPanel();
		panel_28.setBackground(new Color(255, 255, 255));
		verticalBox_9.add(panel_28);
		panel_28.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_9 = Box.createHorizontalBox();
		panel_28.add(horizontalBox_9, BorderLayout.NORTH);

		JLabel lblNewLabel_31 = new JLabel("Tổng tiền được giảm");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_9.add(lblNewLabel_31);

		Component rigidArea_38 = Box.createRigidArea(new Dimension(180, 20));
		horizontalBox_9.add(rigidArea_38);

		tongTienGiam = 0;
		lblTienDuocGiam = new JLabel(tongTienGiam+"");
		lblTienDuocGiam.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_9.add(lblTienDuocGiam);
		
		JLabel lblVn_1 = new JLabel(" VNĐ");
		lblVn_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_9.add(lblVn_1);

		Component rigidArea_43 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_9.add(rigidArea_43);

		JPanel panel_29 = new JPanel();
		panel_29.setBackground(new Color(255, 255, 255));
		verticalBox_9.add(panel_29);
		panel_29.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_10 = Box.createHorizontalBox();
		panel_29.add(horizontalBox_10, BorderLayout.NORTH);

		JLabel lblNewLabel_33 = new JLabel("Số tiền cần thanh toán");
		lblNewLabel_33.setForeground(Color.RED);
		lblNewLabel_33.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_10.add(lblNewLabel_33);

		Component rigidArea_40 = Box.createRigidArea(new Dimension(160, 20));
		horizontalBox_10.add(rigidArea_40);
		
		tongTienCanThanhToan = tongTienChuaGiam - tongTienGiam;
		lblTienThanhToan = new JLabel(tongTienCanThanhToan+"");
		lblTienThanhToan.setForeground(Color.RED);
		lblTienThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_10.add(lblTienThanhToan);
		
		JLabel lblVn_2 = new JLabel(" VNĐ");
		lblVn_2.setForeground(Color.RED);
		lblVn_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_10.add(lblVn_2);

		Component rigidArea_45 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_9.add(rigidArea_45);

		JPanel panel_30 = new JPanel();
		panel_30.setBackground(new Color(255, 255, 255));
		verticalBox_9.add(panel_30);
		panel_30.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_11 = Box.createHorizontalBox();
		panel_30.add(horizontalBox_11);

		JLabel lblNewLabel_35 = new JLabel("Tiền nhận");
		lblNewLabel_35.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_11.add(lblNewLabel_35);

		Component rigidArea_44 = Box.createRigidArea(new Dimension(120, 20));
		horizontalBox_11.add(rigidArea_44);
		
		txtTienNhan = new JTextField();
		txtTienNhan.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_11.add(txtTienNhan);
		txtTienNhan.setColumns(5);
		
		btnNewButton = new JButton("Xác Nhận");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		horizontalBox_11.add(btnNewButton);

		Component rigidArea_50 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_9.add(rigidArea_50);

		JPanel panel_31 = new JPanel();
		panel_31.setBackground(new Color(255, 255, 255));
		verticalBox_9.add(panel_31);
		panel_31.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_12 = Box.createHorizontalBox();
		panel_31.add(horizontalBox_12, BorderLayout.NORTH);

		JPanel panel_33 = new JPanel();
		panel_33.setBackground(new Color(255, 255, 255));
		horizontalBox_12.add(panel_33);
		panel_33.setLayout(new BorderLayout(0, 0));

		Box verticalBox_10 = Box.createVerticalBox();
		panel_33.add(verticalBox_10, BorderLayout.NORTH);
		nhanTien = new JButton[9];
		soLuongnhanTien = new int[9]; 
		nhanTien[0] = new JButton("1000");
		nhanTien[0].setForeground(new Color(255, 255, 255));
		nhanTien[0].setBackground(new Color(3, 89, 157));
		nhanTien[0].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_10.add(nhanTien[0]);

		Component rigidArea_51 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_10.add(rigidArea_51);

		nhanTien[1] = new JButton("2000");
		nhanTien[1].setBackground(new Color(3, 89, 157));
		nhanTien[1].setForeground(new Color(255, 255, 255));
		nhanTien[1].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_10.add(nhanTien[1]);

		Component rigidArea_52 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_10.add(rigidArea_52);

		nhanTien[2] = new JButton("5000");
		nhanTien[2].setForeground(new Color(255, 255, 255));
		nhanTien[2].setBackground(new Color(3, 89, 157));
		nhanTien[2].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_10.add(nhanTien[2]);

		Component rigidArea_46 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_12.add(rigidArea_46);

		JPanel panel_34 = new JPanel();
		panel_34.setBackground(new Color(255, 255, 255));
		horizontalBox_12.add(panel_34);
		panel_34.setLayout(new BorderLayout(0, 0));

		Box verticalBox_11 = Box.createVerticalBox();
		panel_34.add(verticalBox_11, BorderLayout.NORTH);

		nhanTien[3] = new JButton("10000");
		nhanTien[3].setForeground(new Color(255, 255, 255));
		nhanTien[3].setBackground(new Color(3, 89, 157));
		nhanTien[3].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_11.add(nhanTien[3]);

		Component rigidArea_53 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_11.add(rigidArea_53);

		nhanTien[4] = new JButton("20000");
		nhanTien[4].setForeground(new Color(255, 255, 255));
		nhanTien[4].setBackground(new Color(3, 89, 157));
		nhanTien[4].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_11.add(nhanTien[4]);

		Component rigidArea_54 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_11.add(rigidArea_54);

		nhanTien[5] = new JButton("50000");
		nhanTien[5].setForeground(new Color(255, 255, 255));
		nhanTien[5].setBackground(new Color(3, 89, 157));
		nhanTien[5].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_11.add(nhanTien[5]);

		Component rigidArea_47 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_12.add(rigidArea_47);

		JPanel panel_35 = new JPanel();
		panel_35.setBackground(new Color(255, 255, 255));
		horizontalBox_12.add(panel_35);
		panel_35.setLayout(new BorderLayout(0, 0));

		Box verticalBox_12 = Box.createVerticalBox();
		panel_35.add(verticalBox_12, BorderLayout.NORTH);

		nhanTien[6] = new JButton("100000");
		nhanTien[6].setForeground(new Color(255, 255, 255));
		nhanTien[6].setBackground(new Color(3, 89, 157));
		nhanTien[6].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_12.add(nhanTien[6]);

		Component rigidArea_55 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_12.add(rigidArea_55);

		nhanTien[7] = new JButton("200000");
		nhanTien[7].setForeground(new Color(255, 255, 255));
		nhanTien[7].setBackground(new Color(3, 89, 157));
		nhanTien[7].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_12.add(nhanTien[7]);

		Component rigidArea_56 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_12.add(rigidArea_56);

		nhanTien[8] = new JButton("500000");
		nhanTien[8].setForeground(new Color(255, 255, 255));
		nhanTien[8].setBackground(new Color(3, 89, 157));
		nhanTien[8].setFont(new Font("Tahoma", Font.PLAIN, 25));
		verticalBox_12.add(nhanTien[8]);

		Component rigidArea_49 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_9.add(rigidArea_49);

		JPanel panel_32 = new JPanel();
		panel_32.setBackground(new Color(255, 255, 255));
		verticalBox_9.add(panel_32);
		panel_32.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_13 = Box.createHorizontalBox();
		panel_32.add(horizontalBox_13, BorderLayout.NORTH);

		JLabel lblNewLabel_36 = new JLabel("Tiền trả lại");
		lblNewLabel_36.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_13.add(lblNewLabel_36);

		Component rigidArea_48 = Box.createRigidArea(new Dimension(290, 20));
		horizontalBox_13.add(rigidArea_48);
		
		double tongTienTraLai = tongtienNhan - tongTienCanThanhToan;
		lblTienTra = new JLabel(tongTienTraLai+"");
		lblTienTra.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_13.add(lblTienTra);
		
		JLabel lblVn_3 = new JLabel(" VNĐ");
		lblVn_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		horizontalBox_13.add(lblVn_3);

		JPanel panel_25 = new JPanel();
		tabbedPane.addTab("Online", null, panel_25, null);

		JPanel panel_36 = new JPanel();
		contentPane.add(panel_36, BorderLayout.NORTH);
		panel_36.setLayout(new BorderLayout(0, 0));

		JPanel panel_37 = new JPanel();
		panel_37.setBackground(new Color(255, 255, 255));
		panel_36.add(panel_37, BorderLayout.NORTH);
		panel_37.setLayout(new BorderLayout(0, 0));

		Component rigidArea_32 = Box.createRigidArea(new Dimension(1079, 20));
		panel_37.add(rigidArea_32, BorderLayout.NORTH);

		JButton btnNewButton_13 = new JButton("   Trở Lại   ");
		btnNewButton_13.setForeground(new Color(255, 255, 255));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DichVu dichvu = new DichVu();
				dichvu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dichvu.setExtendedState(MAXIMIZED_BOTH);
				dichvu.setVisible(true);
				setVisible(false);
				DichVu.resetStaticVariables();
			}
		});
		btnNewButton_13.setBackground(new Color(3, 89, 157));
		btnNewButton_13.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnNewButton_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_37.add(btnNewButton_13, BorderLayout.WEST);

		Component rigidArea_57 = Box.createRigidArea(new Dimension(1075, 20));
		panel_37.add(rigidArea_57, BorderLayout.SOUTH);
		
		for(int i=0; i<9; i++) {
			soLuongnhanTien[i] = 0;
			nhanTien[i].addActionListener(this);
			nhanTien[i].addMouseListener(this);
		}
		txtSDT.addActionListener(this);
		txtTienNhan.addActionListener(this);
		btnNewButton.addActionListener(this);
		btnDoiDiem.addActionListener(this);
	}
	private void canNhatTien() {
		lblTienTra.setText(tongtienCanTraLai+"");
		lblTienDuocGiam.setText(tongTienGiam+"");
        lblTienThanhToan.setText(tongTienCanThanhToan+"");
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    Object source = e.getSource();
	    if(source.equals(btnDoiDiem)) {
	    	if(kh != null ) {
			    if(txtDiem.getText().equals("") || txtDiem.getText() == null) {
			    	JOptionPane.showMessageDialog(this, "Vui lòng nhập điểm cần đổi");
			    	return;
			    }
		    	diemCanDoi = Integer.parseInt(txtDiem.getText());
		    	if(diemCanDoi < 1000) {
			    	JOptionPane.showMessageDialog(this, "Điểm cần đổi từ 1000!");
			    	diemCanDoi = 0;
			    	return;
			    }
	    		if(kh.get(0).getDiemTichLuy() >= diemCanDoi) {
	    			tongTienGiam += diemCanDoi;
	    			tongTienCanThanhToan = tongTienChuaGiam - tongTienGiam;
	    			daDoiDiem = true;
	    			canNhatTien();
	    		}else {
	    			JOptionPane.showMessageDialog(this, "Điểm sử dụng cao hơn điểm tích lũy");
	    			return;
	    		}
	    	}else {
	    		JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại trước khi sử dụng điểm");
	    		return;
	    	}
	    }
	    if(source.equals(txtSDT)) {
            String phoneNumber = txtSDT.getText();
            try {
				kh = khachHangDao.timTenKHTheoSDT(phoneNumber);
				lblNewLabel_23.setText(kh.get(0).getDiemTichLuy()+"");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}            
        }
	    if(source.equals(txtTienNhan)) {
	    	txtTienNhan.setText("");
	    	for(int j =0 ; j<9; j++) {
	    		soLuongnhanTien[j] = 0;
	    	} 	
	    }
	    if(source.equals(btnNewButton)) {
	    	if(txtTienNhan.getText().equals("")) {
	    		JOptionPane.showMessageDialog(this, "Nhập số tiền nhận");
	    	}else {
	    		double tienNhan = Double.parseDouble(txtTienNhan.getText());
		    	tongtienCanTraLai = tienNhan - tongTienCanThanhToan;
			    canNhatTien();
	    	}
	    }
	    if(source.equals(btnThanhToan)) {
	    	HoaDonXemPhim hdPhim;
	    	if(kh == null) {
	    		hdPhim = new HoaDonXemPhim(null,TrangChu.nhanVien,ChonPhim.suatChieu1 );
	    		System.out.println("Loi o day");
	    	}else {
	    		hdPhim = new HoaDonXemPhim(kh.get(0),TrangChu.nhanVien,ChonPhim.suatChieu1);
	    		
	    	}
	    	try {
	    		hoadonPhim_DAO.addHoaDonTong(hdPhim);
	    		int maHD;
				try {
					maHD = hoadonPhim_DAO.getLatestMaHoaDon();
					hdPhim.setMaHDXemPhim(maHD);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		double giaVe = 0;
	    		if(ChonGhe.loaiGheDaChon == 1 ){
	    			giaVe = 60000;
	    		}else if(ChonGhe.loaiGheDaChon == 2) {
	    			giaVe = 80000;
	    		}else if(ChonGhe.loaiGheDaChon == 3) {
	    			giaVe = 130000;
	    		}
	    		for (Ghe ghe : ChonGhe.dsGheDaChon) {
	    			VeXemPhim ve = new VeXemPhim(hdPhim, giaVe, ghe);
	    			veXemPhim_DAO.addVeXemPhim(ve);
				}	
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	if(daDoiDiem) {
	    		KhachHang khachHang = new KhachHang();
		    	khachHang.setMaKhachHang(kh.get(0).getMaKhachHang());	
		    	khachHang.setDiemTichLuy(kh.get(0).getDiemTichLuy() - diemCanDoi);
		    	try {
					khachHangDao.updateDiemKhachHang(khachHang);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    	if(kh != null) {
	    		KhachHang khachHang = new KhachHang();
		    	khachHang.setMaKhachHang(kh.get(0).getMaKhachHang());
		    	int diemSeTich = (int) (tongTienCanThanhToan / 1000);;
		    	khachHang.setDiemTichLuy(kh.get(0).getDiemTichLuy() + diemSeTich);
		    	try {
					khachHangDao.updateDiemKhachHang(khachHang);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    	
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
	    	ChonGhe.resetStaticVariables();
	    	DichVu.resetStaticVariables();
	    	JOptionPane.showMessageDialog(this, "Thanh Toán Thành Công");
	    }
	    if (source.equals(btnApMa)) {
	        int selectedIndex = cbVoucher.getSelectedIndex();
	        tongTienGiam = 0;
	        switch (selectedIndex) {
	            case 1:
	                lblTienDuocGiam.setText("20000");
	                tongTienGiam = 20000;
	                break;
	            case 2:
	                lblTienDuocGiam.setText("30000");
	                tongTienGiam = 30000;
	                break;
	            case 3: 
	                lblTienDuocGiam.setText("35000");
	                tongTienGiam = 35000;
	                break;
	            default: 
	                lblTienDuocGiam.setText("0");
	                tongTienGiam = 0;
	                break;
	        }	        
            tongTienCanThanhToan = tongTienChuaGiam - tongTienGiam;
            canNhatTien();
	    }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		// TODO Auto-generated method stub
		 if (e.getClickCount() == 1) {
		        for (int i = 0; i < 9; i++) {
		            if (obj.equals(nhanTien[i])) {
		                soLuongnhanTien[i]++;
		            }
		        }
		    }
		    if (e.getClickCount() == 2) {
		        for (int i = 0; i < 9; i++) {
		            if (obj.equals(nhanTien[i])) {
		                if (soLuongnhanTien[i] > 0) {
		                    soLuongnhanTien[i] -= 2;
		                }
		            }
		        }
		    }
		    double total = 0;
		    double[] menhGia = {1000, 2000, 5000, 10000, 20000, 50000, 100000, 200000, 500000};
		    for (int i = 0; i < 9; i++) {
		    	total += soLuongnhanTien[i] * menhGia[i];
		    }
		    txtTienNhan.setText(total+"");
		    tongtienCanTraLai = tongtienNhan - tongTienCanThanhToan;
		    canNhatTien();
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