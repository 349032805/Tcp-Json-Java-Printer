package Demo;

public class ExceptionTest {
	public static void main(String[] args) {
		String msg = "success";
		try {
			int[] is = null;
			System.out.println(is[10]);
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionRecord.setRecord(ExceptionRecord.getExceptionMsg(e));
			
			msg = "fail";
		} finally {
			System.out.println(msg);
		}
	}
}
