package id.ten.realtimedashboard.web;

import id.ten.realtimedashboard.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {



    @GetMapping("/home")
    public String home(Model model) throws InterruptedException {

        return "home";
    }
}