# ELO Score Simulator Sorter in Scala
ELOSSSS allows you to sort a text list by simulating games between each element of the list. You will have to indicate for each possible game who win (or if it is a draw). An ELO score will be computed for each element based on game results, and the list will be sorted. Cf. https://en.wikipedia.org/wiki/Elo_rating_system#Mathematical_details

# Running
Clone the repo, fill `src/resources/sample.txt` with your custom list then use [sbt](http://www.scala-sbt.org/) to run it.
`sbt run`