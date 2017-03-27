package Demo;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TcpServer {
	public static void main(String args[]) {

		int port = 9100;
		ServerSocket server_socket;
		BufferedReader input;

		try {
			server_socket = new ServerSocket(port);
			System.out.println("服务端已启动端口: " + server_socket.getLocalPort() + ",等待客户端连接..");

			while (true) {
				Socket socket = server_socket.accept();
				System.out.println("连接成功!");
				System.out.println("当前客户端IP为: " + socket.getInetAddress() + ":" + socket.getPort());
				input = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));

				String data = "";
				while (true) {
					String message = input.readLine();

					if (message == null || message.equals("null")) {
						break;
					} else {
						data += message;
					}
				}

				System.out.println("接收的数据: " + data);
				System.out.println(
						"当期时间: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

				OutputStream outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
				PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
				// printWriter.print("你好，服务端已接收到您的信息");

				if (data != null && !data.equals("")) {
					printWriter.print("ok");

					gotoPrint(data);
				} else {
					printWriter.print("fail");
				}

				printWriter.flush();
				socket.shutdownOutput();// 关闭输出流

				// 关闭相应的资源
				printWriter.close();
				outputStream.close();
				input.close();

				socket.close();
				System.out.println("关闭socket,等待客户端再次请求...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionRecord.setRecord(ExceptionRecord.getExceptionMsg(e));
		}
	}

	// 将main函数作为方法调用
	public static void tcpConnect(int port) {

		ServerSocket server_socket;
		BufferedReader input;
		try {
			server_socket = new ServerSocket(port);
			System.out.println("服务端已启动端口: " + server_socket.getLocalPort() + ",等待客户端连接..");

			while (true) {
				Socket socket = server_socket.accept();
				System.out.println("连接成功!");
				System.out.println("当前客户端IP为: " + socket.getInetAddress() + ":" + socket.getPort());
				input = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));

				String data = "";
				while (true) {
					String message = input.readLine();

					if (message == null || message.equals("null")) {
						break;
					} else {
						data += message;
					}
				}

				System.out.println("接收的数据: " + data);
				System.out.println(
						"当期时间: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

				OutputStream outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
				PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
				// printWriter.print("你好，服务端已接收到您的信息");

				if (data != null && !data.equals("")) {
					printWriter.print("ok");

					gotoPrint(data);
				} else {
					printWriter.print("fail");
				}

				printWriter.flush();
				socket.shutdownOutput();// 关闭输出流

				// 关闭相应的资源
				printWriter.close();
				outputStream.close();
				input.close();

				socket.close();
				System.out.println("关闭socket,等待客户端再次请求...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionRecord.setRecord(ExceptionRecord.getExceptionMsg(e));
		}
	}

	public static void gotoPrint(String data) {

		JSONObject jsonObj = (JSONObject) JSON.parse(data);
		String printType = jsonObj.getString("printType");
		System.out.println("------------------printType: " + printType);

		// 确认小票,前台和后厨同时打印,(可能不止两台打印机,所以得采用循环遍历的方式传入数据)
		if (printType.equals("0")) {
			printConfirmTicket(data);
		}

		// 支付
		if (printType.equals("1")) {
			printPayTicket(data);
		}

		// 加菜
		if (printType.equals("2")) {
			printAddDishTicket(data);
		}

		// 退菜
		if (printType.equals("3")) {
			printDeleteDishTicket(data);
		}

	}

	// 确认小票,前台和后厨同时打印,(可能不止两台打印机,所以得采用循环遍历的方式传入数据)
	public static void printConfirmTicket(String data) {

		try {
			ConfirmBean confirmBean = JSON.parseObject(data, ConfirmBean.class);
			List<Demo.ConfirmBean.ModelBean> modelBeanList = confirmBean.getModel();

			// 开始遍历数据进行打印,将单个对象传入打印类
			for (int i = 0; i < modelBeanList.size(); i++) {
				// 获取单个对象, 注意!这个很重要.
				Demo.ConfirmBean.ModelBean.OrderDetailDTOBean order = modelBeanList.get(i).getOrderDetailDTO();
				int paperWidth = modelBeanList.get(i).getWidth();
				System.out.println("-----------------纸张宽度: " + paperWidth);

				// 通俗理解就是书、文档
				Book book = new Book();
				// 设置成竖打
				PageFormat pf = new PageFormat();
				pf.setOrientation(PageFormat.PORTRAIT);
				// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
				Paper p = new Paper();
				// p.setSize(182, 80);// 纸张大小
				p.setImageableArea(0, 0, 200, 840);// A4(595 X
													// 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
				pf.setPaper(p);
				// 把 PageFormat 和 Printable 添加到书中，组成一个页面

				// typeId,前台2,后厨1
				String typeId = modelBeanList.get(i).getTypeId();
				if (typeId.equals("2")) {
					book.append(new ConfirmTicket(order, paperWidth), pf);
				} else {
					book.append(new KitchenTicket(order, paperWidth), pf);
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

				job.setPrintService(pss[0]);
				job.print();
			}

		} catch (Exception e) {
			e.printStackTrace();
			ExceptionRecord.setRecord(ExceptionRecord.getExceptionMsg(e));
		}
	}

	// 支付小票
	public static void printPayTicket(String data) {

		try {
			PayBean payBean = JSON.parseObject(data, PayBean.class);
			List<Demo.PayBean.ModelBean> modelBeanList = payBean.getModel();

			// 开始遍历数据进行打印,将单个对象传入打印类
			for (int i = 0; i < modelBeanList.size(); i++) {
				// 获取单个对象, 注意!这个很重要.
				Demo.PayBean.ModelBean.OrderDetailDTOBean order = modelBeanList.get(i).getOrderDetailDTO();
				// typeId,前台2,后厨1
				String typeId = modelBeanList.get(i).getTypeId();
				System.out.println("-----------------typeId: " + typeId);
				int paperWidth = modelBeanList.get(i).getWidth();
				System.out.println("-----------------纸张宽度: " + paperWidth);
				// 只有前台打印!
				if (typeId.equals("2")) {
					// 通俗理解就是书、文档
					Book book = new Book();
					// 设置成竖打
					PageFormat pf = new PageFormat();
					pf.setOrientation(PageFormat.PORTRAIT);
					// 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
					Paper p = new Paper();
					// p.setSize(400, 840);// 纸张大小

					// 宽140
					p.setImageableArea(0, 0, 200, 840);// A4(595 X
														// 842)设置打印区域，其实0，0应该是72，72，因为A4纸的默认X,Y边距是72
					pf.setPaper(p);
					// 把 PageFormat 和 Printable 添加到书中，组成一个页面

					book.append(new PayTicket(order, paperWidth), pf);

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

					job.setPrintService(pss[0]);
					job.print();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			ExceptionRecord.setRecord(ExceptionRecord.getExceptionMsg(e));
		}
	}

	// 加菜小票
	public static void printAddDishTicket(String data) {

		try {
			AddOrDelDishBean addOrDelDishBean = JSON.parseObject(data, AddOrDelDishBean.class);
			List<Demo.AddOrDelDishBean.ModelBean> modelBeanList = addOrDelDishBean.getModel();

			// 开始遍历数据进行打印,将单个对象传入打印类
			for (int i = 0; i < modelBeanList.size(); i++) {
				// 获取单个对象, 注意!这个很重要.
				Demo.AddOrDelDishBean.ModelBean.OrderDetailDTOBean order = modelBeanList.get(i).getOrderDetailDTO();

				int paperWidth = modelBeanList.get(i).getWidth();
				System.out.println("-----------------纸张宽度: " + paperWidth);

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
				book.append(new AddDishTicket(order, paperWidth), pf);

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

				job.setPrintService(pss[0]);
				job.print();

			}

		} catch (Exception e) {
			e.printStackTrace();
			ExceptionRecord.setRecord(ExceptionRecord.getExceptionMsg(e));
		}
	}

	public static void printDeleteDishTicket(String data) {

		try {
			AddOrDelDishBean addOrDelDishBean = JSON.parseObject(data, AddOrDelDishBean.class);
			List<Demo.AddOrDelDishBean.ModelBean> modelBeanList = addOrDelDishBean.getModel();

			// 开始遍历数据进行打印,将单个对象传入打印类
			for (int i = 0; i < modelBeanList.size(); i++) {
				// 获取单个对象, 注意!这个很重要.
				Demo.AddOrDelDishBean.ModelBean.OrderDetailDTOBean order = modelBeanList.get(i).getOrderDetailDTO();

				int paperWidth = modelBeanList.get(i).getWidth();
				System.out.println("-----------------纸张宽度: " + paperWidth);

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
				book.append(new DeleteDishTicket(order, paperWidth), pf);

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

				job.setPrintService(pss[0]);
				job.print();

			}

		} catch (Exception e) {
			e.printStackTrace();
			ExceptionRecord.setRecord(ExceptionRecord.getExceptionMsg(e));
		}
	}

}
