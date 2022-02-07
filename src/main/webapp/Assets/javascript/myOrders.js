function check(){
    var result = confirm("10% cancellation charge will be detected on your total price.If you want to cancel?");

    if(result==false){
        event.preventDefault();
    }
}