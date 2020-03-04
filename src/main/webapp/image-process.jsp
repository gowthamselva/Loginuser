
<html>
<body>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.mysql.*"%>
 <%@ page import="java.util.*"%>
  <%@ page import="java.text.*"%>
 <%@ page import="javax.servlet.*"%>
 <%@ page import="javax.servlet.http.*"%>
 <%@ page import="javax.servlet.http.HttpSession"%>
 <%@ page language="java"%>
 <%@ page session="true"%>
 <%@ page import="java.sql.*"%>
 <%
Connection conn=null;
PreparedStatement pstmt = null;
ResultSet rs=null;
String url="jdbc:mysql://localhost:3306/image?useTimezone=true&serverTimezone=UTC";
FileInputStream fis=null;
String fname=request.getParameter("fname");
String myloc=request.getParameter("myimg");
System.out.println("First Name :"+fname+"myloc="+myloc);
try{
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
conn=DriverManager.getConnection(url, "root", "");
File image= new File(myloc);
pstmt = (PreparedStatement) conn.prepareStatement("insert into upload(Name, photo) " + "values(?,?)");
pstmt.setString(1, fname);
fis=new FileInputStream(image);
pstmt.setBinaryStream(2, fis, (int) (image.length()));
pstmt.executeUpdate();
pstmt.close();
conn.close();
}
catch(Exception ex)
{
ex.printStackTrace();
}
%>
<%
Blob image = null;
Connection con = null;
byte[ ] imgData = null ;
Statement stmt = null;


try {
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image?useTimezone=true&serverTimezone=UTC","root","");
stmt = con.createStatement();
String s="Logo";
rs = stmt.executeQuery("select photo from upload");%>
<table border="2">
<tr><th>DISPLAYING IMAGE</th></tr>
<tr><td>Image 2</td></tr>
<tr><td>
<%while(rs.next()){image=rs.getBlob(1);
imgData = image.getBytes(1,(int)image.length());
response.setContentType("image/jpg");
OutputStream o = response.getOutputStream();%><img src="<% o.write(imgData);%>" width="500" height="500"/>
 <%}%>
</td></tr>
</table>
<%
}
catch (Exception e) {
    out.println("DB problem"); 
    return;
}
finally {
try {
rs.close();
stmt.close();
con.close();
} 
catch (SQLException e) {
e.printStackTrace();
}
}
/*if (rs.next()) {
image = rs.getBlob(1);
imgData = image.getBytes(1,(int)image.length());
}

else {
out.println("Display Blob Example");
out.println("image not found for given id>");
return;
}
// display the image
response.setContentType("image/jpg");
OutputStream o = response.getOutputStream();
o.write(imgData);
o.flush();
o.close();
} catch (Exception e) {
out.println("Unable To Display image");
out.println("Image Display Error=" + e.getMessage());
return;
 
}*/
%>

</body>
</html>