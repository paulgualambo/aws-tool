#https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-sqs-queue.html

sqs.create: ##@aws Despliega el stack de cloudformation.
	sudo aws cloudformation deploy \
	--template-file ./cloudformation/sqs.yaml \
	--stack-name $(SQS_TOPIC_NAME) \
	--parameter-overrides \
		ContentBasedDeduplication: #Boolean
		DeduplicationScope: String
		DelaySeconds: Integer
		FifoQueue: Boolean
		FifoThroughputLimit: String
		KmsDataKeyReusePeriodSeconds: Integer
		KmsMasterKeyId: !Ref KmsMasterKeyId
		MaximumMessageSize: !Ref MaximumMessageSize
		MessageRetentionPeriod: Integer
		QueueName: !Ref QueueName
		ReceiveMessageWaitTimeSeconds: Integer
	--region $(DEPLOY_REGION)