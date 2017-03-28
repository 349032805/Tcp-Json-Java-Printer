package Demo;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			int[] is = null;
			System.out.println(is[10]);
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionRecord.setRecord(ExceptionRecord.getExceptionMsg(e));
			SendMail.sendMail(ExceptionRecord.sendMailMessage(e));
//			SendMail.sendMail("Java程序出错了!");

		}
	}
}
