package Demo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;

public class PrintTest implements Printable {

	private String port;
	private String printerName;
	private String ip;
	private List<String> strList;

	public PrintTest(String ip, String port, String printerName, List<String> strList) {
		this.ip = ip;
		this.port = port;
		this.printerName = printerName;
		this.strList = strList;
	}

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		Graphics2D g2 = (Graphics2D) graphics;
		g2.setPaint(Color.black);
		g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		Font font = new Font("宋体", Font.PLAIN, 10);
		g2.setFont(font);

		int yLocation = 15;
		g2.drawString("欢迎使用易趴打印服务! ", 0, yLocation);
		yLocation += 15;
		g2.drawString("这是一个打印测试页!", 0, yLocation);
		yLocation += 15;
		g2.drawString("主机局域网ip:" + ip, 0, yLocation);
		yLocation += 15;
		g2.drawString("端口号:" + port, 0, yLocation);
		yLocation += 15;
		g2.drawString("系统存在的打印服务:", 0, yLocation);
		for (int i = 0; i < strList.size(); i++) {
			yLocation += 15;
			g2.drawString(strList.get(i), 0, yLocation);
		}

		yLocation += 15;
		g2.drawString("默认打印机:" + printerName, 0, yLocation);

		yLocation += 20;
		double x = pageFormat.getImageableX();
		double y = pageFormat.getImageableY();
		Component component = null;

		Image src = Toolkit.getDefaultToolkit().getImage(Config.IMAGE_PATH);
		g2.drawImage(src, (int) x + 10, (int) (yLocation), component);

		return Printable.PAGE_EXISTS;

	}

	public static void defaultPrint(String ip, String port, String defaultPrinter, List<String> strList) {
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		// p.setSize(590, 840);// 纸张大小
		p.setImageableArea(0, 0, 140, 840);// A4(595 X
											// 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new PrintTest(ip, port, defaultPrinter, strList), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);
		job.setCopies(2);

		try {
			job.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}

	}

	public static void printWithPrinterName(String ip, String port, String defaultPrinter, List<String> strList) {
		// 通俗理解就是文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		// p.setSize(590, 840);// 纸张大小
		p.setImageableArea(0, 0, 140, 840);// A4(595 X
											// 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new PrintTest(ip, port, defaultPrinter, strList), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);
		job.setCopies(2);

		for (int i = 0; i < strList.size(); i++) {
			HashAttributeSet hs = new HashAttributeSet();
			String printerName = strList.get(i);
			hs.add(new PrinterName(printerName, null));
			PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, hs);
			if (ps.length > 0) {
				try {
					job.setPrintService(ps[0]);
					job.print();
				} catch (PrinterException e) {
					e.printStackTrace();
				}

			} else {
				System.out.println("找不到打印机:" + printerName);
			}
		}

	}

	public static void main(String[] args) {
		// defaultPrint();
		// printWithPrinterName();
	}
}
