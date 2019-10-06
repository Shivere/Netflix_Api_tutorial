package com.cat.movie.MovieApiMockup;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "client", url = "http://127.0.0.1:1000")
public interface FeignBoss {
    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    Void getStores();
}
