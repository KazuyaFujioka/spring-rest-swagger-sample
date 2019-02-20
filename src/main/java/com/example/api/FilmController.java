package com.example.api;

import com.example.domain.model.film.Film;
import io.swagger.annotations.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}