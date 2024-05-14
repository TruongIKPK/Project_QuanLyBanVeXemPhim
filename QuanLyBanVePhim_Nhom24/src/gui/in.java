package gui;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class in {
    public static void main(String[] args) {
        // Tạo một đối tượng PrinterJob
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        
        // Kiểm tra xem có máy in nào được chọn không
        if (printerJob.printDialog()) {
            try {
                // Tạo một Printable từ tệp cụ thể
                PrintableDocument printableDocument = new PrintableDocument("Report.pdf");
                
                // Thiết lập printable cho printer job
                printerJob.setPrintable(printableDocument);
                
                // In tài liệu
                printerJob.print();
            } catch (PrinterException ex) {
                // Xử lý ngoại lệ in hoặc không tìm thấy tệp
                System.out.println("Lỗi khi in: " + ex);
            }
        }
    }
}

class PrintableDocument implements Printable {
    private String filePath;

    public PrintableDocument(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        try {
            // Đọc nội dung từ tệp và in ra
            FileInputStream fis = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            int y = 100; // Y-coordinate của văn bản
            while ((line = br.readLine()) != null) {
                graphics.drawString(line, 100, y);
                y += 20; // Dịch chuyển xuống dòng tiếp theo
            }
            br.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return PAGE_EXISTS;
    }
}



