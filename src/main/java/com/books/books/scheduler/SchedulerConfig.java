package com.books.books.scheduler;

import com.books.books.models.User;
import com.books.books.repositoriesSpringDataJPA.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

@EnableScheduling
@Configuration
@EnableAsync
public class SchedulerConfig {

    private final UserRepository userRepository;

    public SchedulerConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Scheduled(initialDelay = 30000, fixedDelay = 3000)
    @Transactional
    @Async
    public void scheduledDataInserting() {
        User user = new User();
        user.setUserName("");
        userRepository.save(user);
        long userId = user.getId();
        user.setUserName("user"+userId);
        userRepository.save(user);
        System.out.println("Добавлена запись в таблицу User" + user.getUserName());
    }
}
