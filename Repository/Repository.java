package Repository;

import Model.Domain;
import Model.Person;
import Model.Users;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kateromanova
 */
public class Repository {
    
    
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";
    
    public Set<Users> findUser() {
        Set<Users> users = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                Users user = new Users(id, name, password);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    
    public Set<Person> getAllPersonWithDomain(){
        Set<Person> persons = new HashSet<>();
        try(Connection conn = (Connection) DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
            Statement stm = conn.createStatement()){
            try(ResultSet rs = stm.executeQuery("SELECT * FROM PERSON LEFT JOIN DOMAINS ON PERSON.ID = DOMAINS.PERSONID");){
            while(rs.next()){
                
                
                Integer personid = rs.getInt(1);
                Person person = persons.stream()
                        .filter(per -> per.getId() == personid).findFirst().orElse(null);
                if(person == null){
                String jobTitle = rs.getString(2);
                String firstNameLastName = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
               
                person = new Person(personid, jobTitle, firstNameLastName, phone, email);
                persons.add(person);
                }
                
                int domainid = rs.getInt(6);
                String webName = rs.getString(7);
                String domainName = rs.getString(8);
                if(domainName != null){
                    String ip =rs.getString(9);
                    Date dateReg = rs.getDate(10);
                    String countryReg = rs.getString(11);
                    int personId =  rs.getInt(12);
                    Domain domain = new Domain(domainid, webName, domainName, ip, dateReg, countryReg, personId);
                
                    person.addDomain(domain);
                    domain.setPerson(person);
                }
            }
            }
        } catch(SQLException e){}
        return persons;
    }
    
    
    
    /*public List <Person> getAllPerson() {
        List<Person> persons = new ArrayList<>();
        try(Connection conn = (Connection) DriverManager.getConnection(url, user, psw);
            Statement stm = conn.createStatement()){
            try(ResultSet rs = stm.executeQuery("SELECT ID, JOBTITLE, FIRSTNAMELASTNAME, PHONE, EMAIL FROM PERSON")){
            while(rs.next()){
                int id = rs.getInt(1);
                String jobTitle = rs.getString(2);
                String firstNameLastName = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                persons.add(new Person(id, jobTitle, firstNameLastName, phone, email));
                }
            }
        } catch(SQLException e){}
        return persons;
    }*/
    
    
    
    public Set <Domain> getAllDomain(int personid) {
        Set<Domain> domains = new HashSet<>();
        try(Connection conn = (Connection) DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
            Statement stm = conn.createStatement()){
            try(ResultSet rs = stm.executeQuery("SELECT * FROM DOMAINS WHERE PERSONID= " + personid);){
            
            
            while(rs.next()){
                int id = rs.getInt(1);
                String webName = rs.getString(2);
                String domainName = rs.getString(3);
                String ip =rs.getString(4);
                Date dateReg = rs.getDate(5);
                String countryReg = rs.getString(6);
                int personId =  rs.getInt(7);
                Domain domain = new Domain(id, webName, domainName, ip, dateReg, countryReg, personId);
                domains.add(domain);
                }
            }
        } catch(SQLException e){
        }
        return domains;
    }
}
