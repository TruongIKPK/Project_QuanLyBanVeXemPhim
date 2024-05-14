package gui;
import javax.swing.*;
import java.awt.*;

public class GiaoDienLoading extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JProgressBar progressBar;
    private JLabel loadingLabel;
    
    public GiaoDienLoading() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/Screenshot 2024-04-28 134218 (3).png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(imageLabel);

        loadingLabel = new JLabel("", JLabel.CENTER);
        panel.add(loadingLabel);
        loadingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        progressBar = new JProgressBar();
        progressBar.setStringPainted(false);
        Dimension progressBarSize = new Dimension(imageIcon.getIconWidth(), 15);
        progressBar.setPreferredSize(progressBarSize);
        progressBar.setBorderPainted(false);
        
        Color lightBlue = new Color(0, 128, 0);
        progressBar.setForeground(lightBlue);
        
        panel.add(progressBar);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);

        simulateLoading();
    }

    private void simulateLoading() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(50);
                        progressBar.setValue(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new DangNhap().setVisible(true);
                            setVisible(false);
                        }
                    });
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GiaoDienLoading centeredLoadingInterface = new GiaoDienLoading();
                centeredLoadingInterface.setVisible(true);
            }
        });
    }
}