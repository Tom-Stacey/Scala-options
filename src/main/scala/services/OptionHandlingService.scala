package services

import models.Animal

object OptionHandlingService {

  def gimmeThatString(opt: Option[String]): String = opt.get

  def gimmeThatNumber(opt: Option[Int]): Int = opt.get

  def gimmeWhatsInTheOption[T](opt: Option[T]): T = opt.get

  def doubleMyOption(opt: Option[Int]): Option[Int] = opt.map(_ * 2)

  def addZZZsToMyOption(opt: Option[String]): Option[String] = opt.map(_ + "ZZZ")

  def doubleIfEven(opt: Option[Int]): Option[Int] = opt.map { num =>
    if(num % 2 == 0) num * 2 else num
  }

  def extractStringOrDefault(opt: Option[String]): String = opt.getOrElse("Option Not Defined")

  def addQQQsAndExtract(opt: Option[String]): String = opt.map(_ + "QQQ").getOrElse("No String to add the QQQs to")

  def populateIfEmpty(opt: Option[String], default: String): Option[String] = opt.orElse(Some(default))

  def isItACat(opt: Option[Animal]): String = {
    if(opt.exists(_.species == "cat")) {
      "yep, it's a cat"
    } else {
      "nope, it's not a cat"
    }
  }

  def hasItGotATail(opt: Option[Animal]): Boolean = opt.exists(_.tailLength.isDefined)

  def getTailLength(opt: Option[Animal]): Option[Int] = opt.flatMap(_.tailLength)

  def tailAsStringOrDefault(opt: Option[Animal]): String = ???

  def getFriendsTails(opt: Option[Animal]): Seq[Int] = opt.map(_.friends.flatMap(_.tailLength)).getOrElse(Seq.empty)

}
