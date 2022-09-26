package list4.Q02;

public class ToolRent {
    public static String table(String[] dataTable){
        String table = "";

        for (String data: dataTable) {
            table = table.concat(String.format("%-15s",data));
        }

        return table;
    }

    public static String[] toStringArray(WeekDay[] weekDay){
        String[] weekDays = new String[weekDay.length];
        for (int i = 0; i < weekDays.length; i++) {
            weekDays[i] = weekDay[i].getWeekDay();
        }

        return weekDays;
    }

    public static void main(String[] args) {

        Tool oldTool = new Tool(20f);
        Tool newTool = new Tool(oldTool.getPrice() * 1.15f);



        System.out.println("=============================================================");
        System.out.println("=-=-=-=-=-=-=- WELCOME TO MR. LONDON TOOL RENT -=-=-=-=-=-=-=");
        System.out.println("=============================================================");

        System.out.println("Search at the table below for more information about the tool rent price");

        WeekDay[] weekDays = {
                WeekDay.SUNDAY,     WeekDay.MONDAY,     WeekDay.TUESDAY,
                WeekDay.WEDNESDAY,  WeekDay.THURSDAY,   WeekDay.FRIDAY,
                WeekDay.SATURDAY
        };
        String[] prices = new String[weekDays.length];



        System.out.printf   ("\nDefault price per day: R$%.2f\n", newTool.getPrice());
        System.out.println  ();

        System.out.print("Week days\t");
        System.out.println(table(toStringArray(weekDays)));

        System.out.print("New tools\t");
        for (int i = 0; i < prices.length; i++) {
            prices[i] = String.format("R$%.2f", newTool.getPrice(weekDays[i]));
        }
        System.out.println(table(prices));


        System.out.print("Old tools\t");
        for (int i = 0; i < prices.length; i++) {
            prices[i] = String.format("R$%.2f", oldTool.getPrice(weekDays[i]));
        }
        System.out.println(table(prices));

    }
}
