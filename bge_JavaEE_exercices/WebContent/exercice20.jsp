<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercice 20</title>
</head>
<body>

    <center><h3> Demande d'informations</h3></center>
    <form action="ServletExercice20" method="post" name="formInfos">
            <table style="border: 1px solid red;">
                <tr>    
                    <td>Votre nom : </td>
                    <td> <input type="text" name="nom" value="" maxlength="100" size="25" /> </td>
                </tr>
                <tr>   
                    <td>Votre prénom : </td>
                    <td> <input type="text" name="prenom" value="" maxlength="100" size="25" /></td>
                </tr>
                 <tr>   
                    <td>Votre age : </td>
                    <td> <input type="text" name="age" value="" maxlength="3" size="5" /></td>
                </tr>   
                
                <tr>   
                    <td> &nbsp;</td>
                    <td><input type="reset" name="annuler" value="Annuler" />&nbsp; &nbsp;<input type="submit" name="valider" value="Valider" /> </td><br />
                </tr>                 
  
            </table>
     </form>

</body>
</html>