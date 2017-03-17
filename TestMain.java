package Demo;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class TestMain {
	
	public static void main(String[] args) {
		
		List<String> strList= new ArrayList<String>();
		
		PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);
		for(int i=0;i<ps.length;i++){
			String printName = ps[i].toString();
			if(!printName.contains("Fax") && !printName.contains("Microsoft XPS Document Writer") && !printName.contains("Foxit Reader PDF Printer")){
				strList.add(printName.split(":")[1]);
			}
		
		}
		
		for(int j=0;j<strList.size();j++){
			System.out.println("系统存在的打印机服务:"+strList.get(j));
		}
		
		System.out.println("------------------------------华丽丽的分割线-------------------------:");
		
		//当前默认打印机
		PrintService pss = PrintServiceLookup.lookupDefaultPrintService();
		pss.getName();
		System.out.println("当前默认打印机" + pss.getName());
		
		try{
			System.out.println("当前局域网IP地址:"+InetAddress.getLocalHost().getHostAddress());
		}catch(Exception e){
			System.out.println("IP地址获取失败!");
		}
			
	}

}
