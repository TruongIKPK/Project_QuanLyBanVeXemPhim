package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.HoaDonXemPhimDAO;
import dao.SuatChieu_DAO;
import entity.HoaDonXemPhim;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LichSu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model_table;
//	private HoaDonXemPhimDAO hdXemPhim_Dao;
//	private ArrayList<HoaDonXemPhim> dsHD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LichSu frame = new LichSu();
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
	public LichSu() {
//		hdXemPhim_Dao = new HoaDonXemPhimDAO().getInstance();
//		try {
//			dsHD = hdXemPhim_Dao.dsHDDaDat();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1709, 713);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		verticalBox.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Thoát");
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
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBackground(new Color(3, 89, 157));
		panel.add(btnNewButton, BorderLayout.WEST);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Theo ngày", "Theo phim", "Theo tổng tiền"}));
		panel.add(comboBox, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("Lịch Sử Bán Vé");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		verticalBox.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.SOUTH);
		
		// Tạo một đối tượng JTable với dữ liệu mẫu
        JTable table = new JTable();
      
        model_table = new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"M\u00E3", "Ng\u00E0y", "Su\u1EA5t Chi\u1EBFu", "Phim", "Ph\u00F2ng", "T\u1ED5ng ti\u1EC1n"
        	}
        );
        model_table.setRowCount(0);
//        for (HoaDonXemPhim hoaDonXemPhim : dsHD) {
////        	SuatChieu sc = new SuatChieu_DAO().
//        	model_table.addRow(new Object[] {
//        			hoaDonXemPhim.getMaHDXemPhim(),
//			});
//		}
        table.setModel(model_table);
        table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		// Đặt chiều cao mới cho từng hàng trong bảng
		table.setRowHeight(35);
		// Tăng kích thước của tiêu đề cột
		JTableHeader header = table.getTableHeader();
		Font headerFont = header.getFont();
		header.setFont(new Font(headerFont.getName(), Font.BOLD, 25));

        // Thêm table vào JScrollPane
        scrollPane.setViewportView(table);
	}
	
}
