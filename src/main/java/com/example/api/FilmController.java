package com.example.api;

import com.example.domain.model.film.Film;
import io.swagger.annotations.*;

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.client.HttpClientErrorException.BadRequest;

@RestController
@RequestMapping("/v1/film")
@Api(description = "フィルム作品を探す")
class FilmController {

    @ApiOperation(value = "フィルム作品を取得する", nickname = "findBy")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK",
                    response = Film.class
            )
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Film findBy() {
        return Film.prototype();
    }

    @ApiOperation(value = "フィルム作品を保存する", nickname = "register")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class)
    })
    @PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    void register(
            @ApiParam(name = "body", required = true, value = "保存するフィルム作品") @Validated @RequestBody Film film, BindingResult result) {
        System.out.println(result.getAllErrors());
        System.out.println("film=" + film);
    }
}