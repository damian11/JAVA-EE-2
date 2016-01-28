$(document).ready(function(){
	var id_karnet = window.location.search.replace("?id_karnet=", "");


    $.get("/silownia/rest/karnet/getBilet/" + id_karnet, function(data, textStatus){
       document.getElementById('id_karnet').innerHTML = data.id_karnet;
       document.getElementById('rodzaj').innerHTML = data.rodzaj;
       document.getElementById('opis').innerHTML = data.opis;
       document.getElementById('cena').innerHTML = data.cena;
    });
});
