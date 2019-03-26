package company.model.dao;
import company.model.entity.NoteBook;

import java.util.List;

public interface NoteBookDao extends AutoCloseable {
    void create(NoteBook entity);
    NoteBook findById(int id);
    List<NoteBook> findAll();
    void update(NoteBook entity);
    void delete(int id);
}
