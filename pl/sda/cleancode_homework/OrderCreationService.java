package pl.sda.cleancode_homework;

import static java.lang.String.format;

public final class OrderCreationService
{
    private Customer customer;
    private Order order;

    public void makeOrder(UUID customerId, List<OrderItems> orderItems, String coupon){
        try{
            if ( ! Customer.customerExists( customerId )) {
                throw new IllegalArgumentException(format("Invalid customer Id", customerId));
            }
            Order order = new Order( customerId );
            OrderItem orderItem = new OrderItem( 'Test product', 22.50, 3, 2 );
            order.addItems( orderItem );
            Order.save( order );
            EmailSenter.sendEmail();
        } catch (Exception ex){

        }
    }

}
