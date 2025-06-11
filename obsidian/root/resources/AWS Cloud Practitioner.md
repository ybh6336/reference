
**Practice tests**

+ Which of the following AWS services support VPC Endpoint Gateway for a private connection from a VPC?

Correct options:

**Amazon Simple Storage Service (Amazon S3)**

**Amazon DynamoDB**

A VPC endpoint enables you to privately connect your VPC to supported AWS services and VPC endpoint services powered by AWS PrivateLink without requiring an internet gateway, NAT device, VPN connection, or AWS Direct Connect connection. Instances in your VPC do not require public IP addresses to communicate with resources in the service. Traffic between your VPC and the other service does not leave the Amazon network.

There are two types of VPC endpoints: interface endpoints and gateway endpoints.

An interface endpoint is an elastic network interface with a private IP address from the IP address range of your subnet that serves as an entry point for traffic destined to a supported service. Interface endpoints are powered by AWS PrivateLink, a technology that enables you to privately access services by using private IP addresses.

A gateway endpoint is a gateway that you specify as a target for a route in your route table for traffic destined to a supported AWS service. The following AWS services are supported:

Amazon Simple Storage Service (Amazon S3)

Amazon DynamoDB

Exam Alert:

You may see a question around this concept in the exam. Just remember that only Amazon S3 and Amazon DynamoDB support VPC gateway endpoint. All other services that support VPC Endpoints use a VPC interface endpoint (note that Amazon S3 supports the VPC interface endpoint as well).

Incorrect options:

**Amazon Elastic Compute Cloud (Amazon EC2)**

**Amazon Simple Queue Service (SQS)**

**Amazon Simple Notification Service (SNS)**

As explained earlier, these services support VPC Endpoint Interfaces.

Reference:

[https://docs.aws.amazon.com/vpc/latest/userguide/vpc-endpoints.html](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-endpoints.html)

---------------------------------------------

A web application stores all of its data on Amazon S3 buckets. A client has mandated that data be encrypted before sending it to Amazon S3.

Which of the following is the right technique for encrypting data as needed by the customer?

Correct option:

**Enable client-side encryption using AWS encryption SDK**

The act of encrypting data before sending it to Amazon S3 is termed as client-side encryption. The AWS encryption SDK is a client-side encryption library that is separate from the language–specific SDKs. You can use this encryption library to more easily implement encryption best practices in Amazon S3. Unlike the Amazon S3 encryption clients in the language–specific AWS SDKs, the AWS encryption SDK is not tied to Amazon S3 and can be used to encrypt or decrypt data to be stored anywhere.

Incorrect options:

**Enable server-side encryption with Amazon S3 Managed Keys (SSE-S3)** - When you use server-side encryption with Amazon S3-Managed Keys (SSE-S3), each object is encrypted with a unique key. As an additional safeguard, it encrypts the key itself with a root key that it regularly rotates.

**Enable server-side encryption with AWS Key Management Service (AWS KMS) keys (SSE-KMS)** - Server-side encryption with AWS KMS keys (SSE-KMS) is similar to SSE-S3, but with some additional benefits and charges for using this service. There are separate permissions for the use of a KMS key that provides added protection against unauthorized access of your objects in Amazon S3. SSE-KMS also provides you with an audit trail that shows when your KMS key was used and by whom.

Server-side encryption is the encryption of data at its destination by the application or service that receives it. Amazon S3 encrypts your data at the object level as it writes it to disks in its data centers and decrypts it for you when you access it. Hence, server-side encryption is not the right answer for the current scenario. So both these options are incorrect.

**Encryption is enabled by default for all the objects written to Amazon S3. Additional configuration is not required** - Although it's correct that encryption is enabled by default for all the objects written to Amazon S3, however, the given use case mandates that data be encrypted before sending it to Amazon S3, which cannot be accomplished with the given option. So this option is incorrect.

References:

[https://docs.aws.amazon.com/en_us/AmazonS3/latest/userguide/UsingClientSideEncryption.html](https://docs.aws.amazon.com/en_us/AmazonS3/latest/userguide/UsingClientSideEncryption.html)

[https://docs.aws.amazon.com/en_us/AmazonS3/latest/userguide/serv-side-encryption.html](https://docs.aws.amazon.com/en_us/AmazonS3/latest/userguide/serv-side-encryption.html)

---------------------------------------------

A company runs an application on a fleet of EC2 instances. The company wants to automate the traditional maintenance job of running timely assessments and checking for OS vulnerabilities. As a Cloud Practitioner, which service will you suggest for this use case?

Correct option:

**Amazon Inspector**

Amazon Inspector is an automated security assessment service that helps improve the security and compliance of applications deployed on your Amazon EC2 instances. Amazon Inspector automatically assesses applications for exposure, vulnerabilities, and deviations from best practices. After performing an assessment, Amazon Inspector produces a detailed list of security findings prioritized by level of severity. These findings can be reviewed directly or as part of detailed assessment reports which are available via the Amazon Inspector console or API.

Incorrect options:

**Amazon GuardDuty** - Amazon GuardDuty is a threat detection service that monitors malicious activity and unauthorized behavior to protect your AWS account. GuardDuty analyzes billions of events across your AWS accounts from AWS CloudTrail (AWS user and API activity in your accounts), Amazon VPC Flow Logs (network traffic data), and DNS Logs (name query patterns). This service is for AWS account level access, not for instance-level management like an EC2. GuardDuty cannot be used to check OS vulnerabilities.

**Amazon Macie** - Amazon Macie is a fully managed data security and data privacy service that uses machine learning and pattern matching to discover and protect your sensitive data in AWS. Macie helps identify and alert you to sensitive data, such as personally identifiable information (PII). This service is for securing data and has nothing to do with an EC2 security assessment. Macie cannot be used to check OS vulnerabilities.

**AWS Shield** - AWS Shield is a managed Distributed Denial of Service (DDoS) protection service that safeguards applications running on AWS. AWS Shield provides always-on detection and automatic inline mitigations that minimize application downtime and latency, so there is no need to engage AWS Support to benefit from DDoS protection. Shield is general protection against DDos attacks for all resources in the AWS network, and not an instance-level security assessment service. Shield cannot be used to check OS vulnerabilities.

Reference:

[https://aws.amazon.com/inspector/](https://aws.amazon.com/inspector/)

---------------------------------------------

The DevOps team at an e-commerce company is trying to debug performance issues for its serverless application built using a microservices architecture. As a Cloud Practitioner, which AWS service would you recommend addressing this use-case?

Correct option:

**AWS X-Ray**

You can use AWS X-Ray to analyze and debug serverless and distributed applications such as those built using a microservices architecture. With X-Ray, you can understand how your application and its underlying services are performing to identify and troubleshoot the root cause of performance issues and errors.

via - [https://aws.amazon.com/xray/](https://aws.amazon.com/xray/)

Incorrect options:

**AWS Trusted Advisor** - AWS Trusted Advisor is an online tool that provides you real-time guidance to help you provision your resources following AWS best practices on cost optimization, security, fault tolerance, service limits and performance improvement. Whether establishing new workflows, developing applications, or as part of ongoing improvement, recommendations provided by Trusted Advisor regularly help keep your solutions provisioned optimally. Trusted Advisor cannot be used to debug performance issues for this serverless application built using a microservices architecture.

**Amazon Pinpoint** - Amazon Pinpoint allows marketers and developers to deliver customer-centric engagement experiences by capturing customer usage data to draw real-time insights. Pinpoint cannot be used to debug performance issues for this serverless application built using a microservices architecture.

**AWS CloudFormation** - AWS CloudFormation allows you to use programming languages or a simple text file to model and provision, in an automated and secure manner, all the resources needed for your applications across all Regions and accounts. Think infrastructure as code; think CloudFormation. CloudFormation cannot be used to debug performance issues for this serverless application built using a microservices architecture.

via - [https://aws.amazon.com/pinpoint/](https://aws.amazon.com/pinpoint/)

Reference:

[https://aws.amazon.com/xray/](https://aws.amazon.com/xray/)

---------------------------------------------

Which of the following AWS Support plans provide access to only core checks from the AWS Trusted Advisor Best Practice Checks? (Select two)

Correct options:

**AWS Basic Support**

The AWS Basic Support plan only provides access to the following:

Customer Service & Communities - 24x7 access to customer service, documentation, whitepapers, and support forums. AWS Trusted Advisor - Access to the core Trusted Advisor checks and guidance to provision your resources following best practices to increase performance and improve security. AWS Health - Your Account Health Dashboard : A personalized view of the health of your AWS services, and alerts when your resources are impacted.

**AWS Developer Support**

You should use the AWS Developer Support plan if you are testing or doing early development on AWS and want the ability to get email-based technical support during business hours as well as general architectural guidance as you build and test. This plan provides access to just the core Trusted Advisor checks from the Service Quota and basic Security checks.

Exam Alert:

Please review the differences between the AWS Developer Support, AWS Business Support, AWS Enterprise On-Ramp Support and AWS Enterprise Support plans as you can expect at least a couple of questions on the exam:

![[Pasted image 20250114062622.png]]

---------------------------------------------

A Project Manager, working on AWS for the first time, is confused about how credits are used in AWS. There are two credits available in the manager's account. Credit one is for $100, expires July 2022, and can be used for either Amazon S3 or Amazon EC2. Credit two is for $50, expires December 2022, and can be used only for Amazon EC2. The manager's AWS account has incurred two charges: $1000 for Amazon EC2 and $500 for Amazon S3.

What will be the outcome on the overall bill once the credits are used? (Select two)

Correct options:

**Credit one is applied, which expires in July, to the Amazon EC2 charge which leaves you with a $900 Amazon EC2 charge and a $500 Amazon S3 charge**

**Then, credit two is applied to the remaining $900 of Amazon EC2 usage**

Credits are applied in the following order:

Soonest expiring

Least number of applicable products

Oldest credit

For the given use case, credit one is applied, which expires in July, to the Amazon EC2 charge which leaves you with a $900 Amazon EC2 charge and a $500 Amazon S3 charge. Then, credit two is applied to the remaining $900 of Amazon EC2 usage. You need to pay $850 for Amazon EC2 and $500 for Amazon S3. All your credits are now exhausted.

Incorrect options:

**Credit one is applied, which expires in July, to Amazon S3 usage which leaves you with a $1000 Amazon EC2 charge and a $400 Amazon S3 charge**

**Only one credit can be used in one billing cycle and the customer has a choice to choose from the available ones**

**Then, credit two is applied to $500 for Amazon S3 usage**

These three options contradict the explanation provided above, so these options are incorrect.

Reference:

[https://www.amazonaws.cn/en/support/faqs/](https://www.amazonaws.cn/en/support/faqs/)

---------------------------------------------

The DevOps team at an IT company is moving 500 GB of data from an EC2 instance to an S3 bucket in the same region. Which of the following scenario captures the correct charges for this data transfer?

Correct option:

**The company would not be charged for this data transfer**

There are three fundamental drivers of cost with AWS: compute, storage, and outbound data transfer. In most cases, there is no charge for inbound data transfer or data transfer between other AWS services within the same region. Outbound data transfer is aggregated across services and then charged at the outbound data transfer rate.

Per AWS pricing, data transfer between S3 and EC2 instances within the same region is not charged, so there would be no data transfer charge for moving 500 GB of data from an EC2 instance to an S3 bucket in the same region.

Incorrect options:

**The company would only be charged for the outbound data transfer from EC2 instance**

**The company would only be charged for the inbound data transfer into the S3 bucket**

**The company would be charged for both the outbound data transfer from EC2 instance as well as the inbound data transfer into the S3 bucket**

These three options contradict the details provided earlier in the explanation, so these options are incorrect.

References:

[https://aws.amazon.com/s3/pricing/](https://aws.amazon.com/s3/pricing/)

[https://d0.awsstatic.com/whitepapers/aws_pricing_overview.pdf](https://d0.awsstatic.com/whitepapers/aws_pricing_overview.pdf)

---------------------------------------------

Which of the following AWS services has encryption enabled by default?

Correct option:

**AWS CloudTrail Logs**

AWS CloudTrail is a service that enables governance, compliance, operational auditing, and risk auditing of your AWS account. AWS CloudTrail can be used to record AWS API calls and other activity for your AWS account and save the recorded information to log files in an Amazon Simple Storage Service (Amazon S3) bucket that you choose. By default, the log files delivered by CloudTrail to your S3 bucket are encrypted using server-side encryption with Amazon S3 managed keys (SSE-S3).

Incorrect options:

**Amazon Elastic File System (Amazon EFS)** - Amazon Elastic File System (Amazon EFS) provides a simple, scalable, fully managed elastic NFS file system for use with AWS Cloud services and on-premises resources. Amazon EFS supports two forms of encryption for file systems, encryption of data in transit and encryption at rest. This is an optional feature and has to be enabled by user if needed.

**Amazon Elastic Block Store (Amazon EBS)** - Amazon Elastic Block Store (EBS) is an easy to use, high-performance block storage service designed for use with Amazon Elastic Compute Cloud (EC2) instances for both throughput and transaction-intensive workloads at any scale. Encryption (at rest and during transit) is an optional feature for EBS and has to be enabled by the user.

**Amazon Relational Database Service (Amazon RDS)** - Amazon Relational Database Service (Amazon RDS) can encrypt your Amazon RDS DB instances. Data that is encrypted at rest includes the underlying storage for DB instances, its automated backups, read replicas, and snapshots. Encryption for RDS is an additional feature and the user needs to enable it.

Reference:

[https://docs.aws.amazon.com/awscloudtrail/latest/userguide/encrypting-cloudtrail-log-files-with-aws-kms.html](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/encrypting-cloudtrail-log-files-with-aws-kms.html)

---------------------------------------------

A big data analytics company is moving its IT infrastructure from an on-premises data center to AWS Cloud. The company has some server-bound software licenses that it wants to use on AWS. As a Cloud Practitioner, which of the following EC2 instance types would you recommend to the company?

Correct option:

**Dedicated Host**

Amazon EC2 Dedicated Hosts allow you to use your eligible software licenses from vendors such as Microsoft and Oracle on Amazon EC2. An Amazon EC2 Dedicated Host is a physical server fully dedicated for your use, so you can help address corporate compliance requirements.

Exam Alert:

Please review the differences between Dedicated hosts and Dedicated instances:

![[Pasted image 20250114064807.png]]

---------------------------------------------

Which of the following is an AWS database service?

Correct option:

**Amazon Redshift**

Amazon Redshift is a fully-managed petabyte-scale cloud-based data warehouse product designed for large scale data set storage and analysis.

Incorrect options:

**AWS Glue** - AWS Glue is a fully managed extract, transform, and load (ETL) service that makes it easy for customers to prepare and load their data for analytics.

**AWS Storage Gateway** - AWS Storage Gateway is a hybrid cloud storage service that connects your existing on-premises environments with the AWS Cloud. Customers use AWS Storage Gateway to simplify storage management and reduce costs for key hybrid cloud storage use cases.

**AWS Database Migration Service (AWS DMS)** - AWS Database Migration Service (AWS DMS) helps you migrate databases to AWS quickly and securely. The source database remains fully operational during the migration, minimizing downtime to applications that rely on the database. The AWS Database Migration Service (AWS DMS) can migrate your data to and from the most widely used commercial and open-source databases.

References:

[https://aws.amazon.com/redshift/](https://aws.amazon.com/redshift/)

[https://aws.amazon.com/dms/](https://aws.amazon.com/dms/)

---------------------------------------------

Under the AWS Shared Responsibility Model, which of the following is a shared responsibility of both AWS and the customer?

Correct option:

**Configuration Management**

Security and Compliance is a shared responsibility between AWS and the customer. This shared model can help relieve the customer’s operational burden as AWS operates, manages and controls the components from the host operating system and virtualization layer down to the physical security of the facilities in which the service operates.

Controls that apply to both the infrastructure layer and customer layers, but in completely separate contexts or perspectives are called shared controls. In a shared control, AWS provides the requirements for the infrastructure and the customer must provide their own control implementation within their use of AWS services. Configuration Management forms a part of shared controls - AWS maintains the configuration of its infrastructure devices, but a customer is responsible for configuring their own guest operating systems, databases, and applications.

Shared Responsibility Model Overview:

![[Pasted image 20250114065135.png]]

via - [https://aws.amazon.com/compliance/shared-responsibility-model/](https://aws.amazon.com/compliance/shared-responsibility-model/)

Incorrect options:

**Infrastructure maintenance of Amazon Simple Storage Service (Amazon S3) storage servers** - AWS is responsible for protecting the infrastructure that runs all of the services offered in the AWS Cloud.

**Guarantee data separation among various AWS customers** - AWS is responsible for protecting the infrastructure that runs all of the services offered in the AWS Cloud. This infrastructure is composed of the hardware, software, networking, and facilities that run AWS Cloud services.

**Availability Zone (AZ) infrastructure maintenance** - AWS is responsible for protecting the infrastructure that runs all of the services offered in the AWS Cloud.

Reference:

[https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys](https://aws.amazon.com/compliance/shared-responsibility-model/)

---------------------------------------------

A company needs a storage solution for a project wherein the data is accessed less frequently but needs rapid access when required. Which S3 storage class is the MOST cost-effective for the given use-case?

Correct option:

**Amazon S3 Standard-Infrequent Access (S3 Standard-IA)**

Amazon S3 Standard-Infrequent Access (S3 Standard-IA) is for data that is accessed less frequently, but requires rapid access when needed. S3 Standard-IA offers the high durability, high throughput, and low latency of S3 Standard, with a low per GB storage price and per GB retrieval fee. This combination of low cost and high performance make S3 Standard-IA ideal for long-term storage, backups, and as a data store for disaster recovery files.

Incorrect options:

**Amazon S3 Standard** - The Amazon S3 Standard offers high durability, availability, and performance object storage for frequently accessed data. S3 standard would turn out to be costlier than S3 Standard-IA for the given use-case, so this option is not correct.

**Amazon S3 Intelligent-Tiering (S3 Intelligent-Tiering)** - The Amazon S3 Intelligent-Tiering storage class is designed to optimize costs by automatically moving data to the most cost-effective access tier, without performance impact or operational overhead. It works by storing objects in two access tiers: one tier that is optimized for frequent access and another lower-cost tier that is optimized for infrequent access. S3 Intelligent-Tiering would turn out to be costlier than S3 Standard-IA for the given use-case, so this option is not correct.

**Amazon S3 Glacier (S3 Glacier)** - Amazon S3 Glacier is a secure, durable, and extremely low-cost Amazon S3 cloud storage class for data archiving and long-term backup. It is designed to deliver 99.999999999% durability, and provide comprehensive security and compliance capabilities that can help meet even the most stringent regulatory requirements. S3 Glacier does not support rapid data retrieval, so this option is ruled out.

Reference:

[https://aws.amazon.com/s3/storage-classes/](https://aws.amazon.com/s3/storage-classes/)

---------------------------------------------

A multi-national corporation wants to get expert professional advice on migrating to AWS and managing their applications on AWS Cloud. Which of the following entities would you recommend for this engagement?

Correct option:

**APN Consulting Partner**

The AWS Partner Network (APN) is the global partner program for technology and consulting businesses that leverage Amazon Web Services to build solutions and services for customers.

APN Consulting Partners are professional services firms that help customers of all types and sizes design, architect, build, migrate, and manage their workloads and applications on AWS, accelerating their migration to AWS cloud.

APN Partner Types Overview:
![[Pasted image 20250114065731.png]]

via - [https://aws.amazon.com/partners/](https://aws.amazon.com/partners/)

Incorrect options:

**APN Technology Partner** - APN Technology Partners provide hardware, connectivity services, or software solutions that are either hosted on or integrated with, the AWS Cloud. APN Technology Partners cannot help in migrating to AWS and managing applications on AWS Cloud.

**AWS Trusted Advisor** - AWS Trusted Advisor is an online tool that provides you real-time guidance to help you provision your resources following AWS best practices on cost optimization, security, fault tolerance, service limits, and performance improvement. Whether establishing new workflows, developing applications, or as part of ongoing improvement, recommendations provided by Trusted Advisor regularly help keep your solutions provisioned optimally. All AWS customers get access to the seven core Trusted Advisor checks to help increase the security and performance of the AWS environment. Trusted Advisor cannot be used to migrate to AWS and manage applications on AWS Cloud.

**Concierge Support Team** - The Concierge Support Team are AWS billing and account experts that specialize in working with enterprise accounts. They will quickly and efficiently assist you with your billing and account inquiries. The Concierge Support Team is only available for the Enterprise Support plan. Concierge Support Team cannot help in migrating to AWS and managing applications on AWS Cloud.

Reference:

[https://aws.amazon.com/partners/](https://aws.amazon.com/partners/)

---------------------------------------------

AWS Web Application Firewall (WAF) offers protection from common web exploits at which layer?

Correct option:

**Layer 7**

AWS WAF is a web application firewall that lets you monitor the HTTP and HTTPS requests that are forwarded to an Amazon API Gateway API, Amazon CloudFront or an Application Load Balancer. HTTP and HTTPS requests are part of the Application layer, which is layer 7.

Incorrect options:

**Layer 3** - Layer 3 is the Network layer and this layer decides which physical path data will take when it moves on the network. AWS Shield offers protection at this layer. WAF does not offer protection at this layer.

**Layer 4** - Layer 4 is the Transport layer and this layer data transmission occurs using TCP or UDP protocols. AWS Shield offers protection at this layer. WAF does not offer protection at this layer.

**Layer 4 and 7** - This option has been added as a distractor.

Reference: https://docs.aws.amazon.com/waf/latest/developerguide/what-is-aws-waf.html

---------------------------------------------

Which AWS service will help you receive alerts when the reservation utilization falls below the defined threshold?

Correct option:

**AWS Budgets**

AWS Budgets gives you the ability to set custom budgets that alert you when your costs or usage exceed (or are forecasted to exceed) your budgeted amount.

You can also use AWS Budgets to set reservation utilization or coverage targets and receive alerts when your utilization drops below the threshold you define. Reservation alerts are supported for Amazon EC2, Amazon RDS, Amazon Redshift, Amazon ElastiCache, and Amazon Elasticsearch reservations.

Incorrect options:

**AWS Pricing Calculator** - AWS Pricing Calculator lets you explore AWS services and create an estimate for the cost of your use cases on AWS. You can model your solutions before building them, explore the price points and calculations behind your estimate, and find the available instance types and contract terms that meet your needs. This enables you to make informed decisions about using AWS. You cannot use this service to receive alerts when the reservation utilization falls below the defined threshold.

**AWS CloudTrail** - AWS CloudTrail is a service that enables governance, compliance, operational auditing, and risk auditing of your AWS account. With AWS CloudTrail, you can log, continuously monitor, and retain account activity related to actions across your AWS infrastructure. AWS CloudTrail provides event history of your AWS account activity, including actions taken through the AWS Management Console, AWS SDKs, command-line tools, and other AWS services. You cannot use this service to receive alerts when the reservation utilization falls below the defined threshold.

**AWS Trusted Advisor** - AWS Trusted Advisor is an online tool that provides real-time guidance to help provision your resources following AWS best practices. Whether establishing new workflows, developing applications, or as part of ongoing improvement, recommendations provided by AWS Trusted Advisor regularly help keep your solutions provisioned optimally. AWS Trusted Advisor analyzes your AWS environment and provides best practice recommendations in five categories: Cost Optimization, Performance, Security, Fault Tolerance, Service Limits. You cannot use this service to receive alerts when the reservation utilization falls below the defined threshold.

References:

[https://aws.amazon.com/aws-cost-management/aws-budgets/](https://aws.amazon.com/aws-cost-management/aws-budgets/)

[https://aws.amazon.com/premiumsupport/technology/trusted-advisor/best-practice-checklist/](https://aws.amazon.com/premiumsupport/technology/trusted-advisor/best-practice-checklist/)

---------------------------------------------

A data analytics company is running a proprietary batch analytics application on AWS and wants to use a storage service which would be accessed by hundreds of EC2 instances simultaneously to append data to existing files. As a Cloud Practitioner, which AWS service would you suggest for this use-case?

Correct option:

**Amazon Elastic File System (Amazon EFS)**

Amazon EFS is a file storage service for use with Amazon EC2. Amazon EFS provides a file system interface, file system access semantics, and concurrently-accessible storage for up to thousands of Amazon EC2 instances. Amazon EFS uses the Network File System protocol.

How EFS works:
![[Pasted image 20250114071020.png]]

via - [https://aws.amazon.com/efs/](https://aws.amazon.com/efs/)

Incorrect options:

**Amazon Elastic Block Store (Amazon EBS)** - Amazon Elastic Block Store (EBS) is an easy to use, high-performance block storage service designed for use with Amazon Elastic Compute Cloud (EC2) for both throughput and transaction-intensive workloads at any scale. EBS volumes cannot be accessed simultaneously by multiple EC2 instances, so this option is incorrect.

**Instance Store** - An instance store provides temporary block-level storage for your instance. This storage is located on disks that are physically attached to the host computer. Instance Store volumes cannot be accessed simultaneously by multiple EC2 instances, so this option is incorrect.

**Amazon Simple Storage Service (Amazon S3)** - Amazon Simple Storage Service (Amazon S3) is an object storage service that offers industry-leading scalability, data availability, security, and performance. S3 is object storage and it does not support file append operations, so this option is incorrect.

Reference:

[https://aws.amazon.com/efs/](https://aws.amazon.com/efs/)

---------------------------------------------

Which of the following is a recommended way to provide programmatic access to AWS resources?

Correct option:

**Use Access Key ID and Secret Access Key to access AWS resources programmatically**

Access keys are long-term credentials for an IAM user or the AWS account root user. You can use access keys to sign programmatic requests to the AWS CLI or AWS API (directly or using the AWS SDK). Access keys consist of two parts: an access key ID and a secret access key. As a user name and password, you must use both the access key ID and secret access key together to authenticate your requests. When you create an access key pair, save the access key ID and secret access key in a secure location. The secret access key is available only at the time you create it. If you lose your secret access key, you must delete the access key and create a new one.

Incorrect options:

**Create a new IAM user and share the username and password** - This is not a viable option, IAM user credentials are not needed to access resources programmatically.

**Use AWS Multi-Factor Authentication (AWS MFA) to access AWS resources programmatically** - For increased security, AWS recommends that you configure AWS Multi-Factor Authentication (AWS MFA) to help protect your AWS resources. You can enable MFA for IAM users or the AWS account root user. MFA adds extra security because it requires users to provide unique authentication from an AWS supported MFA mechanism in addition to their regular sign-in credentials when they access AWS websites or services. MFA cannot be used for programmatic access to AWS resources.

**Use IAM user group to access AWS resources programmatically** - An IAM user group is a collection of IAM users. An IAM user group lets you specify permissions for multiple users, which can make it easier to manage the permissions for those users. IAM user group is for managing users and not for programmatic access to AWS resources.

Reference:

[https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html)

---------------------------------------------

Which of the following statements are CORRECT regarding the Availability Zone (AZ) specific characteristics of Amazon Elastic Block Store (EBS) and Amazon Elastic File System (Amazon EFS) storage types?

Correct option:

**EBS volume can be attached to a single instance in the same Availability Zone (AZ) whereas EFS file system can be mounted on instances across multiple Availability Zones (AZ)**

Amazon Elastic File System (Amazon EFS) provides a simple, scalable, fully managed elastic NFS file system for use with AWS Cloud services and on-premises resources. It is built to scale on-demand to petabytes without disrupting applications, growing and shrinking automatically as you add and remove files, eliminating the need to provision and manage capacity to accommodate growth.

The service is designed to be highly scalable, highly available, and highly durable. Amazon EFS file systems store data and metadata across multiple Availability Zones (AZ) in an AWS Region. EFS file system can be mounted on instances across multiple Availability Zones (AZ).

Amazon Elastic Block Store (EBS) is an easy to use, high-performance block storage service designed for use with Amazon Elastic Compute Cloud (EC2) for both throughput and transaction-intensive workloads at any scale.

Designed for mission-critical systems, EBS volumes are replicated within an Availability Zone (AZ) and can easily scale to petabytes of data. You can attach an available EBS volume to one instance that is in the same Availability Zone (AZ) as the volume.

References:

[https://aws.amazon.com/efs/faq/](https://aws.amazon.com/efs/faq/)

[https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-attaching-volume.html](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-attaching-volume.html)

[https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-volumes-multi.html](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-volumes-multi.html)

---------------------------------------------

A cyber forensics team has detected that AWS owned IP-addresses are being used to carry out malicious attacks. As this constitutes prohibited use of AWS services, which of the following is the correct solution to address this issue?

Correct option:

**Contact AWS Abuse Team**

The AWS Abuse team can assist you when AWS resources are used to engage in abusive behavior.

Please see details of the various scenarios that the AWS Abuse team can address:

![[Pasted image 20250114081228.png]]

via - [https://aws.amazon.com/premiumsupport/knowledge-center/report-aws-abuse/](https://aws.amazon.com/premiumsupport/knowledge-center/report-aws-abuse/)

---------------------------------------------

A company wants to have control over creating and using its own keys for encryption on AWS services. Which of the following can be used for this use-case?

Correct option:

**customer managed key (CMK)**

An AWS KMS key is a logical representation of a cryptographic key. A KMS key contains metadata, such as the key ID, key spec, key usage, creation date, description, and key state. Most importantly, it contains a reference to the key material that is used when you perform cryptographic operations with the KMS key.

The KMS keys that you create are customer managed keys. Customer managed keys are KMS keys in your AWS account that you create, own, and manage. You have full control over these KMS keys, including establishing and maintaining their key policies, IAM policies, and grants, enabling and disabling them, rotating their cryptographic material, adding tags, creating aliases that refer to the KMS keys, and scheduling the KMS keys for deletion.

Incorrect options:

**AWS Secrets Manager** - AWS Secrets Manager helps you protect secrets needed to access your applications, services, and IT resources. The service enables you to easily rotate, manage, and retrieve database credentials, API keys, and other secrets throughout their lifecycle. You cannot use AWS Secrets Manager for creating and using your own keys for encryption on AWS services.

**AWS managed key** - AWS managed keys are KMS keys in your account that are created, managed, and used on your behalf by an AWS service integrated with AWS KMS.

**AWS owned key** - AWS owned keys are a collection of KMS keys that an AWS service owns and manages for use in multiple AWS accounts. Although AWS owned keys are not in your AWS account, an AWS service can use an AWS owned key to protect the resources in your account.

Reference:

[https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys)

---------------------------------------------

A company wants to improve the resiliency of its flagship application so it wants to move from its traditional database system to a managed AWS NoSQL database service to support active-active configuration in both the East and West US AWS regions. The active-active configuration with cross-region support is the prime criteria for any database solution that the company considers.

Which AWS database service is the right fit for this requirement?

Correct option:

**Amazon DynamoDB with global tables**

Amazon DynamoDB is a fully managed, serverless, key-value NoSQL database designed to run high-performance applications at any scale. DynamoDB offers built-in security, continuous backups, automated multi-region replication, in-memory caching, and data export tools.

DynamoDB global tables replicate data automatically across your choice of AWS Regions and automatically scale capacity to accommodate your workloads. With global tables, your globally distributed applications can access data locally in the selected regions to get single-digit millisecond read and write performance. DynamoDB offers active-active cross-region support that is needed for the company.

Incorrect options:

**Amazon DynamoDB with DynamoDB Accelerator** - DynamoDB Accelerator (DAX) is an in-memory cache that delivers fast read performance for your tables at scale by enabling you to use a fully managed in-memory cache. Using DAX, you can improve the read performance of your DynamoDB tables by up to 10 times—taking the time required for reads from milliseconds to microseconds, even at millions of requests per second. DAX does not offer active-active cross-Region configuration.

**Amazon Aurora with multi-master clusters** - Amazon Aurora (Aurora) is a fully managed relational database engine that's compatible with MySQL and PostgreSQL. With some workloads, Aurora can deliver up to five times the throughput of MySQL and up to three times the throughput of PostgreSQL without requiring changes to most of your existing applications. In a multi-master cluster, all DB instances have read/write capability. Aurora is not a NoSQL database, so this option is incorrect.

**Amazon Relational Database Service (Amazon RDS) for MYSQL** - Amazon Relational Database Service (Amazon RDS) makes it easy to set up, operate, and scale a relational database in the cloud. It provides cost-efficient and resizable capacity while automating time-consuming administration tasks such as hardware provisioning, database setup, patching and backups. It frees you to focus on your applications so you can give them the fast performance, high availability, security and compatibility they need. RDS is not a NoSQL database, so this option is incorrect.

References:

[https://aws.amazon.com/dynamodb/features/](https://aws.amazon.com/dynamodb/features/)

[https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/aurora-multi-master.html](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/aurora-multi-master.html)

---------------------------------------------

Which security service of AWS is enabled for all AWS customers, by default, at no additional cost?

Correct option:

**AWS Shield Standard**

AWS Shield Standard defends against most common, frequently occurring network and transport layer DDoS attacks that target your website or applications. While AWS Shield Standard helps protect all AWS customers, you get better protection if you are using Amazon CloudFront and Amazon Route 53. All AWS customers benefit from the automatic protections of AWS Shield Standard, at no additional charge.

Incorrect options:

**AWS Web Application Firewall (AWS WAF)** - AWS WAF is a web application firewall that lets you monitor the HTTP(S) requests that are forwarded to an Amazon CloudFront distribution, an Amazon API Gateway API, or an Application Load Balancer. AWS WAF charges based on the number of web access control lists (web ACLs) that you create, the number of rules that you add per web ACL, and the number of web requests that you receive (it is not a free service).

**AWS Secrets Manager** - AWS Secrets Manager helps you protect secrets needed to access your applications, services, and IT resources. The service enables you to easily rotate, manage, and retrieve database credentials, API keys, and other secrets throughout their lifecycle. With Secrets Manager, you pay based on the number of secrets stored and API calls made.

**AWS Shield Advanced** - AWS Shield Advanced includes intelligent DDoS attack detection and mitigation for not only for network layer (layer 3) and transport layer (layer 4) attacks but also for application layer (layer 7) attacks. AWS Shield Advanced is a paid service that provides additional protections for internet-facing applications.

Reference: https://docs.aws.amazon.com/waf/latest/developerguide/shield-chapter.html

---------------------------------------------

Which of the following are correct statements regarding the AWS Global Infrastructure? (Select two)

Correct options:

**Each AWS Region consists of a minimum of three Availability Zones (AZ)**

**Each Availability Zone (AZ) consists of one or more discrete data centers**

AWS has the concept of a Region, which is a physical location around the world where AWS clusters its data centers. AWS calls each group of logical data centers an Availability Zone (AZ). Each AWS Region consists of a minimum of three, isolated, and physically separate AZs within a geographic area. Each AZ has independent power, cooling, and physical security and is connected via redundant, ultra-low-latency networks.

An Availability Zone (AZ) is one or more discrete data centers with redundant power, networking, and connectivity in an AWS Region. All AZs in an AWS Region are interconnected with high-bandwidth, low-latency networking, over fully redundant, dedicated metro fiber providing high-throughput, low-latency networking between AZs.

AWS Regions and Availability Zones Overview:

![[Pasted image 20250114082024.png]]

via - [https://aws.amazon.com/about-aws/global-infrastructure/regions_az/](https://aws.amazon.com/about-aws/global-infrastructure/regions_az/)

Incorrect options:

**Each AWS Region consists of a minimum of two Availability Zones (AZ)**

**Each Availability Zone (AZ) consists of two or more discrete data centers**

**Each AWS Region consists of two or more Edge Locations**

These three options contradict the details provided earlier in the explanation, so these options are incorrect.

Reference:

[https://aws.amazon.com/about-aws/global-infrastructure/regions_az/](https://aws.amazon.com/about-aws/global-infrastructure/regions_az/)

---------------------------------------------

According to the AWS Cloud Adoption Framework (AWS CAF), what are two tasks that a company should perform when planning to migrate to the AWS Cloud and aiming to become more responsive to customer inquiries and feedback as part of their organizational transformation? (Select two)

Correct options:

The AWS Cloud Adoption Framework (AWS CAF) leverages AWS experience and best practices to help you digitally transform and accelerate your business outcomes through innovative use of AWS. AWS CAF identifies specific organizational capabilities that underpin successful cloud transformations. These capabilities provide best practice guidance that helps you improve your cloud readiness. AWS CAF groups its capabilities in six perspectives: Business, People, Governance, Platform, Security, and Operations.

**Organize your teams around products and value streams**

**Leverage agile methods to rapidly iterate and evolve**

Using the AWS Cloud Adoption Framework (AWS CAF), you can reimagine how your business and technology teams create customer value and meet your strategic intent. Organizing your teams around products and value streams while leveraging agile methods to rapidly iterate and evolve will help you become more responsive and customer centric.

Incorrect options:

**Leverage legacy infrastructure for cost efficiencies**

**Create new analytical insights with existing products and services**

**Organize your teams around bureaucratic design principles**

These three options are not in agreement with the tasks outlined by the AWS Cloud Adoption Framework (AWS CAF) to become more responsive to customer inquiries and feedback, hence these options are incorrect.

Reference:

[https://aws.amazon.com/cloud-adoption-framework/](https://aws.amazon.com/cloud-adoption-framework/)

---------------------------------------------

A unicorn startup is building an analytics application with support for a speech-based interface. The application will accept speech-based input from users and then convey results via speech. As a Cloud Practitioner, which solution would you recommend for the given use-case?

Correct option:

**Use Amazon Transcribe to convert speech to text for downstream analysis. Then use Amazon Polly to convey the text results via speech**

You can use Amazon Transcribe to add speech-to-text capability to your applications. Amazon Transcribe uses a deep learning process called automatic speech recognition (ASR) to convert speech to text quickly and accurately. Amazon Transcribe can be used to transcribe customer service calls, to automate closed captioning and subtitling, and to generate metadata for media assets.

Amazon Transcribe Use-Cases:

![[Pasted image 20250114082457.png]]

via - [https://aws.amazon.com/transcribe/](https://aws.amazon.com/transcribe/)

You can use Amazon Polly to turn text into lifelike speech thereby allowing you to create applications that talk. Polly's Text-to-Speech (TTS) service uses advanced deep learning technologies to synthesize natural sounding human speech.

Amazon Polly Benefits:

![[Pasted image 20250114082509.png]]

via - [https://aws.amazon.com/polly/](https://aws.amazon.com/polly/)

Amazon Translate is used for language translation. Amazon Translate uses neural machine translation via deep learning models to deliver more accurate and more natural-sounding translation than traditional statistical and rule-based translation algorithms.

---------------------------------------------

Which AWS services can be used to facilitate organizational change management, part of the Reliability pillar of AWS Well-Architected Framework? (Select three)

Correct options:

There are three best practice areas for Reliability in the cloud - Foundations, Change Management, Failure Management. Being aware of how change affects a system (change management) allows you to plan proactively, and monitoring allows you to quickly identify trends that could lead to capacity issues or SLA breaches.

**AWS Config**

AWS Config is a service that enables you to assess, audit, and evaluate the configurations of your AWS resources. Config continuously monitors and records your AWS resource configurations and allows you to automate the evaluation of recorded configurations against desired configurations.

via - [https://aws.amazon.com/config/](https://aws.amazon.com/config/)

**AWS CloudTrail**

AWS CloudTrail is a service that enables governance, compliance, operational auditing, and risk auditing of your AWS account. With CloudTrail, you can log, continuously monitor, and retain account activity related to actions across your AWS infrastructure. CloudTrail provides event history of your AWS account activity, including actions taken through the AWS Management Console, AWS SDKs, command-line tools, and other AWS services.

via - [https://aws.amazon.com/cloudtrail/](https://aws.amazon.com/cloudtrail/)

**Amazon CloudWatch**

Amazon CloudWatch is a monitoring and observability service built for DevOps engineers, developers, site reliability engineers (SREs), and IT managers. CloudWatch provides data and actionable insights to monitor applications, respond to system-wide performance changes, optimize resource utilization, and get a unified view of operational health.

Incorrect options:

**AWS Trusted Advisor** - AWS Trusted Advisor is an online tool that provides you real-time guidance to help you provision your resources following AWS best practices on cost optimization, security, fault tolerance, service limits, and performance improvement.

**Amazon Inspector** - Amazon Inspector is an automated security assessment service that helps improve the security and compliance of applications deployed on AWS. Amazon Inspector automatically assesses applications for exposure, vulnerabilities, and deviations from best practices.

**Amazon GuardDuty** - Amazon GuardDuty is a threat detection service that monitors malicious activity and unauthorized behavior to protect your AWS account. GuardDuty analyzes billions of events across your AWS accounts from AWS CloudTrail (AWS user and API activity in your accounts), Amazon VPC Flow Logs (network traffic data), and DNS Logs (name query patterns). This service is for AWS account level access, not for instance-level management like an EC2. GuardDuty cannot be used to check OS vulnerabilities.

References:

[https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf](https://d1.awsstatic.com/whitepapers/architecture/AWS_Well-Architected_Framework.pdf)

[https://aws.amazon.com/config/](https://aws.amazon.com/config/)

---------------------------------------------















