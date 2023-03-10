package com.example.repository;

import com.example.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {
    ProfileEntity findByPhone(String phone);

    ProfileEntity findByPhoneAndPassword(String phone, String encode);

    ProfileEntity findByEmail(String email);

    ProfileEntity findByPassword(String password);



    @Transactional
    @Modifying
    @Query("update ProfileEntity set password = ?2 where id = ?1")
    int change(Integer id, String newPassword);
    @Transactional
    @Modifying
    @Query("update ProfileEntity set name = ?1, surname = ?2   where id = ?3")
    int updateUserById(String name, String surname, Integer currentUserId);

    @Transactional
    @Modifying
    @Query("update ProfileEntity set email = ?1 , status = ?2 where id = ?3")
    int changeEmail( String newEmail,String status , Integer id);


    @Transactional
    @Modifying
    @Query("update ProfileEntity set photoId = ?1  where id = ?2")
    int attachUpdate(String id, Integer userId);
}
