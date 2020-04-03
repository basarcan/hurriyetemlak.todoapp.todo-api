# hurriyetemlak.todoapp.todo-api

This is a todo app task for Hurriyet Emlak and it is a todo api 

## Installation

First you need to pull docker image

```bash
docker pull cavitcanbasar/hurriyetemlak.todoapi:latest
```

and than run couchbase (if you already did this please skip)

```bash
docker run --rm -d -p 8091-8094:8091-8094 -p 11210:11210 couchbase:community-6.0.0
```

create cluster (if you already did this please skip)

```bash
docker exec -it he-couchbase /opt/couchbase/bin/couchbase-cli cluster-init -c 127.0.0.1 \
--cluster-username=admin \
--cluster-password=123456 \
--cluster-port=8091 \
--cluster-ramsize=256 \
--services=data,query,index
```

create bucket 

```bash
docker exec -it he-couchbase /opt/couchbase/bin/couchbase-cli bucket-create -c 127.0.0.1:8091 \
--bucket=todo-bucket \
--bucket-type=couchbase \
--bucket-ramsize=128 \
--bucket-replica=1 \
-u todo-bucket -p todo-bucket
```

and run the docker image

```bash
docker run -i -t -p 8080:81 cavitcanbasar/hurriyetemlak.todoapi
```


## Usage

You can view all the controllers from swagger

