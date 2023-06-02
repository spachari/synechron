package runner


case class WordCounter( stream: Stream[String] = Stream.empty) {

  def addWord(words: String*): Stream[String] = {
    val regex = "[^a-zA-Z]"
    words.map(word =>  word.replaceAll(regex, "")).toStream ++ stream
  }

  def updateCount(words: Stream[String]): Map[String, Int] = {
    words.
      foldLeft(Map.empty[String, Int].
        withDefaultValue(0)) {
        case (wordCounter, word)  if (wordCounter.get(word) == None && word != "") => wordCounter.updated(word, 1)
        case (wordCounter, word)  if (wordCounter.getOrElse(word, "") == "") => wordCounter
        case (wordCounter, word)  => {
          val existingCount = wordCounter.get(word).head
          wordCounter.updated(word, existingCount + 1)
        }
      }
  }
}
