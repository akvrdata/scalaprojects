import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object scalaprojects
{
  def main(args:Array[String])
  {

    val conf = new SparkConf().setAppName("scalaprojects").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val file = sc.textFile("/data/mr/wordcount/input/big.txt")
    val wordsrdd = file.flatMap(x=>x.split(" "))
    val wordsrddkv = wordsrdd.map(x=>(x,1))
    val reduce = wordsrddkv.reduceByKey((x,y)=>(x+y))
  }
}






