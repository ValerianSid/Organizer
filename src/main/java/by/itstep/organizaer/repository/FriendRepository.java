package by.itstep.organizaer.repository;

import by.itstep.organizaer.model.Friend;
import by.itstep.organizaer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {
}
