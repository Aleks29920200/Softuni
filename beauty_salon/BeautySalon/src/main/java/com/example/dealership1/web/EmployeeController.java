package com.example.dealership1.web;

import com.example.dealership1.domain.binding.AddEmployeeDto;
import com.example.dealership1.domain.entity.Employee;
import com.example.dealership1.services.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/boss")
public class EmployeeController {
    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add-employee")
   @PreAuthorize("hasAuthority('BOSS')")
    public String addService(){
        return "add-employee";
    }
    @PostMapping("/add-employee")
   @PreAuthorize("hasAuthority('BOSS')")
    public String service(@Valid @ModelAttribute("addEmployeeDto") AddEmployeeDto addEmployeeDto,
                          BindingResult bindingResult,
                          RedirectAttributes attr){
        if(bindingResult.hasErrors()){
            attr
                    .addFlashAttribute("addEmployeeDto", addEmployeeDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addEmployeeDto", bindingResult);
            return "redirect:/add-employee";
        }
       this.employeeService.addEmployee(addEmployeeDto);
        return "redirect:/home";
    }
    @GetMapping("/all-employees")
    @PreAuthorize("hasAuthority('BOSS')")
    public String allServices(Model model){
        List<Employee> all = this.employeeService.allEmployees();
        model.addAttribute("employees",all);
        return "all-employees";
    }
    @GetMapping("/all-employees/{id}")
     @PreAuthorize("hasAuthority('ADMIN')")
    public ModelAndView delete(@PathVariable Long id, ModelAndView model){
        Employee employeeById = this.employeeService.findEmployeeById(id);
        model.setViewName("delete-employee");
        model.addObject("employee",employeeById);
        return model;
    }
    @PostMapping("/all-employees/{id}")
   @PreAuthorize("hasAuthority('ADMIN')")
    public String delete(@PathVariable Long id){
        this.employeeService.deleteById(id);
        return "redirect:/all-employees";
    }
    @ModelAttribute(name="employees")
    public List<Employee> allServices() {
        return this.employeeService.allEmployees();
    }
    @ModelAttribute("start")
    public LocalTime time() {
        return addEmployeeDto().getStartOfWorkingDay();
    }
    @ModelAttribute("end")
    public LocalTime timeEnd() {
        return addEmployeeDto().getEndOfWorkingDay();
    }
    @ModelAttribute
    public AddEmployeeDto addEmployeeDto() {
        return new AddEmployeeDto();
    }
}
