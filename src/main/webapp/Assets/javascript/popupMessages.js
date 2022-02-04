
// var check = document.currentScript.getAttribute('status');
function showMessage(check)
{
    



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
    
       
        toastMixin.fire({
        animation: true,
        title: 'Login Sucessfull'
        });
    
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

			
			toastMixin.fire({
			animation: true,
			title: 'Successfully Deleted'
			});
			
    break;

	case "deleteFailure":
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

		
			toastMixin.fire({
			animation: true,
			title: 'Unable To Delete Product Something Went Wrong'
			});
			
	break;			
			
	case "productUpdated":
		Swal.fire({
			  icon: 'success',
			  title: 'Product Details Updated',
			  showConfirmButton: false,
			  timer: 2000})
	break;
	
	case "productAdded":
	
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

			
			toastMixin.fire({
			animation: true,
			title: 'New Product Added Successfully'
			});
	break;
	
	case "productExist":
	
		Swal.fire({
			  icon: 'error',
			  title: 'This Product Already Exists',
			  showConfirmButton: false,
			  timer: 2000})
	
	break;
  default:
      alert("Invalid");
    
	}
	
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
    
    
     
  




    
    