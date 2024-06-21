
$(document).ready(function (){
    $("tr #btnDelete").click(function (){
        var idp = $(this).closest("tr").find("#idp").val();
        swal({
            title: "Are you sure?",
            text: "Once deleted, you will not be able to recover this imaginary file!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
                .then((willDelete) => {
                    if (willDelete) {
                        eliminar(idp);
                        swal("Poof! Your imaginary file has been deleted!", {
                            icon: "success",
                        }).then((willDelete)=>{
                            if(willDelete){
                                parent.location.href = "Controller?accion=Carrito";
                            }
                        });
                    } else {
                        swal("Registro eliminado!");
                    }
                });
        eliminar(idp);
    });

    function eliminar(idp) {
        var url = "Controller?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: { idp: idp },
            success: function (data, textStatus, jqXHR) {
            }
        });
    }
    
    $("tr #cantidad").click(function(){
        var idp=$(this).parent().find("#idpro").val();
        var cantidad = $(this).parent().find("#cantidad").val();
        var url = "Controller?accion=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url, 
            data: "idp=" + idp + "&cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR){
                location.href="Controller?accion=Carrito";
            }
        });
    });
});



