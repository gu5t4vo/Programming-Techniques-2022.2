package data_percistence;


import business.Commitment;

/*DAO Data Access Object*/
public interface CommitmentDAO {
    void update(Commitment commitment);
    void insert();


}
