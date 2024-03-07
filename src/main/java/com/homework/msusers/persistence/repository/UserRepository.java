    package com.homework.msusers.persistence.repository;

    import com.homework.msusers.persistence.entity.User;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRepository extends CrudRepository<User, Long> {
        @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
        Boolean existsByEmail(String email);
    }
