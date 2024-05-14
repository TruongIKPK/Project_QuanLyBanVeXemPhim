package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Component;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import dao.Phim_DAO;
import dao.SuatChieu_DAO;
import entity.Phim;
import entity.SuatChieu;

import java.awt.GridLayout;
import java.awt.SystemColor;

public class ChonPhim extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private static LocalDate currentDate = LocalDate.now();
	private JButton[] nutChonNgay;
	private JScrollPane scrollPane;
	private SuatChieu_DAO suatChieuDAO;
	private ArrayList<SuatChieu> suatChieu;
	private JButton[] nutSuatChieu;
	private Phim_DAO phim_DAO;
	private JButton btnNewButton_10;
	private JPanel panel_12;
	private JButton btnNewButton_20;
	public static SuatChieu suatChieu1;
	public static Phim phimDaChon;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChonPhim frame = new ChonPhim();
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
	public ChonPhim() throws Exception {
		phim_DAO = Phim_DAO.getInstance();
		nutChonNgay = new JButton[7];
		suatChieuDAO = suatChieuDAO.getInstance();
		LocalDateTime currentDate1 = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String ngays = currentDate1.format(formatter1);
		loadSuatChieu(ngays);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1079, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Danh Sách Phim Đang Chiếu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_2.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panel_4.add(rigidArea, BorderLayout.WEST);
		
		JButton btnNewButton_13 = new JButton("   Thoát   ");
		btnNewButton_13.addActionListener(new ActionListener() {
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
		btnNewButton_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_13.setBorder(new EmptyBorder(10, 20, 10, 20));
		btnNewButton_13.setBackground(Color.LIGHT_GRAY);
		panel_4.add(btnNewButton_13, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_5.add(rigidArea_1, BorderLayout.EAST);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hoặc tên phim: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_10.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(20);
		panel_10.add(textField);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_10.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Lấy Vé Xem Phim");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaoDienLayVe layve = new GiaoDienLayVe();
				layve.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				layve.setExtendedState(MAXIMIZED_BOTH);
				layve.setVisible(true);
                setVisible(false);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_10.add(btnNewButton_1_1);
		
		JPanel panel_11 = new JPanel();
		panel_6.add(panel_11, BorderLayout.SOUTH);
		
		panel_12 = new JPanel();
		
		btnNewButton_10 = new JButton("<<");
		panel_11.add(btnNewButton_10);
		
		panel_12.setBackground(Color.LIGHT_GRAY);
		panel_11.add(panel_12);
		
		for(int i = 0; i<7; i++) {
			nutChonNgay[i] = new JButton(currentDate.plusDays(i).format(DateTimeFormatter.ofPattern("MM-dd")));
			panel_12.add(nutChonNgay[i]);
		}
		
		btnNewButton_20 = new JButton(">>");
		panel_11.add(btnNewButton_20);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(158, 575));
		panel_1.add(rigidArea_2, BorderLayout.WEST);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(151, 575));
		panel_1.add(rigidArea_3, BorderLayout.EAST);
		
		JSeparator separator = new JSeparator();
		panel_1.add(separator, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		LoadDSPhim();
		for(int j = 0; j < 7; j++) {
			nutChonNgay[j].addActionListener(this);
		}
		btnNewButton_10.addActionListener(this);
		btnNewButton_20.addActionListener(this);
}
	public void LoadDSPhim() throws Exception {
		nutSuatChieu = new JButton[suatChieu.size()];
		
		JPanel panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new GridLayout(5, 1, 0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		panel_3.add(verticalBox);
		
		for(int i=0; i < suatChieu.size(); i++) {
			JPanel panel_7 = new JPanel();
			verticalBox.add(panel_7);
			
			panel_7.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
			int maPhim = suatChieu.get(i).getPhim().getMaPhim();
			Phim phim = phim_DAO.timPhim(maPhim);
			String urlString = phim.getHinhAnh(); 
		    URL imageURL;
		    imageURL = getClass().getResource(urlString);
			try {
				BufferedImage image = ImageIO.read(imageURL);
				Image scaledImage = image.getScaledInstance(100, 175, Image.SCALE_DEFAULT);
				ImageIcon newIcon1 = new ImageIcon(scaledImage);
				lblNewLabel_2.setIcon(newIcon1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel_7.add(lblNewLabel_2, BorderLayout.WEST);
			
			JPanel panel_9 = new JPanel();
			panel_7.add(panel_9);
			panel_9.setLayout(new BorderLayout(0, 0));
			
			Box horizontalBox = Box.createHorizontalBox();
			panel_9.add(horizontalBox, BorderLayout.NORTH);
			
			JLabel lblNewLabel_4 = new JLabel(phim.getTenPhim());
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
			horizontalBox.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("Phụ Đề 2D");
			horizontalBox.add(lblNewLabel_5);
			
			JPanel panel_13 = new JPanel();
			panel_9.add(panel_13, BorderLayout.CENTER);
			panel_13.setLayout(new BorderLayout(0, 0));
			
			String giochieu = suatChieu.get(i).getGioChieu();
			String giochieuShort = giochieu.substring(0, 5);
			nutSuatChieu[i] = new JButton(giochieuShort);
			nutSuatChieu[i].setFont(new Font("Tahoma", Font.BOLD, 25));
			panel_13.add(nutSuatChieu[i]);

		}	
		for(int j = 0; j < nutSuatChieu.length; j++) {
			nutSuatChieu[j].addActionListener(this);
		}
	}
	public void loadSuatChieu(String ngay) {
		try {
			suatChieu = suatChieuDAO.getSuatChieuTheoNgay(ngay);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void updateDateButtons() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
	    for(int j = 0; j < 7; j++) {
			nutChonNgay[j].setText(formatter.format(currentDate.plusDays(j+1)));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnNewButton_10)) {
			currentDate = currentDate.minusDays(5);
            updateDateButtons();
		}
		if(obj.equals(btnNewButton_20)) {
			currentDate = currentDate.plusDays(7);
            updateDateButtons();
		}
	 for(int j = 0; j < 7; j++) {
		 nutChonNgay[j].setBackground(UIManager.getColor("Button.background"));
		 nutChonNgay[j].setForeground(Color.black);
		 if(obj.equals(nutChonNgay[j])) {
				int currentYear = LocalDateTime.now().getYear();
				String ngay =  String.valueOf(currentYear ) +'-'+ nutChonNgay[j].getText();
				nutChonNgay[j].setBackground(Color.red);
				nutChonNgay[j].setForeground(Color.white);
				loadSuatChieu(ngay);
				try {
					LoadDSPhim();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	}
		for(int i = 0; i < nutSuatChieu.length; i++) {
			if (obj.equals(nutSuatChieu[i])) {
				try {
					phimDaChon = phim_DAO.timPhim(suatChieu.get(i).getPhim().getMaPhim());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				suatChieu1 = suatChieu.get(i);
				ChonGhe chonghe = new ChonGhe();
				chonghe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				chonghe.setExtendedState(MAXIMIZED_BOTH);
				chonghe.setVisible(true);
                setVisible(false);
			}
		}
	}
}
