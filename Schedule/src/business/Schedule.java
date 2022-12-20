package business;

import data_percistence.CommitmentToFile;
import data_percistence.ConnectionDB;
import data_percistence.FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Objects;

public class Schedule implements CommitmentToFile {

    public static ArrayList<Commitment> list(){

        ArrayList<Commitment> commitments = new ArrayList<>();

        try {
            Connection connection = new ConnectionDB().getConnection();
            ResultSet resultSet = connection.prepareStatement("select * from commitment").executeQuery();

            Commitment commitment;

            while (resultSet.next()){
                commitment = new Commitment(
                        resultSet.getDate("date"),
                        resultSet.getTime("time"),
                        resultSet.getString("commitmentToDo")
                );

                commitment.id = resultSet.getInt("id");

                commitments.add(commitment);
            }
            return commitments;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Commitment> listByDate(){
        ArrayList<Commitment> commitmentsByDate = new ArrayList<>();
        if (Objects.requireNonNull(list()).size() != 0) {

            Date date = Objects.requireNonNull(list()).get(0).getDate();
            boolean repeat = false;

            for (Commitment commitment : Objects.requireNonNull(list())) {
                if (commitment.getDate().equals(date) && !repeat) {
                    commitmentsByDate.add(commitment);
                    repeat = true;
                } else if (!commitment.getDate().equals(date)) {
                    date = commitment.getDate();
                    repeat = false;
                }
            }
        }

        return commitmentsByDate;
    }

    public Commitment selectCommitmentByDate(Date date) {
        Commitment commitment = null;

        try {
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement result = connection.prepareStatement("SELECT * FROM commitment WHERE date =?");

            result.setDate(1, date);
            ResultSet ans = result.executeQuery();

            while (ans.next()){

                commitment = new Commitment(
                        ans.getDate("date"),
                        ans.getTime("time"),
                        ans.getString("commitmentToDo")
                );

            }
            connection.close();

        } catch (SQLException exception){

            exception.printStackTrace();

        }

        return commitment;
    }

    @Override
    public void saveSchedule(Date date) {
        ArrayList<Commitment> commitments = list();
        ArrayList<Commitment> sameDateCommitments = new ArrayList<>();

        for (Commitment commitment: Objects.requireNonNull(commitments)) {
            if (commitment.getDate().equals(date)){

                sameDateCommitments.add(commitment);

            }
        }
        File file = new File("src/program_files/schedule_" + date.toString() + ".txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            System.out.println("file error!");
        }

        String aux = date + ";";

        for (Commitment commitment: sameDateCommitments) {
            String time = commitment.getTime().toString();
            String toDo = commitment.getToDo();

            aux = aux.concat(time + ";" + toDo + ";");
        }

        FileManager.write(aux, file);
    }

    @Override
    public ArrayList<String> getSchedule(File commitmentFile) {
        try {
            FileReader fileReader = new FileReader(commitmentFile.getCanonicalPath());

            return FileManager.read(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
