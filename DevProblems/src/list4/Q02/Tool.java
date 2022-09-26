package list4.Q02;

public class Tool {

    private float price;

    public Tool(float price){
        this.price = price;
    }

    public float getPrice(WeekDay weekDay) {
        return price - (price * weekDay.getDiscount());
    }

    public float getPrice() {
        return price;
    }
}
