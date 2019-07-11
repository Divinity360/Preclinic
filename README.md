---


---

<h1 id="preclinic">Preclinic</h1>
<p>Preclinic is a java enterprise web app that is used by health organisations to coordinate the day to day activities in the organization.<br>
Built with JSF (JavaServer Faces), MySQL, PrimeFaces, JavaScript.</p>
<h2 id="features">Features</h2>
<ul>
<li>Overview of daily appointments booked by patients</li>
<li>Calculation of the number of patients to workdone on a particular work day</li>
<li>Overview of the patients and thier details</li>
<li>Overview of doctors and thier areas of expertise</li>
</ul>
<p><img src="https://lh3.googleusercontent.com/Gra3tFd5kMoO3a5ityrSGHlXwHt5kHWpmxz5wPmV7Oc6JrLtq2XgcBAXWKYdTUjLAI1lXibKeeFG" alt="Preclinic homepage" title="Preclinic homepage"></p>
<h2 id="contact">Contact</h2>
<p>Email : <a href="mailto:thedivinitysoft@gmail.com">thedivinitysoft@gmail.com</a></p>
<h2 id="license">License</h2>
<p>Divine Chiedozie</p>
<h2 id="how-to-run-using-tomcat-server">How to run using Tomcat Server</h2>
<ul>
<li>
<p>Tomcat</p>
<ul>
<li>
<p><code>tomcat-remote</code></p>
<p>This profile requires you to start up a plain Tomcat (8.5 or 9) server outside of the build. Each sample will then reuse this instance to run the tests.</p>
<p>Tomcat supports samples that make use of Servlet, JSP, Expression Language (EL), WebSocket and JASPIC.</p>
<p>This profile requires you to enable JMX in Tomcat. This can be done by adding the following to <code>[tomcat home]/bin/catalina.sh</code>:</p>
<pre><code>JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.port=8089 -Dcom.sun.management.jmxremote=true "
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.ssl=false "
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.authenticate=false"
JAVA_OPTS="$JAVA_OPTS -Djava.rmi.server.hostname=localhost "

</code></pre>
<p>This profile also requires you to set a username (<code>tomcat</code>) and password (<code>manager</code>) for the management application in <code>tomcat-users.xml</code>. See the file <code>test-utils/src/main/resources/tomcat-users.xml</code> in this repository for a full example.</p>
<p>Be aware that this should <em>only</em> be done for a Tomcat instance that’s used exclusively for testing, as the above will make the Tomcat installation <strong>totally insecure!</strong></p>
</li>
<li>
<p><code>tomcat-ci-managed</code></p>
<p>This profile will install a Tomcat server and start up the server per sample. Useful for CI servers. The Tomcat version that’s used can be set via the <code>tomcat.version</code> property.</p>
</li>
</ul>
</li>
</ul>
<p>The containers that download and install a server (the *-ci-managed profiles) allow you to override the version used, e.g.:</p>
<ul>
<li>
<p><code>-Dpayara.version=4.1.1.163</code></p>
<p>This will change the version from the current one (e.g 4.1.1.171.1) to 4.1.1.163 for Payara testing purposes.</p>
</li>
<li>
<p><code>-Dglassfish.version=4.1</code></p>
<p>This will change the version from the current one (e.g 4.1.1) to 4.1 for GlassFish testing purposes.</p>
</li>
<li>
<p><code>-Dwildfly.version=8.1.0.Final</code></p>
<p>This will change the version from the current one (e.g. 10.1.0.Final) to 8.1.0.Final for WildFly.</p>
</li>
</ul>
<p><strong>To run them in the console do</strong>:</p>
<ol>
<li>In the terminal, <code>mvn test -fae</code> at the top-level directory to start the tests for the default profile.</li>
</ol>
<p>When developing and runing them from IDE, remember to activate the profile before running the test.</p>
<p>To learn more about Arquillian please refer to the <a href="http://arquillian.org/guides/">Arquillian Guides</a></p>
<p><strong>To run only a subset of the tests do at the top-level directory</strong>:</p>
<ol>
<li>Install top level dependencies: <code>mvn clean install -pl "test-utils,util" -am</code></li>
<li>cd into desired module, e.g.: <code>cd jaspic</code></li>
<li>Run tests against desired server, e.g.: <code>mvn clean test -P liberty-ci-managed</code></li>
</ol>

