package com.example.demo.controller;

import com.example.demo.model.OneLineJoke;
import com.example.demo.model.TwoLineJoke;
import com.example.demo.service.JokeNotFoundExeption;
import com.example.demo.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class JokeController {

    @Autowired
    public JokeService jokeService;

    @GetMapping("/home")
    public String homePage(Model model) throws IOException {

        List<TwoLineJoke> twoLineJokes = jokeService.getAllTwoLineJokes();
        if (twoLineJokes.isEmpty()) {

            jokeService.fillTwoLineProgramersJokes();


            jokeService.fillTwoLineDarkJokes();


            jokeService.fillTwoLineMiscJokes();

            jokeService.fillOneLineJokes();

        }
        model.addAttribute("twolinejoke", new TwoLineJoke());
        model.addAttribute("onelinejoke", new OneLineJoke());
        return "index";
    }

    @RequestMapping("/programerJokes")
    public String showAllProgrammersJokes(Model model){
        List<TwoLineJoke> allProgramerJokes = jokeService.getAllTwoLineJokesByCategory("Programming");
        model.addAttribute("allProgramerJokes", allProgramerJokes);
        return "all_programer_jokes";
    }

    @RequestMapping("/refreshProgrammersJokes")
    public String refreshAllProgrammerJokes() throws IOException {

        List<TwoLineJoke> allProgramerJokes = jokeService.getAllTwoLineJokesByCategory("Programming");
        jokeService.deleteAllListJokes(allProgramerJokes);
        allProgramerJokes.clear();
        jokeService.fillTwoLineProgramersJokes();
        return "redirect:/programerJokes";
    }

    @RequestMapping(value = "/programmerJoke/delete{id}")
    public String deleteProgrammerJokeById(@PathVariable int id) throws JokeNotFoundExeption {

        TwoLineJoke twoLineJoke = jokeService.getTwoLineJokeById(id);
        jokeService.deleteById(twoLineJoke);

        return "redirect:/programerJokes";

    }



    @RequestMapping("/darkJokes")
    public String showAllDarkJokes(Model model){
        List<TwoLineJoke> allDarkJokes = jokeService.getAllTwoLineJokesByCategory("Dark");
        model.addAttribute("allDarkJokes", allDarkJokes);
        return "all_dark_jokes";
    }

    @RequestMapping("/refreshDarkJokes")
    public String refreshAllDarkJokes() throws IOException {
        List<TwoLineJoke> allDarkJokes= jokeService.getAllTwoLineJokesByCategory("Dark");
        jokeService.deleteAllListJokes(allDarkJokes);
        allDarkJokes.clear();
        jokeService.fillTwoLineDarkJokes();
        return "redirect:/darkJokes";
    }

    @RequestMapping(value = "/darkJoke/delete{id}")
    public String deleteDarkJokeById(@PathVariable int id) throws JokeNotFoundExeption {

        TwoLineJoke twoLineJoke = jokeService.getTwoLineJokeById(id);
        jokeService.deleteById(twoLineJoke);

        return "redirect:/darkJokes";

    }



    @RequestMapping("/miscellanousJokes")
    public String showAllMiscJokes(Model model){
        List<TwoLineJoke> allMiscDarkJokes = jokeService.getAllTwoLineJokesByCategory("Misc");
        model.addAttribute("allMiscDarkJokes", allMiscDarkJokes);
        return "all_misc_jokes";
    }

    @RequestMapping("/refreshMiscJokes")
    public String refreshAllMiscJokes() throws IOException {

        List<TwoLineJoke> allMiscDarkJokes = jokeService.getAllTwoLineJokesByCategory("Misc");
        jokeService.deleteAllListJokes(allMiscDarkJokes);
        allMiscDarkJokes.clear();
        jokeService.fillTwoLineMiscJokes();

        return "redirect:/miscellanousJokes";
    }

    @RequestMapping(value = "/miscJoke/delete{id}")
    public String deleteMiscJokeById(@PathVariable int id) throws JokeNotFoundExeption {

        TwoLineJoke twoLineJoke = jokeService.getTwoLineJokeById(id);
        jokeService.deleteById(twoLineJoke);

        return "redirect:/miscellanousJokes";

    }




    @RequestMapping("/oneLiners")
    public String showAllOneLinersJokes(Model model){
        List<OneLineJoke> allOneliners = jokeService.getAllOneLineJokes();
        model.addAttribute("allOneliners", allOneliners);
        return "all_one_liners_jokes";
    }

    @RequestMapping("/refreshOneLineJokes")
    public String refreshAllOneLineJokes() throws IOException {

        List<OneLineJoke> allOneLineJokes = jokeService.getAllOneLineJokes();
        jokeService.deleteAllOneLineListJokes(allOneLineJokes);
        allOneLineJokes.clear();
        jokeService.fillOneLineJokes();

        return "redirect:/oneLiners";
    }

    @RequestMapping(value = "/oneLineJoke/delete{id}")
    public String deleteOneLineJokeById(@PathVariable int id) throws JokeNotFoundExeption {

        OneLineJoke oneLineJoke = jokeService.getOneLineJokeById(id);
        jokeService.deleteOneLineJokeById(oneLineJoke);

        return "redirect:/oneLiners";

    }

}
