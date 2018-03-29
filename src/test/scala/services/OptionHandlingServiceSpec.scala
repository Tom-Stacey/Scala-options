package services

import models.Animal
import org.scalatest.{Matchers, WordSpec}

class OptionHandlingServiceSpec extends WordSpec with Matchers {

  "gimmeThatString" should {
    "return the contents of a defined String Option" in {
      OptionHandlingService.gimmeThatString(Some("hola")) shouldBe "hola"
    }
    "return the contents of a defined String Option with an empty string" in {
      OptionHandlingService.gimmeThatString(Some("")) shouldBe ""
    }
    "throw a NoSuchElementException if the Option is not defined" in {
      a[NoSuchElementException] shouldBe thrownBy {
        OptionHandlingService.gimmeThatString(None)
      }
    }
  }

  "gimmeThatNumber" should {
    "return the contents of a defined Int Option" in {
      OptionHandlingService.gimmeThatNumber(Some(4000)) shouldBe 4000
    }
    "return the contents of a defined Int Option with the number 0" in {
      OptionHandlingService.gimmeThatNumber(Some(0)) shouldBe 0
    }
    "throw a NoSuchElementException if the Option is not defined" in {
      a[NoSuchElementException] shouldBe thrownBy {
        OptionHandlingService.gimmeThatNumber(None)
      }
    }
  }

  "gimmeWhatsInTheOption" should {
    "return the contents of a defined String Option" in {
      OptionHandlingService.gimmeWhatsInTheOption[String](Some("bonjour")) shouldBe "bonjour"
    }
    "return the contents of a defined Double Option" in {
      OptionHandlingService.gimmeWhatsInTheOption[Double](Some(3.234)) shouldBe 3.234
    }
    "throw a NoSuchElementException if the Option is not defined" in {
      a[NoSuchElementException] shouldBe thrownBy {
        OptionHandlingService.gimmeWhatsInTheOption(None)
      }
    }
  }

  "doubleMyOption" should {
    "double a defined Option with a positive value" in {
      OptionHandlingService.doubleMyOption(Some(39)) shouldBe Some(78)
    }
    "double a defined Option with a negative value" in {
      OptionHandlingService.doubleMyOption(Some(-12)) shouldBe Some(-24)
    }
    "leave a defined Option of 0 unchanged" in {
      OptionHandlingService.doubleMyOption(Some(0)) shouldBe Some(0)
    }
    "leave an undefined Option unchanged" in {
      OptionHandlingService.doubleMyOption(None) shouldBe None
    }
  }

  "addZZZsToMyOption" should {
    "add the ZZZs to 'aaaaa'" in {
      OptionHandlingService.addZZZsToMyOption(Some("aaaaa")) shouldBe Some("aaaaaZZZ")
    }
    "add the ZZZs to an empty String" in {
      OptionHandlingService.addZZZsToMyOption(Some("")) shouldBe Some("ZZZ")
    }
    "leave an undefined Option unchanged" in {
      OptionHandlingService.addZZZsToMyOption(None) shouldBe None
    }
  }

  "doubleIfEven" should {
    "double a defined Option with a positive, even value" in {
      OptionHandlingService.doubleIfEven(Some(20)) shouldBe Some(40)
    }
    "leave a defined Option with a positive, odd value unchanged" in {
      OptionHandlingService.doubleIfEven(Some(13)) shouldBe Some(13)
    }
    "double a defined Option with a negative, even value" in {
      OptionHandlingService.doubleIfEven(Some(-12)) shouldBe Some(-24)
    }
    "leave a defined Option with a negative, odd value unchanged" in {
      OptionHandlingService.doubleIfEven(Some(-1)) shouldBe Some(-1)
    }
    "leave a defined Option of 0 unchanged" in {
      OptionHandlingService.doubleIfEven(Some(0)) shouldBe Some(0)
    }
    "leave an undefined Option unchanged" in {
      OptionHandlingService.doubleIfEven(None) shouldBe None
    }
  }

  "extractStringOrDefault" should {
    "bring the string for 'abcdef'" in {
      OptionHandlingService.extractStringOrDefault(Some("abcdef")) shouldBe "abcdef"
    }
    "bring the string for an empty string" in {
      OptionHandlingService.extractStringOrDefault(Some("")) shouldBe ""
    }
    "return a default string when the Option isn't defined" in {
      OptionHandlingService.extractStringOrDefault(None) shouldBe "Option Not Defined"
    }
  }

  "addQQQsAndExtract" should {
    "add the QQQs to 'aaaaa'" in {
      OptionHandlingService.addQQQsAndExtract(Some("aaaaa")) shouldBe "aaaaaQQQ"
    }
    "add the QQQs to an empty String" in {
      OptionHandlingService.addQQQsAndExtract(Some("")) shouldBe "QQQ"
    }
    "leave an undefined Option unchanged" in {
      OptionHandlingService.addQQQsAndExtract(None) shouldBe "No String to add the QQQs to"
    }
  }

  "populateIfEmpty" should {
    "return a populated Option unchanged" in {
      OptionHandlingService.populateIfEmpty(Some("hola"), "default text") shouldBe Some("hola")
    }
    "return a default Option if passed an empty Option" in {
      OptionHandlingService.populateIfEmpty(None, "default str") shouldBe Some("default str")
    }
  }

  "isItACat" should {
    """return "yep, it's a cat" for a cat""" in {
      val testAnimal = Animal("Captain Snugglepuss", "cat", Some(20))
      OptionHandlingService.isItACat(Some(testAnimal)) shouldBe "yep, it's a cat"
    }
    """return "nope, it's not a cat" for a fish""" in {
      val testAnimal = Animal("Leeroy The Wise", "fish", Some(1))
      OptionHandlingService.isItACat(Some(testAnimal)) shouldBe "nope, it's not a cat"
    }
    """return "nope, it's not a cat" for an empty Option""" in {
      OptionHandlingService.isItACat(None) shouldBe "nope, it's not a cat"
    }
  }

  "hasItGotATail" should {
    "return true if the animal has a tail" in {
      val testAnimal = Animal("Joffrey", "dog", Some(15))
      OptionHandlingService.hasItGotATail(Some(testAnimal)) shouldBe true
    }
    "return false if the animal hasn't got a tail" in {
      val testAnimal = Animal("Ribbit Simpkins", "frog", None)
      OptionHandlingService.hasItGotATail(Some(testAnimal)) shouldBe false
    }
    "return false for an empty Option" in {
      OptionHandlingService.hasItGotATail(None) shouldBe false
    }
  }

  "getTailLength" should {
    "return the length of tail if defined" in {
      val testAnimal = Animal("Maximus Decimus Meridius", "gerbil", Some(7))
      OptionHandlingService.getTailLength(Some(testAnimal)) shouldBe Some(7)
    }
    "return None if tail is not defined" in {
      val testAnimal = Animal("Klem", "clam", None)
      OptionHandlingService.getTailLength(Some(testAnimal)) shouldBe None
    }
    "return None if the animal is not defined" in {
      OptionHandlingService.getTailLength(None) shouldBe None
    }
  }

  "tailAsStringOrDefault" should {
    "return the tail length as a string if the animal has a tail" in {
      val testAnimal = Animal("Bruce 'Crocodile' Outback", "kangaroo", Some(40))
      OptionHandlingService.tailAsStringOrDefault(Some(testAnimal)) shouldBe "40"
    }
    """return "No Tail" if the animal has no tail""" in {
      val testAnimal = Animal("Legsy McGee", "octopus", None)
      OptionHandlingService.tailAsStringOrDefault(Some(testAnimal)) shouldBe "No Tail"
    }
    """return "No Tail" if the animal Option is not defined""" in {
      OptionHandlingService.tailAsStringOrDefault(None) shouldBe "No Tail"
    }
  }

  "getFriendsTails" should {
    val jeremy = Animal("Jeremy", "badger", Some(4))
    val jemima = Animal("Jemima", "orangutan", None)
    val jeremiah = Animal("Jeremiah", "cheetah", Some(70))
    val liam = Animal("Liam the friendly giraffe", "hippo", Some(20), Seq(jeremy, jemima, jeremiah))

    "return the lengths of all the tails of all the animal's friends" in {
      OptionHandlingService.getFriendsTails(Some(liam)) shouldBe Seq(4, 70)
    }

    "return an empty sequence for an undefined Option" in {
      OptionHandlingService.getFriendsTails(None) shouldBe Seq.empty
    }
  }

}
