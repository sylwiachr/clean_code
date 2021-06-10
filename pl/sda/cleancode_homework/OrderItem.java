package pl.sda.cleancode_homework;

public final class OrderItem
{
    private UUID id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private Float weight;

    public BigDecimal getPrice( )
    {
        return price;
    }

    public int getQuantity( )
    {
        return quantity;
    }

    public Float getWeight( )
    {
        return weight;
    }

    public OrderItem( String name, BigDecimal price, int quantity, Float weight )
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }
}
