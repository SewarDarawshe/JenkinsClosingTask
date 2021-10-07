package pac;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RestController
public class controller {

/*
this method stores the HTML string that is being returned from the ReadFeeds method
and connects it tto the viewed HTML page called "home" .
 */
    @RequestMapping
    public ModelAndView  rssForm(Model model) throws Exception {

        String finalFeed = FeedHandler.ReadFeeds();
        model.addAttribute("FinalParsedFeed",finalFeed);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
