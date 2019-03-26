package company.model.dao;
import company.model.entity.NoteBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCNoteBookDao implements NoteBookDao {
    private Connection connection;

    public JDBCNoteBookDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(NoteBook entity) {
        try (Statement ps = connection.createStatement()){
            PreparedStatement prs = connection.prepareStatement("INSERT INTO notebook(name, login) VALUES(?,?)");
            prs.setString(1,entity.getFirstName());
            prs.setString(2,entity.getLoginData());
            prs.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NoteBook findById(int id) {
        return null;
    }

    private NoteBook extractFromResultSet(ResultSet rs) throws SQLException {
        NoteBook result = new NoteBook();

        result.setFirstName(rs.getString("name"));
        result.setLoginData(rs.getString("login"));

        return result;
    }

    @Override
    public List<NoteBook> findAll() {
        List<NoteBook> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(
                    "select * from notebook ");
            while ( rs.next() ){
                NoteBook result = extractFromResultSet(rs);

                resultList.add(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void update(NoteBook entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}
