package org.education.service;

import org.education.beans.UserEnt;
import org.education.service.exception.AlreadyExistException;
import org.education.service.exception.ServiceException;
import org.education.service.exception.UnknownUserException;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     *
     * @return
     * @throws ServiceException
     */
    List<UserEnt> getUsers() throws ServiceException;

    /**
     *
     * @param name
     * @return
     * @throws ServiceException
     */
    Optional<UserEnt> getUserByUsername(String name) throws ServiceException;

    /**
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    Optional<UserEnt> getUserById(int id) throws ServiceException;

    /**
     * @param email
     * @param password
     * @param username
     * @throws ServiceException
     * @throws AlreadyExistException
     */
    void newUser( String password, String username) throws ServiceException;

//    /**
//     *
//     * @param login
//     * @param password
//     * @return
//     * @throws ServiceException
//     * @throws UnknownUserException
//     */
//    void authenticate(String login, String password) throws ServiceException, UnknownUserException;

    /**
     *
     * @throws ServiceException
     */
    void updateRate() throws ServiceException;

    /**
     *
     * @param id
     * @throws ServiceException
     */
    void deleteUser(int id) throws ServiceException;

    /**
     *
     * @param id
     * @throws ServiceException
     */
    void changeStatus(String name) throws ServiceException;
}
