package Demo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class PrintSwingFrame {

	// 面板的宽和高
	private static final int WINDOW_WIDTH = 350;
	private static final int WINDOW_HEIGHT = 480;

	// 配置文件的相对路径
	public static final String FILE_PATH = "src/Demo/config.properties";

	private static void placeComponents(JPanel panel,JFrame jFrame) {

		panel.setLayout(null);
		JLabel portLabel = new JLabel("端口号:");
		portLabel.setBounds(10, 20, 50, 25);
		panel.add(portLabel);

		String port = getValueByConfig("port");
		JTextField portText = new JTextField(port, 4);
		portText.setBounds(100, 20, 100, 25);
		panel.add(portText);

		JLabel tipLabel = new JLabel("(1024-9999)");
		tipLabel.setBounds(210, 20, 120, 25);
		panel.add(tipLabel);

		JLabel titleLabel1 = new JLabel("系统存在的打印服务:");
		titleLabel1.setBounds(10, 60, WINDOW_WIDTH, 25);
		panel.add(titleLabel1);

		List<String> strList = new ArrayList<String>();

		PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);
		for (int i = 0; i < ps.length; i++) {
			String printName = ps[i].toString();
			if (!printName.contains("Fax") && !printName.contains("Microsoft XPS Document Writer")
					&& !printName.contains("Foxit Reader PDF Printer")) {
				String printer = printName.split(":")[1];
				printer = printer.trim();
				strList.add(printer);
			}

		}

		int currentLocation = 80;
		for (int j = 0; j < strList.size(); j++) {
			System.out.println("系统存在的打印机服务:" + strList.get(j));
			JLabel label = new JLabel(strList.get(j));
			label.setBounds(10, currentLocation, 200, 25);
			panel.add(label);

			currentLocation += 20;
		}

		currentLocation += 20;
		PrintService pss = PrintServiceLookup.lookupDefaultPrintService();
		JLabel titleLabel2 = new JLabel("当前默认打印机: " + pss.getName());
		titleLabel2.setBounds(10, currentLocation, WINDOW_WIDTH, 25);
		panel.add(titleLabel2);
		System.out.println("当前默认打印机:" + pss.getName());

		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println("当前局域网IP地址:" + ip);
		} catch (Exception e) {
			System.out.println("IP地址获取失败!");
		}

		currentLocation += 25;
		JLabel titleLabel3 = new JLabel("当前局域网IP地址: " + ip);
		titleLabel3.setBounds(10, currentLocation, WINDOW_WIDTH, 25);
		panel.add(titleLabel3);

		currentLocation += 50;
		JButton testButton = new JButton("打印测试页(请设置默认物理打印机)");
		testButton.setBounds(25, currentLocation, 280, 30);
		panel.add(testButton);

		String ipAddress = ip;
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pss.getName() != "" && pss.getName() != null) {
					PrintTest.defaultPrint(ipAddress, port, pss.getName(), strList);
				} else {
					JPanel jPanel = new JPanel();
					JOptionPane.showMessageDialog(jPanel, "请添加默认打印机!", "警告", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		currentLocation += 40;
		JButton testButton2 = new JButton("打印测试页(全部)");
		testButton2.setBounds(25, currentLocation, 280, 30);
		panel.add(testButton2);

		testButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (strList.size() > 0) {
					PrintTest.printWithPrinterName(ipAddress, port, pss.getName(), strList);
				} else {
					JPanel jPanel = new JPanel();
					JOptionPane.showMessageDialog(jPanel, "请添加打印机!", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		// 确定按钮
		currentLocation += 90;
		JButton saveButton = new JButton("确定");
		saveButton.setBounds(100, currentLocation, 100, 30);
		panel.add(saveButton);

		// JPanel jPanel = new JPanel();
		// JOptionPane.showMessageDialog(jPanel, "提示消息",
		// "警告",JOptionPane.WARNING_MESSAGE);

		// 保存事件,先判断端口号是否符合规范.1024-9999
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("重新输入的端口号:" + portText.getText());
				String resetPortStr = portText.getText().trim();

				int resetPort = 0;
				try {
					resetPort = Integer.parseInt(resetPortStr);
				} catch (NumberFormatException e1) {
					JPanel jPanel = new JPanel();
					JOptionPane.showMessageDialog(jPanel, "端口号不合法!", "警告", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if (resetPort < 1024 || resetPort > 9999) {
					JPanel jPanel = new JPanel();
					JOptionPane.showMessageDialog(jPanel, "端口号不合法!", "警告", JOptionPane.WARNING_MESSAGE);
					return;
				} else {
					// 如果端口号修改过,写入配置文件,启动打印程序,没有修改过,直接启动
					System.out.println("输入的合法端口号: " + resetPort + ". 写入配置文件,启动打印程序!");
					
					if(!port.equals(resetPortStr)){
						addOrUpdatConfig("port",resetPortStr);
					}
					
					
					//关闭设置界面
					jFrame.setVisible(false);
					
					//启动打印程序
					TcpServer.tcpConnect(resetPort);
				}

			}
		});
	}

	private static void InitGlobalFont(Font font) {
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
	}

	public static String file2String(File f, String charset) {
		String result = null;
		try {
			result = stream2String(new FileInputStream(f), charset);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String stream2String(InputStream in, String charset) {
		StringBuffer sb = new StringBuffer();
		try {
			Reader r = new InputStreamReader(in, charset);
			int length = 0;
			for (char[] c = new char[1024]; (length = r.read(c)) != -1;) {
				sb.append(c, 0, length);
			}
			r.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	// 读取配置文件的字段值
	public static String getValueByConfig(String columnName) {

		InputStream inStream = null;
		try {
			inStream = new FileInputStream(new File(FILE_PATH));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Properties prop = new Properties();
		try {
			prop.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("要获取的字段: " + columnName + ",值: " + prop.getProperty(columnName));
		return prop.getProperty(columnName);

	}

	// 修改配置文件字段的值
	public static void addOrUpdatConfig(String key, String value) {
		Properties prop = new Properties();
		File file = new File(FILE_PATH);
		InputStream fis;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
			// 一定要在修改值之前关闭fis
			fis.close();
			OutputStream fos = new FileOutputStream(FILE_PATH);
			prop.setProperty(key, value);
			// 保存，并加入注释
			prop.store(fos, "Update '" + key + "' value");
			fos.close();

			System.out.println("修改/添加的字段: " + key + ",值: " + value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		InitGlobalFont(new Font("宋体", Font.PLAIN, 14));

		// 创建 JFrame 实例
		JFrame frame = new JFrame("Java打印参数面板");
		// Setting the width and height of frame
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		// 添加面板
		frame.add(panel);
		/*
		 * 调用用户定义的方法并添加组件到面板
		 */
		placeComponents(panel,frame);

		// 设置界面可见并居中
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
