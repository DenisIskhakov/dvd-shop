package com.dvdshop.controller;


import com.dvdshop.dto.ActorDTO;
import com.dvdshop.model.Actor;
import com.dvdshop.model.Film;
import com.dvdshop.repository.ActorRepository;
import com.dvdshop.repository.FilmRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Film controller")
@RestController
@RequestMapping(value = FilmController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class FilmController {

    static final String REST_URL = "/film";
    private FilmRepository filmRepository;
    private ActorRepository actorRepository;

    @DeleteMapping("/{id}")
    public String deleteFilmById(@PathVariable Long id) {
        filmRepository.deleteById(id);
        return "Delete " + id;
    }

    @GetMapping("/{id}")
    public Film findById(@PathVariable Long id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Киннофильм с указаным ID %d не найден", id)));
    }

    @GetMapping("/getByTitle")
    public Film getFilmByTitle(@RequestParam(name = "title") String title) {
        return filmRepository.findByTitle(title);
    }

    @GetMapping("/releaseYear")
    public Film getFilmByReleaseYear(@RequestParam(name = "releaseyear") Integer releaseYear) {
        return filmRepository.findByReleaseYear(releaseYear);
    }

    @GetMapping("/rating")
    public Film getFilmByRating(@RequestParam(name = "rating") String rating) {
        return filmRepository.findByRating(rating);
    }

    @PostMapping(value = "/byActor",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findFilmByActor(@RequestBody ActorDTO dto) {
        Actor actor = actorRepository.findActorByFirstNameAndLastName(dto.getFirstName(), dto.getLastName());
        return filmRepository.findByActors(actor);
    }
}
