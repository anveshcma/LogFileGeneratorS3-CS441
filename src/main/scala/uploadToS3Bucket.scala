/*
Program to copy the locally generated log file to a S3 bucket
 */

import com.typesafe.config.ConfigFactory
import java.text.SimpleDateFormat
import java.util.Calendar
import java.io.File
// Amazon service dependencies
// Reference https://docs.aws.amazon.com/code-samples/latest/catalog/java-s3-src-main-java-aws-example-s3-PutObject.java.html
import com.amazonaws.AmazonServiceException
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}
import HelperUtils.{CreateLogger, Parameters}

object uploadToS3Bucket:
  val logger = CreateLogger(classOf[uploadToS3Bucket.type])
  val config = ConfigFactory.load()
  val bucket_name: String = config.getString("s3Params.Bucket")
  val format = new SimpleDateFormat("yyyy-MM-dd")
  // Modify the local file name and desired S3 key if needed
  val file_path: String = "log/LogFileGenerator."+format.format(Calendar.getInstance().getTime())+".log"
  val key_name: String = "input/LogFileGenerator."+format.format(Calendar.getInstance().getTime())+".log"

  // Modify the S3 region to reflect the correct region
  val s3: AmazonS3 = AmazonS3ClientBuilder.standard.withRegion(Regions.US_EAST_1).build
  try s3.putObject(bucket_name, key_name, new File(file_path))
  catch {
    case e: AmazonServiceException =>
      System.err.println(e)
      System.exit(1)
  }
  logger.info("Pushed to S3")
  logger.info(s"Bucket name: ${bucket_name}")
  logger.info(s"File path: ${key_name}")