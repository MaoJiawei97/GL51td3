package gl51.td3.movie.service.impl
import javax.inject.Inject
import javax.inject.Singleton

import gl51.td3.movie.data.Movie
import gl51.td3.movie.service.MovieClient
import gl51.td3.movie.service.MovieRegistry


@Singleton
class MovieRegistryImpl implements MovieRegistry{
private List<Movie> internalRegistry = []

    @Inject

    private MovieClient movieClient
    @Override
    void addMovieToFavorite(String imdbID){
        internalRegistry << movieClient.getMovieDetail(String imdbID)
    }
    @Override
    List<Movie> listFavorite(){
        internalRegistry
    }
}
