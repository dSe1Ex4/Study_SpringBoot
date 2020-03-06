package kgsu.web.Study_SpringBoot.Repositories;

import kgsu.web.Study_SpringBoot.Models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {

}
