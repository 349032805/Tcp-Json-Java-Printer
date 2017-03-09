package Demo;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TcpServer {
	public static void main(String args[]) {

		int port;
		ServerSocket server_socket;
		BufferedReader input;
		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("port = 9100 (default)");
			port = 9100;
		}

		try {
			server_socket = new ServerSocket(port);
			System.out.println("Server waiting for client on port " + server_socket.getLocalPort());
			// server infinite loop

			while (true) {
				StringBuffer sb = new StringBuffer("");

				Socket socket = server_socket.accept();
				System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
				input = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));
				// input = new BufferedReader(new
				// InputStreamReader(socket.getInputStream()));
				// print received data
				try {
					while (true) {
						String message = input.readLine();
						System.out.println("------------------------连上");
						System.out.println("------------------------message:" + message);
						sb.append(message);
						if (message == null)
							break;
					}

				} catch (IOException e) {
					System.out.println(e);
				}

				System.out.println("-------------传入数据参数:" + sb);

				if (!sb.toString().replace("null", "").equals("")) {
					gotoPrint(sb.toString().replace("null", ""));
				}

				// connection closed by client
				try {
					socket.close();
					System.out.println("Connection closed by client");
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void gotoPrint(String message) {

		if (message == null || message.equals("null") || message == "") {
			return;
		} else {
			// book.append(new PayTicket(message), pf);
			// book.append(new ConfirmTicket(message), pf);
			// book.append(new KitchenTicket(message), pf);
			// book.append(new AddDishTicket(message), pf);
			// book.append(new DeleteDishTicket(message), pf);

			JSONObject jsonObj = (JSONObject) JSON.parse(message);
			String printType = jsonObj.getString("printType");
			System.out.println("------------------printType: " + printType);

			// 确认小票,前台和后厨同时打印
			if (printType.equals("0")) {
				printConfirmTicket(message);
				printKitchenTicket(message);
			}

			// 支付
			if (printType.equals("1")) {
				printPayTicket(message);
			} 

			// 加菜
			if (printType.equals("2")) {
				printAddDishTicket(message);
			}

			// 退菜
			if (printType.equals("3")) {
				printDeleteDishTicket(message);
			}

		}

	}

	public static void printPayTicket(String message) {
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		// p.setSize(182, 80);// 纸张大小
		p.setImageableArea(0, 0, 140, 840);// A4(595 X
											// 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new PayTicket(message), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);

		// 支付打印一份,取第一个对象的打印机名称
		PayBean payBean = JSON.parseObject(message, PayBean.class);
		Demo.PayBean.ModelBean modelBean = payBean.getModel().get(0);

		String printerName = modelBean.getDeviceName();

		HashAttributeSet hs = new HashAttributeSet();
		hs.add(new PrinterName(printerName, null));
		PrintService[] pss = PrintServiceLookup.lookupPrintServices(null, hs);
		if (pss.length == 0) {
			System.out.println("找不到打印机:" + printerName);
			return;
		}

		try {
			job.setPrintService(pss[0]);
			job.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	public static void printConfirmTicket(String message) {
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		// p.setSize(182, 80);// 纸张大小
		p.setImageableArea(0, 0, 140, 840);// A4(595 X
											// 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new ConfirmTicket(message), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);

		// 取第一个对象的打印机名称
		ConfirmBean confirmBean = JSON.parseObject(message, ConfirmBean.class);
		Demo.ConfirmBean.ModelBean modelBean = confirmBean.getModel().get(0);

		String printerName = "";

		String typeId = modelBean.getTypeId();

		// typeId,前台2,后厨1
		if (typeId.equals("2")) {
			printerName = modelBean.getDeviceName();
		} else {
			printerName = confirmBean.getModel().get(1).getDeviceName();
		}

		HashAttributeSet hs = new HashAttributeSet();
		hs.add(new PrinterName(printerName, null));
		PrintService[] pss = PrintServiceLookup.lookupPrintServices(null, hs);
		if (pss.length == 0) {
			System.out.println("找不到打印机:" + printerName);
			return;
		}

		try {
			job.setPrintService(pss[0]);
			job.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	public static void printKitchenTicket(String message) {
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		// p.setSize(182, 80);// 纸张大小
		p.setImageableArea(0, 0, 140, 840);// A4(595 X
											// 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new KitchenTicket(message), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);

		// 取第二个对象的打印机名称
		ConfirmBean confirmBean = JSON.parseObject(message, ConfirmBean.class);
		Demo.ConfirmBean.ModelBean modelBean = confirmBean.getModel().get(0);

		String printerName = "";

		String typeId = modelBean.getTypeId();

		// typeId,前台2,后厨1
		if (typeId.equals("1")) {
			printerName = modelBean.getDeviceName();
		} else {
			printerName = confirmBean.getModel().get(1).getDeviceName();
		}

		HashAttributeSet hs = new HashAttributeSet();
		hs.add(new PrinterName(printerName, null));
		PrintService[] pss = PrintServiceLookup.lookupPrintServices(null, hs);
		if (pss.length == 0) {
			System.out.println("找不到打印机:" + printerName);
			return;
		}

		try {
			job.setPrintService(pss[0]);
			job.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	public static void printAddDishTicket(String message) {
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		// p.setSize(182, 80);// 纸张大小
		p.setImageableArea(0, 0, 140, 840);// A4(595 X
											// 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new AddDishTicket(message), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);

		// 取第二个对象的打印机名称
		AddOrDelDishBean addOrDelDishBean = JSON.parseObject(message, AddOrDelDishBean.class);
		Demo.AddOrDelDishBean.ModelBean modelBean = addOrDelDishBean.getModel().get(0);

		String printerName = modelBean.getDeviceName();
		String printerName2 = addOrDelDishBean.getModel().get(1).getDeviceName();

		// 设置第一台打印机的参数
		HashAttributeSet hs = new HashAttributeSet();
		// String printerName = "XP-58";
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
		// String printerName2 = "AiBao-A-5801";
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

	public static void printDeleteDishTicket(String message) {
		// 通俗理解就是书、文档
		Book book = new Book();
		// 设置成竖打
		PageFormat pf = new PageFormat();
		pf.setOrientation(PageFormat.PORTRAIT);
		// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		Paper p = new Paper();
		// p.setSize(182, 80);// 纸张大小
		p.setImageableArea(0, 0, 140, 840);// A4(595 X
											// 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
		pf.setPaper(p);
		// 把 PageFormat 和 Printable 添加到书中，组成一个页面
		book.append(new DeleteDishTicket(message), pf);

		// 获取打印服务对象
		PrinterJob job = PrinterJob.getPrinterJob();
		// 设置打印类
		job.setPageable(book);

		// 取第二个对象的打印机名称
		AddOrDelDishBean addOrDelDishBean = JSON.parseObject(message, AddOrDelDishBean.class);
		Demo.AddOrDelDishBean.ModelBean modelBean = addOrDelDishBean.getModel().get(0);

		String printerName = modelBean.getDeviceName();
		String printerName2 = addOrDelDishBean.getModel().get(1).getDeviceName();

		// 设置第一台打印机的参数
		HashAttributeSet hs = new HashAttributeSet();
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
