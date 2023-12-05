package com.cts.wishlist.controller;

import com.cts.wishlist.entity.Weather;
import com.cts.wishlist.entity.WishList;
import com.cts.wishlist.response.ResponseHandler;
import com.cts.wishlist.service.WishListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class controller {

    private final WishListServiceImpl wishListService;
    private static final String API_KEY = "5bca776f735e450785d80355231611";
    private static final String API_URL = "http://api.weatherapi.com/v1/current.json?key=";


    @Autowired
    public controller(WishListServiceImpl wishListService) {
        this.wishListService = wishListService;
    }


//    @GetMapping("/saveFav/{city}")
//    public Weather addWishListItem(@PathVariable String city) {
//        String url = API_URL + API_KEY + "&q=" + city + "&aqi=no";
//
//        RestTemplate restTemplate = new RestTemplate();
//        Weather weather = restTemplate.getForObject(url, Weather.class);
//
//        // return wishListService.addTowishlist(wishList);
//        return weather;
//    }

//    @GetMapping("/getSaved/{userId}")
//    public List<WishList> getAllFav(@PathVariable String userId) {
//        int<WishList> list = wishListService.getAllSaved(userId);
//        return list;
//    }

    @PostMapping("/fav")
    public ResponseEntity<?> updateWishlist(@RequestBody WishList wishList){
        WishList wishList1=wishListService.addTowishlist(wishList);
        return new ResponseEntity<>(wishList1,HttpStatus.OK);
    }
}


