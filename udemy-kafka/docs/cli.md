# CLI
## Topics
### Create and delete a topic
Create:
```bash
kafka-topics.sh --zookeeper 127.0.0.1:2181 --topic first_topic --create --partitions 3 --replication-factor 1
```
* `--zookeeper`, `--partitions` and `--replication-factor` are required parameters
*  `--replication-factor` can't be larger than the number of brokers. So in case of a simple kafka start we have only one broker, so `--replication-factor` is `1`

Delete:
```bash
kafka-topics.sh --zookeeper 127.0.0.1:2181 --topic first_topic --delete
```
### Get topics info

To list all the topics:
```bash
kafka-topics.sh --zookeeper 127.0.0.1:2181 --list
```
To get info about a topic:
```bash
kafka-topics.sh --zookeeper 127.0.0.1:2181 --topic first_topic --describe
```

## Console producer

```bash
kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic first_topic
```
If topic doesn't exist yet, it'll be created with default number of partitions = 1 and default replication factor = 1 (can be altered in config/server.properties) and will also show you a warning about it

## Console consumer

The following will read only the messages which are produced to the topic from the point when we launch it
```bash
kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic first_topic
```

* `--from-beginning` - allows to read all messages submitted to the topic

## Resetting offsets
```bash
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group my-first-application --topic first_topic --reset-offsets --to-earliest --execute
```
* `--to-earliest` has many alternatives, for example `--to-latest` or `--shift-by`, see docs for more
* `--execute` is required