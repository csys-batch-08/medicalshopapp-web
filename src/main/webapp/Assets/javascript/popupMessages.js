
// var check = document.currentScript.getAttribute('status');
function showMessage(check)
{
    console.log(check);



switch(check) {
  case "loginSucess":
   var toastMixin = Swal.mixin({
        toast: true,
        icon: 'success',
        title: 'General Title',
        animation: false,
        position: 'top-right',
        showConfirmButton: false,
        timer: 1500,
        timerProgressBar: true,
        didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
        });
    
        deleted();
        function deleted(){
        toastMixin.fire({
        animation: true,
        title: 'Login Sucessfull'
        });
    }
    break;

  case "deleteSucess":
   var toastMixin = Swal.mixin({
			toast: true,
			icon: 'success',
			title: 'General Title',
			animation: false,
			position: 'top-right',
			showConfirmButton: false,
			timer: 1500,
			timerProgressBar: true,
			didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
			}
			});

			deleted();
			function deleted(){
			toastMixin.fire({
			animation: true,
			title: 'Successfully Deleted'
			});
			}
    break;
  default:
      alert("Invalid");
    
}



    // if(check==="loginSucess"){
    //   var toastMixin = Swal.mixin({
    //     toast: true,
    //     icon: 'success',
    //     title: 'General Title',
    //     animation: false,
    //     position: 'top-right',
    //     showConfirmButton: false,
    //     timer: 1500,
    //     timerProgressBar: true,
    //     didOpen: (toast) => {
    //     toast.addEventListener('mouseenter', Swal.stopTimer)
    //     toast.addEventListener('mouseleave', Swal.resumeTimer)
    //     }
    //     });
    
    //     deleted();
    //     function deleted(){
    //     toastMixin.fire({
    //     animation: true,
    //     title: 'Login Sucessfull'
    //     });
    // }

    // }else if(check==="deleteSucess"){
      
    //     var toastMixin = Swal.mixin({
	// 		toast: true,
	// 		icon: 'success',
	// 		title: 'General Title',
	// 		animation: false,
	// 		position: 'top-right',
	// 		showConfirmButton: false,
	// 		timer: 1500,
	// 		timerProgressBar: true,
	// 		didOpen: (toast) => {
	// 		toast.addEventListener('mouseenter', Swal.stopTimer)
	// 		toast.addEventListener('mouseleave', Swal.resumeTimer)
	// 		}
	// 		});

	// 		deleted();
	// 		function deleted(){
	// 		toastMixin.fire({
	// 		animation: true,
	// 		title: 'Successfully Deleted'
	// 		});
	// 		}
    //     }
    
    }
     
  




    
    