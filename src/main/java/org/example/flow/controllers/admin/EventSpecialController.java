package org.example.flow.controllers.admin;

import org.example.flow.models.EventSpecial;
import org.example.flow.services.EventSpecialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("admin-manager/event")
public class EventSpecialController {
    private final EventSpecialService eventSpecialService;
    public EventSpecialController(EventSpecialService eventSpecialService) {
        this.eventSpecialService = eventSpecialService;
    }
    @GetMapping
    public String editEventSpecial(Model model) {
        EventSpecial eventSpecial = eventSpecialService.get("1");
        model.addAttribute("eventSpecial", eventSpecial);
        return "admin/event-special";

    }

    @PostMapping("update")
    public String saveEventSpecial(@ModelAttribute("eventSpecial") EventSpecial eventSpecial, RedirectAttributes redirectAttributes) {
        try{
        eventSpecialService.update(eventSpecial);
        redirectAttributes.addFlashAttribute("editSuccess", true);
    }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("editError", true);
        }
        return "redirect:/admin-manager/event";
    }
}
