$(document).ready(function(){
    var id_klient = window.location.search.replace("?id_klient=", "");
    document.getElementById('id_klient').value = id_klient;
    $.get("/silownia/rest/klient/getKlient/" + id_klient,
         function(data, textStatus)
         {
        document.getElementById('id_klient').innerHTML = 
            data.id_klient;
        document.getElementById('karnet').innerHTML =
            data.karnet.rodzaj;
        document.getElementById('imie').innerHTML =
            data.imie;
        document.getElementById('nazwisko').innerHTML =
            data.nazwisko;
        document.getElementBy('telefon').innerHTML =
            data.telefon;
    });
});