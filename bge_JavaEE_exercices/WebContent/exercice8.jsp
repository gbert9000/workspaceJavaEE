<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercice 8</title>
</head>
<body>

    <center><h3>Controle d'une adresse mail</h3></center>
    
    <%!
    boolean verifieMail(String email)
    {int posArobase,posPoint,p;
     boolean ok = true;

if( (posArobase = email.indexOf('@')) != -1 && email.indexOf('@') == email.lastIndexOf('@')  )
{   if( posArobase == 0 )ok = false;
    else
    { posPoint = email.lastIndexOf('.');
      if(posPoint == -1) ok = false;
      else
      {  if(posPoint - posArobase < 3 ) ok = false;
         else
         {   
             if( ( email.length() - posPoint ) < 3 )ok = false;
                       
         }      
      }      
    }    
}
else{ok = false;}
    
    return ok;
    
    }
    %>    
    
    <% 
    String email = "gm-ingenierie@tiscali.fr";
    if(verifieMail(email) == true)out.println("Email " + email + " valide ...<br /><br />" );
    else out.println("Email " + email + " invalide ...<br /><br />" );
    
    email = "@tiscali.fr";
    if(verifieMail(email) == true)out.println("Email " + email + " valide ...<br /><br />" );
    else out.println("Email " + email + " invalide ...<br /><br />" );
    
    email = "gm-ingenierie@tis@cali.fr";
    if(verifieMail(email) == true)out.println("Email " + email + " valide ...<br /><br />" );
    else out.println("Email " + email + " invalide ...<br /><br />" );
    
    email = "guymassoumou@infonie.f";
    if(verifieMail(email) == true)out.println("Email " + email + " valide ...<br /><br />" );
    else out.println("Email " + email + " invalide ...<br /><br />" );
    
     email = "g@x.f";
    if(verifieMail(email) == true)out.println("Email " + email + " valide ...<br /><br />" );
    else out.println("Email " + email + " invalide ...<br /><br />" );
    
    %>    


</body>
</html>