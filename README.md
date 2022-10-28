# CS 441 - HW2
Anvesh Koganti <br />
UIN: 670875073 <br />

## Introduction
The homework is distributed across 3 repos.
1) EC2 deployable LogGenerator - THIS REPO
2) Lambda function - ([Link](https://github.com/anveshcma/HW2-Lambda))
3) gRPC server and client - ([Link](https://github.com/anveshcma/CS441-HW2-gRPC-REST))
4) REST client - ([Link](https://github.com/anveshcma/CS441-HW2-gRPC-REST))

## Setup
- Create a EC2 instance (suggested t2.large or better) with Amazon linux 2 AMI.
- Create a new IAM role with S3 write access and assign it to this instance.
- SSH into the instance and install java and SBT.
- Copy the contents of this repo into the instance file system using secure copy or git clone this repo.
- Modify S3 bucket name in `application.conf` file under s3Params section. Modify the S3 bucket path if needed as well.
- Run `sbt clean compile`. Then run `sbt run`.

## Overview
- This program builds upon the [LogFileGenerator](https://github.com/0x1DOCD00D/LogFileGenerator) program.
- Once the logs are generated in the local folder, they are then automatically copied into the S3 bucket.
- Optionally a CRON job can be setup to invoke the program in a scheduled manner.

## Video demo
Part 1 - EC2 Log file generator ([Link](https://www.youtube.com/watch?v=GisMXmrRnmQ))
## Output
### EC2 log generation complete
![EC2 1000 logs output](https://drive.google.com/uc?export=view&id=1uP4sz_8YSM3Z8aJpPCsTJmbSutIB8Wdh)