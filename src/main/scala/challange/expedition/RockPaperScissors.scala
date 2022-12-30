package challange.expedition

import scala.io.Source

object RockPaperScissors {
  //A->Rock<-X (1)
  //B->Paper<-Y (2)
  //C->Scissors<-Z (3)
  //Bonus points: For each round, if win or draw add 3 , if lose add0

  val scores : Map[String,Int]= Map("Rock" -> 1, "Paper" -> 2, "Scissors" -> 3)
  val winningMap:Map[String,String] = Map("Rock" -> "Scissors", "Paper" -> "Rock", "Scissors" -> "Paper")
  val losingMap:Map[String,String]= Map("Rock" -> "Paper", "Paper" -> "Scissors", "Scissors" -> "Rock")
  val map:Map[String,String] = Map("A"->"Rock","B"->"Paper","C"->"Scissors","X"->"Rock","Y"->"Paper","Z"->"Scissors")

  def main(args: Array[String]): Unit = {

        val filename = "src/main/resources/tournament.txt"
//    val filename = "src/main/resources/test.txt"

    println(s"Score: ${Source.fromFile(filename).getLines.map(evaluateRoundPart2).sum}")
  }

  def evaluateRound(round: String): Int = {

    val arr = round.split(" ")
    val opponent = arr(0)
    val me = arr(1)
    println(s"${map(me)}, ${map(opponent)}, ${winningMap(map(me))} ${ scores(map(me))} , ${(if(winningMap(map(me))==map(opponent)) 6 else if( map(me) == map(opponent)) 3 else 0)
    }")
    scores(map(me)) + (if(winningMap(map(me))==map(opponent)) 6 else if( map(me) == map(opponent)) 3 else 0)
  }

  def evaluateRoundPart2(round: String): Int = {

    val arr = round.split(" ")
    val opponent = arr(0)
    val result = arr(1)

    if(result=="X")
      scores(winningMap(map(opponent)))
    else if(result=="Y")
      3 + scores(map(opponent))
    else
      6 + scores(losingMap(map(opponent)))
  }
}
