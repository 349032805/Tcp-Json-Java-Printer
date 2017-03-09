package Demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.alibaba.fastjson.JSON;

import Demo.AddOrDelDishBean.ModelBean.OrderDetailDTOBean;
import Demo.AddOrDelDishBean.ModelBean.OrderDetailDTOBean.OrderItemListBean;

public class DeleteDishTicket implements Printable {
	
	private String data;

	public DeleteDishTicket(String data) {
		this.data = data;
	}

	/**
	 * @param graphics
	 *            指明打印的图形环境
	 * @param pageFormat
	 *            指明打印页格式（页面大小以点为计量单位，1点为1英才的1/72，1英寸为25.4毫米。A4纸大致为595× 842点）
	 * @param pageIndex
	 *            指明页号
	 **/
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// 转换成Graphics2D 拿到画笔
		Graphics2D g2 = (Graphics2D) graphics;
		// 设置打印颜色为黑色
		g2.setColor(Color.black);

		// 打印起点坐标
		double x = pageFormat.getImageableX();
		double y = pageFormat.getImageableY();

		System.out.println("----------------------------x: " + x);
		System.out.println("----------------------------y: " + y);

		// String str =
		// "{\"recId\":284,\"code\":\"200\",\"model\":[{\"typeId\":\"2\",\"width\":58,\"isIncision\":2,\"deviceId\":\"56\",\"printIp\":\"192.168.0.253\",\"orderDetailDTO\":{\"headUrl\":\"http://wx.qlogo.cn/mmopen/RX0XCujlbMPrXgJYKnF4MZMiajOlvZItFSclohF5Ikvmm2zQVEH52o8utPUrTyQ3DHlqTgqO0BSDeDcx6X6No4cxIbuNbRwibG/0\",\"orderId\":1989,\"addtime\":\"2017-01-13
		// 15:15:36\",\"orderType\":1,\"invoiceType\":1,\"storeId\":\"144\",\"remark\":\"ddas,!@#撒旦法萨发\",\"payConfigTime\":\"2017-01-13
		// 16:22:58\",\"tableName\":\"3外1\",\"payConfigUserName\":\"0021\",\"configUserName\":\"0021\",\"activityName\":\"全单2折\",\"configUserId\":\"151\",\"attribute\":\"1100\",\"paidDiscountMoney\":120,\"totelprice\":148,\"invoiceHeader\":\"\",\"orderDiscount\":20,\"payType\":2,\"tableId\":\"374\",\"orderItemList\":[{\"number\":2,\"orderId\":1989,\"propertyName\":\"自烤\",\"itemName\":\"精品牛舌\",\"dishesId\":1273,\"menusItemId\":9468,\"dishesSortId\":175,\"itemStatus\":1,\"orderItemId\":5081,\"money\":55},{\"number\":1,\"orderId\":1989,\"propertyName\":\"自烤\",\"itemName\":\"生牛排\",\"dishesId\":1282,\"menusItemId\":9477,\"dishesSortId\":175,\"itemStatus\":2,\"orderItemId\":5134,\"money\":148}],\"storeName\":\"真炉韩国料理(龙阳店)\",\"peopleNumber\":\"2\",\"noDiscountMoney\":0,\"channel\":\"2\",\"email\":\"\",\"paidMoney\":30,\"totalWeight\":1,\"activityType\":2,\"status\":4,\"configTime\":\"2017-01-13
		// 16:22:40\",\"isRead\":1,\"serviceCharges\":[{\"orderChargeId\":908,\"orderId\":1989,\"quantity\":2,\"chargeName\":\"湿巾\",\"price\":1,\"chargeType\":1,\"money\":2}],\"orderNo\":\"17011300000104\",\"isInvoice\":0,\"userName\":\"%E6%AF%94%E5%8D%A1%E4%B8%98\",\"parentId\":0,\"phone\":\"15618929263\",\"drinkType\":0,\"userId\":\"77\"},\"deviceName\":\"POS58\",\"number\":0,\"isShowMoney\":0,\"printPort\":\"8000\",\"printNumber\":1,\"status\":\"1\"}],\"printType\":1,\"time\":1484296343425,\"currentTime\":\"2017-01-13
		// 16:32:23\"}";

		System.out.println("-------------数据: " + data);
		AddOrDelDishBean dddOrDelDishBean = JSON.parseObject(data, AddOrDelDishBean.class);
		OrderDetailDTOBean order = dddOrDelDishBean.getModel().get(0).getOrderDetailDTO();

		// 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
		Font font = new Font("宋体", Font.BOLD, 11);
		g2.setFont(font);// 设置字体
		float heigth = font.getSize2D();// 字体高度
		// 标题
		System.out.println("---------------------(float) y + heigth:" + (float) y + heigth);
		g2.drawString("[退]" +order.getTableName(), (float) x, (float) y + heigth);

		font = new Font("宋体", Font.PLAIN, 9);
		g2.setFont(font);// 设置字体
		heigth = font.getSize2D();// 字体高度

		g2.drawString("订单编号: " + order.getOrderNo(), (float) x, (float) y + 40);
		g2.drawString("下单时间:" + order.getAddtime(), (float) x, (float) y + 55);
		g2.drawString("打印时间:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
				(float) x, (float) y + 70);
		
		
		// 显示标题
		g2.drawString("菜品", (float) x + 20, (float) y + 85);
		g2.drawString("份数", (float) x + 105, (float) y + 85);

		List<OrderItemListBean> orderItemList = order.getOrderItemList();

		// 显示内容
		int yLocation = 100;
		int row = 15;

		for (int i = 0; i < orderItemList.size(); i++) {
			OrderItemListBean dish = orderItemList.get(i);
			g2.drawString(dish.getItemName(), (float) x, (float) y + yLocation + i * row);
			g2.drawString("x" + String.valueOf(dish.getNumber()), (float) x + 107, (float) y + yLocation + i * row);
			int yNumber = (int) (y + yLocation + i * row - 3);
			g2.drawLine(0,yNumber,130,yNumber); 
		}

		switch (pageIndex) {
		case 0:
			return PAGE_EXISTS;
		default:
			return NO_SUCH_PAGE;

		}

	}
}
