package kh.edu.social_members.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/signup")
    public String signup(@RequestParam("nickname") String nickname,
                         @RequestParam("email") String email,
                         @RequestParam("profileImg") String profileImg,
                         @RequestParam("name") String name,
                         Model model) {
        model.addAttribute("nickname", nickname);
        model.addAttribute("email", email);
        model.addAttribute("profileImg", profileImg);
        model.addAttribute("name", name);
        log.info("=========== signup controller ==========");
        log.info("nickname : " + nickname);
        log.info("email : " + email);
        log.info("profileImg : " + profileImg);
        log.info("name : " + name);
        return "signup";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
