package business;

import java.sql.Time;

public enum ScheduleEnum {
    _7h(Time.valueOf("07:00:00")), _8h(Time.valueOf("08:00:00")),
    _9h(Time.valueOf("09:00:00")), _10h(Time.valueOf("10:00:00")),
    _11h(Time.valueOf("11:00:00")), _12h(Time.valueOf("12:00:00")),
    _13h(Time.valueOf("13:00:00")), _14h(Time.valueOf("14:00:00")),
    _15h(Time.valueOf("15:00:00")), _16h(Time.valueOf("16:00:00")),
    _17h(Time.valueOf("17:00:00")), _18h(Time.valueOf("18:00:00"));

    final Time time;


    ScheduleEnum(Time time) {

        this.time = time;

    }

    public Time getTime() {
        return time;
    }

}
