package Demo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.BadLocationException;

import com.sun.xml.internal.txw2.Document;

public class PrintSwingFrame {
	
	private static final int WINDOW_WIDTH = 350;
	private static final int WINDOW_HEIGHT = 480;

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);
		JLabel portLabel = new JLabel("端口号:");
		portLabel.setBounds(10, 20, 50, 25);
		panel.add(portLabel);
		
		String port = "9100";
		JTextField portText = new JTextField(port, 5);
		portText.setBounds(100, 20, 100, 25);
		panel.add(portText);
		
		
		JLabel titleLabel1 = new JLabel("系统存在的打印服务:");
		titleLabel1.setBounds(10, 60, WINDOW_WIDTH, 25);
		panel.add(titleLabel1);
		
		List<String> strList= new ArrayList<String>();
		
		PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);
		for(int i=0;i<ps.length;i++){
			String printName = ps[i].toString();
			if(!printName.contains("Fax") && !printName.contains("Microsoft XPS Document Writer") && !printName.contains("Foxit Reader PDF Printer")){
				String printer = printName.split(":")[1];
				printer = printer.trim();
				strList.add(printer);
			}
		
		}
		
		int currentLocation  = 80;
		for(int j=0;j<strList.size();j++){
			System.out.println("系统存在的打印机服务:"+strList.get(j));
			JLabel label = new JLabel(strList.get(j));
			label.setBounds(10, currentLocation, 200, 25);
			panel.add(label);
			
			currentLocation += 20;
		}
		
		currentLocation += 20;
		PrintService pss = PrintServiceLookup.lookupDefaultPrintService();
		JLabel  titleLabel2 = new JLabel("当前默认打印机: " + pss.getName());
		titleLabel2.setBounds(10, currentLocation, WINDOW_WIDTH, 25);
		panel.add(titleLabel2);
		System.out.println("当前默认打印机:"+ pss.getName());
		
		String ip = "";
		try{
			ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println("当前局域网IP地址:"+ip);
		}catch(Exception e){
			System.out.println("IP地址获取失败!");
		}

		currentLocation += 25;
		JLabel  titleLabel3 = new JLabel("当前局域网IP地址: " + ip);
		titleLabel3.setBounds(10, currentLocation, WINDOW_WIDTH, 25);
		panel.add(titleLabel3);
		
		currentLocation += 50;
		JButton testButton = new JButton("打印测试页(请设置默认物理打印机)");
		testButton.setBounds(25, currentLocation, 280, 30);
		panel.add(testButton);
		
		String ipAddress = ip;
		testButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PrintTest.defaultPrint(ipAddress,port,pss.getName(),strList);
            }
        });
		
		currentLocation += 40;
		JButton testButton2 = new JButton("打印测试页(多台)");
		testButton2.setBounds(25, currentLocation, 280, 30);
		panel.add(testButton2);
		
		testButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PrintTest.printWithPrinterName(ipAddress, port, pss.getName(), strList);
            }
        });
		
		// 确定按钮
		currentLocation += 90;
		JButton saveButton = new JButton("确定");
		saveButton.setBounds(100, currentLocation, 100, 30);
		panel.add(saveButton);
		
		String resetPort = port;
		//监听输入框的变化
		portText.getDocument().addDocumentListener(new DocumentListener(){
			 
            public void changedUpdate(DocumentEvent e) {
            	  javax.swing.text.Document doc = e.getDocument();  
                  try {
					String s = doc.getText(0, doc.getLength());
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
 
            public void insertUpdate(DocumentEvent e) {
            	  javax.swing.text.Document doc = e.getDocument();  
                  try {
					String s = doc.getText(0, doc.getLength());
					System.out.println(s);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                 
            }
 
            public void removeUpdate(DocumentEvent e) {
            	  javax.swing.text.Document doc = e.getDocument();  
                  try {
					String s = doc.getText(0, doc.getLength());
					System.out.println(s);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //返回文本框输入的内容  
                 
            }
             
        });

		
		
		saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("重设IP:"+resetPort);
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
		placeComponents(panel);

		// 设置界面可见并居中
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); 
	}
}
