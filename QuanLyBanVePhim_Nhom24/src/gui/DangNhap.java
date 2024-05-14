package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.TaiKhoanDAO;
import entity.TaiKhoan;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DangNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	public static TaiKhoan taiKhoan;
	private TaiKhoanDAO taiKhoanDAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		try {
            taiKhoanDAO = (TaiKhoanDAO) TaiKhoanDAO.getInstance();
        } catch (Exception e) {
            System.out.println("Loi Ket Noi");
        }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 376);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 225, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng Nhập");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(188, 10, 187, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(40, 60, 119, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(40, 148, 119, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(35, 96, 487, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("ĐĂNG NHẬP");
		getRootPane().setDefaultButton(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String tenTaiKhoan = textField.getText().trim();
                String matKhau = String.valueOf(passwordField.getPassword());
                // kiểm tra dữ liệu
                if (tenTaiKhoan.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Vui lòng nhập tên người dùng");
                } else if (matKhau.isEmpty()) {
                	JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu");
                }
                // lấy tài khoản từ db lên
                try {
                	taiKhoan = taiKhoanDAO.getTaiKhoan(tenTaiKhoan);
                	System.out.println("đã tới đây!");
                } catch (Exception e1) { 
                	JOptionPane.showMessageDialog(null,e1.getMessage());
                    return;
                }
                
                if(!taiKhoan.isKichHoat()) {
                	JOptionPane.showMessageDialog(null, "Tài Khoản Đã Bị Khóa");
                	return;
                }
                
                String tenTKSQL = taiKhoan.getTenDangNhap().trim();
                String matKhauSQL = taiKhoan.getMatKhau().trim();
                
                if (tenTaiKhoan.equals(tenTKSQL) && matKhau.equals(matKhauSQL)) {
                    setVisible(false);
                    try {
						new TrangChu().setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } else {
                	JOptionPane.showMessageDialog(null,"Sai tên đăng nhập hoặc mật khẩu");
                    textField.requestFocus();
                    passwordField.selectAll();
                }
			}
		});
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBackground(new Color(222, 59, 64)); 
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(35, 260, 487, 53);
		btnNewButton.setBorderPainted(false);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(35, 184, 487, 42);
		contentPane.add(passwordField);
		
	}
}
