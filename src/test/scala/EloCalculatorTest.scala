import org.scalatest.FunSuite

class EloCalculatorTest extends FunSuite {
  test("EloCalculator.updateElo_draw") {
    // given
    val calculator = new EloCalculator
    val a = new Player("a", 1000)
    val b = new Player("b", 1000)

    // when
    calculator.updateElo(a, b, calculator.DRAW)

    // then
    assert(a.elo === 1000)
    assert(b.elo === 1000)
  }
  test("EloCalculator.updateElo_AwinB") {
    // given
    val calculator = new EloCalculator
    val a = new Player("a", 1000)
    val b = new Player("b", 1000)

    // when
    calculator.updateElo(a, b, calculator.WIN)

    // then
    assert(a.elo === 1008)
    assert(b.elo === 992)
  }

  test("EloCalculator.updateElo_AlostB") {
    // given
    val calculator = new EloCalculator
    val a = new Player("a", 1000)
    val b = new Player("b", 1000)

    // when
    calculator.updateElo(a, b, calculator.LOST)

    // then
    assert(a.elo === 992)
    assert(b.elo === 1008)
  }
}
