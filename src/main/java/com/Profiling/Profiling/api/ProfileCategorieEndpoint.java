package com.Profiling.Profiling.api;


import com.Profiling.Profiling.model.ProfileCategorie;
import com.Profiling.Profiling.repository.ProfileCategorieRepository;
import com.Profiling.Profiling.service.ClickIncrement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin
public class ProfileCategorieEndpoint {

    @Autowired
    public ProfileCategorieRepository profileCategorieRepository;

    public Optional<ProfileCategorie> ExistingProfileCategorie;


    @Autowired
    public ClickIncrement clickIncrement;

    @PostMapping("/ProfileCategorie")
    public ProfileCategorie saveProfileCategory (@RequestBody ProfileCategorie profileCategorie){
        if(  profileCategorieRepository.findById(profileCategorie.getClick()).isPresent() ){

             ExistingProfileCategorie= profileCategorieRepository.findById(profileCategorie.getClick());
             clickIncrement.incrementClickCategorie(ExistingProfileCategorie.get());
             profileCategorieRepository.save(ExistingProfileCategorie.get());


            return ExistingProfileCategorie.get() ;
        }else {
            clickIncrement.incrementClickCategorie(profileCategorie);
            profileCategorieRepository.save(profileCategorie);
            return profileCategorie;
        }
    }
}
