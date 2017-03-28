package Demo;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExceptionRecord {
	public static void setRecord(String record) {
		File filename = new File(Config.EXCEPTION_RECORD);
		try {
			if (!filename.exists())
				filename.createNewFile();
			FileWriter fileWriter = new FileWriter(Config.EXCEPTION_RECORD, true); // true代表追加
			fileWriter.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\r\n"
					+ record + "\r\n");
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void setRecordWithStoreName(String record, String storeName) {
		File filename = new File(Config.EXCEPTION_RECORD);
		try {
			if (!filename.exists())
				filename.createNewFile();
			FileWriter fileWriter = new FileWriter(Config.EXCEPTION_RECORD, true); // true代表追加
			fileWriter.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\r\n"
					+ record + "\r\n" + "当前门店: " + storeName + "\r\n");
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getExceptionMsg(Exception e) {
		StringBuffer emsg = new StringBuffer();
		if (e != null) {
			StackTraceElement[] st = e.getStackTrace();
			for (StackTraceElement stackTraceElement : st) {
				String exclass = stackTraceElement.getClassName();
				String method = stackTraceElement.getMethodName();
				emsg.append("[类:" + exclass + "]调用" + method + "时在第" + stackTraceElement.getLineNumber()
						+ "行代码处发生异常!异常类型:" + e.toString() + "\r\n");
			}
		}
		return emsg.toString();
	}

	// 传给邮箱的消息体
	public static String sendMailMessage(Exception e) {
		String record = getExceptionMsg(e);
		record = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\r\n" + record
				+ "\r\n";
		return record;
	}

	public static String sendMailMessageWithStoreName(Exception e, String storeName) {
		String record = getExceptionMsg(e);
		record = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\r\n" + record
				+ "\r\n" + "当前门店: " + storeName + "\r\n";
		return record;
	}

}
