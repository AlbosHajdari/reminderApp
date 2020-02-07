package com.remindyou.backend.repository;

import com.remindyou.backend.domain.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    @Query("Select r from Reminder r where r.fromUser.email =: fromUserEmail")
    List<Reminder> findAllByFromUserEmail(@Param("fromUserEmail") String email); // shembulli me raw query

    List<Reminder> findAllByToUserEmail(String email); //shembulli pa raw query

    Optional<Reminder> findByUuid(String uui);


}
