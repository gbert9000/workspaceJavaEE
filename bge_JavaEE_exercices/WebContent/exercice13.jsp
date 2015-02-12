<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercice 13</title>
</head>
<body>
<center><h3> Demande d'informations </h3></center>
    <form action="ServletExercice15" method="post" name="formInfos">
            <table style="border: 1px solid red;">
                <tr>
                    <td>Votre sélection : </td>
                    <td> <select name="item" size="2" multiple>
                            <option value="1">Le conseil en systèmes Informatqiues</option>
                            <option value="2">Le conseil en calcul scientifique</option>
                            <option value="3">Le développement d'applications</option>
                            <option value="4">Autres services</option>
                         </select>
                    </td><br />
                </tr>
                <tr>    
                    <td>Votre email : </td>
                    <td> <input type="text" name="email" value="" maxlength="100" size="25" /> </td>
                </tr>
                <tr>   
                    <td>Votre commentaire : </td>
                    <td> <textarea name="commentaire" cols="50" rows="20" ></textarea></td>
                </tr>                
                <tr>   
                    <td> &nbsp;</td>
                    <td><input type="reset" name="annuler" value="Annuler" />&nbsp; &nbsp;<input type="submit" name="valider" value="Valider" /> </td><br />
                </tr>                 
  
            </table>
            
        </form>      
    <br /><hr />
    
    <center><h3> Demande d'informations avec cases à cocher  </h3></center>
       <form action="ServletExercice15" method="post" name="formInfos2">
            <table style="border: 1px solid red;">
                <tr>
                    <td>Votre sélection : </td>
                    <td>
                            <input type="checkbox" name="conseilsi" value="1" >Le conseil en systèmes Informatqiues</input><br />
                            <input type="checkbox" name="conseilcs" value="2" >Le conseil en calcul scientifique</input><br />
                            <input type="checkbox" name="da" value="3"> Le développement d'applications</input><br />
                            <input type="checkbox" name="as" value="4" >Autres services</input>
                            <input type="hidden" name="ttt" value="5" />                            
                    </td>
                </tr>
                <tr>    
                    <td>Votre email : </td>
                    <td> <input type="text" name="email" value="" maxlength="100" size="25" /> </td>
                </tr>
                <tr>   
                    <td>Votre commentaire : </td>
                    <td> <textarea name="commentaire" cols="50" rows="20" ></textarea> </td>
                </tr>                
                <tr>   
                    <td> &nbsp;</td>
                    <td><input type="reset" name="annuler" value="Annuler" />&nbsp; &nbsp;<input type="submit" name="valider" value="Valider" /> </td><br />
                </tr>                 
  
            </table>
            
        </form>        
    	

</body>
</html>