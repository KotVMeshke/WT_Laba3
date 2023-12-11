package org.education.DAO.impl;

import org.education.DAO.UserDAO;
import org.education.DAO.exception.DatabaseQueryException;

//import org.education.beans.User;
import org.education.beans.UserEnt;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {

//    ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserEnt> getUsers() throws DatabaseQueryException {
        return sessionFactory.fromTransaction(session -> session.createSelectionQuery("from UserEnt", UserEnt.class).getResultList());
////        List<User> res = new ArrayList<>();
////        try(Connection connection = connectionPool.getConnection()){
////            String sql = "SELECT * FROM users";
////            try(Statement statement = connection.createStatement()) {
////                try(ResultSet rs = statement.executeQuery(sql)){
////                    while(rs.next()){
////                        res.add(UserMapper.mapperUser(rs));
////                    }
////                }
////            } catch (SQLException e) {
////                throw new DatabaseQueryException("Some problems with database");
////            }
////        }
////        catch (SQLException e) {
////            throw new DatabaseQueryException("Some problems with database");
////        }
////        return res;
    }
//
    @Override
    public Optional<UserEnt> getUserByUsername(String name) throws DatabaseQueryException {
        return sessionFactory.fromTransaction(session -> {
            var query = session.createSelectionQuery("from UserEnt where userLogin = :name", UserEnt.class);
            query.setParameter("name",name);
            UserEnt user = query.getSingleResultOrNull();
            if (user == null) return Optional.empty();
            else return Optional.of(user);
        });
//        Optional<User> res = Optional.empty();
//        try(Connection connection = connectionPool.getConnection()){
//            String sql = "SELECT * FROM users WHERE username = ?";
//            try(PreparedStatement statement = connection.prepareStatement(sql)){
//                statement.setString(1, name);
//                try(ResultSet rs = statement.executeQuery()){
//                    if(rs.next()){
//                        res = Optional.of(UserMapper.mapperUser(rs));
//                    }
//                }
//            } catch (SQLException e) {
//                throw new DatabaseQueryException(e.getMessage());
//            }
//        } catch (SQLException e) {
//            throw new DatabaseQueryException(e.getMessage());
//        }
//        return res;
    }

//    @Override
//    public Optional<UserEnt> getUserByEmail(String name) throws DatabaseQueryException {
//        return sessionFactory.fromTransaction(session -> {
//            var query = session.createSelectionQuery("from UserEnt where userLogin = :name", UserEnt.class);
//            query.setParameter("name",name);
//            UserEnt user = query.getSingleResultOrNull();
//            if (user == null) return Optional.empty();
//            else return Optional.of(user);
//        });
////        Optional<User> res = Optional.empty();
////        try(Connection connection = connectionPool.getConnection()){
////            String sql = "SELECT * FROM users WHERE login = ?";
////            try(PreparedStatement statement = connection.prepareStatement(sql)){
////                statement.setString(1, name);
////                try(ResultSet rs = statement.executeQuery()){
////                    if(rs.next()){
////                        res = Optional.of(UserMapper.mapperUser(rs));
////                    }
////                }
////            } catch (SQLException e) {
////                throw new DatabaseQueryException(e.getMessage());
////            }
////        } catch (SQLException e) {
////            throw new DatabaseQueryException(e.getMessage());
////        }
////        return res;
//    }
//
    @Override
    public Optional<UserEnt> getUserById(int id) throws DatabaseQueryException {
        return sessionFactory.fromTransaction(session -> {
            var query = session.createSelectionQuery("from UserEnt where idUser = :id", UserEnt.class);
            query.setParameter("id",id);
            UserEnt user = query.getSingleResultOrNull();
            if (user == null) return Optional.empty();
            else return Optional.of(user);
        });
////        Optional<User> res = Optional.empty();
////        try(Connection connection = connectionPool.getConnection()){
////            String sql = "SELECT * FROM users WHERE user_id = ?";
////            try(PreparedStatement statement = connection.prepareStatement(sql)){
////                statement.setInt(1, id);
////                try(ResultSet rs = statement.executeQuery()){
////                    if(rs.next()){
////                        res = Optional.of(UserMapper.mapperUser(rs));
////                    }
////                }
////            } catch (SQLException e) {
////                throw new DatabaseQueryException(e.getMessage());
////            }
////        } catch (SQLException e) {
////            throw new DatabaseQueryException(e.getMessage());
////        }
////        return res;
    }

    @Override
    public void saveUser(UserEnt user) throws DatabaseQueryException {
        sessionFactory.inTransaction(session -> session.merge(user));
//        try(Connection connection = connectionPool.getConnection()){
//            String sql = "INSERT INTO users (login, password, username, token, role) VALUES (?, ?, ?, ?, ?)";
//            try(PreparedStatement statement = connection.prepareStatement(sql)){
//                statement.setString(1, user.getLogin());
//                statement.setString(2, user.getPassword());
//                statement.setString(3, user.getUsername());
//                statement.setString(4, user.getToken());
//                statement.setString(5, Role.USER.toString());
//                statement.execute();
//            } catch (SQLException e) {
//                throw new DatabaseQueryException(e.getMessage());
//            }
//        } catch (SQLException e) {
//            throw new DatabaseQueryException(e.getMessage());
//        }
    }

//    @Override
//    public void updateUser(User user) throws DatabaseQueryException {
//        try(Connection connection = connectionPool.getConnection()){
//            String sql = "UPDATE users SET login = ?, password = ?, username = ?, socialcredit = ?, role = ?, token = ? WHERE user_id = ?";
//            try(PreparedStatement statement = connection.prepareStatement(sql)){
//                statement.setString(1, user.getLogin());
//                statement.setString(2, user.getPassword());
//                statement.setString(3, user.getUsername());
//                statement.setInt(4, user.getSocialCredit());
//                statement.setString(5, user.getRole().toString());
//                statement.setString(6, user.getToken());
//                statement.setInt(7, user.getId());
//                statement.executeUpdate();
//            } catch (SQLException e) {
//                throw new DatabaseQueryException(e.getMessage());
//            }
//        } catch (SQLException e) {
//            throw new DatabaseQueryException(e.getMessage());
//        }
//    }

//    @Override
//    public void deleteUser(int user_id) throws DatabaseQueryException {
//        sessionFactory.inTransaction(session -> {
//            UserEnt user = session.createSelectionQuery("from UserEnt where idUser = :id", UserEnt.class).getSingleResultOrNull();
//            if (user != null) session.remove(user);
//        });
////        try(Connection connection = connectionPool.getConnection()){
////            String sql = "DELETE FROM users WHERE user_id = ?";
////            try(PreparedStatement statement = connection.prepareStatement(sql)){
////                statement.setInt(1, user);
////                statement.executeUpdate();
////            } catch (SQLException e) {
////                throw new DatabaseQueryException(e.getMessage());
////            }
////        } catch (SQLException e) {
////            throw new DatabaseQueryException(e.getMessage());
////        }
//    }
}
