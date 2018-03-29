package services

import models.Animal

object OptionHandlingService {

  def gimmeThatString(opt: Option[String]): String = ???

  def gimmeThatNumber(opt: Option[Int]): Int = ???

  def gimmeWhatsInTheOption[T](opt: Option[T]): T = ???

  def doubleMyOption(opt: Option[Int]): Option[Int] = ???

  def addZZZsToMyOption(opt: Option[String]): Option[String] = ???

  def doubleIfEven(opt: Option[Int]): Option[Int] = ???

  def extractStringOrDefault(opt: Option[String]): String = ???

  def addQQQsAndExtract(opt: Option[String]): String = ???

  def populateIfEmpty(opt: Option[String], default: String): Option[String] = ???

  def isItACat(opt: Option[Animal]): String = ???

  def hasItGotATail(opt: Option[Animal]): Boolean = ???

  def getTailLength(opt: Option[Animal]): Option[Int] = ???

  def tailAsStringOrDefault(opt: Option[Animal]): String = ???

  def getFriendsTails(opt: Option[Animal]): Seq[Int] = ???

}
