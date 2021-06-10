package pl.sda.cleancode_homework;

import java.math.BigDecimal;

public final class Order
{
    public enum OrderStatus {WAITING, SENT, DELIVERED}

    private UUID id;
    private UUID customerId;
    private LocalDateTime ctime;
    private float discount;
    private List<OrderItem> orderItems;
    private OrderStatus status;
    private DiscountCoupons discountCoupons;
    private BigDecimal deliveryCost = BigDecimal.ZERO;
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private BigDecimal totalWeight = BigDecimal.ZERO;

    public Order( UUID customerId, String couponCode )
    {
        this.customerId = customerId;
        this.status = OrderStatus.WAITING;
        calculateDiscount( couponCode );
        calculateDeliveryCost( );
    }


    public void addItems (OrderItem orderItem){
        if(orderItems == null){
            orderItems = new ArrayList<>();
        }
        orderItems.add(orderItem);
        this.totalPrice += orderItem.getPrice().multiply(new BigDecimal(orderItem.getQuantity()));
        this.totalWeight += orderItem.getWeight();
    }

    public void calculateDiscount(String couponCode){
        var discount = DiscountCoupons.findDiscountByCouponCode(couponCode);
        if (!discount.isUsed()){
            this.totalPrice -= this.totalPrice * discount.getValue();
            discount.setUsedBy(this.customerId);
            discount.setUsed();
            DiscountCoupons.save(discount);
        }

    }

    public void calculateDeliveryCost(){
        if( this.totalPrice.compareTo(new BigDecimal(250)) > 0 && this.totalWeight < 1 ){
            this.deliveryCost = BigDecimal.ZERO;
        } else if ( this.totalWeight < 1 ){
            this.deliveryCost = new BigDecimal(15);
        } else if ( this.totalWeight < 5 ){
            this.deliveryCost = new BigDecimal(35);
        } else {
            this.deliveryCost = new BigDecimal(50);
        }
    }



    public void sentOrder(){
        this.status = OrderStatus.SENT;
    }
    public void deliverOrder(){
        this.status = OrderStatus.DELIVERED;
    }

}
