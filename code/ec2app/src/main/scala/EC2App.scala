package mwt.ec2app

object EC2App extends Logging {

  def main(args: Array[String]): Unit = {
    while (true) {
      log.error(s"I just got started. These are the args: $args")
      Thread.sleep(1000)
    }
  }
}

