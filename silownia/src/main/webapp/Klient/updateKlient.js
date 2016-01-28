$(document).ready(function(){
    var id_klient = window.location.search.replace("?id_klient=", "");
    document.getElementById('id_klient').value = id_klient;
    //Load customers
    $.get("/silownia/rest/karnet/getAllKarnet", function(data, textStatus)
         {
        var karnetSelect =
            document.getElementById('id_karnet');
        for(var i in data) {
            var option = document.createElement('option');
            var karnetInf = data[i].id_karnet;
            var karnetInf2 = data[i].rodzaj;
            opcja.value = karnetInf;
            opcja.innerHTML = karnetInf2;
            karnetSelect.appendChild(opcja);
        }
    })
//Load rest of  data
$.get("/silownia/rest/klient/getKlient/" + id_klient,
     function(data, textStatus){
    document.getElementById('id_klient').innerHTML =
        data.id_klient;
    document.getElementById('imie').value =
        data.imie;
    document.getElementById('naziwsko').value =
        dara.nazwisko;
    document.getElementById('telefon').value =
        data.telefon;
    document.getElementById('id_karnet').value =
        data.karnet.id_karnet;
});
});