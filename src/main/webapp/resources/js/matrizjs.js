function clearCanvas() {
    var c = document.getElementById("myCanvas");
    var context = c.getContext("2d");
    var tmp = context.fillStyle;
    context.fillStyle = 'white';
    context.fillRect(0, 0, context.canvas.width, context.canvas.height);
    context.fillStyle = tmp;
}


function ubicarPosicion() {

    var x = $("#idEngineUbicacionH").val();
    var y = $("#idEngineUbicacionV").val();


    var filas, columnas;
    if (x !== null && x !== '') {
        if (Number(x) === 1) {
            filas = 0;
        } else {
            filas = Number(x) - 1;
        }
    } else {
        filas = 0;
    }
    if (y !== null && y !== '') {
        if (Number(y) === 1) {
            columnas = 0;
        } else {
            columnas = Number(y) - 1;
        }
    } else {
        columnas = 0;
    }

    this.clearCanvas();

    this.generarMatriz(filas, columnas, true);


}


function dimension(rows, cols)
{
    var scale;

    var prod = rows * cols;

    if (prod > 54) {
        scale = 0.72;
    } else {
        if (prod >= 45 && prod <= 54) {
            scale = 1.28;
        } else {
            if (prod >= 42) {
                scale = 1.08;
            } else {
                if (prod >= 40) {
                    scale = 1.3;
                } else {
                    if (prod >= 36) {
                        scale = 1.28;
                    } else {
                        if (prod >= 35) {
                            scale = 1.28;
                        } else {
                            if (prod >= 32) {
                                scale = 1.44;
                            } else {
                                if (prod >= 30) {
                                    scale = 1.3;
                                } else {
                                    if (prod >= 28) {
                                        scale = 1.6;
                                    } else {
                                        if (prod >= 25) {
                                            scale = 1.28;
                                        } else {
                                            if (prod >= 24) {
                                                scale = 1.8;
                                            } else {
                                                if (prod >= 21) {
                                                    scale = 1.64;
                                                } else {
                                                    if (prod == 20) {
                                                        scale = 1.6;
                                                    } else {
                                                        if (prod >= 16) {
                                                            scale = 1.6;
                                                        } else {
                                                            if (prod == 15) {
                                                                scale = 2.1;
                                                            } else {
                                                                if (prod >= 12) {
                                                                    scale = 2.1;
                                                                } else {
                                                                    if (prod >= 9) {
                                                                        scale = 2.1;
                                                                    } else {
                                                                        if (prod >= 6) {
                                                                            scale = 3.18;
                                                                        } else {
                                                                            if (prod >= 4) {
                                                                                scale = 2.1;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    return scale;
}





function generarMatriz(x_, y_, niben) {

    var fila = Number(x_);
    var columna = Number(y_);


    var filas = Number($("#idFilas").val());
    var columnas = Number($("#idColumnas").val());
    var numeroCubos = Number($("#idNumeroCubos").val());

    numeroCubos = (numeroCubos !== null && numeroCubos !== '') ? numeroCubos : 0;

    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    //var grd = ctx.createLinearGradient(0, 0, 170, 0);


    //var scale = this.dimension(filas, columnas);

//    if (niben === false) {
//        ctx.scale(scale, scale);
//    }

    var x, y, x1, y1;
    var count = 0;
    var inc = 35;
    x = 2;
    y = 2;


    var prod = filas * columnas;


    if (prod > 45) {
        inc = 30;
        font = '14px';
        middle = 9;
    } else {
        if (prod >= 45) {
            inc = 45;
            font = '17px';
            middle = 12;
        } else {
            if (prod >= 42) {
                inc = 38;
                font = '17px';
                middle = 11;
            } else {
                if (prod >= 40) {
                    inc = 45;
                    font = '17px';
                    middle = 12;
                } else {
                    if (prod >= 36) {
                        inc = 45;
                        font = '17px';
                        middle = 12;
                    } else {
                        if (prod >= 35) {
                            inc = 45;
                            font = '17px';
                            middle = 12;
                        } else {
                            if (prod >= 33) {
                                inc = 37;
                                font = '17px';
                                middle = 11;
                            } else {
                                if (prod >= 32) {
                                    inc = 51;
                                    font = '20px';
                                    middle = 15;
                                } else {
                                    if (prod >= 30) {
                                        inc = 45;
                                        font = '20px';
                                        middle = 14;
                                    } else {
                                        if (prod >= 28) {
                                            inc = 56;
                                            font = '22px';
                                            middle = 17;
                                        } else {
                                            if (prod >= 25) {
                                                inc = 45;
                                                font = '20px';
                                                middle = 14;
                                            } else {
                                                if (prod == 24) {
                                                    inc = 67.5;
                                                    font = '27px';
                                                    middle = 16;
                                                } else {
                                                    if (prod >= 21) {
                                                        inc = 57;
                                                        font = '30px';
                                                        middle = 18;
                                                    } else {
                                                        if (prod == 20) {
                                                            inc = 57;
                                                            font = '30px';
                                                            middle = 18;
                                                        } else {
                                                            if (prod >= 18) {
                                                                inc = 68;
                                                                font = '30px';
                                                                middle = 15;
                                                            } else {
                                                                if (prod >= 16) {
                                                                    inc = 55;
                                                                    font = '30px';
                                                                    middle = 15;
                                                                } else {
                                                                    if (prod == 15) {
                                                                        inc = 75;
                                                                        font = '35px';
                                                                        middle = 23;
                                                                    } else {
                                                                        if (prod >= 12) {
                                                                            inc = 75;
                                                                            font = '40px';
                                                                            middle = 20;
                                                                        } else {
                                                                            if (prod >= 10) {
                                                                                inc = 81;
                                                                                font = '40px';
                                                                                middle = 24;
                                                                            } else {
                                                                                if (prod == 9) {
                                                                                    inc = 75;
                                                                                    font = '45px';
                                                                                    middle = 28;
                                                                                } else {
                                                                                    if (prod >= 6) {
                                                                                        inc = 113;
                                                                                        font = '50px';
                                                                                        middle = 40;
                                                                                    } else {
                                                                                        if (prod >= 4) {
                                                                                            inc = 113;
                                                                                            font = '50px';
                                                                                            middle = 40;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    x1 = inc;
    y1 = inc;

    for (i = 0; i < filas; i++)
    {
        x = 2;
        for (j = 0; j < columnas; j++)
        {
            count++;
            ctx.beginPath();
            var grd = ctx.createLinearGradient(0, 0, 170, 0);
            grd.addColorStop(0, "#0277BD");
            grd.addColorStop(1, "#0277BD");
            ctx.rect(x, y, x1, y1);
            ctx.font = font + ' Arial';
            ctx.fillStyle = "black";

            if (numeroCubos === count)
            {
                if (niben === true) {

                    ctx.fillStyle = grd;
                    ctx.fillRect(x, y, x1, y1);
                    ctx.fillStyle = "white";
                    ctx.font = font + ' Arial';
                }
            }
            ctx.fillText(count, x + middle, y + (middle * 2));
            ctx.stroke();
            x += inc;
        }
        y += inc;
    }

    var pngUrl = c.toDataURL();

    $("#idMatrizUbicacionBase64").val(pngUrl);

}





