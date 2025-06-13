PROMPT="%F{green}%n@%m %~
%B$%b%f "

# aliases
alias ll='ls -al'
alias vi='vim'
alias tree='$HOME/development/software/tree/bin/bin/tree'

# functions
function java17() {
    export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk/Contents/Home
}

function java21() {
    export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home
}

function idea() {
    '/Applications/IntelliJ IDEA.app/Contents/MacOS/idea' "$1" > /dev/null 2>&1 &
}

function ports_in_use() {
    lsof -iTCP -sTCP:LISTEN -n -P
}

function docker_prune() {
    docker container prune
    docker image prune -a
    docker volume prune
}

### Begin kafka
function start_zk() {
    cd $KAFKA_HOME
    ./bin/zookeeper-server-start.sh ./config/zookeeper.properties
}

function start_kafka() {
    cd $KAFKA_HOME
    ./bin/kafka-server-start.sh ./config/server.properties
}

function create_all_topics() {
    cd $KAFKA_HOME
    ./bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic card_provisioning_requested-local
    ./bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic card_provisioning_processed-local
    ./bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic card_provisioning_retried-local
}

function list_topics() {
    cd $KAFKA_HOME
    ./bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
}

function purge_topic() {
    cd $KAFKA_HOME
    ./bin/kafka-delete-records.sh --bootstrap-server localhost:9092 --offset-json-file $1
}

function purge_requested() {
    purge_topic $KAFKA_HOME/purge-requested.json
}

function purge_retried() {
    purge_topic $KAFKA_HOME/purge-retried.json
}

function purge_processed() {
    purge_topic $KAFKA_HOME/purge-processed.json
}

function produce_to_topic() {
    cd $KAFKA_HOME
    ./bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic $1
}

function produce_requested() {
    produce_to_topic card_provisioning_requested-local
}

function produce_retried() {
    produce_to_topic card_provisioning_retried-local
}

function produce_processed() {
    produce_to_topic card_provisioning_processed-local
}

function consume_from_topic() {
    cd $KAFKA_HOME
    ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic $1 --from-beginning
}

function consume_requested() {
    consume_from_topic card_provisioning_requested-local
}

function consume_retried() {
    consume_from_topic card_provisioning_retried-local
}

function consume_processed() {
    consume_from_topic card_provisioning_processed-local
}
### End kafka

# PATH
# JAVA_HOME is set in $HOME/.jpmctools/javahome
export JBANG=$HOME/development/software/jbang-0.114.0
export TEMPORAL_CLI=$HOME/development/software/temporal/temporal-cli
export GOROOT=/usr/local/jpmc/go-1.21.3
export GOPATH=$HOME/development/golang/external-lib
export GOPATH=$GOPATH:$HOME/development/golang/workspace
export REDIS_HOME=$HOME/development/software/redis/redis-stable
export JMETER_HOME=$HOME/development/software/jmeter/apache-jmeter-5.6.3
export KAFKA_HOME=$HOME/development/software/kafka/kafka_2.13-3.9.0
export M2_HOME=/usr/local/jpmc/apache-maven-3.9.1

export PATH=$JBANG/bin:$TEMPORAL_CLI:$GOPATH/bin:$REDIS_HOME/bin:$JMETER_HOME/bin:$HOME/development/software/docker/bin:$PATH

export GOROOT=/usr/local/jpmc/go-1.21.3

