package com.cts.wishlist.service;

import com.cts.wishlist.entity.WishList;


import com.cts.wishlist.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class WishListServiceImpl implements WishListService{

@Autowired
   public WishListRepository wishListRepository;



@Override
    public WishList addTowishlist(WishList wishList){


        return wishListRepository.save(wishList);

    }

//    @Override
//    public List<WishList> getAllSaved(String userId) {
//    List<WishList> list = wishListRepository.findAllById(Collections.singleton(userId));
//        return list;
//    }


}
