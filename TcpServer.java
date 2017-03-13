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
import java.util.List;

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
						System.out.println("------------------------连接成功!");
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

			JSONObject jsonObj = (JSONObject) JSON.parse(message);
			String printType = jsonObj.getString("printType");
			System.out.println("------------------printType: " + printType);

			// 确认小票,前台和后厨同时打印,(可能不止两台打印机,所以得采用循环遍历的方式传入数据)
			if (printType.equals("0")) {
				printConfirmTicket(message);
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

	// 确认小票,前台和后厨同时打印,(可能不止两台打印机,所以得采用循环遍历的方式传入数据)
	public static void printConfirmTicket(String message) {

		ConfirmBean confirmBean = JSON.parseObject(message, ConfirmBean.class);
		List<Demo.ConfirmBean.ModelBean> modelBeanList = confirmBean.getModel();

		// 开始遍历数据进行打印,将单个对象传入打印类
		for (int i = 0; i < modelBeanList.size(); i++) {
			// 获取单个对象, 注意!这个很重要.
			Demo.ConfirmBean.ModelBean.OrderDetailDTOBean order = modelBeanList.get(i).getOrderDetailDTO();

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
			
			// typeId,前台2,后厨1
			String typeId = modelBeanList.get(i).getTypeId();
			if (typeId.equals("2")) {
				book.append(new ConfirmTicket(order), pf);
			} else {
				book.append(new KitchenTicket(order), pf);
			}

			// 获取打印服务对象
			PrinterJob job = PrinterJob.getPrinterJob();
			// 设置打印类
			job.setPageable(book);

			String printerName = modelBeanList.get(i).getDeviceName();

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
	}

	// 支付小票
	public static void printPayTicket(String message) {

		PayBean payBean = JSON.parseObject(message, PayBean.class);
		List<Demo.PayBean.ModelBean> modelBeanList = payBean.getModel();

		// 开始遍历数据进行打印,将单个对象传入打印类
		for (int i = 0; i < modelBeanList.size(); i++) {
			// 获取单个对象, 注意!这个很重要.
			Demo.PayBean.ModelBean.OrderDetailDTOBean order = modelBeanList.get(i).getOrderDetailDTO();
			// typeId,前台2,后厨1
			String typeId = modelBeanList.get(i).getTypeId();
			System.out.println("-----------------typeId: "+ typeId);
			//只有前台打印!
			if (typeId.equals("2")) {
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
				
				book.append(new PayTicket(order), pf);
			
				// 获取打印服务对象
				PrinterJob job = PrinterJob.getPrinterJob();
				// 设置打印类
				job.setPageable(book);

				String printerName = modelBeanList.get(i).getDeviceName();

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
			
		}
	}

	// 加菜小票
	public static void printAddDishTicket(String message) {

		AddOrDelDishBean addOrDelDishBean = JSON.parseObject(message, AddOrDelDishBean.class);
		List<Demo.AddOrDelDishBean.ModelBean> modelBeanList = addOrDelDishBean.getModel();

		// 开始遍历数据进行打印,将单个对象传入打印类
		for (int i = 0; i < modelBeanList.size(); i++) {
			// 获取单个对象, 注意!这个很重要.
			Demo.AddOrDelDishBean.ModelBean.OrderDetailDTOBean order = modelBeanList.get(i).getOrderDetailDTO();

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
			book.append(new AddDishTicket(order), pf);

			// 获取打印服务对象
			PrinterJob job = PrinterJob.getPrinterJob();
			// 设置打印类
			job.setPageable(book);

			String printerName = modelBeanList.get(i).getDeviceName();

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
	}

	public static void printDeleteDishTicket(String message) {
		AddOrDelDishBean addOrDelDishBean = JSON.parseObject(message, AddOrDelDishBean.class);
		List<Demo.AddOrDelDishBean.ModelBean> modelBeanList = addOrDelDishBean.getModel();

		// 开始遍历数据进行打印,将单个对象传入打印类
		for (int i = 0; i < modelBeanList.size(); i++) {
			// 获取单个对象, 注意!这个很重要.
			Demo.AddOrDelDishBean.ModelBean.OrderDetailDTOBean order = modelBeanList.get(i).getOrderDetailDTO();

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
			book.append(new DeleteDishTicket(order), pf);

			// 获取打印服务对象
			PrinterJob job = PrinterJob.getPrinterJob();
			// 设置打印类
			job.setPageable(book);

			String printerName = modelBeanList.get(i).getDeviceName();

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
	}

}
