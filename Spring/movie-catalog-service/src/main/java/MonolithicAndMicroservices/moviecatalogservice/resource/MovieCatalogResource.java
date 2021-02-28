package MonolithicAndMicroservices.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import MonolithicAndMicroservices.moviecatalogservice.model.CatalogItem;
import MonolithicAndMicroservices.moviecatalogservice.model.Movie;
import MonolithicAndMicroservices.moviecatalogservice.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
	{
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.getForObject("http://localhost:8081/catalog/foo", Movie.class);
		
		List<Rating> ratings=Arrays.asList(
				new Rating("1234", 4),
				new Rating("5678", 3)
				);
		
		return ratings.stream().map(rating -> new CatalogItem("Mann", "superb", 6)).collect(Collectors.toList());
		
		
		//return Collections.singletonList(new CatalogItem("Mann","superb",5));
	}
}