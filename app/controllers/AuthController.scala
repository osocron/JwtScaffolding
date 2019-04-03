package controllers

import auth.AuthAction
import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext

class AuthController @Inject()(cc: ControllerComponents, authAction: AuthAction)(implicit ec: ExecutionContext)
  extends AbstractController(cc) {

  def protectedAction(post: String) = authAction.async { implicit request =>
    Future.successful(Ok(post))
  }

}
