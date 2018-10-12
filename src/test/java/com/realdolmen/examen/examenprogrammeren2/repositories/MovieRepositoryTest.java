package com.realdolmen.examen.examenprogrammeren2.repositories;

import com.realdolmen.examen.examenprogrammeren2.repositories.MovieRepository;
import com.realdolmen.examen.examenprogrammeren2.domain.Movie;
import com.realdolmen.examen.examenprogrammeren2.exceptions.NoQueryPossibleException;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MovieRepositoryTest {
    
    private static String URL = "jdbc:mysql://localhost:3306/movie_db_test?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    private MovieRepository repository;
    

    @Before
    public void init() {
        repository = new MovieRepository(URL);
    }
    
    
    @Test
    public void findTestSucces() throws Exception {
        //Geef als parameter de String "SELECT * FROM movies" mee
        List<Movie> movies = repository.find("SELECT * FROM movies");
        assertFalse(movies.isEmpty());
        //Doe de nodige check om een succesvolle test te krijgen
    }
    
    
    //TODO maak een test voor MovieRepository.find()
    @Test(expected = NoQueryPossibleException.class)
    public void findTestWrongQuery() throws Exception{
        //Geef als parameter de String "SELECT tietel FROM movies" mee
        List<Movie> movies = repository.find("SELECT tieeetel FROM movies");
        //Doe de nodige check om een succesvolle test te krijgen
    }
    
    @Test
    public void createTestAddsNewMovie() throws SQLException, NoQueryPossibleException{
        //create new movie
        int max = repository.max();
        Movie movie = new Movie();
        movie.setTitle("a new movie");
        movie.setGenre("Funny");
        String query = "INSERT INTO movies(title,genre) VALUES('"+movie.getTitle()+"','"+movie.getGenre()+"')";
        assertTrue(repository.create(query));
        assertEquals((max+1),repository.max());
    }
    
    //TODO gebruik String query = "INSERT INTO movies(title,genre)" als query en laat de test falen.
      public void createTestAddsNewMovieThrowsException() throws SQLException, NoQueryPossibleException{
      
      }
}
