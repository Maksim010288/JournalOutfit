package voe.company.OutfitsCompletedOfLog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import voe.company.OutfitsCompletedOfLog.CheckOut;
import voe.company.OutfitsCompletedOfLog.entity.JournalEntity;
import voe.company.OutfitsCompletedOfLog.service.MagazineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    private MagazineService journalService;

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(defaultValue = "0") String id) {
        Optional<JournalEntity> journalEntity = journalService.findById(Long.parseLong(id));
        ArrayList<JournalEntity> journalEntities = new ArrayList<>();
        journalEntity.ifPresent(journalEntities::add);
        model.addAttribute("journal", journalEntities);
        return "update";
    }

    @PostMapping(value = "/edit")
    private String updateEntry(@RequestParam(defaultValue = "0") Long id,
                               @RequestParam Integer numberName,
                               @RequestParam String date,
                               @RequestParam String type_etc,
                               @RequestParam Integer number_etc,
                               @RequestParam String description,
                               @RequestParam String performer,
                               Model model) {
        JournalEntity entityById = journalService.findById(id).orElseThrow();
        entityById.setNumberOutfit(numberName);
        entityById.setDate(date);
        entityById.setTypeEac(type_etc);
        entityById.setDispatcherNameEts(number_etc);
        entityById.setJobDescription(description);
        entityById.setPerformer(performer);
        journalService.save(entityById);
        return "redirect:/journal/get";
    }

    @GetMapping("/deleteId")
    private String deleteById(@RequestParam(defaultValue = "0") String id_del) {
        journalService.deleteJournalById(Long.parseLong(id_del));
        return "journal";
    }

    @GetMapping("/deleteAll")
    private ResponseEntity<String> deleteAll() {
        journalService.deleteAll();
        return ResponseEntity.ok().body("delete all with database");
    }

    @GetMapping("/get")
    private String journal(Model model) {
        List<JournalEntity> entities = journalService.findAll();
        model.addAttribute("entity", entities);
        return "journal";
    }

    @PostMapping("/get")
    private String addNewJorn(@RequestParam Integer numberName,
                              @RequestParam String date,
                              @RequestParam String type_etc,
                              @RequestParam Integer number_etc,
                              @RequestParam String description,
                              @RequestParam String performer,
                              Model model) {
        Exception checkOut = new CheckOut().check(numberName, date, type_etc, number_etc, description, performer);
        JournalEntity entity = new JournalEntity(
                numberName, date, type_etc,
                number_etc, description, performer);
        model.addAttribute("check", checkOut);
        journalService.addNewEntry(entity);
        return "journal";
    }

    @GetMapping("/get/by")
    public String dataSearchBy(@RequestParam(defaultValue = "0") String etc, Model model) {
        model.addAttribute("list", journalService.findBy(etc));
        return "formSearch";
    }

    @GetMapping("/homepage")
    public String homePage() {
        return "homepage";
    }

    @GetMapping("/delete")
    public String delete() {
        return "delete";
    }
}
