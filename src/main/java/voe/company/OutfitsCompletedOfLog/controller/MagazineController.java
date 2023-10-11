package voe.company.OutfitsCompletedOfLog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import voe.company.OutfitsCompletedOfLog.CheckOut;
import voe.company.OutfitsCompletedOfLog.entity.JournalEntity;
import voe.company.OutfitsCompletedOfLog.security.WebSecurityConfigurerInJdbc;
import voe.company.OutfitsCompletedOfLog.service.MagazineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class MagazineController {

    private final Logger logger = Logger.getLogger(MagazineController.class.getName());

    @Autowired
    private MagazineService magazineService;

    @Autowired
    private WebSecurityConfigurerInJdbc jdbc;

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("user", jdbc.provider() + "- hello");
        return "greeting";
    }

    @GetMapping("journal/edit")
    public String edit(Model model, @RequestParam(defaultValue = "0") String id) {
        Optional<JournalEntity> journalEntity = magazineService.findById(Long.parseLong(id));
        ArrayList<JournalEntity> journalEntities = new ArrayList<>();
        journalEntity.ifPresent(journalEntities::add);
        model.addAttribute("journal", journalEntities);
        logger.info(journalEntities + "update");
        return "update";
    }

    @PostMapping(value = "journal/edit")
    private String updateEntry(@RequestParam(defaultValue = "0") Long id,
                               @RequestParam Integer numberName,
                               @RequestParam String date,
                               @RequestParam String type_etc,
                               @RequestParam Integer number_etc,
                               @RequestParam String description,
                               @RequestParam String performer,
                               Model model) {
        JournalEntity entityById = magazineService.findById(id).orElseThrow();
        entityById.setNumberOutfit(numberName);
        entityById.setDate(date);
        entityById.setTypeEac(type_etc);
        entityById.setDispatcherNameEts(number_etc);
        entityById.setJobDescription(description);
        entityById.setPerformer(performer);
        magazineService.edit(entityById);
        return "redirect:/journal/get";
    }

    @GetMapping("journal/delete")
    public String delete() {
        return "delete";
    }

    @GetMapping("journal/deleteId")
    private String deleteById(@RequestParam(defaultValue = "0") String id_del) {
        magazineService.deleteById(Long.parseLong(id_del));
        logger.info(jdbc.provider() + " - delete by id");
        return "journal";
    }

    @GetMapping("journal/deleteAll")
    private ResponseEntity<String> deleteAll() {
        magazineService.deleteAll();
        logger.info(jdbc.provider() + " - delete all with database");
        return ResponseEntity.ok().body("delete all with database");
    }

    @GetMapping("journal/get")
    private String journal(Model model) {
        List<JournalEntity> entities = magazineService.getAll();
        model.addAttribute("entity", entities);
        return "journal";
    }

    @PostMapping("journal/get")
    private String save(@RequestParam Integer numNar,
                        @RequestParam String date,
                        @RequestParam String type,
                        @RequestParam Integer duspNumbTP,
                        @RequestParam String description,
                        @RequestParam String performer,
                        Model model) {
        JournalEntity entity = new JournalEntity(numNar, date,
                type, duspNumbTP, description, performer);
        model.addAttribute("check", new CheckOut().check(entity));
        magazineService.addEntry(entity);
        logger.info(jdbc.provider() + " - add entry");
        return "journal";
    }

    @GetMapping("journal/get/by")
    public String searchBy(@RequestParam(defaultValue = "0") String etc,
                           @RequestParam(defaultValue = "0") String etc_date,
                           @RequestParam(defaultValue = "0") String etc_name,
                           @RequestParam(defaultValue = "0") String id_del,
                           Model model) {
        model.addAttribute("list", magazineService.findBy(etc));
        model.addAttribute("list_name", magazineService.findByName(etc_name));
        model.addAttribute("list_date", magazineService.findByDate(etc_date));
        magazineService.deleteById(Long.parseLong(id_del));
        return "formSearch";
    }

    @GetMapping("journal/logout")
    public String logout() {
        return "redirect:/logout";
    }

    @GetMapping("journal/homepage")
    @PreAuthorize("hasAnyAuthorize('ADMIN', 'USER')")
    public String homePage() {
        return "homepage";
    }
}
