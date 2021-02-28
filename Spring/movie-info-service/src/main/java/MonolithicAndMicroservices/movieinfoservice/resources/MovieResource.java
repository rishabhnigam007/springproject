package MonolithicAndMicroservices.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MonolithicAndMicroservices.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource 
{
	@RequestMapping("/{movieId}")
	public Movie getMovieinfo(@PathVariable("movieId") String movieId)
	{
		return new Movie(movieId, "3 idoit");
		
	}
}
