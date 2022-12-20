package data_percistence;

import business.Commitment;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

public interface CommitmentToFile {

    void saveSchedule(Date date);
    ArrayList<String> getSchedule(File CommitmentFile);

}
