package business;

import data_percistence.CommitmentDAO;
import data_percistence.ConnectionDB;

import java.sql.*;

public class Commitment implements CommitmentDAO {
    private Date date;
    private Time time;
    public String toDo;

    protected int id;

    public Commitment(Date date, Time time, String toDo) {
        this.date = date;
        this.time = time;
        this.toDo = toDo;

    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getToDo() {
        return toDo;
    }


    @Override
    public void update(Commitment commitment) {
        try {
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement up = connection.prepareStatement
                    ("update commitment set date=?, time=?, commitmentToDo=? where id=?");

            up.setDate(1, commitment.date);
            up.setTime(2, commitment.time);
            up.setString(3, commitment.toDo);
            up.setInt(4, id);

            up.executeUpdate();

            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void insert() {
        try {
            Connection connection = new ConnectionDB().getConnection();

            PreparedStatement insert = connection.prepareStatement
                    ("insert into commitment (date, time, commitmentToDo) values (?, ?, ?)");
            insert.setDate(1, date);
            insert.setTime(2, time);
            insert.setString(3, toDo);
            insert.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String dateToString(){
        String[] date = this.date.toString().split("-");

        String year     = date[0];
        String month    = date[1];
        String day      = date[2];

        return String.format("%s/%s/%s", day, month, year);
    }

    public String timeToString(){
        String[] time = this.time.toString().split(":");

        String hour = time[0];
        String minute = time[1];

        return String.format("%s:%s", hour, minute);
    }
}
