$(document).ready(function(){
	var id_karnet = window.location.search.replace("?id_karnet=", "");
    document.getElementById('id_karnet').value = id_karnet;

    $.get("/silownia/rest/karnet/getBilet/" + id_karnet, function(data, textStatus){
       document.getElementById('id_karnet').innerHTML = data.id_karnet;
       document.getElementById('rodzaj').value = data.rodzaj;
       document.getElementById('opis').value = data.opis;
       document.getElementById('cena').value = data.cena;
    });
});
