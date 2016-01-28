$(document).ready(function(){
    var id_klient = window.location.search.replace("?id_klient=", "");
    $.get("/silownia/rest/klient/getKlient/" + id_klient,
         function(data, textStatus)
         {
        document.getElementById('id_klient').innerHTML =
            data.id_klient;
        document.getElementById('karnet').innerHTML =
            dara.id_karnet;
        document.getElementById('imie').innerHTML =
            data.imie;
        document.getElementById('nazwisko').innerHTML =
            data.nazwisko;
        document.getElementById('telefon').innerHTML =
            dara.telefon;
    });
});