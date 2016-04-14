/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.dao;

import java.sql.SQLException;
import java.sql.Statement;
import uk.ac.brookes.mscprojectadmin.beans.Criteria;

/**
 *
 * @author Quentin
 */
public class CriteriaDAO extends ClassDAO {

    /**
     *
     */
    public CriteriaDAO() {
        super();
    }

    // add a new approval and return id 

    /**
     *
     * @param criteria
     * @return
     * @throws SQLException
     */
    public int addCriteria(Criteria criteria) throws SQLException {
        int criteriaId = 0;
        //String query = "INSERT INTO criteria(criteriaDescription, marks, comments, agreedComments) VALUES (?,?,?,?)";
        String query = "INSERT INTO criteria(marks, comments) VALUES (?,?)";
        //System.out.println("add approval query: " + query);
        try {
            // prepared statement to avoid SQL injection
            preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            //preparedStatement.setString(1, criteria.getDescription());
            preparedStatement.setString(1, criteria.getMarks());
            preparedStatement.setString(2, criteria.getComments());
            //preparedStatement.setString(4, criteria.getAgreedComments());

            // execute insert
            preparedStatement.executeUpdate();
            rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                // return generated key
                criteriaId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }
        System.out.println("Returned criteriaId ID: " + criteriaId);
        return criteriaId;
    }

}
