package com.example.demo.service;

import com.example.demo.dao.OneLineJokeDao;
import com.example.demo.dao.TwoLineJokeDao;
import com.example.demo.model.OneLineJoke;
import com.example.demo.model.TwoLineJoke;
import com.example.demo.rest_api.JokesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JokeService {

    private TwoLineJokeDao twoLineJokeDao;
    private OneLineJokeDao oneLineJokeDao;

    private JokesApi jokesApi;

    @Autowired
    public JokeService(TwoLineJokeDao twoLineJokeDao, OneLineJokeDao oneLineJokeDao) {
        this.twoLineJokeDao = twoLineJokeDao;
        this.oneLineJokeDao = oneLineJokeDao;
    }


    public TwoLineJoke getTwoLineJokeById(int id) throws JokeNotFoundExeption {
        Optional<TwoLineJoke> selectedJoke = twoLineJokeDao.findById(id);

        if (selectedJoke.isPresent()){
            return selectedJoke.get();
        }else{
            throw new JokeNotFoundExeption("Joke not found");
        }

    }

    public List<TwoLineJoke> getAllTwoLineJokes(){

        List<TwoLineJoke> twoLineJokeList = new ArrayList<>();

        Iterable<TwoLineJoke> twoLineJokeIterable = twoLineJokeDao.findAll();
        for (TwoLineJoke twoLineJoke:twoLineJokeIterable){

            twoLineJokeList.add(twoLineJoke);
        }

        return twoLineJokeList;

    }

    public List<TwoLineJoke> getAllTwoLineJokesByCategory(String category){

        List<TwoLineJoke> twoLineJokeList = new ArrayList<>();

        Iterable<TwoLineJoke> twoLineJokeIterable = twoLineJokeDao.findTwoLineJokesByCategory(category);
        for (TwoLineJoke twoLineJoke:twoLineJokeIterable){

            twoLineJokeList.add(twoLineJoke);
        }

        return twoLineJokeList;

    }

    public void deleteById(TwoLineJoke twoLineJoke){

        twoLineJokeDao.deleteById(twoLineJoke.getId());
    }

    public void deleteAllListJokes(List<TwoLineJoke> twoLineJokes){
        twoLineJokeDao.deleteAll(twoLineJokes);
    }

    public void fillTwoLineProgramersJokes() throws IOException {
        jokesApi = new JokesApi();

        List<TwoLineJoke> progrmersJokeList = jokesApi.getTwoLineProgramerJokes();
        twoLineJokeDao.saveAll(progrmersJokeList);

    }

    public void fillTwoLineDarkJokes() throws IOException {
        jokesApi = new JokesApi();

        List<TwoLineJoke> darkJokeList = jokesApi.getTwoLineDarkJokes();
        twoLineJokeDao.saveAll(darkJokeList);

    }

    public void fillTwoLineMiscJokes() throws IOException {
        jokesApi = new JokesApi();

        List<TwoLineJoke> miscellanousJokes = jokesApi.getTwoLineMiscellanousJokes();
        twoLineJokeDao.saveAll(miscellanousJokes);

    }


    public OneLineJoke getOneLineJokeById(int id) throws JokeNotFoundExeption {
        Optional<OneLineJoke> selectedJoke = oneLineJokeDao.findById(id);

        if (selectedJoke.isPresent()){
            return selectedJoke.get();
        }else{
            throw new JokeNotFoundExeption("Joke not found");
        }

    }
    public void deleteById(OneLineJoke oneLineJoke){

        oneLineJokeDao.deleteById(oneLineJoke.getId());
    }
    public List<OneLineJoke> getAllOneLineJokes(){

        List<OneLineJoke> oneLineJokeList = new ArrayList<>();

        Iterable<OneLineJoke> oneLineJokeIterable = oneLineJokeDao.findAll();
        for (OneLineJoke oneLineJoke:oneLineJokeIterable){

            oneLineJokeList.add(oneLineJoke);
        }

        return oneLineJokeList;

    }
    public void fillOneLineJokes() throws IOException {
        jokesApi = new JokesApi();

        List<OneLineJoke> oneLineJoke = jokesApi.getOneLineJokes();
        oneLineJokeDao.saveAll(oneLineJoke);

    }
    public void deleteOneLineJokeById(OneLineJoke oneLineJoke){

        oneLineJokeDao.deleteById(oneLineJoke.getId());
    }
    public void deleteAllOneLineListJokes(List<OneLineJoke> oneLineJokes){
        oneLineJokeDao.deleteAll(oneLineJokes);
    }

}
