package company.model.entity;

import company.model.dao.DaoFactory;
import company.model.dao.NoteBookDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 04.10.2017.
 */
public class NoteBook {
    private String firstName;
    private String loginData;

    DaoFactory factory;
    NoteBookDao dao;

    public NoteBook() {
        factory = DaoFactory.getInstance();
        dao = factory.createNoteBookDaoDao();
        System.out.println("true");
    }

    public NoteBook(String firstName, String loginData)
                            throws NotUniqueLoginException{

        factory = DaoFactory.getInstance();
        dao = factory.createNoteBookDaoDao();
        System.out.println("true");

        List<NoteBook> list = dao.findAll();
        for(NoteBook nb : list){
            if (nb.getLoginData().equals(loginData))
            throw new NotUniqueLoginException("Not Unique Login",
                    loginData);
        }

        this.firstName = firstName;
        this.loginData = loginData;

        dao.create(this);
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLoginData() {
        return loginData;
    }
    public void setLoginData(String loginData) {
        this.loginData = loginData;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "firstName='" + firstName + '\'' +
                ", loginData='" + loginData + '\'' +
                '}';
    }
}
