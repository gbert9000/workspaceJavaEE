<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercice 12</title>
</head>
<body>

<center><h3>Votre identité</h3>
    
    <form action="ServletExercice12" method="post" name="formIdentite">
            <table style="border: 1px solid red;">
                <tr>
                    <td>Civilité : </td>
                    <td> <select name="civilite">
                            <option value="Madame">Madame</option>
                            <option value="Monsieur">Monsieur</option>
                         </select>
                    </td>
                </tr>
                <tr>    
                    <td>Nom : </td>
                    <td> <input type="text" name="nom" value="" maxlength="100" size="25" /> </td><br />
                </tr>
                <tr>   
                    <td>Prénom : </td>
                    <td> <input type="text" name="prenom" value="" maxlength="100" size="25" /> </td><br />
                </tr>
                 <tr>  
                    <td>Age : </td>
                    <td> <input type="text" name="age" value="" maxlength="3"  size="5" /> </td><br />
                </tr>
                <tr>  
                    <td>Adresse : </td>
                    <td> <input type="text" name="adresse" value="" maxlength="100"  size="25" /> </td><br />
                </tr>
                <tr>  
                    <td>Email : </td>
                    <td> <input type="text" name="email" value="" maxlength="100"  size="25" /> </td><br />
                </tr>
                <tr>  
                    <td>Niveau d'études : </td>
                    <td> <input type="text" name="niveau" value="" maxlength="100"  size="25" /> </td><br />
                </tr>                
                <tr>   
                    <td> &nbsp;</td>
                    <td><input type="reset" name="annuler" value="Annuler" />&nbsp; &nbsp;<input type="submit" name="valider" value="Valider" /> </td><br />
                </tr>                 
  
            </table>
            
        </form>      
    <br />
    </center>

 

</body>
</html>