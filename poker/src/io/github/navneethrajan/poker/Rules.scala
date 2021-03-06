package io.github.navneethrajan.poker

import scala.util.Random

object Rules extends App {

  val suits = "♠♥♦♣"
  val ranks = (2 to 10) ++ "JQKA"

  val deck =
    for {
      suit <- suits
      rank <- ranks
    } yield s"$suit$rank"

  val shuffled = Random.shuffle(deck)

  println(deck)
  println(shuffled)

  var pile = shuffled

  val hand = pile.take(2)
  pile = pile.drop(2)

  val hand2 = pile.take(2)
  pile = pile.drop(2)

  val river = pile.take(5)
  pile = pile.drop(5)

  val workingHand = hand ++ river

  println(workingHand)
  println(workingHand.combinations(5).toSeq)

  workingHand.combinations(5).map(Hand(_)).toSeq.sorted
}

sealed trait Hand extends Ordered[Hand]
object Hand {
  def apply(cards: Seq[String]): Hand = ???
}

case class HighCard(card: String) extends Hand {

  def compare(that: Hand): Int = ???

}

