package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DichVuDAO;
import entity.ChiTietDichVu;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class DichVu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private DichVuDAO dichVuDAO;
	private ArrayList<entity.DichVu> dichVus = new ArrayList<entity.DichVu>();
	private int[] sldv = new int[dichVus.size()];
	private JButton[] giam;
	private JButton[] tang;
	private JTextField[] textField;
	private JButton btnNewButton_13_1;
	public static ArrayList<ChiTietDichVu> dsCacDichVuChon = new ArrayList<>();
	public static double tongTien = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DichVu frame = new DichVu();
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
	public DichVu() {
		dichVuDAO = DichVuDAO.getInstance();
		
		try {
			dichVus = dichVuDAO.getDichVus();
			System.out.println("Lay duoc danh sach");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Khong lay duoc danh sach");
			e.printStackTrace();
		}
		for(int i=0; i< dichVus.size(); i++) {
			System.out.println(dichVus.get(i).getHinhAnh());
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Dịch Vụ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_2.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panel_4.add(rigidArea, BorderLayout.WEST);
		
		JButton btnNewButton_13 = new JButton("   Trở Lại   ");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ChonGhe.flag) {
					ChonGhe chonghe = new ChonGhe();
					chonghe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					chonghe.setExtendedState(MAXIMIZED_BOTH);
					chonghe.setVisible(true);
	                setVisible(false);
	                ChonGhe.resetStaticVariables();
				}else {
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
			}
		});
		btnNewButton_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_13.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnNewButton_13.setBackground(Color.LIGHT_GRAY);
		panel_4.add(btnNewButton_13, BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_5.add(rigidArea_1, BorderLayout.EAST);
		
		btnNewButton_13_1 = new JButton("Tiêp Tục");
		btnNewButton_13_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_13_1.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnNewButton_13_1.setBackground(Color.LIGHT_GRAY);
		panel_5.add(btnNewButton_13_1, BorderLayout.WEST);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hoặc tên dịch vụ: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_6.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_6.add(textField_1);
		textField_1.setColumns(20);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_6.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(255, 255, 255));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setColumnHeaderView(panel_1);
		
		Box verticalBox = Box.createVerticalBox();
		panel_1.add(verticalBox);
		
		int dem = 0, sl = 5;
		
		Box horizontalBox = null;
		textField = new JTextField[dichVus.size()];
		giam = new JButton[dichVus.size()];
	    tang = new JButton[dichVus.size()];
		
		for(int i = 0; i < dichVus.size(); i++) {
			JPanel panel_3_1 = new JPanel();
			dem++;
            if(dem % 3 == 1) {
                horizontalBox = Box.createHorizontalBox();
                verticalBox.add(horizontalBox); 
            }
            horizontalBox.add(panel_3_1);
            
			JLabel lblNewLabel_1_1 = new JLabel("");
			lblNewLabel_1_1.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 5));
			lblNewLabel_1_1.setBounds(new Rectangle(2, 2, 3, 2));
			lblNewLabel_1_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
			String urlString = dichVus.get(i).getHinhAnh(); 
		    URL imageURL;
			imageURL = getClass().getResource(urlString);
			try {
				BufferedImage image = ImageIO.read(imageURL);
				Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
				ImageIcon newIcon = new ImageIcon(scaledImage);
				lblNewLabel_1_1.setIcon(newIcon);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
	    	panel_3_1.setLayout(new BorderLayout(0, 0));
			panel_3_1.add(lblNewLabel_1_1, BorderLayout.WEST);
			Box verticalBox_1 = Box.createVerticalBox();
			verticalBox_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panel_3_1.add(verticalBox_1);
			
			JLabel lblNewLabel_2_1 = new JLabel(dichVus.get(i).getTenDichVu());
			lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
			verticalBox_1.add(lblNewLabel_2_1);
			
			JLabel lblNewLabel_3_1 = new JLabel(dichVus.get(i).getMoTa());
			lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			verticalBox_1.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_4_1 = new JLabel("- Nhận ngay trong ngày đã mua");
			lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			verticalBox_1.add(lblNewLabel_4_1);
			
			double number = dichVus.get(i).getGiaBan();
			DecimalFormat decimalFormat = new DecimalFormat("#,###");
			String formattedNumber = decimalFormat.format(number);
			
			JLabel lblNewLabel_5_1 = new JLabel(formattedNumber);
			lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 23));
			verticalBox_1.add(lblNewLabel_5_1);
			
			JPanel panel_3 = new JPanel();
			verticalBox_1.add(panel_3);
			
			giam[i] = new JButton(" - ");
			giam[i].setBorderPainted(false);
			giam[i].setForeground(Color.WHITE);
			giam[i].setBackground(new Color(0, 189, 214));
			giam[i].setFont(new Font("Tahoma", Font.PLAIN, 25));
			
			
			textField[i] = new JTextField(2);
		    textField[i].setFocusTraversalPolicyProvider(true);
		    textField[i].setHorizontalAlignment(SwingConstants.CENTER);
		    textField[i].setText("0");
		    textField[i].setFont(new Font("Tahoma", Font.BOLD, 25));
		    textField[i].setColumns(2);
			
			Arrays.fill(sldv, 0);
			
			tang[i] = new JButton("+");
			tang[i].setBorderPainted(false);
			tang[i].setBackground(new Color(0, 189, 214));
			tang[i].setForeground(Color.WHITE);
			tang[i].setFont(new Font("Tahoma", Font.PLAIN, 25));
			
			panel_3.add(giam[i]);
			panel_3.add(textField[i]);
			panel_3.add(tang[i]);
			
			if(sl % 3 == 1 && i+1 == sl) {
				Dimension chieurong = panel_3_1.getPreferredSize();
				Component rigidArea1 = Box.createRigidArea(chieurong);
				Component rigidArea2 = Box.createRigidArea(chieurong);
				horizontalBox.add(rigidArea1);
				horizontalBox.add(rigidArea2);
			}else if(sl % 3 == 2 && i+1 == sl) {
				Dimension chieurong = panel_3_1.getPreferredSize();
				Component rigidArea1 = Box.createRigidArea(chieurong);
				horizontalBox.add(rigidArea1);
			}
		}
		btnNewButton_13_1.addActionListener(this);
		for (int i = 0; i < tang.length; i++) {
			tang[i].addActionListener(this);
        }
		for (int i = 0; i < giam.length; i++) {
			giam[i].addActionListener(this);
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnNewButton_13_1)) {
			for (int i = 0; i < textField.length; i++) {
				int sl = Integer.parseInt(textField[i].getText());
				if(sl > 0) {
					ChiTietDichVu chiTietDichVu = new ChiTietDichVu(dichVus.get(i).getMaDichVu(), sl);
					dsCacDichVuChon.add(chiTietDichVu);
				}
			}
			ThanhToan thanhtoan = new ThanhToan();
			thanhtoan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			thanhtoan.setExtendedState(MAXIMIZED_BOTH);
			thanhtoan.setVisible(true);
            setVisible(false);
		}
		
		for (int i = 0; i < tang.length; i++) {
			int sl = Integer.parseInt(textField[i].getText());
			System.out.println(sl);
			if (obj.equals(tang[i])) {
				sl++;
				textField[i].setText(String.valueOf(sl));
				tongTien += dichVus.get(i).getGiaBan() * sl;
			}
		}
		for (int i = 0; i < giam.length; i++) {
			int sl = Integer.parseInt(textField[i].getText());
			System.out.println(sl);
			if (obj.equals(giam[i])) {
				if (sl <= 0) {
					return;
				}else {
					sl--;
					textField[i].setText(String.valueOf(sl));
					tongTien -= dichVus.get(i).getGiaBan() * sl;
				}
			}
		}
	}
	public static void resetStaticVariables() {
		// TODO Auto-generated method stub
		dsCacDichVuChon = new ArrayList<ChiTietDichVu>();
		tongTien = 0;
	}
}
