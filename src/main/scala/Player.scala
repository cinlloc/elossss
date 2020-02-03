class Player(val name: String, var elo: Double) {

  override def toString(): String = {
    s"${name}, ${elo}"
  }

}
