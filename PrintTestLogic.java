package Demo;

public class PrintTestLogic {
	public static void main(String[] args) {
		
		//支付
		String payMessage = "{\"recId\":284,\"code\":\"200\",\"model\":[{\"typeId\":\"2\",\"width\":58,\"isIncision\":2,\"deviceId\":\"56\",\"printIp\":\"192.168.0.253\",\"orderDetailDTO\":{\"headUrl\":\"http://wx.qlogo.cn/mmopen/RX0XCujlbMPrXgJYKnF4MZMiajOlvZItFSclohF5Ikvmm2zQVEH52o8utPUrTyQ3DHlqTgqO0BSDeDcx6X6No4cxIbuNbRwibG/0\",\"orderId\":1989,\"addtime\":\"2017-01-13 15:15:36\",\"orderType\":1,\"invoiceType\":1,\"storeId\":\"144\",\"remark\":\"ddas,!@#撒旦法萨发\",\"payConfigTime\":\"2017-01-13 16:22:58\",\"tableName\":\"3外1\",\"payConfigUserName\":\"0021\",\"configUserName\":\"0021\",\"activityName\":\"全单2折\",\"configUserId\":\"151\",\"attribute\":\"1100\",\"paidDiscountMoney\":120,\"totelprice\":148,\"invoiceHeader\":\"\",\"orderDiscount\":20,\"payType\":2,\"tableId\":\"374\",\"orderItemList\":[{\"number\":2,\"orderId\":1989,\"propertyName\":\"自烤\",\"itemName\":\"精品牛舌\",\"dishesId\":1273,\"menusItemId\":9468,\"dishesSortId\":175,\"itemStatus\":1,\"orderItemId\":5081,\"money\":55},{\"number\":1,\"orderId\":1989,\"propertyName\":\"自烤\",\"itemName\":\"生牛排\",\"dishesId\":1282,\"menusItemId\":9477,\"dishesSortId\":175,\"itemStatus\":2,\"orderItemId\":5134,\"money\":148}],\"storeName\":\"真炉韩国料理(龙阳店)\",\"peopleNumber\":\"2\",\"noDiscountMoney\":0,\"channel\":\"2\",\"email\":\"\",\"paidMoney\":30,\"totalWeight\":1,\"activityType\":2,\"status\":4,\"configTime\":\"2017-01-13 16:22:40\",\"isRead\":1,\"serviceCharges\":[{\"orderChargeId\":908,\"orderId\":1989,\"quantity\":2,\"chargeName\":\"湿巾\",\"price\":1,\"chargeType\":1,\"money\":2}],\"orderNo\":\"17011300000104\",\"isInvoice\":0,\"userName\":\"%E6%AF%94%E5%8D%A1%E4%B8%98\",\"parentId\":0,\"phone\":\"15618929263\",\"drinkType\":0,\"userId\":\"77\"},\"deviceName\":\"XP-58\",\"number\":0,\"isShowMoney\":0,\"printPort\":\"8000\",\"printNumber\":1,\"status\":\"1\"}],\"printType\":1,\"time\":1484296343425,\"currentTime\":\"2017-01-13 16:32:23\"}";		
		TcpServer.gotoPrint(payMessage);
		
		//预点,前台和后厨
//		String confirmMesasge = "{\"currentTime\":\"2017-03-07 18:28:33\",\"qrCode\":\"\",\"printType\":0,\"model\":[{\"propertyName\":\"\",\"dishesSortId\":\"70\",\"itemName\":\"wwww\",\"isIncision\":1,\"orderItemId\":\"109508\",\"status\":\"1\",\"width\":80,\"orderDetailDTO\":{\"phone\":\"13918075139\",\"remark\":\"\",\"attribute\":\"0000\",\"configUserId\":\"105\",\"parentId\":0,\"invoiceHeader\":\"\",\"addtime\":\"2017-03-07 17:31:38\",\"tableId\":\"100\",\"tableName\":\"浦电2号\",\"isInvoice\":0,\"userId\":\"584\",\"peopleNumber\":\"2\",\"userName\":\"非常 \uE057\",\"headUrl\":\"http:\\/\\/wx.qlogo.cn\\/mmopen\\/ajNVdqHZLLBDBgcZvSvag6zK8ia0YYDbvHcCicbNAib6bXerp4BNAyH8dMgWFu7oBQeX88iaqKllM6fhYjOt2KNGfsGcNTiaGodQMdshLQ8sQetE\\/0\",\"eatNumber\":\"\",\"orderId\":13513,\"orderDiscount\":1,\"serviceCharges\":[{\"chargeName\":\"餐具费\",\"money\":2,\"quantity\":2,\"price\":1,\"chargeType\":1,\"orderChargeId\":1625,\"orderId\":13513}],\"payConfigUserName\":\"刘鑫\",\"configTime\":\"2017-03-07 17:32:15\",\"totelprice\":23.01,\"storeName\":\"小杨生煎(浦电路店)\",\"orderType\":1,\"status\":4,\"invoiceType\":0,\"drinkType\":0,\"paidDiscountMoney\":0,\"orderNo\":\"17030700000060\",\"email\":\"\",\"totalWeight\":3,\"orderItemList\":[{\"propertyName\":\"\",\"dishesSortId\":70,\"money\":0.01,\"itemStatus\":0,\"number\":1,\"itemName\":\"wwww\",\"orderItemId\":109508},{\"propertyName\":\"\",\"dishesSortId\":486,\"money\":15,\"itemStatus\":0,\"number\":1,\"itemName\":\"蓝莓沙冰\",\"orderItemId\":109509},{\"propertyName\":\"\",\"dishesSortId\":76,\"money\":8,\"itemStatus\":0,\"number\":1,\"itemName\":\"珍珠奶茶\",\"orderItemId\":109510}],\"payType\":2,\"paidMoney\":25.01,\"activityType\":0,\"activityName\":\"\",\"configUserName\":\"刘鑫\",\"channel\":\"2\",\"storeId\":\"146\",\"noDiscountMoney\":0,\"payConfigTime\":\"2017-03-07 17:33:46\",\"isRead\":1},\"itemStatus\":0,\"number\":1,\"printNumber\":1,\"isShowMoney\":0,\"printIp\":\"10.15.248.176\",\"deviceName\":\"XP-58\",\"money\":0.01,\"typeId\":\"2\",\"deviceId\":\"49\",\"printPort\":\"8888\"},{\"isShowMoney\":0,\"isIncision\":2,\"printIp\":\"10.15.248.176\",\"deviceName\":\"AiBao-A-5801\",\"status\":\"1\",\"width\":58,\"orderDetailDTO\":{\"phone\":\"13918075139\",\"remark\":\"\",\"attribute\":\"0000\",\"configUserId\":\"105\",\"parentId\":0,\"invoiceHeader\":\"\",\"addtime\":\"2017-03-07 17:31:38\",\"tableId\":\"100\",\"tableName\":\"浦电2号\",\"isInvoice\":0,\"userId\":\"584\",\"peopleNumber\":\"2\",\"userName\":\"非常 \uE057\",\"headUrl\":\"http:\\/\\/wx.qlogo.cn\\/mmopen\\/ajNVdqHZLLBDBgcZvSvag6zK8ia0YYDbvHcCicbNAib6bXerp4BNAyH8dMgWFu7oBQeX88iaqKllM6fhYjOt2KNGfsGcNTiaGodQMdshLQ8sQetE\\/0\",\"eatNumber\":\"\",\"orderId\":13513,\"orderDiscount\":1,\"serviceCharges\":[{\"chargeName\":\"餐具费\",\"money\":2,\"quantity\":2,\"price\":1,\"chargeType\":1,\"orderChargeId\":1625,\"orderId\":13513}],\"payConfigUserName\":\"刘鑫\",\"configTime\":\"2017-03-07 17:32:15\",\"totelprice\":23.01,\"storeName\":\"小杨生煎(浦电路店)\",\"orderType\":1,\"status\":4,\"invoiceType\":0,\"drinkType\":0,\"paidDiscountMoney\":0,\"orderNo\":\"17030700000060\",\"email\":\"\",\"totalWeight\":3,\"orderItemList\":[{\"propertyName\":\"\",\"dishesSortId\":70,\"dishesId\":4480,\"itemName\":\"wwww\",\"orderItemId\":109508,\"money\":0.01,\"itemStatus\":0,\"number\":1,\"menusItemId\":19614,\"orderId\":13513},{\"propertyName\":\"\",\"dishesSortId\":486,\"dishesId\":4479,\"itemName\":\"蓝莓沙冰\",\"orderItemId\":109509,\"money\":15,\"itemStatus\":0,\"number\":1,\"menusItemId\":19613,\"orderId\":13513},{\"propertyName\":\"\",\"dishesSortId\":76,\"dishesId\":123,\"itemName\":\"珍珠奶茶\",\"orderItemId\":109510,\"money\":8,\"itemStatus\":0,\"number\":1,\"menusItemId\":19598,\"orderId\":13513}],\"payType\":2,\"paidMoney\":25.01,\"activityType\":0,\"activityName\":\"\",\"configUserName\":\"刘鑫\",\"channel\":\"2\",\"storeId\":\"146\",\"noDiscountMoney\":0,\"payConfigTime\":\"2017-03-07 17:33:46\",\"isRead\":1},\"number\":0,\"printNumber\":1,\"typeId\":\"1\",\"deviceId\":\"51\",\"printPort\":\"8888\"}],\"code\":\"200\"}";
//		TcpServer.gotoPrint(confirmMesasge);
		
		//加菜
//		String addDishMesasge = "{\"currentTime\":\"2017-03-07 18:28:33\",\"qrCode\":\"\",\"printType\":2,\"model\":[{\"propertyName\":\"\",\"dishesSortId\":\"70\",\"itemName\":\"wwww\",\"isIncision\":1,\"orderItemId\":\"109508\",\"status\":\"1\",\"width\":80,\"orderDetailDTO\":{\"phone\":\"13918075139\",\"remark\":\"\",\"attribute\":\"0000\",\"configUserId\":\"105\",\"parentId\":0,\"invoiceHeader\":\"\",\"addtime\":\"2017-03-07 17:31:38\",\"tableId\":\"100\",\"tableName\":\"浦电2号\",\"isInvoice\":0,\"userId\":\"584\",\"peopleNumber\":\"2\",\"userName\":\"非常 \uE057\",\"headUrl\":\"http:\\/\\/wx.qlogo.cn\\/mmopen\\/ajNVdqHZLLBDBgcZvSvag6zK8ia0YYDbvHcCicbNAib6bXerp4BNAyH8dMgWFu7oBQeX88iaqKllM6fhYjOt2KNGfsGcNTiaGodQMdshLQ8sQetE\\/0\",\"eatNumber\":\"\",\"orderId\":13513,\"orderDiscount\":1,\"serviceCharges\":[{\"chargeName\":\"餐具费\",\"money\":2,\"quantity\":2,\"price\":1,\"chargeType\":1,\"orderChargeId\":1625,\"orderId\":13513}],\"payConfigUserName\":\"刘鑫\",\"configTime\":\"2017-03-07 17:32:15\",\"totelprice\":23.01,\"storeName\":\"小杨生煎(浦电路店)\",\"orderType\":1,\"status\":4,\"invoiceType\":0,\"drinkType\":0,\"paidDiscountMoney\":0,\"orderNo\":\"17030700000060\",\"email\":\"\",\"totalWeight\":3,\"orderItemList\":[{\"propertyName\":\"\",\"dishesSortId\":70,\"money\":0.01,\"itemStatus\":0,\"number\":1,\"itemName\":\"wwww\",\"orderItemId\":109508},{\"propertyName\":\"\",\"dishesSortId\":486,\"money\":15,\"itemStatus\":0,\"number\":1,\"itemName\":\"蓝莓沙冰\",\"orderItemId\":109509},{\"propertyName\":\"\",\"dishesSortId\":76,\"money\":8,\"itemStatus\":0,\"number\":1,\"itemName\":\"珍珠奶茶\",\"orderItemId\":109510}],\"payType\":2,\"paidMoney\":25.01,\"activityType\":0,\"activityName\":\"\",\"configUserName\":\"刘鑫\",\"channel\":\"2\",\"storeId\":\"146\",\"noDiscountMoney\":0,\"payConfigTime\":\"2017-03-07 17:33:46\",\"isRead\":1},\"itemStatus\":0,\"number\":1,\"printNumber\":1,\"isShowMoney\":0,\"printIp\":\"10.15.248.176\",\"deviceName\":\"XP-58\",\"money\":0.01,\"typeId\":\"2\",\"deviceId\":\"49\",\"printPort\":\"8888\"},{\"isShowMoney\":0,\"isIncision\":2,\"printIp\":\"10.15.248.176\",\"deviceName\":\"AiBao-A-5801\",\"status\":\"1\",\"width\":58,\"orderDetailDTO\":{\"phone\":\"13918075139\",\"remark\":\"\",\"attribute\":\"0000\",\"configUserId\":\"105\",\"parentId\":0,\"invoiceHeader\":\"\",\"addtime\":\"2017-03-07 17:31:38\",\"tableId\":\"100\",\"tableName\":\"浦电2号\",\"isInvoice\":0,\"userId\":\"584\",\"peopleNumber\":\"2\",\"userName\":\"非常 \uE057\",\"headUrl\":\"http:\\/\\/wx.qlogo.cn\\/mmopen\\/ajNVdqHZLLBDBgcZvSvag6zK8ia0YYDbvHcCicbNAib6bXerp4BNAyH8dMgWFu7oBQeX88iaqKllM6fhYjOt2KNGfsGcNTiaGodQMdshLQ8sQetE\\/0\",\"eatNumber\":\"\",\"orderId\":13513,\"orderDiscount\":1,\"serviceCharges\":[{\"chargeName\":\"餐具费\",\"money\":2,\"quantity\":2,\"price\":1,\"chargeType\":1,\"orderChargeId\":1625,\"orderId\":13513}],\"payConfigUserName\":\"刘鑫\",\"configTime\":\"2017-03-07 17:32:15\",\"totelprice\":23.01,\"storeName\":\"小杨生煎(浦电路店)\",\"orderType\":1,\"status\":4,\"invoiceType\":0,\"drinkType\":0,\"paidDiscountMoney\":0,\"orderNo\":\"17030700000060\",\"email\":\"\",\"totalWeight\":3,\"orderItemList\":[{\"propertyName\":\"\",\"dishesSortId\":70,\"dishesId\":4480,\"itemName\":\"wwww\",\"orderItemId\":109508,\"money\":0.01,\"itemStatus\":0,\"number\":1,\"menusItemId\":19614,\"orderId\":13513},{\"propertyName\":\"\",\"dishesSortId\":486,\"dishesId\":4479,\"itemName\":\"蓝莓沙冰\",\"orderItemId\":109509,\"money\":15,\"itemStatus\":0,\"number\":1,\"menusItemId\":19613,\"orderId\":13513},{\"propertyName\":\"\",\"dishesSortId\":76,\"dishesId\":123,\"itemName\":\"珍珠奶茶\",\"orderItemId\":109510,\"money\":8,\"itemStatus\":0,\"number\":1,\"menusItemId\":19598,\"orderId\":13513}],\"payType\":2,\"paidMoney\":25.01,\"activityType\":0,\"activityName\":\"\",\"configUserName\":\"刘鑫\",\"channel\":\"2\",\"storeId\":\"146\",\"noDiscountMoney\":0,\"payConfigTime\":\"2017-03-07 17:33:46\",\"isRead\":1},\"number\":0,\"printNumber\":1,\"typeId\":\"1\",\"deviceId\":\"51\",\"printPort\":\"8888\"}],\"code\":\"200\"}";
//		TcpServer.gotoPrint(addDishMesasge);
		
		//退菜
//		String deleteDishMesasge = "{\"currentTime\":\"2017-03-07 18:28:33\",\"qrCode\":\"\",\"printType\":3,\"model\":[{\"propertyName\":\"\",\"dishesSortId\":\"70\",\"itemName\":\"wwww\",\"isIncision\":1,\"orderItemId\":\"109508\",\"status\":\"1\",\"width\":80,\"orderDetailDTO\":{\"phone\":\"13918075139\",\"remark\":\"\",\"attribute\":\"0000\",\"configUserId\":\"105\",\"parentId\":0,\"invoiceHeader\":\"\",\"addtime\":\"2017-03-07 17:31:38\",\"tableId\":\"100\",\"tableName\":\"浦电2号\",\"isInvoice\":0,\"userId\":\"584\",\"peopleNumber\":\"2\",\"userName\":\"非常 \uE057\",\"headUrl\":\"http:\\/\\/wx.qlogo.cn\\/mmopen\\/ajNVdqHZLLBDBgcZvSvag6zK8ia0YYDbvHcCicbNAib6bXerp4BNAyH8dMgWFu7oBQeX88iaqKllM6fhYjOt2KNGfsGcNTiaGodQMdshLQ8sQetE\\/0\",\"eatNumber\":\"\",\"orderId\":13513,\"orderDiscount\":1,\"serviceCharges\":[{\"chargeName\":\"餐具费\",\"money\":2,\"quantity\":2,\"price\":1,\"chargeType\":1,\"orderChargeId\":1625,\"orderId\":13513}],\"payConfigUserName\":\"刘鑫\",\"configTime\":\"2017-03-07 17:32:15\",\"totelprice\":23.01,\"storeName\":\"小杨生煎(浦电路店)\",\"orderType\":1,\"status\":4,\"invoiceType\":0,\"drinkType\":0,\"paidDiscountMoney\":0,\"orderNo\":\"17030700000060\",\"email\":\"\",\"totalWeight\":3,\"orderItemList\":[{\"propertyName\":\"\",\"dishesSortId\":70,\"money\":0.01,\"itemStatus\":0,\"number\":1,\"itemName\":\"wwww\",\"orderItemId\":109508},{\"propertyName\":\"\",\"dishesSortId\":486,\"money\":15,\"itemStatus\":0,\"number\":1,\"itemName\":\"蓝莓沙冰\",\"orderItemId\":109509},{\"propertyName\":\"\",\"dishesSortId\":76,\"money\":8,\"itemStatus\":0,\"number\":1,\"itemName\":\"珍珠奶茶\",\"orderItemId\":109510}],\"payType\":2,\"paidMoney\":25.01,\"activityType\":0,\"activityName\":\"\",\"configUserName\":\"刘鑫\",\"channel\":\"2\",\"storeId\":\"146\",\"noDiscountMoney\":0,\"payConfigTime\":\"2017-03-07 17:33:46\",\"isRead\":1},\"itemStatus\":0,\"number\":1,\"printNumber\":1,\"isShowMoney\":0,\"printIp\":\"10.15.248.176\",\"deviceName\":\"XP-58\",\"money\":0.01,\"typeId\":\"2\",\"deviceId\":\"49\",\"printPort\":\"8888\"},{\"isShowMoney\":0,\"isIncision\":2,\"printIp\":\"10.15.248.176\",\"deviceName\":\"AiBao-A-5801\",\"status\":\"1\",\"width\":58,\"orderDetailDTO\":{\"phone\":\"13918075139\",\"remark\":\"\",\"attribute\":\"0000\",\"configUserId\":\"105\",\"parentId\":0,\"invoiceHeader\":\"\",\"addtime\":\"2017-03-07 17:31:38\",\"tableId\":\"100\",\"tableName\":\"浦电2号\",\"isInvoice\":0,\"userId\":\"584\",\"peopleNumber\":\"2\",\"userName\":\"非常 \uE057\",\"headUrl\":\"http:\\/\\/wx.qlogo.cn\\/mmopen\\/ajNVdqHZLLBDBgcZvSvag6zK8ia0YYDbvHcCicbNAib6bXerp4BNAyH8dMgWFu7oBQeX88iaqKllM6fhYjOt2KNGfsGcNTiaGodQMdshLQ8sQetE\\/0\",\"eatNumber\":\"\",\"orderId\":13513,\"orderDiscount\":1,\"serviceCharges\":[{\"chargeName\":\"餐具费\",\"money\":2,\"quantity\":2,\"price\":1,\"chargeType\":1,\"orderChargeId\":1625,\"orderId\":13513}],\"payConfigUserName\":\"刘鑫\",\"configTime\":\"2017-03-07 17:32:15\",\"totelprice\":23.01,\"storeName\":\"小杨生煎(浦电路店)\",\"orderType\":1,\"status\":4,\"invoiceType\":0,\"drinkType\":0,\"paidDiscountMoney\":0,\"orderNo\":\"17030700000060\",\"email\":\"\",\"totalWeight\":3,\"orderItemList\":[{\"propertyName\":\"\",\"dishesSortId\":70,\"dishesId\":4480,\"itemName\":\"wwww\",\"orderItemId\":109508,\"money\":0.01,\"itemStatus\":0,\"number\":1,\"menusItemId\":19614,\"orderId\":13513},{\"propertyName\":\"\",\"dishesSortId\":486,\"dishesId\":4479,\"itemName\":\"蓝莓沙冰\",\"orderItemId\":109509,\"money\":15,\"itemStatus\":0,\"number\":1,\"menusItemId\":19613,\"orderId\":13513},{\"propertyName\":\"\",\"dishesSortId\":76,\"dishesId\":123,\"itemName\":\"珍珠奶茶\",\"orderItemId\":109510,\"money\":8,\"itemStatus\":0,\"number\":1,\"menusItemId\":19598,\"orderId\":13513}],\"payType\":2,\"paidMoney\":25.01,\"activityType\":0,\"activityName\":\"\",\"configUserName\":\"刘鑫\",\"channel\":\"2\",\"storeId\":\"146\",\"noDiscountMoney\":0,\"payConfigTime\":\"2017-03-07 17:33:46\",\"isRead\":1},\"number\":0,\"printNumber\":1,\"typeId\":\"1\",\"deviceId\":\"51\",\"printPort\":\"8888\"}],\"code\":\"200\"}";
//		TcpServer.gotoPrint(deleteDishMesasge);
		
	}

}
