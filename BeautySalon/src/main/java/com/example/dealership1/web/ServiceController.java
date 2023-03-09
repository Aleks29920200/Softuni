package com.example.dealership1.web;

import com.example.dealership1.domain.binding.AddServiceDto;
import com.example.dealership1.domain.entity.Service;
import com.example.dealership1.repositories.ServiceRepo;
import com.example.dealership1.services.ServiceImpl;
import com.example.dealership1.services.UserServiceImpl;
import com.example.dealership1.util.LoggedUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ServiceController {
    private ServiceImpl service;
    private ServiceRepo serviceRepo;
    private ModelMapper mapper;
    private UserServiceImpl userService;
    private LoggedUser loggedUser;

    public ServiceController(ServiceImpl service, ServiceRepo serviceRepo, ModelMapper mapper, UserServiceImpl userService, LoggedUser loggedUser) {
        this.service = service;
        this.serviceRepo = serviceRepo;
        this.mapper = mapper;
        this.userService = userService;
        this.loggedUser = loggedUser;
    }
    @GetMapping("admin/add-service")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addService(){
        return "add-service";
    }
    @PostMapping("admin/add-service")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String service(@Valid @ModelAttribute("addServiceDto") AddServiceDto addServiceDto,
                          BindingResult bindingResult,
                          RedirectAttributes attr){
        if(bindingResult.hasErrors()){
            attr
                    .addFlashAttribute("addServiceDto", addServiceDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addServiceDto", bindingResult);
            return "redirect:/add-service";
        }
        service.saveService(addServiceDto);
         return "redirect:/";
    }
    @GetMapping("cosmeticService")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String allServices(Model model){
        List<Service> all = this.serviceRepo.findAll();
        model.addAttribute("services",all);
        return "cosmeticService";
    }
    @GetMapping("/cosmeticService/{id}")
   @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView delete(@PathVariable Long id, ModelAndView model){
        Service serviceById = this.service.findServiceById(id);
        model.setViewName("delete-service");
        model.addObject("service",serviceById);
        return model;
    }
    @PostMapping("/cosmeticService/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(@PathVariable Long id){
        this.service.deleteById(id);
        return "redirect:/cosmeticService";
    }
    @GetMapping("/makeUp")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String makeUp(){
        return "makeUp";
    }
    @PostMapping("/makeUp")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String makeUpPost() {
        return "profile";
    }
    @GetMapping("/pedicure")
   @PreAuthorize("hasAuthority('ROLE_USER')")
    public String pedicure(){
        return "pedicure";
    }
    @PostMapping("/pedicure")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String postPedicure(){
        return "pedicure";
    }
    @GetMapping("/massages")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String massages(){
        return "massages";
    }
    @PostMapping("/massages")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String postMassages(){
        return "profile";
    }
    @GetMapping("/manicure")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String manicure(){
        return "manicure";
    }
    @PostMapping("/manicure")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String postManicure(){
        return "profile";
    }
    @GetMapping("/hairdressing")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String hairdressing(){
        return "hairdressing";
    }
    @PostMapping("/hairdressing")
   @PreAuthorize("hasRole('ROLE_USER')")
    public String postHairdressing(){
        return "profile";
    }
    @ModelAttribute
    public AddServiceDto addServiceDto() {
        return new AddServiceDto();
    }
    @ModelAttribute(name="allServices")
    public List<Service> allServices() {
        return this.serviceRepo.findAll();
    }
}
