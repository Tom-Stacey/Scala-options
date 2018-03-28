package models

case class Animal(
                 name:       String,
                 species:    String,
                 tailLength: Option[Int],
                 friends:    Seq[Animal] = Seq.empty
                 )
