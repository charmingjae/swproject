<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <title>Home</title>
      <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
      <script>
     jQuery.fn.serializeObject = function() { 
      var obj = null; 
      try { 
          if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM" ) { 
              var arr = this.serializeArray(); 
              if(arr){ obj = {}; 
              jQuery.each(arr, function() { 
                  obj[this.name] = this.value; }); 
              } 
          } 
      }catch(e) { 
          alert(e.message); 
      }finally {} 
      return obj; 
    }
    function to_ajax(){
  
 
        const serializedValues2 = $('#chatbotForm').serializeObject()
 
        $.ajax({
            type : 'post',
            url : '/test.jsp',
            data : JSON.stringify(serializedValues2),
            dataType : 'json',
            error: function(xhr, status, error){
                alert(error);
            }
            success : function(json){
                alert(json)
            },
        });
  
    }
 
 
</script>
    </head>
    <body>
        <form name="testForm" id="testForm">
    <input type="text" name="name" id="name" value="홍길동" />
    <input type="text" name="id" id="id" value="1234567" />
</form>
    </body>
</html>