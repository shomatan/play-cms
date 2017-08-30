package me.shoma.ayumi.services

import javax.inject.Inject

import com.mohiva.play.silhouette.api.LoginInfo
import me.shoma.ayumi.repositories.UserRepository
import me.shoma.ayumi.model.User

import scala.concurrent.Future

/** Handles actions to users.
  *
  *  @param userRepository The user DAO implementation.
  */
class UserServiceImpl @Inject() (userRepository: UserRepository) extends UserService {

  /** Retrieves a user that matches the specified login info.
    *
    *  @param loginInfo The login info to retrieve a user.
    *  @return The retrieved user or None if no user could be retrieved for the given login info.
    */
  def retrieve(loginInfo: LoginInfo): Future[Option[User]] = userRepository.find(loginInfo)

  /** Retrieves a user that matches the specified login info.
    *
    *  @return The retrieved user or None if no user could be retrieved for the given login info.
    */
  def find: Future[Seq[User]] = userRepository.find

  /** Saves a user.
    *
    *  @param user The user to save.
    *  @return The saved user.
    */
  def save(user: User) = userRepository.save(user)

}
