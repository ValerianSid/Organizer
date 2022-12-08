package by.itstep.organizaer.repository;

import by.itstep.organizaer.model.Contacts;
import by.itstep.organizaer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepository extends JpaRepository<Contacts, Long> {
}
