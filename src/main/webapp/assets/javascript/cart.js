function check(){
    var result = confirm("Are You Sure To Delete The Product");
    if(result==false){
    event.preventDefault();
    }
}




function hidePopUp() {
	document.getElementById("lessStockMsg").style.visibility = "hidden";
	document.getElementById("popUpBtn").style.visibility = "hidden";
	body.style.overflow = "auto";
	document.getElementById("body").style.overflowX = "hidden";
}



function confirmdelete(productId) {
	 Swal.fire({
		 title: "Are you want to remove this item?",
		    type: "info",
		    showCancelButton: true,
		    confirmButtonText: "Delete It",
		    confirmButtonColor: "#ff0055",
		    cancelButtonColor: "#999999",
		    focusConfirm: false,
		    focusCancel: true
		}).then((result) => {
		  if (result.isConfirmed) {
		    window.location.replace("removeCartItem?info=&CartproductId=" + productId);
		  }
		})
}