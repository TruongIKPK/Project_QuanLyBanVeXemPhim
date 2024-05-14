package gui;
import javax.swing.*;
import connect.ConnectDB;
import dao.GheDAO;
import dao.Phim_DAO;
import dao.PhongChieuDAO;
import dao.VeXemPhim_DAO;
import entity.Ghe;
import entity.Phim;
import entity.PhongChieu;
import entity.SuatChieu;
import entity.VeXemPhim;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class ChonGhe extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    
    // Màu gồm: Ghế Thường, Ghế VIP, Ghế Đôi, Đang Chọn, Đã Đặt, Bảo Trì
    private Color[] maMau = {new Color(0, 189, 214), new Color(235, 135, 138),
    		new Color(224, 88, 88), new Color(64, 105, 229), new Color(144, 149, 160)
    		,new Color(29, 33, 40)};
    private JButton[] buttons;
	private JLabel phongChieu;
	private JLabel gioChieu;
	private JLabel ngayChieu;
	private JLabel tenPhim;
	private JLabel loaiPhim;
	private JLabel tongTien;
	private JButton btndatVe;
	private JLabel thongTinGhe;
    public static String chuoiGhe;   
    private boolean[] flag_checked;
    private int soGheDaChon = 0;
    // 0 = null, 1 = Thường, 2 = VIP, 3 = Ghê Đôi.
    public static int loaiGheDaChon = 0;
	private ArrayList<Ghe> dsGhe = new ArrayList<Ghe>();
	public static ArrayList<Ghe> dsGheDaChon = new ArrayList<Ghe>();
	private GheDAO gheDAO;
	private PhongChieuDAO phongChieuDAO;
	private Phim_DAO phim_DAO;
	public static double tongTienGhe = 0;
	protected static boolean flag;
	public VeXemPhim_DAO veXemPhim_DAO;
	public ArrayList<VeXemPhim> dsvePhimDaBan;
	 public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    ChonGhe frame = new ChonGhe();
	                    frame.setExtendedState(MAXIMIZED_BOTH);
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	public static void resetStaticVariables() {
		dsGheDaChon = new ArrayList<Ghe>();
		tongTienGhe = 0;
		chuoiGhe = "";
	}
    public ChonGhe() {

    	phongChieuDAO = PhongChieuDAO.getInstance();
    	phim_DAO = Phim_DAO.getInstance();
    	gheDAO = GheDAO.getInstance();
    	veXemPhim_DAO = VeXemPhim_DAO.getInstance();
    	try {
			dsGhe = gheDAO.getGhes();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			dsvePhimDaBan = veXemPhim_DAO.dsVeDaDat(ChonPhim.suatChieu1.getMaSuatChieu());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	for (Ghe ghe1 : dsGhe) {
			for(VeXemPhim ve : dsvePhimDaBan) {
				if(ve.getGhe().getMaGhe() == ghe1.getMaGhe()) {
					ghe1.setTrangThai(2);
				}
			}
		}
    	flag_checked = new boolean[136];
    	getContentPane().setLayout(new BorderLayout(0, 0));
    	
    	Box horizontalBox = Box.createHorizontalBox();
    	getContentPane().add(horizontalBox, BorderLayout.SOUTH);
    	
    	JPanel panel = new JPanel();
    	panel.setBackground(new Color(23, 26, 31));
    	getContentPane().add(panel, BorderLayout.WEST);
    	panel.setLayout(new BorderLayout(0, 0));
    	
    	Box verticalBox = Box.createVerticalBox();
    	verticalBox.setBackground(new Color(23, 26, 31));
    	panel.add(verticalBox, BorderLayout.NORTH);
    	
    	Box horizontalBox_10_1 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_10_1);
    	
    	Box verticalBox_3 = Box.createVerticalBox();
    	horizontalBox_10_1.add(verticalBox_3);
    	
    	Component rigidArea_6_1 = Box.createRigidArea(new Dimension(20, 20));
    	verticalBox_3.add(rigidArea_6_1);
    	
    	JPanel panel_19 = new JPanel();
    	verticalBox_3.add(panel_19);
    	panel_19.setLayout(new BorderLayout(0, 0));
    	
    	JButton btnNewButton_6 = new JButton("Thoát");
    	btnNewButton_6.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				ChonPhim chonPhim;
				try {
					chonPhim = new ChonPhim();
					chonPhim.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                chonPhim.setExtendedState(MAXIMIZED_BOTH);
	                chonPhim.setVisible(true);
	                setVisible(false);
	                resetStaticVariables();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
            }   		
    	});
    	btnNewButton_6.setBorderPainted(false);
    	btnNewButton_6.setForeground(Color.WHITE);
    	btnNewButton_6.setBackground(new Color(90, 101, 124));
    	btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
    	btnNewButton_6.setFont(new Font("Dialog", Font.BOLD, 25));
    	panel_19.add(btnNewButton_6, BorderLayout.NORTH);
    	
    	Box horizontalBox_10 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_10);
    	
    	Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
    	horizontalBox_10.add(rigidArea_6);
    	
    	Box horizontalBox_1 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_1);
    	
    	JLabel lblNewLabel = new JLabel("RẠP PHIM QUỐC GIA");
    	lblNewLabel.setForeground(new Color(255, 255, 255));
    	lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 26));
    	horizontalBox_1.add(lblNewLabel);
    	
    	Box horizontalBox_12 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_12);
    	
    	Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
    	horizontalBox_12.add(rigidArea_8);
    	
    	Box horizontalBox_2 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_2);
    	
    	SuatChieu suatchieu = ChonPhim.suatChieu1;
    	PhongChieu phongChieu1;
		try {
			phongChieu1 = phongChieuDAO.timPhong(suatchieu.getPhongChieu().getMaPhong());
			String tenPhong = phongChieu1.getTenPhong();
			phongChieu = new JLabel("Cinema " + tenPhong);
	    	phongChieu.setForeground(new Color(255, 255, 255));
	    	phongChieu.setFont(new Font("Dialog", Font.BOLD, 20));
	    	horizontalBox_2.add(phongChieu);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	Box horizontalBox_3 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_3);
    	
    	JLabel lblNewLabel_2 = new JLabel("Suất Chiếu:");
    	lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
    	lblNewLabel_2.setForeground(new Color(255, 255, 255));
    	horizontalBox_3.add(lblNewLabel_2);
    	
    	String giochieu = suatchieu.getGioChieu();
		String giochieuShort = giochieu.substring(0, 5);
    	gioChieu = new JLabel(giochieuShort);
    	gioChieu.setFont(new Font("Dialog", Font.BOLD, 20));
    	gioChieu.setForeground(Color.WHITE);
    	horizontalBox_3.add(gioChieu);
    	
    	Box horizontalBox_3_1 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_3_1);
    	
    	String ngay = suatchieu.getNgayChieu();
    	ngayChieu = new JLabel(ngay);
    	ngayChieu.setForeground(Color.WHITE);
    	ngayChieu.setFont(new Font("Dialog", Font.BOLD, 20));
    	horizontalBox_3_1.add(ngayChieu);
    	
    	Box horizontalBox_11 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_11);
    	
    	Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 80));
    	horizontalBox_11.add(rigidArea_7);
    	
    	Box horizontalBox_4 = Box.createHorizontalBox();
    	verticalBox.add(horizontalBox_4);
    	
    	Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
    	horizontalBox_4.add(rigidArea);
    	Phim phim = null;
    	try {
			phim = phim_DAO.timPhim(suatchieu.getPhim().getMaPhim());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	JLabel lblNewLabel_3 = new JLabel("");
    	ImageIcon icon = new ImageIcon(ChonGhe.class.getResource(phim.getHinhAnh()));
    	Image img = icon.getImage().getScaledInstance(250, 350, Image.SCALE_DEFAULT); 
    	ImageIcon newIcon = new ImageIcon(img);
    	lblNewLabel_3.setIcon(newIcon);
    	lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
    	horizontalBox_4.add(lblNewLabel_3);
    	
    	Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
    	horizontalBox_4.add(rigidArea_1);
    	
    	JPanel panel_1 = new JPanel();
    	panel_1.setBackground(new Color(222, 225, 230));
    	getContentPane().add(panel_1, BorderLayout.SOUTH);
    	panel_1.setLayout(new BorderLayout(0, 0));
    	
    	JPanel panel_2 = new JPanel();
    	panel_2.setBackground(new Color(238, 238, 238));
    	FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
    	flowLayout.setAlignment(FlowLayout.LEFT);
    	panel_1.add(panel_2, BorderLayout.WEST);
    	
    	Component glue = Box.createGlue();
    	panel_2.add(glue);
    	
    	Box verticalBox_1 = Box.createVerticalBox();
    	verticalBox_1.setBackground(new Color(160, 168, 222));
    	panel_2.add(verticalBox_1);
    	
    	Box horizontalBox_8 = Box.createHorizontalBox();
    	verticalBox_1.add(horizontalBox_8);
    	
    	Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
    	horizontalBox_8.add(rigidArea_5);
    	
    	Box horizontalBox_5 = Box.createHorizontalBox();
    	verticalBox_1.add(horizontalBox_5);
    	
    	tenPhim = new JLabel(phim.getTenPhim());
    	tenPhim.setHorizontalAlignment(SwingConstants.LEFT);
    	tenPhim.setFont(new Font("Dialog", Font.BOLD, 26));
    	horizontalBox_5.add(tenPhim);
    	
    	Box horizontalBox_6 = Box.createHorizontalBox();
    	verticalBox_1.add(horizontalBox_6);
    	
    	loaiPhim = new JLabel("Phụ Đề 2D");
    	loaiPhim.setFont(new Font("Dialog", Font.PLAIN, 15));
    	horizontalBox_6.add(loaiPhim);
    	
    	Component horizontalStrut = Box.createHorizontalStrut(155);
    	horizontalBox_6.add(horizontalStrut);
    	
    	Box horizontalBox_6_1 = Box.createHorizontalBox();
    	verticalBox_1.add(horizontalBox_6_1);
    	
    	JLabel lblNewLabel_5_1 = new JLabel("Tổng tiền: ");
    	lblNewLabel_5_1.setForeground(new Color(255, 0, 0));
    	lblNewLabel_5_1.setFont(new Font("Dialog", Font.BOLD, 24));
    	horizontalBox_6_1.add(lblNewLabel_5_1);
    	
    	tongTien = new JLabel("0đ");
    	tongTien.setForeground(new Color(255, 0, 0));
    	tongTien.setFont(new Font("Dialog", Font.BOLD, 27));
    	horizontalBox_6_1.add(tongTien);
    	
    	Box horizontalBox_9 = Box.createHorizontalBox();
    	verticalBox_1.add(horizontalBox_9);
    	
    	Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
    	horizontalBox_9.add(rigidArea_4);
    	
    	JPanel panel_3 = new JPanel();
    	panel_1.add(panel_3, BorderLayout.CENTER);
    	
    	thongTinGhe= new JLabel("");
    	thongTinGhe.setFont(new Font("Dialog", Font.BOLD, 25));
    	panel_3.add(thongTinGhe);
    	
    	Box horizontalBox_7 = Box.createHorizontalBox();
    	panel_3.add(horizontalBox_7);
    	
    	JPanel panel_4 = new JPanel();
    	panel_1.add(panel_4, BorderLayout.EAST);
    	
    	Box verticalBox_2 = Box.createVerticalBox();
    	panel_4.add(verticalBox_2);
    	
    	Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 30));
    	verticalBox_2.add(rigidArea_2);
    	
    	btndatVe = new JButton("Đặt Vé");
    	btndatVe.setForeground(Color.WHITE);
    	btndatVe.setBackground(Color.RED);
    	btndatVe.setBorderPainted(false);
    	btndatVe.setFont(new Font("Dialog", Font.BOLD, 25));
    	verticalBox_2.add(btndatVe);
    	
    	Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
    	panel_4.add(rigidArea_3);
    	
    	JPanel panel_7 = new JPanel();
    	panel_7.setBackground(Color.WHITE);
    	getContentPane().add(panel_7, BorderLayout.CENTER);
    	panel_7.setLayout(new BorderLayout(0, 0));
    	
    	JPanel panel_5 = new JPanel();
    	panel_5.setBackground(Color.WHITE);
    	panel_7.add(panel_5, BorderLayout.NORTH);
    	panel_5.setLayout(new BorderLayout(0, 0));
    	
    	JLabel lblNewLabel_8 = new JLabel("Màn Hình");
    	lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 24));
    	lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
    	panel_5.add(lblNewLabel_8);
    	
    	JPanel panel_6 = new JPanel();
    	panel_6.setBackground(Color.WHITE);
    	panel_7.add(panel_6, BorderLayout.WEST);
    	
    	Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
    	panel_6.add(rigidArea_9);
    	
    	JPanel panel_8 = new JPanel();
    	panel_8.setBackground(Color.WHITE);
    	panel_7.add(panel_8, BorderLayout.EAST);
    	
    	Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
    	panel_8.add(rigidArea_10);
    	
    	JPanel panel_9 = new JPanel();
    	panel_7.add(panel_9, BorderLayout.CENTER);
    	panel_9.setLayout(new BorderLayout(0, 0));
    	
    	JPanel panel_10 = new JPanel();
    	panel_10.setBackground(Color.BLACK);
    	panel_9.add(panel_10, BorderLayout.NORTH);
    	
    	JPanel panel_11 = new JPanel();
    	panel_11.setBackground(Color.WHITE);
    	panel_9.add(panel_11, BorderLayout.CENTER);
    	panel_11.setLayout(new BorderLayout(0, 0));
    	
    	JPanel panel_15 = new JPanel();
    	panel_15.setBackground(Color.WHITE);
    	panel_11.add(panel_15, BorderLayout.CENTER);
    	panel_15.setLayout(new GridLayout(8, 16, 2, 2));
    	
    	JPanel panel_12 = new JPanel();
    	panel_12.setBackground(Color.WHITE);
    	panel_9.add(panel_12, BorderLayout.SOUTH);
    	panel_12.setLayout(new GridLayout(0, 1, 0, 0));
    	
    	JPanel panel_17 = new JPanel();
    	panel_17.setBackground(Color.WHITE);
    	panel_12.add(panel_17);
    	panel_17.setLayout(new GridLayout(1, 8, 2, 2));
    	
    	buttons = new JButton[136];
    	char row = 'A';
    	int flag1 = 1,flag2 = 1;
    	for (int i = 0; i < buttons.length; i++) {
 
            buttons[i] = new JButton( row + "" + (flag1++));
            flag2++;
            if(flag1 > 16) {
            	flag1 = 1;
            	row++;
            }
            if(flag2 < 66) {
            	buttons[i].setBackground(maMau[0]);
            }else if(flag2 < 130){
            	buttons[i].setBackground(maMau[1]);
            }else {
            	buttons[i].setBackground(maMau[2]);
            }
            buttons[i].setFont(new Font("Dialog", Font.BOLD, 15));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBorderPainted(false);
            
           
            if (dsGhe.get(i).getTrangThai() == 2) {
                buttons[i].setBackground(maMau[4]);
                buttons[i].setEnabled(false);
                buttons[i].setForeground(Color.WHITE);
            }
            if (dsGhe.get(i).getTrangThai() == 3) {
                buttons[i].setBackground(maMau[5]);
                buttons[i].setEnabled(false);
                buttons[i].setForeground(Color.WHITE);
            }
            
            if(i < 128) {
            	panel_15.add(buttons[i]);
            }else {
            	panel_17.add(buttons[i]);
            } 
        }
    	
    	JPanel panel_18 = new JPanel();
    	panel_18.setBackground(Color.WHITE);
    	panel_12.add(panel_18);
    	
    	Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 20));
    	panel_18.add(rigidArea_11);
    	
    	JPanel panel_13 = new JPanel();
    	panel_13.setBackground(Color.WHITE);
    	panel_12.add(panel_13);
    	
    	JButton btnNewButton = new JButton("");
    	btnNewButton.setForeground(new Color(255, 255, 255));
    	btnNewButton.setEnabled(false);
    	btnNewButton.setPreferredSize(new Dimension(30,30));
    	btnNewButton.setBackground(maMau[0]);
    	btnNewButton.setBorderPainted(false);
    	panel_13.add(btnNewButton);
    	
    	JLabel lblNewLabel_9 = new JLabel("Ghế thường");
    	lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel_9.setPreferredSize(new Dimension(70, 30));
    	panel_13.add(lblNewLabel_9);
    	
    	JButton btnNewButton_1 = new JButton("");
    	btnNewButton_1.setEnabled(false);
    	btnNewButton_1.setPreferredSize(new Dimension(30,30));
    	btnNewButton_1.setBackground(maMau[1]);
    	btnNewButton_1.setBorderPainted(false);
    	panel_13.add(btnNewButton_1);
    	
    	JLabel lblNewLabel_10 = new JLabel("Ghế VIP");
    	lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel_10.setPreferredSize(new Dimension(60, 30));
    	panel_13.add(lblNewLabel_10);
    	
    	JButton btnNewButton_2 = new JButton("");
    	btnNewButton_2.setEnabled(false);
    	btnNewButton_2.setPreferredSize(new Dimension(30,30));
    	btnNewButton_2.setBackground(maMau[2]);
    	btnNewButton_2.setBorderPainted(false);
    	panel_13.add(btnNewButton_2);
    	
    	JLabel lblNewLabel_11 = new JLabel("Ghế đôi");
    	lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel_11.setPreferredSize(new Dimension(60, 30));
    	panel_13.add(lblNewLabel_11);
    	
    	JPanel panel_14 = new JPanel();
    	panel_14.setBackground(Color.WHITE);
    	panel_12.add(panel_14);
    	
    	JButton btnNewButton_3 = new JButton("");
    	btnNewButton_3.setEnabled(false);
    	btnNewButton_3.setPreferredSize(new Dimension(30,30));
    	btnNewButton_3.setBackground(maMau[3]);
    	btnNewButton_3.setBorderPainted(false);
    	panel_14.add(btnNewButton_3);
    	
    	JLabel lblNewLabel_12 = new JLabel("Đang chọn");
    	lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel_12.setPreferredSize(new Dimension(70, 30));
    	panel_14.add(lblNewLabel_12);
    	
    	JButton btnNewButton_4 = new JButton("Đã đặt");
    	btnNewButton_4.setEnabled(false);
    	btnNewButton_4.setPreferredSize(new Dimension(30,30));
    	btnNewButton_4.setBackground(maMau[4]);
    	btnNewButton_4.setBorderPainted(false);
    	panel_14.add(btnNewButton_4);
    	
    	JLabel lblNewLabel_13 = new JLabel("Đã đặt");
    	lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel_13.setPreferredSize(new Dimension(60, 30));
    	panel_14.add(lblNewLabel_13);
    	
    	JButton btnNewButton_5 = new JButton("");
    	btnNewButton_5.setEnabled(false);
    	btnNewButton_5.setPreferredSize(new Dimension(30,30));
    	btnNewButton_5.setBackground(maMau[5]);
    	btnNewButton_5.setBorderPainted(false);
    	panel_14.add(btnNewButton_5);
    	
    	JLabel lblNewLabel_14 = new JLabel("Không thể chọn");
    	lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel_14.setPreferredSize(new Dimension(90, 30));
    	panel_14.add(lblNewLabel_14);
    	
    	JPanel panel_16 = new JPanel();
    	panel_16.setBackground(Color.WHITE);
    	panel_12.add(panel_16);
    	
    	Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
    	panel_16.add(rigidArea_12);
    	
    	btndatVe.addActionListener(this);
    	for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btndatVe)) {
			if(chuoiGhe == null || chuoiGhe.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn ghế để tiếp tục");
			}else {
				DichVu dichvu = new DichVu();
				dichvu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dichvu.setExtendedState(MAXIMIZED_BOTH);
				dichvu.setVisible(true);
	            setVisible(false);
	        	flag = true;
			}
			
		}
		for (int i = 0; i < buttons.length; i++) {
            if (obj.equals(buttons[i])) {
            	if((!flag_checked[i])) {	
            		if(soGheDaChon >= 8) {
            			JOptionPane.showMessageDialog(this,"Chọn tối đa 8 ghế cho 1 lần đặt");
            		}else {
            			if(chuoiGhe == null || chuoiGhe == "") {
                    		if(i < 64) {
                    			if(loaiGheDaChon == 0) {
                    				loaiGheDaChon = 1;
                    			}else if(loaiGheDaChon != 1 && soGheDaChon >= 1){
                    				JOptionPane.showMessageDialog(this,"Phải chọn cùng loại ghế");
                    				return;
                    			}
                        		chuoiGhe = "Thường ";
                        		
                        	}else if( i < 128 ) {
                        		if(loaiGheDaChon == 0) {
                    				loaiGheDaChon = 2;
                    			}else if(loaiGheDaChon != 2 && soGheDaChon >= 1){
                    				JOptionPane.showMessageDialog(this,"Phải chọn cùng loại ghế");
                    				return;
                    			}
                        		chuoiGhe = "VIP ";
                        		
                        	}else {
                        		if(loaiGheDaChon == 0) {
                    				loaiGheDaChon = 3;
                    			}
                        		chuoiGhe = "Ghế Đôi ";
                        		
                        	}
                    	}
            			int loaiHienChon;
            			if(i < 64) {
            				loaiHienChon = 1;
            				tongTienGhe += 60000;
            			}else if(i < 128) {
            				loaiHienChon = 2;
            				tongTienGhe += 80000;
            			}else {
            				loaiHienChon = 3;
            				tongTienGhe += 130000;
            			}
            			if(loaiGheDaChon != loaiHienChon && soGheDaChon >= 1){
            				JOptionPane.showMessageDialog(this,"Phải chọn cùng loại ghế");
            				return;
            			}
                        JButton button = (JButton) obj;
                        chuoiGhe = chuoiGhe + button.getText() + " ";
                        dsGheDaChon.add(dsGhe.get(i));
                        thongTinGhe.setText(chuoiGhe);
                        button.setBackground(maMau[3]);
                        soGheDaChon++;
                        flag_checked[i] = true;
                        int tongTienGheInt = (int) tongTienGhe;
                        tongTien.setText(String.valueOf(tongTienGheInt) + " đ");
            		}
            	}else {
            		JButton button = (JButton) obj;
            		soGheDaChon--;
            		if(i < 64) {
            			button.setBackground(maMau[0]);
            			tongTienGhe -= 60000;
                	}else if( i < 128 ) {
                		button.setBackground(maMau[1]);
                		tongTienGhe -= 80000;
                	}else {
                		button.setBackground(maMau[2]);
                		tongTienGhe -= 130000;
                	}
            		chuoiGhe = chuoiGhe.replace(buttons[i].getText() + " ", "");
            		if(soGheDaChon == 0) {
            			chuoiGhe = "";
            			loaiGheDaChon = 0;
            		}
            		dsGheDaChon.remove(dsGhe.get(i));
                    thongTinGhe.setText(chuoiGhe);   
            		flag_checked[i] = false;
            		int tongTienGheInt = (int) tongTienGhe;
            		tongTien.setText(String.valueOf(tongTienGheInt) + " đ");
            	}
            }
        }
	}
}

