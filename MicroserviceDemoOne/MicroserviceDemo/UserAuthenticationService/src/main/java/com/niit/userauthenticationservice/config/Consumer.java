package com.niit.userauthenticationservice.config;

import com.niit.userauthenticationservice.domain.User;
import com.niit.userauthenticationservice.exception.UserAlreadyExistsException;
import com.niit.userauthenticationservice.rabbitmq.domain.UserDTO;
import com.niit.userauthenticationservice.service.UserServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private UserServiceImpl userService;

    @RabbitListener(queues="user_queue")
    public void getUserDTOFromRabbitMq(UserDTO userDTO)throws UserAlreadyExistsException
    {
        User user=new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userService.saveUser(user);

    }
}
