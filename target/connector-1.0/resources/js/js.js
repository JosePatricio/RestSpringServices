/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





function calcularTotales(resta3, resta2, resta1, total1, cC1, cBN1, total, cC, cBN) {

    var contadorColor = '', contadorBN = '', contadorColor1 = '', contadorBN1 = '';


    contadorColor = $('#' + cC + '').val();
    contadorBN = $('#' + cBN + '').val();

    contadorColor1 = $('#' + cC1 + '').val();
    contadorBN1 = $('#' + cBN1 + '').val();

    total_ = $('#' + total + '').val();
    total_1 = $('#' + total1 + '').val();

    if ($.trim($('#' + cC + '').val()) === '') {
        contadorColor = 0;
    }

    if ($.trim($('#' + cBN + '').val()) === '') {
        contadorBN = 0;
    }

    if ($.trim($('#' + cC1 + '').val()) === '') {
        contadorColor1 = 0;
    }

    if ($.trim($('#' + cBN1 + '').val()) === '') {
        contadorBN1 = 0;
    }

    if ($.trim($('#' + total + '').val()) === '') {
        total_ = 0;
    }

    if ($.trim($('#' + total1 + '').val()) === '') {
        total_1 = 0;
    }

    var suma1 = Math.abs((parseInt(contadorColor) + parseInt(contadorBN)));
    var suma2 = Math.abs((parseInt(contadorColor1) + parseInt(contadorBN1)));


    $('#' + total + '').val(suma1);
    $('#' + total1 + '').val(suma2);


    var resta1_res = Math.abs((parseInt(contadorBN1) - parseInt(contadorBN)));
    var resta2_res = Math.abs((parseInt(contadorColor1) - parseInt(contadorColor)));
    var resta3_res = Math.abs((parseInt(suma2) - parseInt(suma1)));

    $('#' + resta1 + '').val(resta1_res);
    $('#' + resta2 + '').val(resta2_res);
    $('#' + resta3 + '').val(resta3_res);

}


function calcularContadorImpresionReal1(resta3, resta2, resta1, total1, cC1, cBN1, total, cC, cBN) {


    $("#" + cC + "").on("change paste keyup", function () {
        calcularTotales(resta3, resta2, resta1, total1, cC1, cBN1, total, cC, cBN);
    });


    $("#" + cBN + "").on("change paste keyup", function () {
        calcularTotales(resta3, resta2, resta1, total1, cC1, cBN1, total, cC, cBN);
    });

}

function calcularContadorImpresionReal2(resta3, resta2, resta1, total1, cC1, cBN1, total, cC, cBN) {


    $("#" + cC1 + "").on("change paste keyup", function () {
        calcularTotales(resta3, resta2, resta1, total1, cC1, cBN1, total, cC, cBN);
    });


    $("#" + cBN1 + "").on("change paste keyup", function () {
        calcularTotales(resta3, resta2, resta1, total1, cC1, cBN1, total, cC, cBN);
    });

}




function deshabilitarFirmaCliente() {
    $('#signatureCliente').css({
        'pointer-events': 'none'
    });

}

function limpiarFirmaCliente() {

    PF('sig2').clear();
    $('#signatureCliente').css({
        'pointer-events': 'auto'
    });
}

function focusInputInDialog(idDialog, idInput)
{
    $(window).on('shown.bs.modal', function () {
        $("#" + idDialog).modal('show');
        document.getElementById(idInput).focus();
    });
}

function overflowYModal(idModal) {
    $('#' + idModal).on('hidden.bs.modal', function () {
        $('body').addClass('modal-open');
    });
}

function hideDialogOnSuccess(args, dialogId) {
    if (args && !args.validationFailed) {
        $('#' + dialogId).modal('hide');
    }
}

