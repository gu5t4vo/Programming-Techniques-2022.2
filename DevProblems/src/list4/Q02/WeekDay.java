package list4.Q02;

public enum WeekDay {
    SUNDAY      ("Sunday", 0),
    MONDAY      ("Monday", 0.4f),
    TUESDAY     ("Tuesday", 0.4f),
    WEDNESDAY   ("Wednesday", 0),
    THURSDAY    ("Thursday", 0.4f),
    FRIDAY      ("Friday", 0),
    SATURDAY    ("Saturday", 0);


    private final String    weekDay;
    private final float     discount;

    WeekDay(String dayName, float discount){
        this.discount = discount;
        weekDay = dayName;
    }

    public float getDiscount() {
        return discount;
    }

    public String getWeekDay() {
        return weekDay;
    }


}
