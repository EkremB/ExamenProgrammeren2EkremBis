package com.realdolmen.examen.examenprogrammeren2.services;

import com.realdolmen.examen.examenprogrammeren2.exceptions.NoQueryPossibleException;
import com.realdolmen.examen.examenprogrammeren2.services.MovieService;
import com.realdolmen.examen.examenprogrammeren2.repositories.MovieRepository;
import com.realdolmen.examen.examenprogrammeren2.domain.Movie;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;


@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    private MovieService movieService;
    private List<Movie>movies;
    private Movie movieObjectToTest;
    
    @Mock
    private MovieRepository movieRepository;

    @Before
    public void init() {
        movieService = new MovieService(movieRepository);
        movies = new ArrayList<>();
        movieObjectToTest = new Movie(1,"comedy", "Ace ventura");
    }


    @Test
    public void findAllMoviesTest() throws Exception {
        movies.add(movieObjectToTest);
        when(movieRepository.find(QueryHelper.findAll())).thenReturn(movies);
        
        List<Movie>result = movieService.findAllMovies();
       
        assertEquals(result,movies);
        verify(movieRepository,times(1)).find(QueryHelper.findAll());
    }
    

    @Test
    public void findAllMoviesTestNoQueryPossibleExceptionThrow() throws Exception{
        when(movieRepository.find(anyString())).thenReturn(movies);
        
        List<Movie>result = movieService.findAllMovies();
    }
    
    //TODO test find movie by id
    public void findMovieByIdTest() throws Exception {
    }

    //TODO tet getAllPalinDromeTitles added
    public void getAllPalindromeTitlesTestTitleAddedToList() {
    }
   
    //TODO test de methode getAllPalindromeTitles, waarbij de MovieRepository methode die wordt opgeroepen een NoQueryPossibleException gooit
    //kijk goed naar de methodes in MovieService, kijk wat er gebeurd en zorg dat je resultaat net is zoals er verwacht wordt
    //Onthou hierbij dat private methoden niet getest worden, maar de publieke methode 
    public void getAllPalindromeTitlesTestNoQueryPossibleExceptionThrownAndCatchedTitleNotAdded() {
        
    }
    
    
    //TODO test the isAPalindrome method gebruik hiervoor "saippuakivikauppias"
    //nice to know, this is the longest palindrome according to the guiness book of records
    public void isAPalinDromeTestTrue() {
    }
    
    //TODO test insertNewMovie met de mocks die je gekregen hebt
    @Test
    public void testInsertNewMovie() throws Exception {
    }

    
    //TODO test insertMovie, laat de mock een SQL exception gooien en zorg dat de test methode de NoResultException kan verwachten
    @Test
    public void testInsertNewMovieCatchSQLException() throws Exception{
        
    }
}
