package com.me.controller;

import com.me.entity.Note;
import com.me.entity.Result;
import com.me.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class NoteController {

    @Autowired
    private NoteService noteService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{userId}/notes", method = RequestMethod.GET)
    public Result list(@PathVariable Integer userId) {
        log.info("Get Notes by UserId");
        List<Note> noteList = noteService.showNotes(userId);
        return Result.success(noteList);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{userId}/notes/{noteId}")
    public Result deleteNote(@PathVariable Integer noteId) {
        log.info("delete note id: {}", noteId);
        noteService.deletenote(noteId);
        return Result.success();
    }

    /*
    @CrossOrigin(origins = "*")
    @PostMapping("/notes")
    public Result add(@RequestBody Note note) {
        log.info("add a new note", note);
        noteService.addNote(note);
        return Result.success();
    }
    */

    @CrossOrigin(origins = "*")
    @PostMapping("/{userId}/notes")
    public Result addNote(@PathVariable Integer userId) {
        log.info("{} adds a new note", userId);
        noteService.addNote(userId);
        return Result.success();
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{userId}/notes")
    public Result updateNote(@RequestBody Note note) {
        log.info("Updates the note {}", note);
        noteService.updateNote(note);
        return Result.success();
    }

}
