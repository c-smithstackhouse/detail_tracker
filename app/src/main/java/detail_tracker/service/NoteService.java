package detail_tracker.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

import detail_tracker.entities.Note;

public class NoteService {

    @PersistenceContext
    private EntityManager entityManager;

    public Note createNote(int userId, String content, Date createdOn, Date updatedOn) {
        Note note = new Note();
        note.setUserId(userId);
        note.setContent(content);
        note.setCreatedOn(createdOn);
        note.setUpdatedOn(updatedOn);

        entityManager.persist(note);

        return note;
    }

    public Note getNote(int noteId) {
        return entityManager.find(Note.class, noteId);
    }

    public Note updateNote(int noteId, int userId, String content, Date createdOn, Date updatedOn) {
        Note note = entityManager.find(Note.class, noteId);
        if (note != null) {
            note.setUserId(userId);
            note.setContent(content);
            note.setCreatedOn(createdOn);
            note.setUpdatedOn(updatedOn);
        }

        return note;
    }

    public void deleteNote(int noteId) {
        Note note = entityManager.find(Note.class, noteId);
        if (note != null) {
            entityManager.remove(note);
        }
    }

    public List<Note> getAllNotes() {
        TypedQuery<Note> query = entityManager.createQuery("SELECT n FROM Note n", Note.class);
        return query.getResultList();
    }

    public List<Note> getNotesByUserId(int userId) {
        TypedQuery<Note> query = entityManager.createQuery("SELECT n FROM Note n WHERE n.userId = :userId", Note.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<Note> getNotesByContent(String content) {
        TypedQuery<Note> query = entityManager.createQuery("SELECT n FROM Note n WHERE n.content LIKE :content", Note.class);
        query.setParameter("content", "%" + content + "%");
        return query.getResultList();
    }
}