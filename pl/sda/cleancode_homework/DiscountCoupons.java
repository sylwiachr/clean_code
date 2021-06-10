package pl.sda.cleancode_homework;

public final class DiscountCoupons
{
    private UUID customerId;
    private String couponCode;
    private Boolean isUsed;
    private BigDecimal value;
    private UUID usedBy;

    public DiscountCoupons( UUID customerId, String couponCode, BigDecimal value )
    {
        this.customerId = customerId;
        this.couponCode = couponCode;
        this.value = value;
        this.isUsed = false;
    }

    public boolean findDiscountByCouponCode( String couponCode ){
        return true;
    }
    public boolean isUsed(){
        return this.isUsed;
    }
    public BigDecimal getValue(){
        return this.value;
    }
    public void setUsedBy( UUID customerId ){
        this.usedBy = customerId;
    }
    public void setUsed(){
        this.isUsed = true;
    }
    public void save(){
        //
    }


}
