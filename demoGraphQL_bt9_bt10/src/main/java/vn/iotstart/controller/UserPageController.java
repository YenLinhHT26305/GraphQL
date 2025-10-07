package vn.iotstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import vn.iotstart.dto.UserDTO;
import vn.iotstart.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UserPageController {
  private final UserService userService;
  public UserPageController(UserService userService){this.userService=userService;}

  @GetMapping("/create")
  public String createForm(Model model){
    model.addAttribute("userDTO", new UserDTO());
    return "admin/user-create";
  }

  @PostMapping("/create")
  public String createSubmit(@Valid @ModelAttribute("userDTO") UserDTO dto,
                             BindingResult br, RedirectAttributes ra){
    if(br.hasErrors()) return "admin/user-create";
    userService.create(dto); // map DTO -> entity + encode password + set role
    ra.addFlashAttribute("msg","Tạo user thành công");
    return "redirect:/admin/users";
  }
}
