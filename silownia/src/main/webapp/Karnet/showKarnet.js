$(document).ready(function(){
      $.get("/silownia/rest/karnet/getAllKarnet", function(data, textStatus){
              var table = document.getElementById('widoktabeli');
