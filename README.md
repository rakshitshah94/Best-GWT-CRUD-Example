# Best-GWT-CRUD-Example
Pure GWT Project integrated with Dynamic Web Project in Eclipse. Let's CRUD.

# How to Run Project ?
<p>Follow Steps and Run GWT project without any issue </p>

# Prerequisites
1.Java SDK version 1.6 or later <br>
2.Apache Ant is also necessary to run command line arguments. If you don’t already have it, install, or download Apache Tomcat 7.0 or later <br>
3.Download and Install the GWT SDK[ 2.7.0 is latest version till now ] [ Most Important ] - This contains the core libraries, compiler, and development server that you need to write web applications <br>
4.Eclipse (Juno, Mars, Neon, Any!!!) I prefer Mars.<br>
5.mysql-connector-java-5.X.X-bin.jar  [ Latest JAR is better ]

# Setup Your Project 
<b>NOTE</b> : Sometimes you may face problems regarding <b>GWT COMPILING</b> and Run on <b>GWT Web Application</b>, Sometimes it works fine and sometimes it won't run perfectly (Try step 12, It will work).<br> So Solution is here, Follow below steps <br>
1. Open Eclipse and Create new project > Dynamic Web Application, After that open "webcontent" from project explorer and find folder "WEB-INF",right click on "WEB-INF" > new > folder or press CTRL+N > folder, Give name "classes" [ Must ] <br>
2. Right click on Project and Go to Properties or press ALT+ENTER, find Google from left navigator panel. Click on "Web Application" and do check "This Project has war directory", In War directory choose path to webcontent of your project. <br>
3. After that click on "Web Toolkit", it is also inside "Google tab", click on "Use GWT" <br>
4. Now goto "JAVA BUILD PATH" from left navigator panel and click on "SOURCE"[ first tab by default ] > do check on "Allow output folder" > Now Navigate through classes using browse button > And click Apply<br>
5. Now move to libraries tab and click on "Add library" > Select GWT and press "Next" > "Finish" , You can also add JARs from "Add JARs" or "Add External JARs" as well  <br>
6. Next tab that is "Order and export", go there and click on selectAll > Apply > ok <br>
7. Hurray !!! You are ready to making your application, But before that make 4 folders <br>&nbsp;&nbsp; 1.<b>com.example</b> : It is for Entry point <br>&nbsp;&nbsp; 2.<b>com.example.client</b> : It is for client side coding or you can say UI part <br>&nbsp;&nbsp; 3.<b>com.example.server</b> : It is for server side coding or you can say backend coding part <br>&nbsp;&nbsp; 4.<b>com.example.shared</b> : It is shared package. You can keep POJO(s), Validators or anything which you want to use as shared resource.<br>
8. Now Locate path : Project explorer > Project > WebContent > WEB-INF > web.xml, to make an entry/mapping for @RemoteServiceRelativePath("someName"), which I have mentioned in above files [ Download and Extract zip, In eclipse You can Import As well ] <br>
9. Ok Done. Now its important step: <b>Select Project > Right click > Google > GWT Compile => It will take few time to complete permutations </b> <br>
10. After compilation > Right click on Project > Run As > Run on Server <br>
11. It will appear in Browser. If you can't see anything then press <b>CTRL+F5</b> to reload. UI will be display on screen.<br>
12. When you Recompile it, Project will working fine but if you get any problem or error thing, Please delete this two directory from your Project > 1. Project/gwt-unitcache and 2. Project/webcontent/projectname [ Reason :I suggest this. Because I faced error many times and this one will be consider as a solution for successful compiling ]<br>
13. Now follow step 9 - 10 - 11 and enjoy. <br>
If you have any query, Feel free to ask ! 
<br>
Email Id : Rakshitshah1994@gmail.com
