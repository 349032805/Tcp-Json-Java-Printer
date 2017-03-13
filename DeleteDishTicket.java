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

import Demo.AddOrDelDishBean.ModelBean.OrderDetailDTOBean;
import Demo.AddOrDelDishBean.ModelBean.OrderDetailDTOBean.OrderItemListBean;

public class DeleteDishTicket implements Printable {

	private OrderDetailDTOBean order;

	public DeleteDishTicket(OrderDetailDTOBean order) {
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
		g2.drawString("[退]" + order.getTableName(), (float) x, (float) y + heigth);

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
			g2.drawLine(0, yNumber, 130, yNumber);
		}

		switch (pageIndex) {
		case 0:
			return PAGE_EXISTS;
		default:
			return NO_SUCH_PAGE;

		}

	}
}
