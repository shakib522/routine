package com.example.trainmanagement.service.profileService;


import com.example.trainmanagement.entity.Profile;
import com.example.trainmanagement.error.DefaultException;
import com.example.trainmanagement.repository.AuthRepository;
import com.example.trainmanagement.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{

    private final ProfileRepository profileRepository;
    private final AuthRepository authRepository;

    @Override
    public Profile createProfile(Profile profile) {
        val user=authRepository.findById(profile.getProfile_id());
        if (user.isEmpty()){
            throw new DefaultException("User not found with this id",404);
        }
        return profileRepository.save(profile);
    }
}
