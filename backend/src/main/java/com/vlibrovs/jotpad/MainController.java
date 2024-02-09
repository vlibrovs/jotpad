package com.vlibrovs.jotpad;

import com.vlibrovs.jotpad.data.model.Note;
import com.vlibrovs.jotpad.data.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
//@RequestMapping(path="/note")
public class MainController {
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping(path = "/note")
    public @ResponseBody Optional<Note> getNote(@RequestParam int id) {
        return noteRepository.findById(id);
    }

    @GetMapping(path = "/notes")
    public @ResponseBody Iterable<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping(path = "/note")
    public @ResponseBody String createNote(@RequestParam int authorId, @RequestParam String title, @RequestParam String content) {
        Note note = new Note();
        note.setAuthorId(authorId);
        note.setContent(content);
        note.setTitle(title);
        noteRepository.save(note);
        return "Saved";
    }
}
