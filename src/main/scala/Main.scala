import scala.io.Source

object Main extends App {

  val DEFAULT_ELO: Double = 1000;

  val playerNames = Source.fromResource("sample.txt").getLines.toList
  println(s"Will perform ELO rating on this: ${playerNames}")
  println(s"Please enter 1 (first win), 0 (second win) or 0.5 (draw)")

  val calculator = new EloCalculator

  var playersToProcess: List[Player] = playerNames.map(name => new Player(name, DEFAULT_ELO))
  var playersProcessed: List[Player] = List[Player]()

  for (player <- playersToProcess) {
    playersProcessed ::= player
    playersToProcess = playersToProcess.filter(!playersProcessed.contains(_))
    for (otherPlayer <- playersToProcess) {
      println(s"${player.name} vs ${otherPlayer.name}: ")
      val scanner = new java.util.Scanner(System.in)
      val input: Double = scanner.nextLine().toDouble
      calculator.updateElo(player, otherPlayer, input)
    }
  }

  println("Scores:")
  playersProcessed.sortBy(_.elo)(Ordering[Double].reverse).zipWithIndex.foreach { case (p, i) => println(s"${i + 1}, ${p}") }
}