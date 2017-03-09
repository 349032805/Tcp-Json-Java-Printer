package Demo;

import java.math.BigDecimal;
import java.util.List;

/*
 * 小票(退菜加菜)Bean
 */
public class AddOrDelDishBean {

	/**
	 * code : 200 model :
	 * [{"deviceId":"41","printIp":"192.168.132.118","printPort":"8000","typeId":"1","status":"1","deviceName":"POS-80Series","isIncision":2,"printNumber":1,"isShowMoney":0,"dishesSortId":"27","orderItemId":"107587","itemName":"可乐鸡翅","width":80,"number":2,"propertyName":"","money":48,"itemStatus":2,"orderDetailDTO":{"orderItemList":[{"orderItemId":107587,"itemName":"可乐鸡翅","number":2,"money":48,"itemStatus":2,"dishesSortId":27,"propertyName":""}],"orderId":12760,"orderNo":"17010600000008","tableName":"大厅1号桌","tableId":"50","addtime":"2017-01-06
	 * 09:55:41","status":3,"storeId":"120","storeName":"英国皇家打卤面","channel":"2","userName":"比卡丘","headUrl":"http://wx.qlogo.cn/mmopen/FEPj5hicyBprorAdY6k7wC2audgzGA0FhLWA73DP4Rt4icnvlhXnpay105LPZ2TvyFyxrEtesOABWzlUZ2bjsibTXJLKDDBKMKx/0","userId":"60","orderType":1,"payType":0,"totelprice":408,"configUserId":"142","phone":"15618929263","configTime":"2017-01-06
	 * 10:07:14","isRead":0,"isInvoice":0,"invoiceType":0,"invoiceHeader":"","totalWeight":6,"attribute":"0100","peopleNumber":"2","remark":"","email":"","configUserName":"超","drinkType":0,"parentId":0,"activityType":0,"paidMoney":0,"noDiscountMoney":0,"paidDiscountMoney":0,"orderDiscount":1}},{"deviceId":"41","printIp":"192.168.132.118","printPort":"8000","typeId":"1","status":"1","deviceName":"POS-80Series","isIncision":2,"printNumber":1,"isShowMoney":0,"dishesSortId":"27","orderItemId":"107588","itemName":"油焖大虾","width":80,"number":2,"propertyName":"","money":67,"itemStatus":2,"orderDetailDTO":{"orderItemList":[{"orderItemId":107588,"itemName":"油焖大虾","number":2,"money":67,"itemStatus":2,"dishesSortId":27,"propertyName":""}],"orderId":12760,"orderNo":"17010600000008","tableName":"大厅1号桌","tableId":"50","addtime":"2017-01-06
	 * 09:55:41","status":3,"storeId":"120","storeName":"英国皇家打卤面","channel":"2","userName":"比卡丘","headUrl":"http://wx.qlogo.cn/mmopen/FEPj5hicyBprorAdY6k7wC2audgzGA0FhLWA73DP4Rt4icnvlhXnpay105LPZ2TvyFyxrEtesOABWzlUZ2bjsibTXJLKDDBKMKx/0","userId":"60","orderType":1,"payType":0,"totelprice":408,"configUserId":"142","phone":"15618929263","configTime":"2017-01-06
	 * 10:07:14","isRead":0,"isInvoice":0,"invoiceType":0,"invoiceHeader":"","totalWeight":6,"attribute":"0100","peopleNumber":"2","remark":"","email":"","configUserName":"超","drinkType":0,"parentId":0,"activityType":0,"paidMoney":0,"noDiscountMoney":0,"paidDiscountMoney":0,"orderDiscount":1}},{"deviceId":"40","printIp":"192.168.132.118","printPort":"8000","typeId":"2","status":"1","deviceName":"POS58","isIncision":1,"printNumber":1,"isShowMoney":1,"width":58,"number":0,"orderDetailDTO":{"orderItemList":[{"orderItemId":107587,"itemName":"可乐鸡翅","number":2,"money":48,"itemStatus":2,"orderId":12760,"dishesId":68,"menusItemId":2096,"dishesSortId":27,"propertyName":""},{"orderItemId":107588,"itemName":"油焖大虾","number":2,"money":67,"itemStatus":2,"orderId":12760,"dishesId":69,"menusItemId":2097,"dishesSortId":27,"propertyName":""}],"orderId":12760,"orderNo":"17010600000008","tableName":"大厅1号桌","tableId":"50","addtime":"2017-01-06
	 * 09:55:41","status":3,"storeId":"120","storeName":"英国皇家打卤面","channel":"2","userName":"比卡丘","headUrl":"http://wx.qlogo.cn/mmopen/FEPj5hicyBprorAdY6k7wC2audgzGA0FhLWA73DP4Rt4icnvlhXnpay105LPZ2TvyFyxrEtesOABWzlUZ2bjsibTXJLKDDBKMKx/0","userId":"60","orderType":1,"payType":0,"totelprice":408,"configUserId":"142","phone":"15618929263","configTime":"2017-01-06
	 * 10:07:14","isRead":0,"isInvoice":0,"invoiceType":0,"invoiceHeader":"","totalWeight":6,"attribute":"0100","peopleNumber":"2","remark":"!@#不要辣椒","email":"","configUserName":"超","drinkType":0,"parentId":0,"activityType":0,"paidMoney":0,"noDiscountMoney":0,"paidDiscountMoney":0,"orderDiscount":1}}]
	 * printType : 2 currentTime : 2017-01-06 10:14:23
	 */

	private String code;
	private int printType;
	private String currentTime;
	private List<ModelBean> model;

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
		 * deviceId : 41 printIp : 192.168.132.118 printPort : 8000 typeId : 1
		 * status : 1 deviceName : POS-80Series isIncision : 2 printNumber : 1
		 * isShowMoney : 0 dishesSortId : 27 orderItemId : 107587 itemName :
		 * 可乐鸡翅 width : 80 number : 2 propertyName : money : 48 itemStatus : 2
		 * orderDetailDTO :
		 * {"orderItemList":[{"orderItemId":107587,"itemName":"可乐鸡翅","number":2,"money":48,"itemStatus":2,"dishesSortId":27,"propertyName":""}],"orderId":12760,"orderNo":"17010600000008","tableName":"大厅1号桌","tableId":"50","addtime":"2017-01-06
		 * 09:55:41","status":3,"storeId":"120","storeName":"英国皇家打卤面","channel":"2","userName":"比卡丘","headUrl":"http://wx.qlogo.cn/mmopen/FEPj5hicyBprorAdY6k7wC2audgzGA0FhLWA73DP4Rt4icnvlhXnpay105LPZ2TvyFyxrEtesOABWzlUZ2bjsibTXJLKDDBKMKx/0","userId":"60","orderType":1,"payType":0,"totelprice":408,"configUserId":"142","phone":"15618929263","configTime":"2017-01-06
		 * 10:07:14","isRead":0,"isInvoice":0,"invoiceType":0,"invoiceHeader":"","totalWeight":6,"attribute":"0100","peopleNumber":"2","remark":"","email":"","configUserName":"超","drinkType":0,"parentId":0,"activityType":0,"paidMoney":0,"noDiscountMoney":0,"paidDiscountMoney":0,"orderDiscount":1}
		 */

		private String deviceId;
		private String printIp;
		private String printPort;
		private String typeId;
		private String status;
		private String deviceName;
		private int isIncision;
		private int printNumber;
		private int isShowMoney;
		private String dishesSortId;
		private String orderItemId;
		private String itemName;
		private int width;
		private int number;
		private String propertyName;
		private int money;
		private int itemStatus;
		private OrderDetailDTOBean orderDetailDTO;

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

		public String getPrintPort() {
			return printPort;
		}

		public void setPrintPort(String printPort) {
			this.printPort = printPort;
		}

		public String getTypeId() {
			return typeId;
		}

		public void setTypeId(String typeId) {
			this.typeId = typeId;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getDeviceName() {
			return deviceName;
		}

		public void setDeviceName(String deviceName) {
			this.deviceName = deviceName;
		}

		public int getIsIncision() {
			return isIncision;
		}

		public void setIsIncision(int isIncision) {
			this.isIncision = isIncision;
		}

		public int getPrintNumber() {
			return printNumber;
		}

		public void setPrintNumber(int printNumber) {
			this.printNumber = printNumber;
		}

		public int getIsShowMoney() {
			return isShowMoney;
		}

		public void setIsShowMoney(int isShowMoney) {
			this.isShowMoney = isShowMoney;
		}

		public String getDishesSortId() {
			return dishesSortId;
		}

		public void setDishesSortId(String dishesSortId) {
			this.dishesSortId = dishesSortId;
		}

		public String getOrderItemId() {
			return orderItemId;
		}

		public void setOrderItemId(String orderItemId) {
			this.orderItemId = orderItemId;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getPropertyName() {
			return propertyName;
		}

		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}

		public int getMoney() {
			return money;
		}

		public void setMoney(int money) {
			this.money = money;
		}

		public int getItemStatus() {
			return itemStatus;
		}

		public void setItemStatus(int itemStatus) {
			this.itemStatus = itemStatus;
		}

		public OrderDetailDTOBean getOrderDetailDTO() {
			return orderDetailDTO;
		}

		public void setOrderDetailDTO(OrderDetailDTOBean orderDetailDTO) {
			this.orderDetailDTO = orderDetailDTO;
		}

		public static class OrderDetailDTOBean {
			/**
			 * orderItemList :
			 * [{"orderItemId":107587,"itemName":"可乐鸡翅","number":2,"money":48,"itemStatus":2,"dishesSortId":27,"propertyName":""}]
			 * orderId : 12760 orderNo : 17010600000008 tableName : 大厅1号桌
			 * tableId : 50 addtime : 2017-01-06 09:55:41 status : 3 storeId :
			 * 120 storeName : 英国皇家打卤面 channel : 2 userName : 比卡丘 headUrl :
			 * http://wx.qlogo.cn/mmopen/FEPj5hicyBprorAdY6k7wC2audgzGA0FhLWA73DP4Rt4icnvlhXnpay105LPZ2TvyFyxrEtesOABWzlUZ2bjsibTXJLKDDBKMKx/0
			 * userId : 60 orderType : 1 payType : 0 totelprice : 408
			 * configUserId : 142 phone : 15618929263 configTime : 2017-01-06
			 * 10:07:14 isRead : 0 isInvoice : 0 invoiceType : 0 invoiceHeader :
			 * totalWeight : 6 attribute : 0100 peopleNumber : 2 remark : email
			 * : configUserName : 超 drinkType : 0 parentId : 0 activityType : 0
			 * paidMoney : 0 noDiscountMoney : 0 paidDiscountMoney : 0
			 * orderDiscount : 1
			 */

			private int orderId;
			private String orderNo;
			private String tableName;
			private String tableId;
			private String addtime;
			private int status;
			private String storeId;
			private String storeName;
			private String channel;
			private String userName;
			private String headUrl;
			private String userId;
			private int orderType;
			private int payType;
			private int totelprice;
			private String configUserId;
			private String phone;
			private String configTime;
			private int isRead;
			private int isInvoice;
			private int invoiceType;
			private String invoiceHeader;
			private int totalWeight;
			private String attribute;
			private String peopleNumber;
			private String remark;
			private String email;
			private String configUserName;
			private int drinkType;
			private int parentId;
			private int activityType;
			private int paidMoney;
			private int noDiscountMoney;
			private int paidDiscountMoney;
			private int orderDiscount;
			private List<OrderItemListBean> orderItemList;

			public int getOrderId() {
				return orderId;
			}

			public void setOrderId(int orderId) {
				this.orderId = orderId;
			}

			public String getOrderNo() {
				return orderNo;
			}

			public void setOrderNo(String orderNo) {
				this.orderNo = orderNo;
			}

			public String getTableName() {
				return tableName;
			}

			public void setTableName(String tableName) {
				this.tableName = tableName;
			}

			public String getTableId() {
				return tableId;
			}

			public void setTableId(String tableId) {
				this.tableId = tableId;
			}

			public String getAddtime() {
				return addtime;
			}

			public void setAddtime(String addtime) {
				this.addtime = addtime;
			}

			public int getStatus() {
				return status;
			}

			public void setStatus(int status) {
				this.status = status;
			}

			public String getStoreId() {
				return storeId;
			}

			public void setStoreId(String storeId) {
				this.storeId = storeId;
			}

			public String getStoreName() {
				return storeName;
			}

			public void setStoreName(String storeName) {
				this.storeName = storeName;
			}

			public String getChannel() {
				return channel;
			}

			public void setChannel(String channel) {
				this.channel = channel;
			}

			public String getUserName() {
				return userName;
			}

			public void setUserName(String userName) {
				this.userName = userName;
			}

			public String getHeadUrl() {
				return headUrl;
			}

			public void setHeadUrl(String headUrl) {
				this.headUrl = headUrl;
			}

			public String getUserId() {
				return userId;
			}

			public void setUserId(String userId) {
				this.userId = userId;
			}

			public int getOrderType() {
				return orderType;
			}

			public void setOrderType(int orderType) {
				this.orderType = orderType;
			}

			public int getPayType() {
				return payType;
			}

			public void setPayType(int payType) {
				this.payType = payType;
			}

			public int getTotelprice() {
				return totelprice;
			}

			public void setTotelprice(int totelprice) {
				this.totelprice = totelprice;
			}

			public String getConfigUserId() {
				return configUserId;
			}

			public void setConfigUserId(String configUserId) {
				this.configUserId = configUserId;
			}

			public String getPhone() {
				return phone;
			}

			public void setPhone(String phone) {
				this.phone = phone;
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

			public int getIsInvoice() {
				return isInvoice;
			}

			public void setIsInvoice(int isInvoice) {
				this.isInvoice = isInvoice;
			}

			public int getInvoiceType() {
				return invoiceType;
			}

			public void setInvoiceType(int invoiceType) {
				this.invoiceType = invoiceType;
			}

			public String getInvoiceHeader() {
				return invoiceHeader;
			}

			public void setInvoiceHeader(String invoiceHeader) {
				this.invoiceHeader = invoiceHeader;
			}

			public int getTotalWeight() {
				return totalWeight;
			}

			public void setTotalWeight(int totalWeight) {
				this.totalWeight = totalWeight;
			}

			public String getAttribute() {
				return attribute;
			}

			public void setAttribute(String attribute) {
				this.attribute = attribute;
			}

			public String getPeopleNumber() {
				return peopleNumber;
			}

			public void setPeopleNumber(String peopleNumber) {
				this.peopleNumber = peopleNumber;
			}

			public String getRemark() {
				return remark;
			}

			public void setRemark(String remark) {
				this.remark = remark;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getConfigUserName() {
				return configUserName;
			}

			public void setConfigUserName(String configUserName) {
				this.configUserName = configUserName;
			}

			public int getDrinkType() {
				return drinkType;
			}

			public void setDrinkType(int drinkType) {
				this.drinkType = drinkType;
			}

			public int getParentId() {
				return parentId;
			}

			public void setParentId(int parentId) {
				this.parentId = parentId;
			}

			public int getActivityType() {
				return activityType;
			}

			public void setActivityType(int activityType) {
				this.activityType = activityType;
			}

			public int getPaidMoney() {
				return paidMoney;
			}

			public void setPaidMoney(int paidMoney) {
				this.paidMoney = paidMoney;
			}

			public int getNoDiscountMoney() {
				return noDiscountMoney;
			}

			public void setNoDiscountMoney(int noDiscountMoney) {
				this.noDiscountMoney = noDiscountMoney;
			}

			public int getPaidDiscountMoney() {
				return paidDiscountMoney;
			}

			public void setPaidDiscountMoney(int paidDiscountMoney) {
				this.paidDiscountMoney = paidDiscountMoney;
			}

			public int getOrderDiscount() {
				return orderDiscount;
			}

			public void setOrderDiscount(int orderDiscount) {
				this.orderDiscount = orderDiscount;
			}

			public List<OrderItemListBean> getOrderItemList() {
				return orderItemList;
			}

			public void setOrderItemList(List<OrderItemListBean> orderItemList) {
				this.orderItemList = orderItemList;
			}

			public static class OrderItemListBean {
				/**
				 * orderItemId : 107587 itemName : 可乐鸡翅 number : 2 money : 48
				 * itemStatus : 2 dishesSortId : 27 propertyName :
				 */

				private int orderItemId;
				private String itemName;
				private int number;
				private BigDecimal money;
				private int itemStatus;
				private int dishesSortId;
				private String propertyName;

				public int getOrderItemId() {
					return orderItemId;
				}

				public void setOrderItemId(int orderItemId) {
					this.orderItemId = orderItemId;
				}

				public String getItemName() {
					return itemName;
				}

				public void setItemName(String itemName) {
					this.itemName = itemName;
				}

				public int getNumber() {
					return number;
				}

				public void setNumber(int number) {
					this.number = number;
				}

				public BigDecimal getMoney() {
					return money;
				}

				public void setMoney(BigDecimal money) {
					this.money = money;
				}

				public int getItemStatus() {
					return itemStatus;
				}

				public void setItemStatus(int itemStatus) {
					this.itemStatus = itemStatus;
				}

				public int getDishesSortId() {
					return dishesSortId;
				}

				public void setDishesSortId(int dishesSortId) {
					this.dishesSortId = dishesSortId;
				}

				public String getPropertyName() {
					return propertyName;
				}

				public void setPropertyName(String propertyName) {
					this.propertyName = propertyName;
				}
			}
		}
	}
}
