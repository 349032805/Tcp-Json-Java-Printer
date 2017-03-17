package Demo;

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

import Demo.ConfirmBean.ModelBean.OrderDetailDTOBean;
import Demo.ConfirmBean.ModelBean.OrderDetailDTOBean.OrderItemListBean;
import Demo.ConfirmBean.ModelBean.OrderDetailDTOBean.ServiceChargesBean;

/*
 * 小票(顾客确认,前台)
 */
public class ConfirmTicket implements Printable {
	
	private OrderDetailDTOBean order;

	public ConfirmTicket(OrderDetailDTOBean order) {
		this.order = order;
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


		// 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
		Font font = new Font("宋体", Font.BOLD, 11);
		g2.setFont(font);// 设置字体
		float heigth = font.getSize2D();// 字体高度
		// 标题
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
		g2.drawString("价格", (float) x + 105, (float) y + 110);

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
		

		if (order.getRemark() != null && order.getRemark() != "" && !order.getRemark().equals("")) {
			resetLocation += 15;
			g2.drawString("备注：", (float) x, (float) y + resetLocation);
			resetLocation += 15;
			g2.drawString(order.getRemark(), (float) x, (float) y + resetLocation);
		}
	

		int orderType = order.getOrderType();
		String typeStr = "";
		if (orderType == 1) {
			typeStr = "普通下单";
		} else if (orderType == 2) {
			typeStr = "拼单";
		} else if (orderType == 3) {
			typeStr = "服务员下单";
		}

		resetLocation += 15;
		g2.drawString("点餐方式: ", (float) x, (float) y + resetLocation);
		g2.drawString(typeStr, (float) x + 45, (float) y + resetLocation);

		resetLocation += 15;
		g2.drawString("订单确认人: ", (float) x, (float) y + resetLocation);
		g2.drawString(order.getConfigUserName(), (float) x + 50, (float) y + resetLocation);

		int invoiceType = order.getInvoiceType();
		System.out.println("---------------invoiceType: " + invoiceType);
		String invoiceTypeStr = "";
		if ( invoiceType == 1) {
			invoiceTypeStr = "个人(纸质)";
		} else if (invoiceType == 2) {
			invoiceTypeStr = "个人(电子)";
		} else if (invoiceType == 3) {
			invoiceTypeStr = "公司(纸质)";
		} else if (invoiceType == 4) {
			invoiceTypeStr = "公司(电子)";
		}

		if (order.getInvoiceType() != 0) {
			resetLocation += 15;
			g2.drawString("发票信息: ", (float) x, (float) y + resetLocation);
			g2.drawString(invoiceTypeStr, (float) x + 50, (float) y + resetLocation);
			resetLocation += 15;
			g2.drawString("发票抬头: " + order.getInvoiceHeader(), (float) x, (float) y + resetLocation);
		}

		resetLocation += 20;
		Component component = null;
		Image src = Toolkit.getDefaultToolkit().getImage(Config.IMAGE_PATH);
		g2.drawImage(src, (int) x + 10, (int) (resetLocation), component);

		resetLocation += 20;
		int imgHeight = src.getHeight(c);
		g2.drawString("关注易趴公众号，可收到订单通知，", (float) x, (float) y + resetLocation + imgHeight);
		resetLocation += 15;
		g2.drawString("红包优惠信息以及可快速聚会吃饭，快关注体验吧！", (float) x, (float) y + resetLocation + imgHeight);
		resetLocation += 15;
		g2.drawString("快关注体验吧！", (float) x, (float) y + resetLocation  + imgHeight);

		switch (pageIndex) {
		case 0:
			return PAGE_EXISTS;
		default:
			return NO_SUCH_PAGE;

		}

	}
}
