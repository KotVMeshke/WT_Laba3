package org.education.DAO;

import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.UserEnt;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    /**
     *
     * @return список всех пользователей
     * @throws DatabaseQueryException ошибка базы данных
     */
    List<UserEnt> getUsers() throws DatabaseQueryException;
//
//    /**
//     * @param name
//     * @return
//     * @throws DatabaseQueryException
//     */
    Optional<UserEnt> getUserByUsername(String name) throws DatabaseQueryException;
//
//    /**
//     *
//     * @param name
//     * @return
//     * @throws DatabaseQueryException
//     */
//    Optional<UserEnt> getUserByEmail(String name) throws DatabaseQueryException;
//
//    /**
//     *
//     * @param id
//     * @return
//     * @throws DatabaseQueryException
//     */
    Optional<UserEnt> getUserById(int id) throws DatabaseQueryException;

    /**
     *
     * @param user
     * @throws DatabaseQueryException
     */
    void saveUser(UserEnt user) throws DatabaseQueryException;


//    /**
//     *
//     * @param user
//     * @throws DatabaseQueryException
//     */
//    void deleteUser(int user) throws DatabaseQueryException;
}
