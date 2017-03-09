package Demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;

public class PrintTest implements Printable {
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		Graphics2D g2 = (Graphics2D) graphics;
		g2.setPaint(Color.black);
		g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		Font font = new Font("宋体", Font.BOLD, 10);
		g2.setFont(font);

		int yLocation = 15;
		g2.drawString("这是一个打印测试案例!", 0, yLocation);
		yLocation += 15;
		g2.drawString("如果一台打印机直接打印,", 0, yLocation);
		yLocation += 15;
		g2.drawString("请确认设置了默认打印机!", 0, yLocation);
		yLocation += 15;
		g2.drawString("这是一个打印测试案例!", 0, yLocation);
		yLocation += 15;
		g2.drawString("如果一台打印机直接打印,", 0, yLocation);
		yLocation += 15;
		g2.drawString("请确认设置了默认打印机!", 0, yLocation);
		yLocation += 15;
		g2.drawString("这是一个打印测试案例!", 0, yLocation);
		yLocation += 15;
		g2.drawString("如果一台打印机直接打印,", 0, yLocation);
		yLocation += 15;
		g2.drawString("请确认设置了默认打印机!", 0, yLocation);
	

		return Printable.PAGE_EXISTS;

	}

	public static void main(String[] args) {
		defaultPrint();
//		printWithPrinterName();
	}

	public static void defaultPrint() {
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
		book.append(new PrintTest(), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);

		try {
			job.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}

	}

	public static void printWithPrinterName() {
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
		book.append(new PrintTest(), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);

		// 设置第一台打印机的参数
		HashAttributeSet hs = new HashAttributeSet();
		String printerName = "XP-58";
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

		// 设置第二台打印机的参数
		HashAttributeSet hs2 = new HashAttributeSet();
		String printerName2 = "AiBao-A-5801";
		hs2.add(new PrinterName(printerName2, null));
		PrintService[] ps2 = PrintServiceLookup.lookupPrintServices(null, hs2);
		if (ps2.length > 0) {
			try {
				job.setPrintService(ps2[0]);
				job.print();
			} catch (PrinterException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("找不到打印机:" + printerName);
		}
	}
}
