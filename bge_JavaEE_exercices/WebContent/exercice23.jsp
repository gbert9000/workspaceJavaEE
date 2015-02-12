<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercice 23</title>
</head>
<body>
    <center>
        <a href="/ServletBDToulousain?action=voir&categorie=client">Liste clients >>&nbsp;</a>
        <a href="/ServletBDToulousain?action=voir&categorie=employe">Liste employés >>&nbsp;</a>
       
        <h3>Caractéristiques d'un client </h3>
        <form action="/ServletBDToulousain" method="post" name="formClient">
            <table >
                
                <tr>    
                    <td>Nom : </td>
                    <td> <input type="text" name="nom" value="" maxlength="100" size="25" /> </td>
                </tr>
                <tr>   
                    <td>Prénom : </td>
                    <td> <input type="text" name="prenom" value="" maxlength="100" size="25" /> </td>
                </tr>                 
                <tr>  
                    <td>Email : </td>
                    <td> <input type="text" name="email" value="" maxlength="100"  size="25" /> 
                         <input type="hidden" name="type" value="client" />
                         <input type="hidden" name="action" value="ajouter" />
                    </td>
                </tr>                               
                <tr>   
                    <td> &nbsp;</td>
                    <td><input type="reset" name="annuler" value="Annuler" />&nbsp; &nbsp;
                    <input type="submit" name="valider" value="Valider" /> </td><br />
                </tr>                 
  
            </table>            
            
        </form>         
        
        <hr  />
        
        
        
        <h3>Caractéristiques d'un employé </h3>
        
        <form action="/ServletBDToulousain" method="post" name="formEmploye">
             <table>
                
                <tr>    
                    <td>Nom : </td>
                    <td> <input type="text" name="nom" value="" maxlength="100" size="25" /> </td>
                </tr>
                <tr>   
                    <td>Prénom : </td>
                    <td> <input type="text" name="prenom" value="" maxlength="100" size="25" /> </td>
                </tr> 
                <tr>   
                    <td>Poste : </td>
                    <td> <input type="text" name="poste" value="" maxlength="100" size="25" /> </td>
                </tr>
                <tr>   
                    <td>Statut : </td>
                    <td> <input type="text" name="statut" value="" maxlength="100" size="25" /> </td>
                </tr>                
                <tr>  
                    <td>Email : </td>
                    <td> <input type="text" name="email" value="" maxlength="100"  size="25" /> 
                         <input type="hidden" name="type" value="employe" />
                         <input type="hidden" name="action" value="ajouter" />
                    </td>
                </tr>                               
                <tr>   
                    <td> &nbsp;</td>
                    <td><input type="reset" name="annuler" value="Annuler" />&nbsp; &nbsp;
                    <input type="submit" name="valider" value="Valider" /> </td><br />
                </tr>                 
  
            </table>            
            
        </form>     
    </center>
</body>
</html>