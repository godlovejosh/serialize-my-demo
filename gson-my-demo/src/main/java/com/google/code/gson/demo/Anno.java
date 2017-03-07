package com.google.code.gson.demo;

import com.google.gson.annotations.SerializedName;

/**
 * @author wuxing
 */
public class Anno {

    private Long id;
    @SerializedName("order_no")
    private String orderNo;
    @SerializedName(value = "waybillNo", alternate = {"waybill_no", "way_bill_no"})
    private String waybillNo;
//    @SerializedName(name = "order_sub_type")
//    private String orderSubType;
//    @SerializedName(name = "product_id")
//    private String productId;
//    @SerializedName(name = "product_type")
//    private String productType;
//    @SerializedName(name = "business_type")
//    private String businessType;
//    @SerializedName(name = "source_bill_no_id")
//    private String sourceBillNoId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }
}
