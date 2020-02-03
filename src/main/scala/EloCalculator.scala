class EloCalculator {

  val WIN: Double = 1;
  val LOST: Double = 0;
  val DRAW: Double = 0.5;

  val K_FACTOR: Double = 16;

  def updateElo(a: Player, b: Player, result: Double) = {
    val expectedA = makeExpected(b, a)
    val expectedB = makeExpected(a, b)
    a.elo = makeNewRating(a, result, expectedA)
    b.elo = makeNewRating(b, 1 - result, expectedB)
  }

  private def makeExpected(a: Player, b: Player): Double = {
    1 / (1 + Math.pow(10, (a.elo - b.elo) / 400))
  }

  private def makeNewRating(player: Player, result: Double, expected: Double) = {
    player.elo + (K_FACTOR * (result - expected));
  }

}
