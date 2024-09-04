package com.angelblackblue.connextion.apirest.connextion_api_rest.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angelblackblue.connextion.apirest.connextion_api_rest.Entities.Agenda;
import com.angelblackblue.connextion.apirest.connextion_api_rest.Repositories.AgendaRepository;

@RestController
@RequestMapping("/api/contacts")
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;

    @PostMapping
    public Agenda createContact(@RequestBody Agenda contact) {
        return agendaRepository.save(contact);
    }

    @GetMapping
    public List<Agenda> getAllContacts() {
        return agendaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Agenda getContact(@PathVariable UUID id) {
        return getContactById(id);
    }

    @PutMapping("/{id}")
    public Agenda updateContact(@PathVariable UUID id, @RequestBody Agenda updatedContact) {
        
        Agenda contact = getContactById(id);
        
        contact.setFullName(updatedContact.getFullName());
        contact.setAddress(updatedContact.getAddress());
        contact.setEmail(updatedContact.getEmail());
        contact.setPhone(updatedContact.getPhone());
        contact.setMobile(updatedContact.getMobile());
        contact.setBirthDate(updatedContact.getBirthDate());
        contact.setNotes(updatedContact.getNotes());

        return agendaRepository.save(contact);        

    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable UUID id) {
        getContactById(id);
        agendaRepository.deleteById(id);
        return "Contact with id: " + id + " deleted successfully";        
    }

    private Agenda getContactById(UUID id) {
        return agendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
    }

}
