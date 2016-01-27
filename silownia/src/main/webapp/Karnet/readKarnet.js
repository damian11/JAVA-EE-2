$(document).ready(function(){
	var id = window.location.search.replace("?id=", "");


    $.get("/silownia/rest/karnet/getBilet/" + id, function(data, textStatus){
       document.getElementById('id').innerHTML = data.id_karnet;
       document.getElementById('imie').innerHTML = data.imie;
       document.getElementById('nazwisko').innerHTML = data.nazwisko;
       document.getElementById('telefon').innerHTML = data.telefon;
    });
});
