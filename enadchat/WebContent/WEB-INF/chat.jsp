<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FACEBOOK CHAT</title>



<link href="<c:url value="/inc/stylefacebook.css"/>" rel="stylesheet" />



</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<a class="btn btn-success" href="javascript:void(0);" onclick="htmlexecute();">Generate  
        Screenshot And Save it :) »</a>
        
        <!-- http://stackoverflow.com/questions/31652698/how-to-save-html2canvas-image-to-my-project-images-folder -->
        
        <script type="text/javascript">
        
        

function htmlexecute() {
	
	html2canvas(document.body, {
		  onrendered: function(canvas) {
			  return Canvas2Image.saveAsPNG(canvas);
		  },
		  
		  useCORS:true,
		  
		  background:undefined
		});
  	
  		
  }
  
  
</script>

     <div class="chat_box">
     
         
         <div class="chat_head">
         
         Chatbox
         
         
         </div>
         
         <div class="chat_body">
         
               <div class="user">
               
               Allissone LAUKAU
               
               
               </div>
         
         </div>
     
     
     </div>
     
     <div class="msg_box" style="right:290px">
     
         <div class="msg_head">
         
         Allissone 
         
             <div class="close">
             x
             </div>
         </div>
         
         <div class="msg_wrap">
         
                 <div class="msg_body">
         
            <div class="msg_a">This is from A</div>
            
            <div class="msg_b">This is from B</div>
            
            <div class="msg_insert"></div>
            
            
         
         </div>
         
         <div class="msg_footer">
         
            <textarea rows="4" cols="" class="msg_input">I LOVE</textarea> 
            
            
            
         
         </div>
         
         
         </div>
         
         
     
     
     </div>
     
     <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
     
     <script src="<c:url value="/inc/facebook.js"/>"></script>
     
     <script src="<c:url value="/inc/html2canvas.js"/>"></script>

<script src="<c:url value="/inc/canvas2image.js"/>"></script>

</body>
</html>