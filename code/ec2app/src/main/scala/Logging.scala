package mwt.ec2app

import com.typesafe.scalalogging.Logger
import org.slf4j.{ILoggerFactory, LoggerFactory}

import scala.sys.SystemProperties

object Logging {
  def initWithConfigAt(path: String): Unit = {
    (new SystemProperties).getOrElseUpdate("logback.configurationFile", path)
    ()
  }


  private lazy val loggerFactory: ILoggerFactory = {
    LoggerFactory.getILoggerFactory()
  }

  def logger(name: String): Logger = Logger(loggerFactory.getLogger(name))
}


trait Logging {

  import Logging._

  lazy val log: Logger = {
    Logger(loggerFactory.getLogger(getClass.getName))
  }
}
