package Demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.alibaba.fastjson.JSON;

import Demo.PayBean.ModelBean.OrderDetailDTOBean;
import Demo.PayBean.ModelBean.OrderDetailDTOBean.OrderItemListBean;
import Demo.PayBean.ModelBean.OrderDetailDTOBean.ServiceChargesBean;

/*
 * 小票(支付确认)
 */
public class PayTicket implements Printable {

	private String data;

	public PayTicket(String data) {
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
		Component c = null;
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
		PayBean payBean = JSON.parseObject(data, PayBean.class);
		OrderDetailDTOBean order = payBean.getModel().get(0).getOrderDetailDTO();

		// 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
		Font font = new Font("宋体", Font.BOLD, 11);
		g2.setFont(font);// 设置字体
		float heigth = font.getSize2D();// 字体高度
		// 标题
		System.out.println("---------------------(float) y + heigth:" + (float) y + heigth);
		g2.drawString(order.getStoreName(), (float) x, (float) y + heigth);

		font = new Font("宋体", Font.PLAIN, 9);
		g2.setFont(font);// 设置字体
		heigth = font.getSize2D();// 字体高度

		g2.drawString("订单编号: " + order.getOrderNo(), (float) x, (float) y + 40);
		g2.drawString("桌   号: " + order.getTableName(), (float) x, (float) y + 55);
		g2.drawString("下单时间:" + order.getAddtime(), (float) x, (float) y + 70);
		// g2.drawString("打印时间:" + order.getPayConfigTime(), (float) x, (float)
		// y + 85);
		g2.drawString("打印时间:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
				(float) x, (float) y + 85);

		// 显示标题
		g2.drawString("菜品", (float) x + 20, (float) y + 110);
		g2.drawString("份数", (float) x + 70, (float) y + 110);
		g2.drawString("总价", (float) x + 105, (float) y + 110);

		List<OrderItemListBean> orderItemList = order.getOrderItemList();

		// 显示内容
		int yLocation = 125;
		int row = 15;

		for (int i = 0; i < orderItemList.size(); i++) {
			OrderItemListBean dish = orderItemList.get(i);
			String dishName = dish.getItemName();
			if (dish.getItemStatus() == 1) {
				dishName = dishName + "[退]";
			} else if (dish.getItemStatus() == 2) {
				dishName = dishName + "[加]";
			} else if (dish.getItemStatus() == 3) {
				dishName = "原（" + dishName + "）";
			} else if (dish.getItemStatus() == 4) {
				dishName = dishName + "[换]";
			}
			g2.drawString(dishName, (float) x, (float) y + yLocation + i * row);
			g2.drawString("x" + String.valueOf(dish.getNumber()), (float) x + 77, (float) y + yLocation + i * row);
			BigDecimal number = new BigDecimal(String.valueOf(dish.getNumber()));
			g2.drawString("¥" + dish.getMoney().multiply(number), (float) x + 107, (float) y + yLocation + i * row);
		}

		int resetLocation = 125 + 15 * orderItemList.size();

		BigDecimal serviceChargesTotalSum = new BigDecimal(0);
		List<ServiceChargesBean> serviceChargesList = order.getServiceCharges();
		if (serviceChargesList.size() > 0) {
			for (int i = 0; i < serviceChargesList.size(); i++) {
				ServiceChargesBean serviceCharges = serviceChargesList.get(i);
				g2.drawString("#" + serviceCharges.getChargeName(), (float) x, (float) y + resetLocation + i * row);
				g2.drawString("x" + String.valueOf(serviceCharges.getQuantity()), (float) x + 77,
						(float) y + resetLocation + i * row);
				g2.drawString("¥" + String.valueOf(serviceCharges.getMoney()), (float) x + 107,
						(float) y + resetLocation + i * row);
				serviceChargesTotalSum = serviceChargesTotalSum.add(serviceCharges.getMoney());
			}
		}

		resetLocation += 15 * serviceChargesList.size();

		BigDecimal totalSum = order.getTotelprice().add(serviceChargesTotalSum);
		g2.drawString("合计：", (float) x, (float) y + resetLocation);
		g2.drawString("x" + String.valueOf(order.getTotalWeight()), (float) x + 77, (float) y + resetLocation);
		g2.drawString("¥" + totalSum, (float) x + 107, (float) y + resetLocation);

		font = new Font("宋体", Font.BOLD, 11);
		g2.setFont(font);
		heigth = font.getSize2D();

		g2.drawString("应收金额：", (float) x, (float) y + resetLocation + 15);
		g2.drawString("¥" + totalSum, (float) x + 107, (float) y + resetLocation + 15);

		font = new Font("宋体", Font.PLAIN, 9);
		g2.setFont(font);
		heigth = font.getSize2D();

		String activeName = "";
		if (order.getActivityName() != null && order.getActivityName() != "" && !order.getActivityName().equals("")) {
			activeName = " (" + order.getActivityName() + ")";
		}
		g2.drawString("商户折扣: ", (float) x, (float) y + resetLocation + 30);
		g2.drawString("¥" + order.getPaidDiscountMoney() + activeName, (float) x + 45, (float) y + resetLocation + 30);

		BigDecimal canDiscount = totalSum.subtract(order.getNoDiscountMoney());
		g2.drawString("可折扣类: ", (float) x, (float) y + resetLocation + 45);
		g2.drawString("¥" + canDiscount, (float) x + 45, (float) y + resetLocation + 45);

		g2.drawString("不可折扣类: ", (float) x, (float) y + resetLocation + 60);
		g2.drawString("¥" + order.getNoDiscountMoney(), (float) x + 50, (float) y + resetLocation + 60);

		font = new Font("宋体", Font.BOLD, 11);
		g2.setFont(font);
		heigth = font.getSize2D();

		g2.drawString("实收金额: ", (float) x, (float) y + resetLocation + 75);
		g2.drawString("¥" + order.getPaidMoney(), (float) x + 55, (float) y + resetLocation + 75);

		font = new Font("宋体", Font.PLAIN, 9);
		g2.setFont(font);
		heigth = font.getSize2D();

		int orderType = order.getOrderType();
		String typeStr = "";
		if (orderType == 1) {
			typeStr = "普通下单";
		} else if (orderType == 2) {
			typeStr = "拼单";
		} else if (orderType == 3) {
			typeStr = "服务员下单";
		}

		g2.drawString("点餐方式: ", (float) x, (float) y + resetLocation + 90);
		g2.drawString(typeStr, (float) x + 45, (float) y + resetLocation + 90);

		g2.drawString("菜品确认人: ", (float) x, (float) y + resetLocation + 105);
		g2.drawString(order.getConfigUserName(), (float) x + 50, (float) y + resetLocation + 105);

		int payType = order.getPayType();
		String payTypeStr = "";
		if (payType == 1) {
			payTypeStr = "微信支付";
		} else if (payType == 2) {
			payTypeStr = "线下支付";
		}

		g2.drawString("支付方式: ", (float) x, (float) y + resetLocation + 120);
		g2.drawString(payTypeStr, (float) x + 45, (float) y + resetLocation + 120);

		String payConfigUserName = order.getPayConfigUserName();
		if (payConfigUserName != null && payConfigUserName != "" && !payConfigUserName.equals("")) {
			g2.drawString("支付确认人: ", (float) x, (float) y + resetLocation + 135);
			g2.drawString(order.getPayConfigUserName(), (float) x + 50, (float) y + resetLocation + 135);
		}

		int invoiceType = order.getInvoiceType();
		System.out.println("---------------invoiceType: " + invoiceType);
		String invoiceTypeStr = "";
		if (invoiceType == 1) {
			invoiceTypeStr = "个人(纸质)";
		} else if (invoiceType == 2) {
			invoiceTypeStr = "个人(电子)";
		} else if (invoiceType == 3) {
			invoiceTypeStr = "公司(纸质)";
		} else if (invoiceType == 4) {
			invoiceTypeStr = "公司(电子)";
		}
		
		g2.drawString("发票信息: ", (float) x, (float) y + resetLocation + 150);
		g2.drawString(invoiceTypeStr, (float) x + 50, (float) y + resetLocation + 150);
		g2.drawString("发票抬头: " + order.getInvoiceHeader(), (float) x, (float) y + resetLocation + 175);

		Component component = null;
		Image src = Toolkit.getDefaultToolkit().getImage("D:\\qrcode.png");
		g2.drawImage(src, (int) x + 10, (int) (resetLocation + 190), component);

		int imgHeight = src.getHeight(c);
		g2.drawString("关注易趴公众号，可收到订单通知，", (float) x, (float) y + resetLocation + 200 + imgHeight);
		g2.drawString("红包优惠信息以及可快速聚会吃饭，快关注体验吧！", (float) x, (float) y + resetLocation + 210 + imgHeight);
		g2.drawString("快关注体验吧！", (float) x, (float) y + resetLocation + 220 + imgHeight);

		switch (pageIndex) {
		case 0:
			return PAGE_EXISTS;
		default:
			return NO_SUCH_PAGE;

		}

	}

}