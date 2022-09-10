/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(document).ready(function () {

    comunicacion().then(function () {
        console.log("La aplicación sigue su ejecución");
    });

});

async function comunicacion() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletTest",
        data: $.param({
            usuario: "Juan David",
            tecnologia: "Java"
        }),
        success: function (data) {
            let parsedData = JSON.parse(data);
            console.log(parsedData[1]["autor"]);
        }
    });
}


