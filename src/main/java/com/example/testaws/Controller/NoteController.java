package com.example.testaws.Controller;

import com.example.testaws.NoteEntity;
import com.example.testaws.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    @GetMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("lstNote", noteRepository.findAll());
        model.addAttribute("dto",new NoteEntity());
        return "index";
    }

    @PostMapping(value = "/createOrUpdate")
    public String index(Model model, NoteEntity noteEntity){
        NoteEntity noteEntity1 = null;
        if(noteEntity.getId() != null){
            noteEntity1 = noteRepository.findById(noteEntity.getId()).get();
        }
        if(noteEntity1 == null)
            noteEntity1 = new NoteEntity();
        noteEntity1.setContent(noteEntity.getContent());
        noteEntity1.setTitle(noteEntity.getTitle());
        noteRepository.save(noteEntity1);
        return "redirect:/index";
    }

    @GetMapping(value = "/getNote/{id}")
    public String getNote(Model model, @PathVariable("id")Long id){
        model.addAttribute("entity",noteRepository.findById(id).get());
        return "detail";
    }


    @GetMapping(value = "/delete/{id}")
    public String deletez(Model model, @PathVariable("id")Long id){
        NoteEntity noteEntity1 = null;
        if(id != null){
            noteEntity1 = noteRepository.findById(id).get();
        }
        if(noteEntity1 != null)
            noteRepository.delete(noteEntity1);
        return "redirect:/index";
    }


}
