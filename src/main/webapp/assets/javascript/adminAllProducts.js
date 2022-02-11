$(document).ready(function() {
    $('#table_id').DataTable();
});


function check(){
var result = confirm("Are You Sure To Delete The Product");

if(result==false){
    event.preventDefault();
}
}


function confirmdelete(productId) {
Swal.fire({
    title: "Are you sure about deleting this Product?",
    type: "info",
    showCancelButton: true,
    confirmButtonText: "Delete It",
    confirmButtonColor: "#ff0055",
    cancelButtonColor: "#999999",
    reverseButtons: true,
    focusConfirm: false,
    focusCancel: true
  }).then((result) => {
      if (result.isConfirmed) {
            window.location.replace("deleteProduct?info=&deleteProductId=" + productId);
          }
  })

}