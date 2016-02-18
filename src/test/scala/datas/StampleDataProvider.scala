package datas

import config.TestConfig

case class Stample(
                    title: String,
                    summary: String,
                    description: String,
                    photoUrls: List[String],
                    embeddedVideosUrls: List[String],
                    attachments: List[String],
                    hashtags: List[String],
                    comments: List[String]
                  )
object Stample {
  val resourcesPath = TestConfig.resourcesPath
  val title: String = "Lorem ipsum dolor sit amet. Sed quis ex ut orci."
  val summary: String = "Sed quis ex ut orci."
  val description: String =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
      "Aenean faucibus tincidunt quam, fringilla gravida dui fringilla in. Phasellus malesuada congue aliquet."
  val youtubeVideoUrl: String = "https://www.youtube.com/watch?v=wNRUzu4fTgw"
  val photo1: String = s"${resourcesPath}res/unionjack.png"
  val photo2: String = s"${resourcesPath}res/tournesol.png"
  val filename: String = s"${resourcesPath}res/rxjs.pdf"
  val comment: String = "Super comment for the win"
  val hashtag1: String = "hashtag1"
  val hashtag2: String = "hashtag2"
  val hashtag3: String = "hashtag3"
  val hashtag4: String = "HASHTAG4"
  val hashtag5: String = "HASHTAG5"
  val hashtag6: String = "HASHTAG6"
  val comment1: String = "Super comment1"
  val comment2: String = "Super comment2"
  val comment3: String = "Super comment3"
  val editComment: String = "Duper"

  // TODO the idea is maybe to have more generator
  def stampleGenerator: Stample = new Stample(
    title,
    summary,
    description,
    List(photo1, photo2),
    List(youtubeVideoUrl),
    List(filename),
    List(hashtag1, hashtag2, hashtag3, hashtag4, hashtag5, hashtag6),
    List(comment1, comment2, comment3)
  )

  val baseStample = stampleGenerator
}

/**
  * Created by dev on 21/01/16.
  */
trait StampleDataProvider {
  val baseStample = Stample.baseStample

  val genStample = Stample.stampleGenerator
}
