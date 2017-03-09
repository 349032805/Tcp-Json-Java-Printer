package Demo;

import java.math.BigDecimal;
import java.util.List;
/*
 * 小票(支付确认) Bean
 */
public class PayBean {

	/**
	 * recId : 284 code : 200 model :
	 * [{"typeId":"2","width":58,"isIncision":2,"deviceId":"56","printIp":"192.168.0.253","orderDetailDTO":{"headUrl":"http://wx.qlogo.cn/mmopen/RX0XCujlbMPrXgJYKnF4MZMiajOlvZItFSclohF5Ikvmm2zQVEH52o8utPUrTyQ3DHlqTgqO0BSDeDcx6X6No4cxIbuNbRwibG/0","orderId":1989,"addtime":"2017-01-13
	 * 15:15:36","orderType":1,"invoiceType":0,"storeId":"144","remark":"ddas,!@#撒旦法萨发","payConfigTime":"2017-01-13
	 * 16:22:58","tableName":"3外1","payConfigUserName":"0021","configUserName":"0021","activityName":"全单2折","configUserId":"151","attribute":"1100","paidDiscountMoney":120,"totelprice":148,"invoiceHeader":"","orderDiscount":20,"payType":2,"tableId":"374","orderItemList":[{"number":2,"orderId":1989,"propertyName":"自烤","itemName":"精品牛舌","dishesId":1273,"menusItemId":9468,"dishesSortId":175,"itemStatus":1,"orderItemId":5081,"money":55},{"number":1,"orderId":1989,"propertyName":"自烤","itemName":"生牛排","dishesId":1282,"menusItemId":9477,"dishesSortId":175,"itemStatus":2,"orderItemId":5134,"money":148}],"storeName":"真炉韩国料理(龙阳店)","peopleNumber":"2","noDiscountMoney":0,"channel":"2","email":"","paidMoney":30,"totalWeight":1,"activityType":2,"status":4,"configTime":"2017-01-13
	 * 16:22:40","isRead":1,"serviceCharges":[{"orderChargeId":908,"orderId":1989,"quantity":2,"chargeName":"湿巾","price":1,"chargeType":1,"money":2}],"orderNo":"17011300000104","isInvoice":0,"userName":"%E6%AF%94%E5%8D%A1%E4%B8%98","parentId":0,"phone":"15618929263","drinkType":0,"userId":"77"},"deviceName":"POS58","number":0,"isShowMoney":0,"printPort":"8000","printNumber":1,"status":"1"}]
	 * printType : 1 time : 1484296343425 currentTime : 2017-01-13 16:32:23
	 */

	private int recId;
	private String code;
	private int printType;
	private long time;
	private String currentTime;
	private List<ModelBean> model;

	public int getRecId() {
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrintType() {
		return printType;
	}

	public void setPrintType(int printType) {
		this.printType = printType;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public List<ModelBean> getModel() {
		return model;
	}

	public void setModel(List<ModelBean> model) {
		this.model = model;
	}

	public static class ModelBean {
		/**
		 * typeId : 2 width : 58 isIncision : 2 deviceId : 56 printIp :
		 * 192.168.0.253 orderDetailDTO :
		 * {"headUrl":"http://wx.qlogo.cn/mmopen/RX0XCujlbMPrXgJYKnF4MZMiajOlvZItFSclohF5Ikvmm2zQVEH52o8utPUrTyQ3DHlqTgqO0BSDeDcx6X6No4cxIbuNbRwibG/0","orderId":1989,"addtime":"2017-01-13
		 * 15:15:36","orderType":1,"invoiceType":0,"storeId":"144","remark":"ddas,!@#撒旦法萨发","payConfigTime":"2017-01-13
		 * 16:22:58","tableName":"3外1","payConfigUserName":"0021","configUserName":"0021","activityName":"全单2折","configUserId":"151","attribute":"1100","paidDiscountMoney":120,"totelprice":148,"invoiceHeader":"","orderDiscount":20,"payType":2,"tableId":"374","orderItemList":[{"number":2,"orderId":1989,"propertyName":"自烤","itemName":"精品牛舌","dishesId":1273,"menusItemId":9468,"dishesSortId":175,"itemStatus":1,"orderItemId":5081,"money":55},{"number":1,"orderId":1989,"propertyName":"自烤","itemName":"生牛排","dishesId":1282,"menusItemId":9477,"dishesSortId":175,"itemStatus":2,"orderItemId":5134,"money":148}],"storeName":"真炉韩国料理(龙阳店)","peopleNumber":"2","noDiscountMoney":0,"channel":"2","email":"","paidMoney":30,"totalWeight":1,"activityType":2,"status":4,"configTime":"2017-01-13
		 * 16:22:40","isRead":1,"serviceCharges":[{"orderChargeId":908,"orderId":1989,"quantity":2,"chargeName":"湿巾","price":1,"chargeType":1,"money":2}],"orderNo":"17011300000104","isInvoice":0,"userName":"%E6%AF%94%E5%8D%A1%E4%B8%98","parentId":0,"phone":"15618929263","drinkType":0,"userId":"77"}
		 * deviceName : POS58 number : 0 isShowMoney : 0 printPort : 8000
		 * printNumber : 1 status : 1
		 */

		private String typeId;
		private int width;
		private int isIncision;
		private String deviceId;
		private String printIp;
		private OrderDetailDTOBean orderDetailDTO;
		private String deviceName;
		private int number;
		private int isShowMoney;
		private String printPort;
		private int printNumber;
		private String status;

		public String getTypeId() {
			return typeId;
		}

		public void setTypeId(String typeId) {
			this.typeId = typeId;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getIsIncision() {
			return isIncision;
		}

		public void setIsIncision(int isIncision) {
			this.isIncision = isIncision;
		}

		public String getDeviceId() {
			return deviceId;
		}

		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}

		public String getPrintIp() {
			return printIp;
		}

		public void setPrintIp(String printIp) {
			this.printIp = printIp;
		}

		public OrderDetailDTOBean getOrderDetailDTO() {
			return orderDetailDTO;
		}

		public void setOrderDetailDTO(OrderDetailDTOBean orderDetailDTO) {
			this.orderDetailDTO = orderDetailDTO;
		}

		public String getDeviceName() {
			return deviceName;
		}

		public void setDeviceName(String deviceName) {
			this.deviceName = deviceName;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public int getIsShowMoney() {
			return isShowMoney;
		}

		public void setIsShowMoney(int isShowMoney) {
			this.isShowMoney = isShowMoney;
		}

		public String getPrintPort() {
			return printPort;
		}

		public void setPrintPort(String printPort) {
			this.printPort = printPort;
		}

		public int getPrintNumber() {
			return printNumber;
		}

		public void setPrintNumber(int printNumber) {
			this.printNumber = printNumber;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public static class OrderDetailDTOBean {
			/**
			 * headUrl :
			 * http://wx.qlogo.cn/mmopen/RX0XCujlbMPrXgJYKnF4MZMiajOlvZItFSclohF5Ikvmm2zQVEH52o8utPUrTyQ3DHlqTgqO0BSDeDcx6X6No4cxIbuNbRwibG/0
			 * orderId : 1989 addtime : 2017-01-13 15:15:36 orderType : 1
			 * invoiceType : 0 storeId : 144 remark : ddas,!@#撒旦法萨发
			 * payConfigTime : 2017-01-13 16:22:58 tableName : 3外1
			 * payConfigUserName : 0021 configUserName : 0021 activityName :
			 * 全单2折 configUserId : 151 attribute : 1100 paidDiscountMoney : 120
			 * totelprice : 148 invoiceHeader : orderDiscount : 20 payType : 2
			 * tableId : 374 orderItemList :
			 * [{"number":2,"orderId":1989,"propertyName":"自烤","itemName":"精品牛舌","dishesId":1273,"menusItemId":9468,"dishesSortId":175,"itemStatus":1,"orderItemId":5081,"money":55},{"number":1,"orderId":1989,"propertyName":"自烤","itemName":"生牛排","dishesId":1282,"menusItemId":9477,"dishesSortId":175,"itemStatus":2,"orderItemId":5134,"money":148}]
			 * storeName : 真炉韩国料理(龙阳店) peopleNumber : 2 noDiscountMoney : 0
			 * channel : 2 email : paidMoney : 30 totalWeight : 1 activityType :
			 * 2 status : 4 configTime : 2017-01-13 16:22:40 isRead : 1
			 * serviceCharges :
			 * [{"orderChargeId":908,"orderId":1989,"quantity":2,"chargeName":"湿巾","price":1,"chargeType":1,"money":2}]
			 * orderNo : 17011300000104 isInvoice : 0 userName :
			 * %E6%AF%94%E5%8D%A1%E4%B8%98 parentId : 0 phone : 15618929263
			 * drinkType : 0 userId : 77
			 */

			private String headUrl;
			private int orderId;
			private String addtime;
			private int orderType;
			private int invoiceType;
			private String storeId;
			private String remark;
			private String payConfigTime;
			private String tableName;
			private String payConfigUserName;
			private String configUserName;
			private String activityName;
			private String configUserId;
			private String attribute;
			private BigDecimal paidDiscountMoney;
			private BigDecimal totelprice;
			private String invoiceHeader;
			private int orderDiscount;
			private int payType;
			private String tableId;
			private String storeName;
			private String peopleNumber;
			private BigDecimal noDiscountMoney;
			private String channel;
			private String email;
			private BigDecimal paidMoney;
			private int totalWeight;
			private int activityType;
			private int status;
			private String configTime;
			private int isRead;
			private String orderNo;
			private int isInvoice;
			private String userName;
			private int parentId;
			private String phone;
			private int drinkType;
			private String userId;
			private List<OrderItemListBean> orderItemList;
			private List<ServiceChargesBean> serviceCharges;

			public String getHeadUrl() {
				return headUrl;
			}

			public void setHeadUrl(String headUrl) {
				this.headUrl = headUrl;
			}

			public int getOrderId() {
				return orderId;
			}

			public void setOrderId(int orderId) {
				this.orderId = orderId;
			}

			public String getAddtime() {
				return addtime;
			}

			public void setAddtime(String addtime) {
				this.addtime = addtime;
			}

			public int getOrderType() {
				return orderType;
			}

			public void setOrderType(int orderType) {
				this.orderType = orderType;
			}

			public int getInvoiceType() {
				return invoiceType;
			}

			public void setInvoiceType(int invoiceType) {
				this.invoiceType = invoiceType;
			}

			public String getStoreId() {
				return storeId;
			}

			public void setStoreId(String storeId) {
				this.storeId = storeId;
			}

			public String getRemark() {
				return remark;
			}

			public void setRemark(String remark) {
				this.remark = remark;
			}

			public String getPayConfigTime() {
				return payConfigTime;
			}

			public void setPayConfigTime(String payConfigTime) {
				this.payConfigTime = payConfigTime;
			}

			public String getTableName() {
				return tableName;
			}

			public void setTableName(String tableName) {
				this.tableName = tableName;
			}

			public String getPayConfigUserName() {
				return payConfigUserName;
			}

			public void setPayConfigUserName(String payConfigUserName) {
				this.payConfigUserName = payConfigUserName;
			}

			public String getConfigUserName() {
				return configUserName;
			}

			public void setConfigUserName(String configUserName) {
				this.configUserName = configUserName;
			}

			public String getActivityName() {
				return activityName;
			}

			public void setActivityName(String activityName) {
				this.activityName = activityName;
			}

			public String getConfigUserId() {
				return configUserId;
			}

			public void setConfigUserId(String configUserId) {
				this.configUserId = configUserId;
			}

			public String getAttribute() {
				return attribute;
			}

			public void setAttribute(String attribute) {
				this.attribute = attribute;
			}

			public BigDecimal getPaidDiscountMoney() {
				return paidDiscountMoney;
			}

			public void setPaidDiscountMoney(BigDecimal paidDiscountMoney) {
				this.paidDiscountMoney = paidDiscountMoney;
			}

			public BigDecimal getTotelprice() {
				return totelprice;
			}

			public void setTotelprice(BigDecimal totelprice) {
				this.totelprice = totelprice;
			}

			public void setPaidMoney(BigDecimal paidMoney) {
				this.paidMoney = paidMoney;
			}

			public String getInvoiceHeader() {
				return invoiceHeader;
			}

			public void setInvoiceHeader(String invoiceHeader) {
				this.invoiceHeader = invoiceHeader;
			}

			public int getOrderDiscount() {
				return orderDiscount;
			}

			public void setOrderDiscount(int orderDiscount) {
				this.orderDiscount = orderDiscount;
			}

			public int getPayType() {
				return payType;
			}

			public void setPayType(int payType) {
				this.payType = payType;
			}

			public String getTableId() {
				return tableId;
			}

			public void setTableId(String tableId) {
				this.tableId = tableId;
			}

			public String getStoreName() {
				return storeName;
			}

			public void setStoreName(String storeName) {
				this.storeName = storeName;
			}

			public String getPeopleNumber() {
				return peopleNumber;
			}

			public void setPeopleNumber(String peopleNumber) {
				this.peopleNumber = peopleNumber;
			}

			public BigDecimal getNoDiscountMoney() {
				return noDiscountMoney;
			}

			public void setNoDiscountMoney(BigDecimal noDiscountMoney) {
				this.noDiscountMoney = noDiscountMoney;
			}

			public String getChannel() {
				return channel;
			}

			public void setChannel(String channel) {
				this.channel = channel;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public BigDecimal getPaidMoney() {
				return paidMoney;
			}

			public int getTotalWeight() {
				return totalWeight;
			}

			public void setTotalWeight(int totalWeight) {
				this.totalWeight = totalWeight;
			}

			public int getActivityType() {
				return activityType;
			}

			public void setActivityType(int activityType) {
				this.activityType = activityType;
			}

			public int getStatus() {
				return status;
			}

			public void setStatus(int status) {
				this.status = status;
			}

			public String getConfigTime() {
				return configTime;
			}

			public void setConfigTime(String configTime) {
				this.configTime = configTime;
			}

			public int getIsRead() {
				return isRead;
			}

			public void setIsRead(int isRead) {
				this.isRead = isRead;
			}

			public String getOrderNo() {
				return orderNo;
			}

			public void setOrderNo(String orderNo) {
				this.orderNo = orderNo;
			}

			public int getIsInvoice() {
				return isInvoice;
			}

			public void setIsInvoice(int isInvoice) {
				this.isInvoice = isInvoice;
			}

			public String getUserName() {
				return userName;
			}

			public void setUserName(String userName) {
				this.userName = userName;
			}

			public int getParentId() {
				return parentId;
			}

			public void setParentId(int parentId) {
				this.parentId = parentId;
			}

			public String getPhone() {
				return phone;
			}

			public void setPhone(String phone) {
				this.phone = phone;
			}

			public int getDrinkType() {
				return drinkType;
			}

			public void setDrinkType(int drinkType) {
				this.drinkType = drinkType;
			}

			public String getUserId() {
				return userId;
			}

			public void setUserId(String userId) {
				this.userId = userId;
			}

			public List<OrderItemListBean> getOrderItemList() {
				return orderItemList;
			}

			public void setOrderItemList(List<OrderItemListBean> orderItemList) {
				this.orderItemList = orderItemList;
			}

			public List<ServiceChargesBean> getServiceCharges() {
				return serviceCharges;
			}

			public void setServiceCharges(List<ServiceChargesBean> serviceCharges) {
				this.serviceCharges = serviceCharges;
			}

			public static class OrderItemListBean {
				/**
				 * number : 2 orderId : 1989 propertyName : 自烤 itemName : 精品牛舌
				 * dishesId : 1273 menusItemId : 9468 dishesSortId : 175
				 * itemStatus : 1 orderItemId : 5081 money : 55
				 */

				private int number;
				private int orderId;
				private String propertyName;
				private String itemName;
				private int dishesId;
				private int menusItemId;
				private int dishesSortId;
				private int itemStatus;
				private int orderItemId;
				private BigDecimal money;

				public int getNumber() {
					return number;
				}

				public void setNumber(int number) {
					this.number = number;
				}

				public int getOrderId() {
					return orderId;
				}

				public void setOrderId(int orderId) {
					this.orderId = orderId;
				}

				public String getPropertyName() {
					return propertyName;
				}

				public void setPropertyName(String propertyName) {
					this.propertyName = propertyName;
				}

				public String getItemName() {
					return itemName;
				}

				public void setItemName(String itemName) {
					this.itemName = itemName;
				}

				public int getDishesId() {
					return dishesId;
				}

				public void setDishesId(int dishesId) {
					this.dishesId = dishesId;
				}

				public int getMenusItemId() {
					return menusItemId;
				}

				public void setMenusItemId(int menusItemId) {
					this.menusItemId = menusItemId;
				}

				public int getDishesSortId() {
					return dishesSortId;
				}

				public void setDishesSortId(int dishesSortId) {
					this.dishesSortId = dishesSortId;
				}

				public int getItemStatus() {
					return itemStatus;
				}

				public void setItemStatus(int itemStatus) {
					this.itemStatus = itemStatus;
				}

				public int getOrderItemId() {
					return orderItemId;
				}

				public void setOrderItemId(int orderItemId) {
					this.orderItemId = orderItemId;
				}

				public BigDecimal getMoney() {
					return money;
				}

				public void setMoney(BigDecimal money) {
					this.money = money;
				}

			}

			public static class ServiceChargesBean {
				/**
				 * orderChargeId : 908 orderId : 1989 quantity : 2 chargeName :
				 * 湿巾 price : 1 chargeType : 1 money : 2
				 */

				private int orderChargeId;
				private int orderId;
				private int quantity;
				private String chargeName;
				private BigDecimal price;
				private int chargeType;
				private BigDecimal money;

				public int getOrderChargeId() {
					return orderChargeId;
				}

				public void setOrderChargeId(int orderChargeId) {
					this.orderChargeId = orderChargeId;
				}

				public int getOrderId() {
					return orderId;
				}

				public void setOrderId(int orderId) {
					this.orderId = orderId;
				}

				public int getQuantity() {
					return quantity;
				}

				public void setQuantity(int quantity) {
					this.quantity = quantity;
				}

				public String getChargeName() {
					return chargeName;
				}

				public void setChargeName(String chargeName) {
					this.chargeName = chargeName;
				}

				public int getChargeType() {
					return chargeType;
				}

				public void setChargeType(int chargeType) {
					this.chargeType = chargeType;
				}

				public BigDecimal getPrice() {
					return price;
				}

				public void setPrice(BigDecimal price) {
					this.price = price;
				}

				public BigDecimal getMoney() {
					return money;
				}

				public void setMoney(BigDecimal money) {
					this.money = money;
				}

			}
		}
	}
}
