package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import dao.ChucVuDAO;
import dao.NhanVienDAO;
import entity.ChucVu;
import entity.NhanVien;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

public class TrangChu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private NhanVienDAO nhanVienDAO;
	public static NhanVien nhanVien;
	private ChucVuDAO chucVuDAO;
	private ChucVu chucVu;
	private JLabel lblThoiGian_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public void TruyXuatDAO() {
		nhanVienDAO = NhanVienDAO.getInstance();
		try {
			nhanVien = nhanVienDAO.getNhanVienDN(DangNhap.taiKhoan.getMaTaiKhoan());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		int maChucVu = nhanVien.getChucVu().getMaChucVu();
		chucVuDAO = ChucVuDAO.getInstance();
		try {
			chucVu = chucVuDAO.getChucVu(maChucVu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public TrangChu() throws Exception {
		TruyXuatDAO();
		String tenNhanVien = nhanVien.getTenNV().trim();
		String tenChucVu = chucVu.getTenChucVu().trim();
		int maChucVu = chucVu.getMaChucVu();
		
		setTitle("Trang Chủ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1385, 847);
		setLocationRelativeTo(null);
		setUndecorated(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_7);
		GridLayout gl_panel_7 = new GridLayout(2,3);
		gl_panel_7.setVgap(2);
		gl_panel_7.setHgap(2);
		panel_7.setLayout(gl_panel_7);
		
		JButton btnBanVe = new JButton("Bán Vé");
		btnBanVe.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBanVe.setIcon(new ImageIcon(TrangChu.class.getResource("/images/Icons8-Windows-8-Cinema-Ticket.128.png")));
		btnBanVe.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_7.add(btnBanVe);
		btnBanVe.addActionListener(new ActionListener() {
            @Override
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
		
		JButton btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNhanVien qlnv = new QuanLyNhanVien();
				qlnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				qlnv.setExtendedState(MAXIMIZED_BOTH);
				qlnv.setVisible(true);
                setVisible(false);
			}
		});
		btnNhanVien.setIcon(new ImageIcon(TrangChu.class.getResource("/images/Hopstarter-Soft-Scraps-User-Administrator-Blue.128.png")));
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 22));
		if(maChucVu == 1) {
			panel_7.add(btnNhanVien);
		}	
		
		JButton btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKhachHang qlkh = new QuanLyKhachHang();
				qlkh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				qlkh.setExtendedState(MAXIMIZED_BOTH);
				qlkh.setVisible(true);
                setVisible(false);
			}
		});
		btnKhachHang.setIcon(new ImageIcon(TrangChu.class.getResource("/images/Custom-Icon-Design-Silky-Line-User-Men.128.png")));
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_7.add(btnKhachHang);
		
		JButton btnDichVu = new JButton("Dịch Vụ");
		btnDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DichVu dichvu = new DichVu();
				dichvu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dichvu.setExtendedState(MAXIMIZED_BOTH);
				dichvu.setVisible(true);
                setVisible(false);
                ChonGhe.flag = false;
			}
		});
		btnDichVu.setIcon(new ImageIcon(TrangChu.class.getResource("/images/Iconarchive-Fat-Sugar-Food-Popcorn.128.png")));
		btnDichVu.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_7.add(btnDichVu);
		
		JButton btnRap = new JButton("QL Phim");
		btnRap.setIcon(new ImageIcon(TrangChu.class.getResource("/images/Iconsmind-Outline-Cinema.128.png")));
		btnRap.setFont(new Font("Tahoma", Font.BOLD, 22));
		if (maChucVu == 1) {
			panel_7.add(btnRap);
		}
		btnRap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyPhim qlPhim = new QuanLyPhim();
				qlPhim.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				qlPhim.setExtendedState(MAXIMIZED_BOTH);
				qlPhim.setVisible(true);
                setVisible(false);
			}
		});
		
		JButton btnPhim = new JButton("Lịch Sử");
		btnPhim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LichSu lichsu = new LichSu();
				lichsu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				lichsu.setExtendedState(MAXIMIZED_BOTH);
				lichsu.setVisible(true);
                setVisible(false);
			}
		});
		btnPhim.setIcon(new ImageIcon(TrangChu.class.getResource("/images/Iconoir-Team-Iconoir-Cinema-old.128.png")));
		btnPhim.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_7.add(btnPhim);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(1359, 131));
		panel.add(rigidArea_4, BorderLayout.NORTH);
		
		Component rigidArea_4_1 = Box.createRigidArea(new Dimension(1359, 143));
		panel.add(rigidArea_4_1, BorderLayout.SOUTH);
		
		Component rigidArea_4_2 = Box.createRigidArea(new Dimension(242, 289));
		panel.add(rigidArea_4_2, BorderLayout.WEST);
		
		Component rigidArea_4_3 = Box.createRigidArea(new Dimension(252, 289));
		rigidArea_4_3.setEnabled(false);
		panel.add(rigidArea_4_3, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 105, 229));
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 105, 229));
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("PHẦN MỀM QUẢN LÝ RẠP CHIẾU PHIM");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(new Color(64, 105, 229));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_2.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(64, 105, 229));
		panel_1.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(64, 105, 229));
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		Box horizontalBox = Box.createHorizontalBox();
		panel_4.add(horizontalBox, BorderLayout.WEST);
		
		
		JLabel lblNewLabel_3 = new JLabel(tenChucVu + ": ");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		horizontalBox.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel(tenNhanVien);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		horizontalBox.add(lblNewLabel_3_1);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		panel_4.add(horizontalBox_1, BorderLayout.NORTH);
		
		JLabel lblThoiGian = new JLabel("Thời gian: ");
		lblThoiGian.setForeground(Color.WHITE);
		lblThoiGian.setFont(new Font("Tahoma", Font.BOLD, 24));
		horizontalBox_1.add(lblThoiGian);
		
		lblThoiGian_1 = new JLabel("");
		lblThoiGian_1.setForeground(Color.WHITE);
		lblThoiGian_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		horizontalBox_1.add(lblThoiGian_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(64, 105, 229));
		panel_4.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_4 = new JButton("Đăng xuất");
		btnNewButton_4.addActionListener(new ActionListener() {
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
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel_5.add(btnNewButton_4, BorderLayout.CENTER);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(92, 35));
		panel_5.add(rigidArea_2, BorderLayout.WEST);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(100, 35));
		panel_5.add(rigidArea_3, BorderLayout.EAST);
		
		Component rigidArea = Box.createRigidArea(new Dimension(1359, 67));
		panel_1.add(rigidArea, BorderLayout.NORTH);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(1359, 71));
		panel_1.add(rigidArea_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		Component rigidArea_5 = Box.createRigidArea(panel_3.getPreferredSize());
		panel_1.add(rigidArea_5, BorderLayout.WEST);
		updateTime();
	}
	private String updateTime() {
		// Lấy thời gian hiện tại
		Date currentTimeDate = new Date();

		// Định dạng thời gian
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String formattedTime = dateFormat.format(currentTimeDate);
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				autoInputData();
			}
		});
		timer.start();

		return formattedTime;
	}
	private void autoInputData() {
		lblThoiGian_1.setText(updateTime());
	}
}
