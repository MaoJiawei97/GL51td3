package gl51.td3.movie.service.impl

import gl51.td3.movie.data.Movie
import gl51.td3.movie.service.MovieClient
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieRegistryImplTest extends Specification{

    @Inject
    MovieRegistryImpl registry

    void "injection should work"(){
        expect:
        registry!=null
    }

    void "favorites should be empty"(){
        expect:
        registry.listFavorite()==[]
    }

    void "adding a favorite should fill in the database"(){
        when:
        registry.addMovieToFavorite("aaaa")
        then:
        registry.listFavorite().size()== 1
        registry.listFavorite().find{it.title='my movie'}
    }

    @MockBean
    MovieClient movieClient(){
        def mock=Mock(MovieClient)
        mock.getMovieDetail("aaaa") >>new Movie(imbdID:"aaaa", title:'my movie')
        mock
    }
}
