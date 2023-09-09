package com.practice.Ewallet.User;
import com.practice.Ewallet.Wallet.Wallet;
import com.practice.Ewallet.Wallet.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    public void create(UserRequest userRequest){
        //get user details
        userRepository.save(User.builder().email(userRequest.getEmail()).userId(userRequest.getUserId()).build());
        walletRepository.save(new Wallet(userRequest.getUserId(),2000.0));
    }

    public User get(String userId){
        User user =  userRepository.findUserByUserId(userId).orElseThrow(()->new NoSuchElementException(String.format("%s not found",userId )));
        return user;
    }
}
