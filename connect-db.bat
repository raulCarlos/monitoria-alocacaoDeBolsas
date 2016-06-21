export DERBY=c:/Users/User/.m2/repository/org/apache/derby/derby/10.8.2.2/derby-10.8.2.2.jar
export DERBY_TOOLS=c:/Users/User/.m2/repository/org/apache/derby/derbytools/10.8.2.2/derbytools-10.8.2.2.jar
export CLASSPATH=$DERBY:$DERBY_TOOLS:$CLASSPATH:.
 
java org.apache.derby.tools.sysinfo
 
java org.apache.derby.tools.ij
 
# connect 'jdbc:derby:test';