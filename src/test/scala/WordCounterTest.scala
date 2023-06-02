import org.scalatest.{FlatSpec, Matchers}
import runner.WordCounter

class WordCounterTest extends FlatSpec with Matchers {


  "wordCounter " should
    "count each word in a given sentence " in {
      // Given
      val wordCount: WordCounter = WordCounter()

      val input = Seq("This", "is", "a", "valid", "sentence")

      // When
      val numberOFWordsAdded = wordCount.addWord(input: _*)
      val outputSummary = wordCount.updateCount(numberOFWordsAdded)

      // Then
      outputSummary.size should be(5)
    }

  it should "count each word when words are repeated " in {
    // Given
    val wordCount: WordCounter = WordCounter()
    val input = Seq("This", "is", "a", "valid", "sentence", "with", "repeated", "repeated", "repeated", "words")

    // When
    val numberOFWordsAdded = wordCount.addWord(input : _*)
    val outputSummary= wordCount.updateCount(numberOFWordsAdded)

    // Then
    outputSummary.size should be(8)
    outputSummary.get("repeated").head should be(3)
  }


  it should "ignore any non alphabetic character before counting " in {
    // Given
    val wordCount: WordCounter = WordCounter()
    val input = Seq("This", "is", "a", "valid", "sentence", "with", "repeated!", "repeated.", "repeated ", "words")

    // When
    val numberOFWordsAdded = wordCount.addWord(input : _*)
    val outputSummary= wordCount.updateCount(numberOFWordsAdded)

    // Then
    outputSummary.get("repeated").head should be(3)
    outputSummary.get("repeated!") should be(None)
  }


  it should "result in no words Added As input was corrupt " in {
    // Given
    val wordCount: WordCounter = WordCounter()
    val input = Seq("This", "1", ".", "!")

    // When
    val  numberOFWordsAdded = wordCount.addWord(input : _*)
    val outputSummary = wordCount.updateCount(numberOFWordsAdded)

    // Then
    outputSummary.size should be(1)
  }

}
